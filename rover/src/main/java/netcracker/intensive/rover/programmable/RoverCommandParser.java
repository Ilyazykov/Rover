package netcracker.intensive.rover.programmable;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RoverCommandParser {
    ProgrammableRover rover;
    RoverProgram program;

    public RoverCommandParser(ProgrammableRover rover, String fileName) {
        this.rover = rover;
        try {
            String filePath = this.getClass().getResource(fileName).getFile();
            program = new RoverProgram(filePath, rover);
        } catch (NullPointerException e) {
            throw new RoverCommandParserException();
        } catch (IOException e) {
            throw new RoverCommandParserException();
        }
    }

    public RoverProgram getProgram() {
        return program;
    }
}
