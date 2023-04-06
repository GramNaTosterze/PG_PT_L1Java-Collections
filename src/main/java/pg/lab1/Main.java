package pg.lab1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Mage> submages = new TreeSet<>();
        submages.add(new Mage("submage1", 1, 1.2, null));
        submages.add(new Mage("submage4", 4, 1.2, null));
        submages.add(new Mage("submage3", 2, 3.2, null));
        submages.add(new Mage("submage2", 5, 2.2, null));

        Set<Mage> asubmages = new TreeSet<>((Mage m1, Mage m2) -> m1.compare(m1,m2));
        asubmages.add(new Mage("submage3", 1, 1.2, null));
        asubmages.add(new Mage("submage2", 4, 1.2, null));
        asubmages.add(new Mage("submage1", 2, 3.2, null));
        asubmages.add(new Mage("submage4", 5, 2.2, null));


        Set<Mage> mages = new HashSet<Mage>();
        mages.add(new Mage("mage1", 1, 1.2, asubmages));
        mages.add(new Mage("mage2", 4, 1.2, null));
        mages.add(new Mage("mage3", 2, 3.2, submages));
        mages.add(new Mage("mage4", 5, 2.2, null));
        Mage mage = new Mage("Gandalf", 10, 12.1, mages);
        System.out.println(mage);
    }
}