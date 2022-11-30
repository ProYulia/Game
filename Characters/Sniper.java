package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.Shooter;
import OOP.Abstract.States;

import java.util.ArrayList;
import java.util.Vector;

public class Sniper extends Shooter {

    public Sniper(ArrayList<Base> group, int x, int y) {
        super(12, 10, new int[]{8,10}, 15, 9, States.ALIVE, 32);
        super.group = group;
        super.position = new Position(x, y);
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
