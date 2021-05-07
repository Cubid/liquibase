package liquibase.command.core;

import liquibase.command.*;
import liquibase.integration.commandline.Main;

public class SnapshotReferenceCommandStep extends AbstractCliWrapperCommandStep {

    public static final String[] COMMAND_NAME = {"snapshotReference"};

    public static final CommandArgumentDefinition<String> REFERENCE_USERNAME_ARG;
    public static final CommandArgumentDefinition<String> REFERENCE_PASSWORD_ARG;
    public static final CommandArgumentDefinition<String> REFERENCE_URL_ARG;
    public static final CommandArgumentDefinition<String> SNAPSHOT_FORMAT_ARG;

    static {
        CommandBuilder builder = new CommandBuilder(COMMAND_NAME);
        REFERENCE_URL_ARG = builder.argument("referenceUrl", String.class).required()
            .description("The JDBC reference database connection URL").build();
        REFERENCE_USERNAME_ARG = builder.argument("referenceUsername", String.class)
            .description("Reference username to use to connect to the database").build();
        REFERENCE_PASSWORD_ARG = builder.argument("referencePassword", String.class)
            .description("Reference password to use to connect to the database").build();
        SNAPSHOT_FORMAT_ARG = builder.argument("snapshotFormat", String.class)
            .description("Output format to use (JSON or YAML").build();
    }

    @Override
    public String[] getName() {
        return COMMAND_NAME;
    }

    @Override
    public void adjustCommandDefinition(CommandDefinition commandDefinition) {
        commandDefinition.setShortDescription("Capture the current state of the reference database");
    }
}
