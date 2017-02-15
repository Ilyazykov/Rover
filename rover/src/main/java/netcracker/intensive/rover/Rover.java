package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

public class Rover {
    private Point currentPosition = new Point(0,0);
    private Direction direction = Direction.SOUTH;
    private boolean airborne = false;
    private GroundVisor groundVisor;


    public Rover(GroundVisor groundVisor) {
        this.groundVisor = groundVisor;
    }


    public void turnTo(Direction direction) {
        this.direction = direction;
    }


    public void move() {
        if (isAirborne())
            return;

        Point newPosition = new Point(currentPosition);

        switch (direction) {
            case WEST:
                newPosition.x -= 1;
                break;
            case EAST:
                newPosition.x += 1;
                break;
            case NORTH:
                newPosition.y -= 1;
                break;
            case SOUTH:
                newPosition.y += 1;
                break;
        }

        try {
            if (!groundVisor.hasObstacles(newPosition)) {
                currentPosition = newPosition;
            }
        } catch (OutOfGroundException e) {
            lift();
        }
    }


    public void lift() {
        airborne = true;
        currentPosition = null;
        direction = null;
    }


    public void land(Point expectedPosition, Direction direction) {
        try {
            if (!groundVisor.hasObstacles(expectedPosition)) {
                airborne = false;
                currentPosition = expectedPosition;
                this.direction = direction;
            }
        } catch (OutOfGroundException e) {}
    }


    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isAirborne() {
        return airborne;
    }
}
