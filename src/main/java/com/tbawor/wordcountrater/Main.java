package com.tbawor.wordcountrater;

import com.tbawor.wordcountrater.cmd.WCRCommandInterpreter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WCRCommandInterpreter commandInterpeter = new WCRCommandInterpreter(args);
        Scanner keyboard = new Scanner(System.in);

        while (commandInterpeter.shouldRun()) {
            commandInterpeter.printPrompt();
            final String inputLine = keyboard.nextLine();
            commandInterpeter.executeCommand(inputLine);
        }

    }
}