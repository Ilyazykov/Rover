package netcracker.intensive.rover.stats;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import netcracker.intensive.rover.Point;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SimpleRoverStatsModule implements RoverStatsModule {
    Collection<Point> visitedPoints = new HashSet<Point>();

    @Override
    public void registerPosition(Point position) {
        visitedPoints.add(position);
    }

    @Override
    public boolean isVisited(Point point) {
        return visitedPoints.contains(point);
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return visitedPoints;
    }
}
