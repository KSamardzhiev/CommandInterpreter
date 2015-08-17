package com.vmware.edu.interpret.reference_refactoring.operations;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Operation;
import com.vmware.edu.interpret.reference_refactoring.variables.NumberVariable;
import com.vmware.edu.interpret.reference_refactoring.variables.StringVariable;

/**
 * This class implements Operation interface and provide the logic of multiply
 * operation of command calc between two variables.
 * 
 * @author KSamardzhiev
 *
 */
public class MultiplyOperation implements Operation {
	/**
	 * This variable stores the name of operation "*".
	 */
	private static final String OPERATION_NAME = "*";

	/**
	 * @return String - the name of the operation "*".
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
		return multiply(cmdargs);
	}

	/**
	 * 
	 * @param newName
	 *            - String of the name of the new variable which is result of
	 *            multiplication of the two variables.
	 * @param newValue
	 *            - String of the value of the new variable which is result of
	 *            multiplication of the two variables.
	 * @param args
	 *            - String array of split parameters after the command calc.
	 * @author KSamardzhiev - As a side-effect, this methods put new key-value
	 *         in the map in which the Interpreter stores different type of
	 *         variables.
	 */
	private void checkType(String newName, String newValue, String[] args) {
		if (CmdInterpreter.variables.get(args[1]).getType().equals("String")) {
			CmdInterpreter.variables.put(newName, new StringVariable(newName, newValue));
		} else
			CmdInterpreter.variables.put(newName, new NumberVariable(newName, Integer.parseInt(newValue)));
	}

	/**
	 * 
	 * @param cmdargs
	 *            - String with all parameters after the command calc.
	 * @return String - the result of execution of the multiplication.
	 */
	private String multiply(String cmdargs) {
		String[] args = cmdargs.split(" ");
		String newValue = CmdInterpreter.variables.get(args[1]).calcMultiply(CmdInterpreter.variables.get(args[3]));
		String newName = args[0];
		checkType(newName, newValue, args);
		return "Ok";
	}
}
