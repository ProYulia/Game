package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.Shooter;
import OOP.Abstract.States;

import java.util.ArrayList;
import java.util.Vector;

public class Xbowman extends Shooter {
    public Xbowman(ArrayList<Base> group, int x, int y) {
        super(6, 3, new int[]{2,3}, 10, 4, States.ALIVE, 16);
        super.group = group;
        super.position = new Position(x, y);
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }
    @Override
    public void step(ArrayList<Base> group) {

    }
}
