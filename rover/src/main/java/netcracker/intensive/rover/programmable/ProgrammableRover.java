package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover {

    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule simpleRoverStatsModule) {
        super(groundVisor);
        //TODO
    }
}
