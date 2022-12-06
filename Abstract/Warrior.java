package OOP.Abstract;

import OOP.Characters.Position;

import java.util.ArrayList;

public abstract class Warrior extends Base {
    public Warrior(int attack, int protection, int[] damage, double health, int speed, States state) {
        super(attack, protection, damage, health, speed, state);
    }
    private Base findAim(ArrayList<Base> group) {
        float minDistance = Float.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getState() == States.DEAD) continue;
            float distance = getPosition().getDist(group.get(i).getPosition());
            if (minDistance > distance) {
                minDistance = distance;
                index = i;
            }
        }
        return group.get(index);
    }

    @Override
    public void step(ArrayList<Base> group) {
        if (getState().equals(States.DEAD)) return;
        Base aim =findAim(group);
        if (getPosition().getDist(aim.getPosition()) < Math.sqrt(2))
            getAttack(aim);
        int x = getPosition().x;
        int y = getPosition().y;
        if (aim.getPosition().y > y && checkPosition(new Position(x, y+1)) && (y+1 < 10))
            setPosition(new Position(x, y+1));
        if (aim.getPosition().y < y && checkPosition(new Position(x, y-1)) && (y-1 >= 0))
            setPosition(new Position(x, y-1));
        if (aim.getPosition().x > x && checkPosition(new Position(x+1, y)) && (x+1 < 10))
            setPosition(new Position(x+1, y));
        if (aim.getPosition().x > x && checkPosition(new Position(x-1, y)) && x-1 >= 0)
            setPosition(new Position(x-1, y));
    }
    private boolean checkPosition(Position pos) {
        for (Base base : getGroup()) {
            if (pos.isEqual(base.getPosition()))
                return false;
        }
        return true;
    }

}
