package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;
import com.vmware.edu.interpret.reference_refactoring.variables.StringVariable;

/**
 * This class provide the implementation of logic of set String variable
 * 
 * @author KSamardzhiev
 *
 */
public class SetStringVariableCommand implements Command {
	/**
	 * This variable stores the name of this command and make it easy to choose
	 * which type of variable to set. In this case - string.
	 */
	private final String NAME = "string";

	/**
	 * @return String - the name of the command.
	 */
	@Override
	public String getCommandName() {
		return this.NAME;
	}

	/**
	 * 
	 * @param cmdargs
	 *            - String of all parameters after the command
	 * @return String with the result of execution
	 * @author KSamardzhiev - this method set string variable. As a side-effect,
	 *         this methods put new key-value in the map in which the
	 *         Interpreter stores different type of variables.
	 */
	@Override
	public String execute(String cmdargs) {
		String[] args = cmdargs.split(" ");
		StringBuffer result = new StringBuffer(args[2]);
		for (int i = 3; i < args.length; i++) {
			result.append(" ");
			result.append(args[i]);
		}
		CmdInterpreter.variables.put(args[0], new StringVariable(args[0], result.toString()));

		return "Ok";
	}

}
