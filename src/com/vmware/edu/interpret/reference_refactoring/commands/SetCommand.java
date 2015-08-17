package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;

/**
 * This class implement Command interface and provide the logic of command set.
 *
 * @author KSamardzhiev
 */
public class SetCommand implements Command {
	/**
	 * This variable stores the name of command set
	 */
	private static final String COMMAND_NAME = "set";

	/**
	 * @return String - the name of command set
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param cmdargs
	 *            - String of all parameters after the command
	 * @return String result of execution of command set
	 * @author KSamardzhiev - In this case it will return "Ok" if the execution
	 *         is completed correct, otherwise it will return message with the
	 *         error (e.g The type of variable is wrong... Only string or number
	 *         type.)
	 * 
	 */
	@Override
	public String execute(String cmdargs) {
		String[] args = cmdargs.split(" ");
		Command cmd = CmdInterpreter.SET_MAP.get(args[1]);
		if (cmd == null) {
			return "The type of variable is wrong... Only string or number type.";
		}
		return cmd.execute(cmdargs);
	}
}
