package liquibase.command.core;

import liquibase.command.*;
import liquibase.exception.CommandExecutionException;
import liquibase.integration.commandline.Main;

public class UpdateToTagSqlCommandStep extends AbstractCliWrapperCommandStep {

    public static final String[] COMMAND_NAME = {"updateToTagSql"};

    public static final CommandArgumentDefinition<String> URL_ARG;
    public static final CommandArgumentDefinition<String> USERNAME_ARG;
    public static final CommandArgumentDefinition<String> PASSWORD_ARG;
    public static final CommandArgumentDefinition<String> CHANGELOG_FILE_ARG;
    public static final CommandArgumentDefinition<String> LABELS_ARG;
    public static final CommandArgumentDefinition<String> CONTEXTS_ARG;
    public static final CommandArgumentDefinition<String> TAG_ARG;

    static {
        CommandBuilder builder = new CommandBuilder(COMMAND_NAME);
        URL_ARG = builder.argument("url", String.class).required()
            .description("The JDBC database connection URL").build();
        USERNAME_ARG = builder.argument("username", String.class)
            .description("Username to use to connect to the database").build();
        PASSWORD_ARG = builder.argument("password", String.class)
            .description("Password to use to connect to the database").build();
        CHANGELOG_FILE_ARG = builder.argument("changelogFile", String.class).required()
            .description("The root changelog").build();
        LABELS_ARG = builder.argument("labels", String.class)
            .description("Changeset labels to match").build();
        CONTEXTS_ARG = builder.argument("contexts", String.class)
            .description("Changeset contexts to match").build();
        TAG_ARG = builder.argument("tag", String.class).required()
            .description("The tag to genenerate SQL up to").build();
    }

    @Override
    public String[] getName() {
        return COMMAND_NAME;
    }

    @Override
    protected String[] collectArguments(CommandScope commandScope) throws CommandExecutionException {
        return createParametersFromArgs(createArgs(commandScope), "tag");
    }

    @Override
    public void adjustCommandDefinition(CommandDefinition commandDefinition) {
        commandDefinition.setShortDescription("Generate the SQL to deploy changes up to the tag");
    }
}
