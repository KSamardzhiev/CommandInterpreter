package com.vmware.edu.interpret.reference_refactoring;

/**
 * This interface provide the abilities of each variable. It is implemented by
 * StringVariable class and NumberVariable class
 * 
 * @author KSamardzhiev
 *
 */
public interface Variable {
	/**
	 * 
	 * @return String - the name of particular variable
	 */
	String getName();

	/**
	 * 
	 * @return String - the value of particular variable
	 */
	String getValue();

	/**
	 * 
	 * @return String - the type of particular variable (e.g. String or Number)
	 */
	String getType();

	/**
	 * 
	 * @param variable
	 *            - instance of class which implement Variable interface (e.g
	 *            StringVariable or NumberVariable)
	 * @return String - the result of calculation between the two variables. In
	 *         this case the operation is "+"
	 */
	String calcPlus(Variable variable);

	/**
	 * 
	 * @param variable
	 *            - instance of class which implement Variable interface (e.g
	 *            StringVariable or NumberVariable)
	 * @return String - the result of calculation between the two variables. In
	 *         this case the operation is "*"
	 */
	String calcMultiply(Variable variable);

	/**
	 * 
	 * @param variable
	 *            - instance of class which implement Variable interface (e.g
	 *            StringVariable or NumberVariable)
	 * @return String - the result of calculation between the two variables. In
	 *         this case the operation is "-"
	 */
	String calcSubstract(Variable variable);
}
