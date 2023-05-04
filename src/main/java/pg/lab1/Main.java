package pg.lab1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Mage> students = new HashSet<>();
        Set<Mage> dragonborn = new HashSet<>();
        Set<Mage> scholars = new HashSet<>();
        Set<Mage> masters = new HashSet<>();
        if (args.length != 0) {
            if (args[0].equals("AltCompare")) {
                students = new TreeSet<>(new MageAltComparator());
                dragonborn = new TreeSet<>(new MageAltComparator());
                scholars = new TreeSet<>(new MageAltComparator());
                masters = new TreeSet<>(new MageAltComparator());
            }
            else if (args[0].equals("Compare")) {
                students = new TreeSet<>();
                dragonborn = new TreeSet<>();
                scholars = new TreeSet<>();
                masters = new TreeSet<>();
            }
        }


        dragonborn.add(new Mage("Dragonborn pre Winterhold quest", 1, 1, null));


        students.add(new Mage("J'zargo", 1, 1.2, dragonborn));
        students.add(new Mage("Onmund", 4, 1.2, null));
        students.add(new Mage("Brelyna Maryon", 2, 3.2, null));


        scholars.add(new Mage("Tolfdir", 1, 1.2, null));
        scholars.add(new Mage("Colette Marence", 4, 1.2, null));
        scholars.add(new Mage("Faralda", 2, 3.2, students));
        scholars.add(new Mage("Drevis Neloren", 5, 2.2, null));

        masters.add(new Mage("Mirabelle Ervine", 1, 1.2, scholars));
        masters.add(new Mage("mac", 4, 1.2, null));

        Mage grandmaster = new Mage("Savos Aren", 10, 12.1, masters);
        System.out.println(grandmaster.printApprentices());


        System.out.println(grandmaster.descendents());
    }
}