package semaine7.banque.compte;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date: 14/11/2023
 */

public abstract class Compte {
        protected double solde;

        Compte(double solde) {
                this.solde = solde;
        }

        public double getSolde() {
                return solde;
        }

        abstract public void boucler();
}


