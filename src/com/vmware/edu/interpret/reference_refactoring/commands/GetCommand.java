package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implement Command interface and provide the logic of command get.
 * 
 * @author KSamardzhiev
 *
 */
public class GetCommand implements Command {
	/**
	 * This variable stores the name of command get
	 */
	private static final String COMMAND_NAME = "get";

	/**
	 * @return String - the name of command get
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param cmdargs
	 *            - String of all parameters after the command
	 * @return String result of execution of command get
	 * @author KSamardzhiev - In this case it will return String which contains
	 *         the type of the variable and its value if the execution is
	 *         completed correct, otherwise it will return message with the
	 *         error (e.g This variable doesn't exist.)
	 * 
	 */
	@Override
	public String execute(String cmdargs) {
		if (CmdInterpreter.variables.get(cmdargs) == null) {
			return "This variable doesn't exist";
		}
		String message = "[" + CmdInterpreter.variables.get(cmdargs).getType() + "] "
				+ CmdInterpreter.variables.get(cmdargs).getValue();
		return message;
	}
}
