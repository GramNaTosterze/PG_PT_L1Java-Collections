package pg.lab1;
import jdk.jfr.Unsigned;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
public class Mage implements Comparable, Comparator<Mage> {
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
        updateDeph();
        depth = 0;
    }
    public Mage() {}

    public HashMap<Mage, Integer> descendents() {
        HashMap<Mage, Integer> mages = new HashMap<Mage, Integer>();
        int numberOfApprentices = 0;
        if (apprentices != null) {
            for (Mage apprentice: apprentices) {
                mages.putAll(apprentice.descendents());
                numberOfApprentices += mages.get(apprentice) + 1;
            }
        }
        mages.put(this, numberOfApprentices);

        return mages;
    }

    public void updateDeph() {
        if (apprentices != null)
            for (Mage apprentice: apprentices) {
                apprentice.depth = depth+1;
                apprentice.updateDeph();
            }
    }
    @Override
    public int compare(Mage mage1, Mage mage2) {
        if (mage1.level != mage2.level)
            return Integer.compare(mage1.level, mage2.level);
        else if (!mage1.equals(mage2.name))
            return mage1.name.compareTo(mage2.name);
        else return Double.compare(mage1.power, mage2.power);
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
            else if (level != mage.level)
                return Integer.compare(level, mage.level);
            else return Double.compare(power, mage.power);
        } catch (ClassCastException cce) {
            System.out.println("Cannot compare Mage to this object");
        }
        return 0;
    }

    public String printApprentices() {
        String printApprentices = "";
        if(apprentices != null) {
            for (Mage apprentice: apprentices) {
                for (int i = 0; i <= depth; i++)
                    printApprentices += "-";
                printApprentices += apprentice.printApprentices();
            }
        }
        return this + printApprentices;
    }

    @Override
    public String toString() {
        return String.format("Mage{name = '%s', level = '%d', power = '%f'} \n", name, level, power);
    }
}
