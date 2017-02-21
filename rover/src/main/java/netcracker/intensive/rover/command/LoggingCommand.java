package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    RoverCommand command;

    public LoggingCommand(RoverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        LOGGER.debug(command.toString());
        command.execute();
    }

    @Override
    public String toString() {
        return command.toString();
    }
}
