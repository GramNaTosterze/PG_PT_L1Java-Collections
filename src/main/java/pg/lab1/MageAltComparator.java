package pg.lab1;

import java.util.Comparator;

public class MageAltComparator implements Comparator<Mage> {

    @Override
    public int compare(Mage mage1, Mage mage2) {
        if (mage1.getLvl() != mage2.getLvl())
            return Integer.compare(mage1.getLvl(), mage2.getLvl());
        else if (!mage1.equals(mage2.getName()))
            return mage1.getName().toLowerCase().compareTo(mage2.getName().toLowerCase());
        else return Double.compare(mage1.getPower(), mage2.getPower());
    }
}
