package pg.lab1;
import jdk.jfr.Unsigned;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
public class Mage implements Comparable, Comparator {
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;
    private int depth;
    public Mage(String _name, int _level, double _power, Set<Mage> _apprentices) {
        name = _name;
        level = _level;
        power = _power;
        apprentices = _apprentices;
        if(apprentices != null)
            for (Mage apprentice : apprentices)
                apprentice.depth = depth+1;
        depth = 0;
    }
    @Override
    public int compare(Object o1, Object o2) {
        try {
            Mage mage1 = (Mage) o1;
            Mage mage2 = (Mage) o2;
            if (mage1.level == mage2.level)
                return Integer.compare(mage1.level, mage2.level);
            else if (!mage1.equals(mage2.name))
                return mage1.name.compareTo(mage2.name);
            else return Double.compare(mage1.power, mage2.power);
        } catch (ClassCastException cce) {
            System.out.println("Cannot compare Mage to this object");
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mage mage = (Mage) o;
        return level == mage.level && Double.compare(mage.power, power) == 0 && Objects.equals(name, mage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, power);
    }

    @Override
    public int compareTo(Object o) {
        try {
            Mage mage = (Mage) o;
            if (!name.equals(mage.name))
                return name.compareTo(mage.name);
            else if (level == mage.level)
                return Integer.compare(level, mage.level);
            else return Double.compare(power, mage.power);
        } catch (ClassCastException cce) {
            System.out.println("Cannot compare Mage to this object");
        }
        return 0;
    }

    @Override
    public String toString() {
        String printApprentices = "";
        if(apprentices != null) {
            for (Mage apprentice: apprentices) {
                for (int i = 0; i <= depth; i++)
                    printApprentices += "-";
                printApprentices += apprentice;
            }
        }
        return String.format("Mage{name = '%s', level = '%d', power = '%f'} \n%s", name, level, power, printApprentices);
    }
}
