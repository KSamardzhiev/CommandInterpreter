package com.vmware.edu.interpret.reference_refactoring.operations;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Operation;
import com.vmware.edu.interpret.reference_refactoring.variables.NumberVariable;

/**
 * This class implements Operation interface and provide the logic of the
 * subtract operation of command calc of two variables.
 * 
 * @author KSamardzhiev
 *
 */
public class SubstractOperation implements Operation {
	/**
	 * This variable stores the name of operation "-".
	 */
	private static final String OPERATION_NAME = "-";

	/**
	 * @return String - the name of the operation "-".
	 */
	@Override
	public String getOperationName() {
		return OPERATION_NAME;
	}

	/**
	 * @param cmdargs
	 *            - String with all parameters after the command calc.
	 * @return String with the result of calculation. If the execution is
	 *         correct, it will return "Ok".
	 */
	@Override
	public String calc(String cmdargs) {
		return substract(cmdargs);
	}

	/**
	 * @param cmdargs
	 *            - String with all parameters after the command calc.
	 * @return String with the result of calculation. If the execution is
	 *         correct, it will return "Ok".
	 * @author KSamardzhiev - As a side-effect, this methods put new key-value
	 *         in the map in which the Interpreter stores different type of
	 *         variables.
	 */
	private String substract(String cmdargs) {
		String[] args = cmdargs.split(" ");
		String newValue = CmdInterpreter.variables.get(args[1]).calcSubstract(CmdInterpreter.variables.get(args[3]));
		String newName = args[0];
		CmdInterpreter.variables.put(newName, new NumberVariable(newName, Integer.parseInt(newValue)));
		return "Ok";
	}
}
