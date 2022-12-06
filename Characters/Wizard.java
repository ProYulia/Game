package OOP.Characters;

import OOP.Abstract.Base;
import OOP.Abstract.Healer;
import OOP.Abstract.States;

import java.util.ArrayList;
import java.util.Vector;

public class Wizard extends Healer {
    public Wizard(ArrayList<Base> group, int x, int y) {
        super(17, 12, new int[]{-5,-5}, 30, 9, States.ALIVE);
        super.group = group;
        super.position = new Position(x, y);
    }

}
