package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;
import com.vmware.edu.interpret.reference_refactoring.variables.NumberVariable;

/**
 * This class provide the implementation of logic of set Number variable
 * 
 * @author KSamardzhiev
 *
 */
public class SetNumberVariableCommand implements Command {
	/**
	 * This variable stores the name of this command and make it easy to choose
	 * which type of variable to set. In this case - number.
	 */
	private final String NAME = "number";

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
	 * @author KSamardzhiev - this method set number variable. As a side-effect,
	 *         this methods put new key-value in the map in which the
	 *         Interpreter stores different type of variables.
	 */
	@Override
	public String execute(String cmdargs) {
		String[] args = cmdargs.split(" ");
		CmdInterpreter.variables.put(args[0], new NumberVariable(args[0], Integer.parseInt(args[2])));
		return "Ok";
	}

}
