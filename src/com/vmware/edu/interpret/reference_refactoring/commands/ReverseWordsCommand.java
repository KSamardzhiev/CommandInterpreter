package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implement Command interface and provide the logic of command
 * reverse-words.
 * 
 * @author KSamardzhiev
 *
 */
public class ReverseWordsCommand implements Command {
	/**
	 * This variable stores the name of command reverse-words
	 */
	private static final String COMMAND_NAME = "reverse-words";

	/**
	 * @return String - the name of command reverse-words
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param -
	 *            String of all parameters after the command
	 * @return String result of execution of command reverse-words
	 * @author KSamardzhiev - In this case it will return the reversed order of
	 *         words in the original parameter String
	 */
	@Override
	public String execute(String cmdargs) {
		StringBuilder revargs = new StringBuilder();
		String[] words = cmdargs.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			revargs.append(words[i]);
			if (i > 0) {
				revargs.append(" ");
			}
		}
		return revargs.toString();
	}

}
