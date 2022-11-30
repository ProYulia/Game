package OOP.Abstract;

import java.util.ArrayList;
import java.util.Vector;

public abstract class Healer extends Base {
    boolean magic;
    public Healer(int attack, int protection, int[] damage, double health, int speed, States state) {
        super(attack, protection, damage, health, speed, state);
        this.magic = true;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step(ArrayList<Base> group) {
        if (getState() == States.DEAD) return;
        double minHp = Double.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < getGroup().size(); i++) {
            if (getGroup().get(i).getState() != States.DEAD && getGroup().get(i).getMaxHealth() - getGroup().get(i).getHealth() != 0) {
                if (minHp > getGroup().get(i).getMaxHealth() - getGroup().get(i).getHealth()) {
                    minHp = getGroup().get(i).getMaxHealth() - getGroup().get(i).getHealth();
                    index = i;
                }
            }
        }
        if (minHp != Double.MAX_VALUE) {
            getGroup().get(index).setHealth(getHealth() - getDamage()[0]);
        }
    }
}
