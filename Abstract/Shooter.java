package OOP.Abstract;

import java.util.ArrayList;

public abstract class Shooter extends Base {
    int shoot;
    public Shooter(int attack, int protection, int[] damage, double health, int speed, States state, int shoot) {
        super(attack, protection, damage, health, speed, state);
        this.shoot=shoot;
    }

    @Override
    public void step(ArrayList<Base> group) {
        if (getState() == States.DEAD) return;
        for (int i=0; i <getGroup().size(); i++) {
            if (getGroup().get(i).getClass().getSimpleName().equals("Peasant") &&
                    getGroup().get(i).getState().equals(States.ALIVE)) {
                shoot++;
                getGroup().get(i).setState(States.USED);
            }
        }
        if (shoot <= 0) return;
        shoot--;
        Base aim = findAim(group);
        getAttack(aim);


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

}
