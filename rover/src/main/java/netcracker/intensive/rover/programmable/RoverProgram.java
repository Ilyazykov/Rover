package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RoverProgram {
    private Map<String, Object> settings;
    private Collection<RoverCommand> commands;

    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";


    private Direction getDirection(String s) {
        Direction res = Direction.EAST;
        switch (s) {
            case "west":
                res = Direction.WEST;
                break;
            case "north":
                res = Direction.NORTH;
                break;
            case "south":
                res = Direction.SOUTH;
        }
        return res;
    }


    public RoverProgram(String filePath, ProgrammableRover rover) throws IOException {
        settings = new HashMap<String, Object>();
        commands = new LinkedList<RoverCommand>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(SEPARATOR)) break;

                String[] lexems = line.split(" ");
                settings.put(lexems[0], lexems[1].equals("on"));
            }

            while ((line = reader.readLine()) != null) {
                if ((boolean)(settings.get(LOG))) {
                    commands.add(new LoggingCommand());
                }
                Direction direction;
                String[] lexems = line.split(" ");
                switch (lexems[0]) {
                    case "move":
                        commands.add(new MoveCommand(rover));
                        break;
                    case "turn":
                        direction = getDirection(lexems[1]);
                        commands.add(new TurnCommand(rover, direction));
                        break;
                    case "lift":
                        commands.add(new LiftCommand(rover));
                        break;
                    case "land":
                        int x = Integer.parseInt(lexems[1]);
                        int y = Integer.parseInt(lexems[2]);
                        direction = getDirection(lexems[3]);
                        commands.add(new LandCommand(rover, new Point(x, y), direction));
                }
            }
        } finally {
            reader.close();
        }
    }


    public Map<String, Object> getSettings() {
        return settings;
    }

    public Collection<RoverCommand> getCommands() {
        return commands;
    }
}
