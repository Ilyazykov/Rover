package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.Collection;

public class SimpleRoverStatsModule implements RoverStatsModule {

    @Override
    public void registerPosition(Point position) {
        //TODO
    }

    @Override
    public boolean isVisited(Point point) {
        //TODO
        return false;
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        //TODO
        return null;
    }
}
