package semaine7.banque.compte;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        14/11/2023
 */

public class CompteEpargne extends Compte{
    private final double taux = 0.02;

    public CompteEpargne(double solde) {
        super(solde);
    }

    @Override
    public void boucler() {
        super.solde *= (1+this.taux);
    }
}
