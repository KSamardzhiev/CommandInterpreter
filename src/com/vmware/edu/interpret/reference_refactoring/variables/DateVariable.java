package com.vmware.edu.interpret.reference_refactoring.variables;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * This class implements Variable interface and provide the logic of each set
 * Date variable in the Interpreter.
 * 
 * @author KSamardzhiev
 *
 */
public class DateVariable implements Variable {
	/**
	 * This variable stores the name of particular variable (date variable).
	 */
	private String name;
	/**
	 * This variable stores the day of particular variable (date variable).
	 */
	private int day;
	/**
	 * This variable stores the month of particular variable (date variable).
	 */
	private int month;
	/**
	 * This variable stores the year of particular variable (date variable).
	 */
	private int year;
	/**
	 * This variable stores the type of particular variable ("Date" type for
	 * StringVariables()).
	 */
	private final String TYPE = "Date";

	/**
	 * 
	 * @param name
	 *            - String of the name of new variable.
	 * @param value
	 *            - String value of new variable (date).
	 */
	public DateVariable(String name, String date) {
		this.name = name;
		String[] arg = date.split("\\.");
		this.day = Integer.parseInt(arg[0]);
		this.month = Integer.parseInt(arg[1]);
		this.year = Integer.parseInt(arg[2]);
	}

	/**
	 * @return String - the name of the variable.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return String - the value of the variable (date).
	 */
	@Override
	public String getValue() {
		return String.valueOf(this.day) + "." + String.valueOf(this.month) + "." + String.valueOf(this.year);
	}

	/**
	 * @return String - the type of the variable (e.g. "Date").
	 */
	@Override
	public String getType() {
		return this.TYPE;
	}

	/**
	 * @param variable
	 *            - instance of class which implements Variable interface.
	 * @return String - result of execution of calcPlus method (summation of
	 *         date variables and number).
	 */
	@Override
	public String calcPlus(Variable variable) {
		if (variable.getType() == "String" || variable.getType() == "Date") {
			return "It is not allowed to make calculation between Date and String/Date";
		}
		// TODO plus logic of Date+number
		return "Ok";
	}

	@Override
	public String calcMultiply(Variable variable) {
		return "Error";
	}

	@Override
	public String calcSubstract(Variable variable) {
		return "Error";
	}

}
