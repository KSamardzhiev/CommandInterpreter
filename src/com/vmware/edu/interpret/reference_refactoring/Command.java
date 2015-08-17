package com.vmware.edu.interpret.reference_refactoring;

/**
 * This interface provide the abilities of each command in our Interpreter. It
 * is implemented by ReverseWordsCommand class, ReverseStringCommand class,
 * CountWordsCommad class, WordsCountCommand class, SetCommand class, GetCommand
 * class, CalcCommand class.
 * 
 * @author KSamardzhiev
 *
 */
public interface Command {
	/**
	 * 
	 * @return String - the name of the command (e.g. reverse, reverse-words,
	 *         count-words, set, get, calc)
	 */
	String getCommandName();

	/**
	 * 
	 * @param cmdargs
	 *            - String of all parameters after particular command
	 * @return String - the result of each command execution
	 */
	String execute(String cmdargs);
}
