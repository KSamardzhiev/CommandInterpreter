package com.vmware.edu.interpret.reference_refactoring.variables;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * This class implements Variable interface and provide the logic of each set
 * Number variable in the Interpreter.
 * 
 * @author KSamardzhiev
 *
 */
public class NumberVariable implements Variable {
	/**
	 * This variable stores the name of particular variable (number variable).
	 */
	private String name;
	/**
	 * This variable stores the value of particular variable (number variable).
	 */
	private int value;
	/**
	 * This variable stores the type of particular variable ("Number" type for
	 * NumberVariables()).
	 */
	private static String TYPE = "Number";

	/**
	 * 
	 * @param name
	 *            - String of the name of new variable.
	 * @param value
	 *            - Int number - value of new variable.
	 */
	public NumberVariable(String name, int value) {
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
	 * @return String - the parse value to String of the variable.
	 */
	@Override
	public String getValue() {
		return String.valueOf(this.value);
	}

	/**
	 * @return String - the type of the variable (e.g "Number").
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

		this.checkTypeString(variable);
		String result = String.valueOf(this.value + Integer.parseInt(variable.getValue()));
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

		this.checkTypeString(variable);
		String result = String.valueOf(this.value * Integer.parseInt(variable.getValue()));
		return result;
	}

	/**
	 * @param variable
	 *            - instance of class which implements Variable interface.
	 * @return String - result of execution of calcPlus method (subtraction of
	 *         two variables).
	 */
	@Override
	public String calcSubstract(Variable variable) {

		this.checkTypeString(variable);
		String result = String.valueOf(this.value - Integer.parseInt(variable.getValue()));
		return result;
	}

	/**
	 * 
	 * @param variable
	 *            - instance of class which implements Variable interface.
	 * @author KSamardzhiev - In this case, if the parameter of the method is
	 *         instance of StringVariable class, this method will throw
	 *         exception.
	 * @throws IllegalArgumentException
	 */
	private void checkTypeString(Variable variable) {

		if (variable.getType().equals("String")) {
			throw new IllegalArgumentException(
					"Wrong type of variable... It is not allowed to make calculation between Number and String");
		}

	}
}
