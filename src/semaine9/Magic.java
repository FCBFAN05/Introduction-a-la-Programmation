package semaine9;

/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        19/11/2023
 */
public class Magic {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);

        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creature(6, "Golem", 4, 6));
        maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
                "La crÃ©ature ciblÃ©e gagne +3/+3 jusqu'Ã  la fin du tour"));

        System.out.println("LÃ , j'ai en stock :");
        maMain.afficher();
        maMain.joue();
    }
}

class Color {
    private final char color;

    public Color(char color) {
        this.color = color;
    }

    public void afficher() {
        switch (this.color) {
            case 'B':
                System.out.println("blanc");
                break;
            case 'b':
                System.out.println("bleu");
                break;
            case 'n':
                System.out.println("noir");
                break;
            case 'r':
                System.out.println("rouge");
                break;
            case 'v':
                System.out.println("vert");
                break;
            default:
                System.out.println("No valid color chosen");
        }
    }
}

class Jeu {
    private Carte[] cartes;
    int indexTaken = 0;

    public Jeu(int maxCartes) {
        cartes = new Carte[maxCartes];
        System.out.println("On change de main");
    }

    public void afficher() {
        for (int i = 0; i < indexTaken; i++) {
            if (cartes[i] != null) {
                cartes[i].afficher();
            }
        }
    }

    public void piocher(Carte carte) {
        if (this.indexTaken < this.cartes.length) {
            this.cartes[indexTaken] = carte;
            indexTaken++;
        } else {
            System.out.println("Main déjà rempli avec maximum de cartes");
        }
    }

    public void joue() {
        System.out.println("Je joue une carte...");
        System.out.println("La carte joueé est: ");
        int i = 0;
        while (cartes[i] == null) {
            i++;
        }
        if (cartes[i] != null) {
            cartes[i].afficher();
            cartes[i] = null;
        } else {
            System.out.println("Plus de cartes");
        }
    }
}

abstract class Carte {
    private final int cost;

    public Carte() {
        this.cost = 0;
    }

    public Carte(int cost) {
        this.cost = cost;
    }

    abstract void afficher();
}

class Terrain extends Carte {
    private Color color;

    Terrain(char c) {
        this.color = new Color(c);
        System.out.println("Un nouveau terrain.");
    }

    public void afficher() {
        System.out.print("Un terrain ");
        color.afficher();
    }
}

class Creature extends Carte {
    private String nom;
    private int degats;
    private int vie;

    Creature(int cost, String nom, int degats, int vie) {
        super(cost);
        this.nom = nom;
        this.degats = degats;
        this.vie = vie;
        System.out.println("Une nouvelle créature.");
    }

    public void afficher() {
        System.out.println("Une créature " + this.nom + " "
                + this.degats + "/" + this.vie);
    }
}

class Sortilege extends Carte {
    private String nom;
    private String explication;

    Sortilege(int cost, String nom, String explication) {
        super(cost);
        this.nom = nom;
        this.explication = explication;
        System.out.println("Un sortilège de plus.");
    }

    public void afficher() {
        System.out.println("Un sortilège " + nom);
    }
}
