package com.vmware.edu.interpret.reference_refactoring;

/**
 * This interface provide the abilities of each operation (for calc command) in
 * our Interpreter. It is implemented by PlusOperation class, MultiplyOperation
 * class and SubstractOperation class
 * 
 * @author KSamardzhiev
 *
 */
public interface Operation {
	/**
	 * 
	 * @return String - the name of each operation
	 */
	String getOperationName();

	/**
	 * 
	 * @param cmdargs
	 *            - String with all parameters needed for the particular
	 *            operation to calc them
	 * @return String - the result of calculation of particular operation
	 */
	String calc(String cmdargs);
}
