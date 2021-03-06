package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class LiftCommand implements RoverCommand {
    Rover rover;

    public LiftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.lift();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LiftCommand other = (LiftCommand) obj;
        return rover == other.rover;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME + rover.hashCode();
    }

    @Override
    public String toString() {
        return "Rover lifted";
    }
}
