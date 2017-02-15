package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LandCommand implements RoverCommand {
    Rover rover;
    Point position;
    Direction direction;

    public LandCommand(Rover rover, Point position, Direction direction) {
        this.rover = rover;
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute() {
        //TODO
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LandCommand other = (LandCommand) obj;
        return rover == other.rover && direction == other.direction && position.equals(other.position);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + rover.hashCode();
        result = PRIME * result + direction.hashCode();
        result = PRIME * result + direction.hashCode();
        result = PRIME * result + position.hashCode();
        return result;
    }
}
