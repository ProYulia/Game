package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.Healer;
import OOP.Abstract.States;

import java.util.ArrayList;
import java.util.Vector;

public class Monk extends Healer {
    public Monk(ArrayList<Base> group, int x, int y) {
        super(12, 7, new int[]{-4,-4}, 30, 5, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
    }


}
