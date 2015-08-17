package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implement Command interface and provide the logic of command
 * reverse.
 * 
 * @author KSamardzhiev
 *
 */
public class ReverseStringCommand implements Command {
	/**
	 * This variable stores the name of command reverse
	 */
	private static final String COMMAND_NAME = "reverse";

	/**
	 * @return String - the name of command reverse
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param -
	 *            String of all parameters after the command
	 * @return - String result of execution of command reverse
	 * @author KSamardzhiev - In this case it will return the reversed String of
	 *         the original parameter String
	 */
	@Override
	public String execute(String cmdargs) {
		return new StringBuilder(cmdargs).reverse().toString();
	}

}
