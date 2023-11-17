package semaine8;
/*
 *	Author:      Melvin Emanuel Trösch
 *	Date:        16/11/22023
 */

import java.util.ArrayList;
import java.util.Calendar;

public class Direction {
    public static void main(String[] args) {
        University epfl = new University();
        RegularStudent gaston = new RegularStudent("Gaston Peutimide",
                2020, "SSC", 6.0);
        RegularStudent yvan = new RegularStudent("Yvan Rattrapeur",
                2016, "SSC", 2.5);
        ExchangeStudent bjorn = new ExchangeStudent("Björn Borgue",
                2018, "SIN", "KTH");
        Teacher mathieu = new Teacher("Mathieu Matheu", 2015,
                10000, "LMEP", "Physique");
        Secretary secretary = new Secretary("Sophie Scribona",
                2005, 5000, "LMT");

        epfl.add(gaston);
        epfl.add(yvan);
        epfl.add(bjorn);
        epfl.add(mathieu);
        epfl.add(secretary);

        epfl.presentStatistics();
        epfl.presentPersons();
    }
}

class University {
    private final ArrayList<PersonAtEPFL> persons = new ArrayList<>();
    private int nbOfStudents = 0;

    University() {
    }

    private int getNbOfStudents() {
        for (PersonAtEPFL person : this.persons) {
            if (person instanceof Student) {
                nbOfStudents++;
            }
        }
        return nbOfStudents;
    }

    private double getAverageYears() {
        int sumYear = 0;

        if (persons.isEmpty()) return 0.0;

        for (PersonAtEPFL person : this.persons) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            sumYear += currentYear - person.getYearOfArrival();
        }
        return sumYear / (double) this.persons.size();
    }

    public void add(PersonAtEPFL person) {
        persons.add(person);
    }

    public void presentStatistics() {
        System.out.println("Parmi les " + persons.size() + " EPFLiens, "
                + getNbOfStudents() + " sont des étudiants.");
        System.out.println("Ils sont ici depuis en moyenne " + getAverageYears() + " ans");
    }

    public void presentPersons() {
        System.out.println("Liste des EPFLiens : ");
        for (PersonAtEPFL person : this.persons) {
            person.present();
        }
    }

}
class PersonAtEPFL {
    private final String name;
    private final int yearOfArrival;

    PersonAtEPFL(String name, int yearOfArrival) {
        this.name = name;
        this.yearOfArrival = yearOfArrival;
    }

    public int getYearOfArrival() {
        return yearOfArrival;
    }

    public void present() {
        System.out.println("Nom : " + this.name);
        System.out.println("Année" + this.yearOfArrival);
    }
}

class Personnel extends PersonAtEPFL {
    private final double salary;
    private final String laboratory;

    Personnel(String name, int yearOfArrival, int salary, String laboratory) {
        super(name, yearOfArrival);
        this.salary = salary;
        this.laboratory = laboratory;
    }
    @Override
    public void present() {
        super.present();
        System.out.println("Laboratoire : " + this.laboratory);
        System.out.println("Salaire : " + this.salary);
    }
}

class Teacher extends Personnel {
    private final String section;

    Teacher(String name, int yearOfArrival, int salary, String laboratory, String section) {
        super(name, yearOfArrival, salary, laboratory);
        this.section = section;
    }
    @Override
    public void present() {
        System.out.println("Enseignant : ");
        super.present();
        System.out.println("Sectioin d'enseignement : " + this.section);
    }
}

class Secretary extends Personnel {

    Secretary(String name, int yearOfArrival, int salary, String laboratory) {
        super(name, yearOfArrival, salary, laboratory);
    }
    @Override
    public void present() {
        System.out.println("Secretaire: ");
        super.present();
    }
}

class Student extends PersonAtEPFL {
    private final String section;

    Student(String name, int yearOfArrival, String section) {
        super(name, yearOfArrival);
        this.section = section;
    }
    @Override
    public void present() {
        super.present();
        System.out.println("Section : " + section);
    }
}

class RegularStudent extends Student {
    private final double resultProp1;

    RegularStudent(String name, int yearOfArrival, String section, double resultProp1) {
        super(name, yearOfArrival, section);
        this.resultProp1 = resultProp1;
    }

    @Override
    public void present() {
        System.out.println("Etudiant regulier :");
        super.present();
        System.out.println("Moyenne : " + resultProp1);
    }
}

class ExchangeStudent extends Student {
    private final String originUni;

    ExchangeStudent(String name, int yearOfArrival, String section, String originUni) {
        super(name, yearOfArrival, section);
        this.originUni = originUni;
    }

    @Override
    public void present() {
        System.out.println("Etudiant d'échange:");
        super.present();
        System.out.println("Uni d'origine : " + originUni);
    }
}