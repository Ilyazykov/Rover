package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import javax.management.openmbean.CompositeData;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover {
    private SimpleRoverStatsModule simpleRoverStatsModule;
    private RoverCommandParser commandParser;
    private Map<String, Object> settings;

    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule simpleRoverStatsModule) {
        super(groundVisor);
        this.simpleRoverStatsModule = simpleRoverStatsModule;
    }

    public void executeProgramFile(String file) {
        commandParser = new RoverCommandParser(this, file);
        RoverProgram program = commandParser.getProgram();
        Collection<RoverCommand> commands = program.getCommands();
        settings = program.getSettings();

        for (RoverCommand command : commands) {
            command.execute();
        }
    }

    public Map<String,Object> getSettings() {
        return Collections.unmodifiableMap(settings);
    }
}
