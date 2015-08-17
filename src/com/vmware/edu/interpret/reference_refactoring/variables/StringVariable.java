package com.vmware.edu.interpret.reference_refactoring.variables;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * This class implements Variable interface and provide the logic of each set
 * String variable in the Interpreter.
 * 
 * @author KSamardzhiev
 *
 */
public class StringVariable implements Variable {
	/**
	 * This variable stores the name of particular variable (string variable).
	 */
	private String name;
	/**
	 * This variable stores the value of particular variable (string variable).
	 */
	private String value;
	/**
	 * This variable stores the type of particular variable ("String" type for
	 * StringVariables()).
	 */
	private static final String TYPE = "String";

	/**
	 * 
	 * @param name
	 *            - String of the name of new variable.
	 * @param value
	 *            - String value of new variable.
	 */
	public StringVariable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return String - the name of the variable.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return String - the value of the variable.
	 */
	@Override
	public String getValue() {
		return this.value;
	}

	/**
	 * @return String - the type of the variable (e.g. "String").
	 */
	@Override
	public String getType() {
		return TYPE;
	}

	/**
	 * @param variable
	 *            - instance of class which implements Variable interface.
	 * @return String - result of execution of calcPlus method (summation of two
	 *         variables).
	 */
	@Override
	public String calcPlus(Variable variable) {
		String result = this.value + variable.getValue();
		return result;
	}

	/**
	 * @param variable
	 *            - instance of class which implements Variable interface.
	 * @return String - result of execution of calcPlus method (multiplication
	 *         of two variables).
	 */
	@Override
	public String calcMultiply(Variable variable) {
		if (variable.getType().equals("String")) {
			return "It is not allowed to multiply two String variables";
		}

		StringBuffer result = new StringBuffer(this.value);
		int iteration = Integer.parseInt(variable.getValue());
		for (int i = 1; i < iteration; i++) {
			result.append(this.value);
		}
		return result.toString();
	}

	/**
	 * @return String - error message because it is not allowed to subtract two
	 *         Strings
	 */
	@Override
	public String calcSubstract(Variable variable) {
		return "It is not allowed to substract from String variables";
	}

}
