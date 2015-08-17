package com.vmware.edu.interpret.reference_refactoring.commands;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Command;
import com.vmware.edu.interpret.reference_refactoring.variables.DateVariable;

/**
 * This class provide the implementation of logic of set Date variable
 * 
 * @author KSamardzhiev
 *
 */
public class SetDateVariableCommand implements Command {
	/**
	 * This variable stores the name of this command and make it easy to choose
	 * which type of variable to set. In this case - date.
	 */
	private final String NAME = "date";

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
	 * @author KSamardzhiev - this method set string variable. As a side-effect,
	 *         this methods put new key-value in the map in which the
	 *         Interpreter stores different type of variables.
	 */
	@Override
	public String execute(String cmdargs) {

		String[] args = cmdargs.split(" ");
		String inputDate = args[2];
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			formatter.setLenient(false);
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			// e.printStackTrace();
			return "Wrong date: Your date is invalid... ";
		}
		CmdInterpreter.variables.put(args[0], new DateVariable(args[0], args[2]));
		return "Ok";
	}

}
