package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class MoveCommand implements RoverCommand {
    Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.move();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MoveCommand other = (MoveCommand) obj;
        return rover == other.rover;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME + rover.hashCode();
    }

    @Override
    public String toString() {
        return "Rover moved";
    }
}
