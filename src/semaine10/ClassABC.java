package semaine10;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        12/12/2023
 */

// Héritage Quiz 6 MOOC 2
// Exercise 5

public class ClassABC {
    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.print();

        ClassB b = new ClassB();
        b.print();

        ClassA ab = new ClassB();
        ab.print();

        ((ClassB)c).print();
    }
}

class ClassA {
    protected int number;

    public ClassA() {
        number = 20;
    }

    public void print() {
        System.out.println(getPrefix() + ": " + number);
    }

    protected String getPrefix() {
        return "A";
    }
}

class ClassB extends ClassA {
    protected int number = 10;

    protected String getPrefix() {
        return "B";
    }
}

class ClassC extends ClassB {
    public ClassC() {
        super();
    }

    protected String getPrefix(){
        return "C";
    }
}
