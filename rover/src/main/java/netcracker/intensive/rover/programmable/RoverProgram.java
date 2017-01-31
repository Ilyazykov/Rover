package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.awt.*;
import java.util.Collection;
import java.util.Map;

public class RoverProgram {
    Map<String, Object> settings; //TODO
    Collection<RoverCommand> commands; //TODO

    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";

    public Map<String, Object> getSettings() {
        //TODO
        return settings;
    }

    public Collection<RoverCommand> getCommands() {
        //TODO
        return commands;
    }
}
