package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.States;
import OOP.Abstract.Warrior;

import java.util.ArrayList;
import java.util.Vector;

public class Peasant extends Warrior {

    boolean delivery;

    public Peasant(ArrayList<Base> group, int x, int y) {
        super(1, 1, new int[]{1,1}, 1, 3, States.ALIVE);
        super.group = group;
        delivery = true;
        super.position = new Position(x, y);
    }

    @Override
    public void step(ArrayList<Base> group) {
        if (getState().equals(States.USED))
            setState(States.ALIVE);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
