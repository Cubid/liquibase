package liquibase.extension.testing.command

import liquibase.exception.CommandValidationException

CommandTests.define {
    command = ["tag"]
    signature = """
Short Description: Mark the current database state with the specified tag
Long Description: NOT SET
Required Args:
  tag (String) Tag to add to the database changelog table
  url (String) The JDBC database connection URL
Optional Args:
  password (String) Password to use to connect to the database
    Default: null
  username (String) Username to use to connect to the database
    Default: null
"""

    run "Happy path", {
        arguments = [
                tag: "version_2.0"
        ]

        expectedResults = [
                statusCode   : 0
        ]
    }

    run "Run without a tag should throw an exception",  {
        arguments = [
                tag          : ""
        ]
        expectedException = CommandValidationException.class
    }

    run "Run without a changeLogFile should throw an exception",  {
        arguments = [
                tag          : "version_2.0"
        ]
        expectedException = CommandValidationException.class
    }

    run "Run without a URL should throw an exception",  {
        arguments = [
                url          : "",
                tag          : "version_2.0"
        ]
        expectedException = CommandValidationException.class
    }

    run "Run without any arguments should throw an exception",  {
        arguments = [
                url          : "",
                tag          : ""
        ]
        expectedException = CommandValidationException.class
    }
}