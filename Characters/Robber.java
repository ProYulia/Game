package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.States;
import OOP.Abstract.Warrior;

import java.util.ArrayList;
import java.util.Vector;

public class Robber extends Warrior {

    boolean delivery;
    public Robber(ArrayList<Base> group, int x, int y) {
        super(8, 3, new int[]{2,4}, 10, 6, States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Position(x, y);
    }

    @Override
    public void step(ArrayList<Base> group) {

    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
