package semaine10;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        24/11/2023
 */

/* interface pour courrier normal */

interface ReductionPub {
    double REDUCTION_PUB = 0.8;
}

interface ReductionColis {
    double REDUCTION_COLIS = 0.85;
}

/* Classe pour reprÃ©senter le courrier (normal)
 */

abstract class Courrier{
    // retourne le montant n'ecessaire pour affranchir le courrier
    // en mode d'exp'edition normal

    // les attributs (communs aux lettres et colis):
    protected double poids;
    protected boolean express;
    protected String adresse;

    // un constructeur possible pour la classe
    public Courrier(double poids, boolean express, String adresse) {
        this.poids = poids;
        this.express = express;
        this.adresse = adresse;
    }

    // calcul du cout de l'affranchissement en tarif normal
    abstract double affranchirNormal();

    // retourne le montant n'ecessaire pour affranchir le courrier.
    // elle appelle affranchirNormal et retourne le double de ce montant
    // si le mode d'exp'edition est  express ('eviter la duplication du code
    // qui double le montant dans les m'ethodes affranchir-normal
    // des sous-classes)
    public double affranchir() {
        if (invalide()) {
            return 0;
        } else {
            double total = affranchirNormal();
            if (express) {
                total *= 2;
            }
            return total;
        }
    }

    // un courrier est invalide si l'adresse de destination est vide
    // methode utilis'ee par Boite::affranchir et
    // Boite::courriersInvalides
    public boolean invalide() {
        return adresse.isEmpty();
    }

    @Override
    public String toString() {
        String s = "";
        if (invalide()) {
            s += "(Courrier  invalide)\n";
        }
        s += "	Poids : " + poids + " grammes\n";
        s += "	Express : " + (express ? "oui" : "non") + "\n";
        s += "	Destination : " + adresse + "\n";
        s += "	Prix : " + affranchir() + " CHF\n";
        return s;
    }
}
/* Une classe pour repr'esenter les lettres
 */

class Lettre extends Courrier {

    //attributs sp'ecifiques aux lettres:
    protected String format;

    public Lettre(double poids, boolean express, String adresse, String format){
        super(poids, express, adresse);
        this.format = format;
    }

    // red'efinit affranchirNormal()
    public double affranchirNormal() {
        double montant;
        if (format.equals("A4")){
            montant = 2.0;
        } else {
            montant = 3.5;
        }
        montant += poids/1000.0;
        return montant;
    }

    // inutile de red'efinir la mÃ©thode valide() pour les  lettres

    @Override
    public String toString() {
        String s = "Lettre\n";
        s += super.toString();
        s += "	Format : " + format + "\n";
        return s;
    }

}
/* Une classe pour repr'esenter les publicit'es
 */

class Publicite extends Courrier implements ReductionPub{

    public Publicite(double poids, boolean express, String adresse){
        super(poids, express, adresse);
    }

    // redÃ©finit affranchirNormal()
    public double affranchirNormal() {
        return REDUCTION_PUB * poids/1000.0 * 5.0;
    }


    // inutile de red'efinir la mÃ©thode valide() pour les  publicitÃ©s

    @Override
    public String toString() {
        String s = "PublicitÃ©\n";
        s += super.toString();
        return s;
    }

}

/* Une classe pour repr'esenter les colis
 */
class Colis extends Courrier{

    //attributs sp'ecifiques aux colis:
    protected double volume;

    public Colis(double poids, boolean express, String adresse, double volume) {
        super(poids, express, adresse);
        this.volume = volume;
    }

    // redÃ©finit affranchirNormal();
    public double affranchirNormal() {
        // affranchit les colis selon une formule pr'ecise
        return 0.25 * volume + poids/1000.0;
    }

    // ici il faut red'efinir  (sp'ecialiser) la re`gle de validit'e des colis
    // un colis est invalide s' il  a une mauvaise adresse
    //ou depasse un certain volume
    public boolean invalide(){
        return (super.invalide() || !(volume <= 50));
    }

    @Override
    public String toString() {
        String s = "Colis\n";
        s += super.toString();
        s += "	Volume : " + volume + " litres\n";
        return s;
    }
}

/* Une classe pour représenter le colis commercial */

class ColisCommercial extends Colis implements ReductionColis {

    ColisCommercial(double poids, boolean express, String adresse, double volume) {
        super(poids, express, adresse, volume);
    }

    public double affranchirNormal() {
        return super.affranchirNormal() * REDUCTION_COLIS;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "Colis commercial\n";
    }
}


/* 	 Une classe pour repr'esenter la boite aux lettre
 */

class Boite {

    private Courrier[] contenu;
    private int index;

    // constructeur
    public Boite(int max) {
        contenu = new Courrier[max];
        index = 0;
    }

    // la mÃ©thode demand'ee
    public double affranchir() {
        double montant = 0.0;
        for(int i=0; i < index; ++i){
            Courrier c = contenu[i];
            montant += c.affranchir();
        }
        return montant;
    }

    public int size() {
        return index;
    }

    public Courrier getCourrier(int index) {
        if (index < contenu.length)
            return contenu[index];
        else
            return null;
    }

    // retourne le nombre de courriers invalides
    public int courriersInvalides() {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (contenu[i].invalide())
                count++;
        }
        return count;
    }

    // difficile de fonctionner sans
    public void ajouterCourrier(Courrier  unCourrier) {
        if (index < contenu.length){
            contenu[index] = unCourrier;
            index++;
        } else {
            System.out.println("Impossible d'ajouter un nouveau courrier. Boite pleine !");
        }
    }

    public void afficher() {
        for (int i = 0; i < index; i++) {
            System.out.println(contenu[i]);
        }
    }

}


// PROGRAMME PRINCIPAL
class PosteCommercial {

    public static void  main(String[] args) {
		//Cr'eation d'une boite-aux-lettres
		Boite boite = new Boite(30);

		//Creation de divers courriers/colis..

		Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
		Publicite pub2 = new Publicite(3000, false, "Ch. de l'Impasse 1, 9999 Nowhere");

		ColisCommercial colisCom1 = new ColisCommercial(7000, false, "Route de la rape 11, 1509 Vucherens", 25);
		ColisCommercial colisCom2 = new ColisCommercial(2500, true, "Route du Rameau 14b, 404 Notfound", 21);

		boite.ajouterCourrier(pub1);
		boite.ajouterCourrier(pub2);
		boite.ajouterCourrier(colisCom1);
		boite.ajouterCourrier(colisCom2);


		System.out.println("Le montant total d'affranchissement est de " +
						   boite.affranchir());
		boite.afficher();

		System.out.println("La boite contient " + boite.courriersInvalides()
						   + " courriers invalides");
    }

}
