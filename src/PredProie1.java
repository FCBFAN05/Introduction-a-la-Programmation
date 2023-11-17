
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        16/11/2023
 */

abstract class Animal {
    abstract boolean canEat(Animal animal);

    abstract boolean isEatableByScorpion();
}


class Scorpion extends Animal {
    // le scorpion mange les souris
    boolean canEat(Animal animal)
	/* comment coder cette méthode sans recours au test de type ?
	 java ne permet pas le multiple dispatch (la méthode ne peut
	 être polymorphique que par rapport à this et non par rapport à ses arguments)
	*/ {
        return animal.isEatableByScorpion();
    }

    @Override
    boolean isEatableByScorpion() {
        return false;
    }
}

class Mouse extends Animal {
    //La souris ne peut manger personne
    // (et n'est pas cannibale !)
    boolean canEat(Animal animal) {
        return false;
    }

    @Override
    boolean isEatableByScorpion() {
        return true;
    }

}

class PredProie1 {
    public static void main(String[] args) {
        Mouse m1 = new Mouse();
        Mouse m2 = new Mouse();

        Scorpion s1 = new Scorpion();
        Scorpion s2 = new Scorpion();

        System.out.println(s1.canEat(s2));
        System.out.println(s1.canEat(m1));
        System.out.println(m1.canEat(m2));
        System.out.println(m1.canEat(s1));
    }
}

/*
  Indications : retournez l'argument pour permettre le polymorphisme
  scorpion.canEat(animal) peut être codé comme animal.isEatableBy(scorpion)
  + aidez vous de la surcharge...
*/
