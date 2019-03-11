package com.tbawor.wordcountrater;

import com.tbawor.wordcountrater.cmd.WCRCommandInterpreter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.assertj.core.api.Assertions.assertThat;

public class WCRCommandInterpreterTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenEmptyArrayProvided() {
        // given
        String[] args = {};

        // when
        new WCRCommandInterpreter(args);
    }

    @Test
    public void shouldBeRunningAfterCreation() {
        // given
        String[] args = {fakeDir()};

        // when
        WCRCommandInterpreter commandInterpreter = new WCRCommandInterpreter(args);

        // then
        assertThat(commandInterpreter.shouldRun()).isTrue();
    }

    @Test
    public void shouldNotBeRunningAfterQuitCommand() {
        // given
        String[] args = {fakeDir()};
        WCRCommandInterpreter commandInterpreter = new WCRCommandInterpreter(args);

        // when
        commandInterpreter.executeCommand(":quit");

        // then
        assertThat(commandInterpreter.shouldRun()).isFalse();
    }

    String fakeDir() {
        return tempFolder.getRoot().getPath();
    }

}
