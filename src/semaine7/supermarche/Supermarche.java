package semaine7.supermarche;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        15/11/2023
 */

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Supermarche {

    public static void main(String[] args) {
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        // Les caddies du supermarché
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Les caisses du supermarché
        // le premier argument est le numero de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à une quantité

        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        // Les clients passent à la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);

        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}

class Achat {
    private final Article article;
    private final int quantity;

    Achat(Article articleAchete, int quantity) {
        this.article = articleAchete;
        this.quantity = quantity;
    }

    public double totalPrize() {
        return quantity * article.prix();
    }

    public void afficher() {
        String description = article.nom() + " : " + article.prix() + " x "
                + this.quantity + " = " + totalPrize() + " Frs";
        if (article.action()) {
            System.out.println(description + " (1/2 prix)");
        } else System.out.println(description);
    }
}

record Article(String nom, double prix, boolean action) {

    @Override
    public double prix() {
        if (action) {
            return this.prix * (1 / 2.0);
        } else return this.prix;
    }
}

class Caddie {
    private final ArrayList<Achat> contenu;

    Caddie() {
        this.contenu = new ArrayList<>();
    }

    public ArrayList<Achat> getContenu() {
        return contenu;
    }

    public void remplir(Article article, int quantity) {
        this.contenu.add(new Achat(article, quantity));
    }
}

class Caisse {
    private final int numero;
    private double montantTotal;

    Caisse(int numero, double montantDebut) {
        this.numero = numero;
        this.montantTotal = montantDebut;
    }

    public void scanner(Caddie caddie) {
        System.out.println("=========================================");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        System.out.println("Caisse numéro " + this.numero);
        System.out.println(); // Empty line

        ArrayList<Achat> contenuCaddie = caddie.getContenu();
        double montantPayer = 0.0;

        for (Achat achat : contenuCaddie) {
            achat.afficher();

            montantPayer += achat.totalPrize();
        }
        this.montantTotal += montantPayer;

        System.out.println(); // Empty line
        System.out.println("Montant à payer : " + montantPayer + " Frs");
        System.out.println("=========================================");
    }

    public void totalCaisse() {
        System.out.printf("La caisse numéro %d a encaissé %.2f Frs aujourd'hui%n",
                this.numero,
                this.montantTotal);
    }
}