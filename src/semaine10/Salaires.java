package semaine10;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        14/11/2023
 */

import java.util.ArrayList;

class Salaires {
    public static void main(String[] args) {
        Personnel p = new Personnel();

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("LÃ©on", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
    }
}

interface ARisque {
    double calculerPrime();
}

abstract class Employe {
    private String name;
    private String preName;
    private int age;
    private String entryDate;

    Employe(String name, String preName, int age, String date) {
        this.name = name;
        this.preName = preName;
        this.age = age;
        this.entryDate = date;
    }

    abstract double calculerSalaire();

    public String getTitre() {
        return "L' employé ";
    }

    public String getName() {
        return getTitre() + this.preName + " " + this.name;
    }
}

abstract class Interacteur extends Employe {
    private static final double POURCENT_SALAIRE = 0.2;
    private int affaire;

    Interacteur(String name, String preName, int age, String date, int affaire) {
        super(name, preName, age, date);
        this.affaire = affaire;
    }

    @Override
    double calculerSalaire() {
        return POURCENT_SALAIRE * affaire;
    }
}

class Vendeur extends Interacteur{
    private final static int BONUS_VENDEUR = 400;

    Vendeur(String name, String preName, int age, String date, int affaire) {
        super(name, preName, age, date, affaire);
    }

    @Override
    double calculerSalaire() {
        return super.calculerSalaire() + BONUS_VENDEUR;
    }

    @Override
    public String getTitre() {
        return "Le vendeur ";
    }
}

class Representant extends Interacteur{
    private final static int BONUS_REPRESENTANT = 800;

    Representant(String name, String preName, int age, String date, int affaire) {
        super(name, preName, age, date, affaire);
    }

    @Override
    double calculerSalaire() {
        return super.calculerSalaire() + BONUS_REPRESENTANT;
    }

    @Override
    public String getTitre() {
        return "Le représentant ";
    }
}

class Technicien extends Employe {
    private final static int CONSTANTE_SALAIRE = 5;
    private int unite;

    Technicien(String name, String preName, int age, String date, int unite) {
        super(name, preName, age, date);
        this.unite = unite;
    }

    @Override
    double calculerSalaire() {
        return this.unite * CONSTANTE_SALAIRE;
    }

    @Override
    public String getTitre() {
        return "Le technicien ";
    }
}

class Manutentionnaire extends Employe {
    private final static int SALAIRE_PAR_HEURE = 65;
    private int heuresTravail;

    Manutentionnaire(String name, String preName, int age, String date, int heures){
        super(name, preName, age, date);
        this.heuresTravail = heures;
    }

    @Override
    double calculerSalaire() {
        return this.heuresTravail * SALAIRE_PAR_HEURE;
    }

    @Override
    public String getTitre() {
        return "Le manut. ";
    }
}

class TechnARisque extends Technicien implements ARisque {

    TechnARisque(String name, String preName, int age, String date, int unite) {
        super(name, preName, age, date, unite);
    }

    @Override
    public double calculerPrime() {
        return 400.0;
    }

    @Override
    double calculerSalaire() {
        return super.calculerSalaire() + calculerPrime();
    }
}

class ManutARisque extends Manutentionnaire implements ARisque {

    ManutARisque(String name, String preName, int age, String date, int heures) {
        super(name, preName, age, date, heures);
    }

    @Override
    public double calculerPrime() {
        return 300.0;
    }

    @Override
    double calculerSalaire() {
        return super.calculerSalaire() + calculerPrime();
    }
}

class Personnel {
    private ArrayList<Employe> employes;

    Personnel() {
        this.employes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe e) {
        this.employes.add(e);
    }

    public void afficherSalaires() {
        if (!this.employes.isEmpty()) {
            for (Employe employe : this.employes) {
                System.out.println(employe.getName() + " gagne "
                        + employe.calculerSalaire() + " francs");
            }
        } else System.out.println("L'entreprise n'a pas d'employés");
    }

    public double salaireMoyen() {
        double somme = 0;
        if (!this.employes.isEmpty()) {
            for (Employe e : this.employes) {
                somme += e.calculerSalaire();
            }
            return somme / (double) this.employes.size();
        } else return 0;
    }
}

