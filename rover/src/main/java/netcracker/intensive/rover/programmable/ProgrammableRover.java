package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.RoverStatsModule;
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
    private RoverStatsModule roverStatsModule; //TODO dont used for a tests
    private RoverCommandParser commandParser;
    private Map<String, Object> settings;

    public ProgrammableRover(GroundVisor groundVisor, RoverStatsModule roverStatsModule) {
        super(groundVisor);
        this.roverStatsModule = roverStatsModule;
    }

    public void executeProgramFile(String file) {
        commandParser = new RoverCommandParser(this, file);
        RoverProgram program = commandParser.getProgram();
        Collection<RoverCommand> commands = program.getCommands();
        settings = program.getSettings();

        for (RoverCommand command : commands) {
            command.execute();

            if (settings.get(RoverProgram.STATS).equals(true)) {
                roverStatsModule.registerPosition(this.getCurrentPosition());
            }
        }
    }

    public Map<String,Object> getSettings() {
        return Collections.unmodifiableMap(settings);
    }
}
