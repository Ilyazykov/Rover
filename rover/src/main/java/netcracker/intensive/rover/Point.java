package netcracker.intensive.rover;

import java.util.Objects;

public class Point {
    //не забудьте реализовать equals, hashCode, toString!
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        if (this != other) {
            x = other.x;
            y = other.y;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point)obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + x;
        result = PRIME * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + ',' + String.valueOf(y);
    }
}
