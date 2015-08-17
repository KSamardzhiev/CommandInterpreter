package com.vmware.edu.interpret.reference_refactoring.commands;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;
import com.vmware.edu.interpret.reference_refactoring.Operation;

/**
 * This class implements Command interface and provide the implementation of
 * command calc.
 * 
 * @author KSamardzhiev
 *
 */
public class CalcCommand implements Command {
	/**
	 * This variable stores the name of the command calc.
	 */
	private static final String COMMAND_NAME = "calc";

	/**
	 * @return String - the name of the command calc.
	 */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param cmdargs
	 *            - String with all parameters after the command calc.
	 * @return String - the result of execution of the command calc.
	 */
	@Override
	public String execute(String cmdargs) {
		String[] args = cmdargs.split(" ");
		String cmd = args[2];
		Operation operation = CmdInterpreter.OPERATION_MAP.get(cmd);
		if (operation == null) {
			return "Error! Incorrect operation. Provide only + - *";
		}
		return operation.calc(cmdargs);
	}
}
