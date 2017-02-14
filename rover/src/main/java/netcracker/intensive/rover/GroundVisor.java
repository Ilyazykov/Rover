package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground;

    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    public boolean hasObstacles(Point point) throws OutOfGroundException {
        return ground.getCell(point.x, point.y).getState() == CellState.OCCUPIED;
    }
}
