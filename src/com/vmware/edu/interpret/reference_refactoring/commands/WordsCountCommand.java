package com.vmware.edu.interpret.reference_refactoring.commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implements Command interface and provide the logic of the command
 * words-count.
 * 
 * @author KSamardzhiev
 *
 */
public class WordsCountCommand implements Command {
	/**
	 * This variable stores the name of the command words-count.
	 */
	private static final String COMMAND_NAME = "words-count";

	/**
	 * @return String - the name of the command words-count.
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param cmdargs
	 *            - String with all parameters after the command words-count.
	 * @return String - the result of execution of the command words-count.
	 */
	@Override
	public String execute(String cmdargs) {
		int numberOfLine = 0;
		int numberOfWords = 0;
		int numberOfChars = 0;

		Scanner file = null;
		try {
			file = new Scanner(new FileReader(cmdargs));
			while (file.hasNextLine()) {
				String line = file.nextLine();
				String[] wordsInLine = line.split("\\s+");
				numberOfChars += line.length();
				numberOfWords += wordsInLine.length;
				numberOfLine++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			file.close();
		}
		return String.valueOf(numberOfLine) + " " + String.valueOf(numberOfWords) + " " + String.valueOf(numberOfChars);

	}

}
