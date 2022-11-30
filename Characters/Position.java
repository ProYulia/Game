package OOP.Characters;

public class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Position pos){
        return pos.y == y & pos.x == x;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public float getDist(Position position) {
        return (float) Math.sqrt((x - position.x) * (x - position.x)+(y-position.y)*(y-position.y));
    }
}
