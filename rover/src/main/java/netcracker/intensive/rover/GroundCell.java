package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundCell {
    CellState state;

    public GroundCell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }
}
