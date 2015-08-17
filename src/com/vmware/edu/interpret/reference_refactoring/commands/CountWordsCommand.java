package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implement Command interface and provide the logic of command
 * count-words.
 * 
 * @author KSamardzhiev
 *
 */
public class CountWordsCommand implements Command {
	/**
	 * This variable stores the name of command count-words
	 */
	private static final String COMMAND_NAME = "count-words";

	/**
	 * @return String - the name of command count-words
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param -
	 *            String of all parameters after the command
	 * @return - String result of execution of command count-words
	 * @author KSamardzhiev - In this case it will return the number of words in
	 *         the String parameter.
	 */
	@Override
	public String execute(String cmdargs) {
		int count = cmdargs.split(" ").length;
		return String.valueOf(count);
	}

}
