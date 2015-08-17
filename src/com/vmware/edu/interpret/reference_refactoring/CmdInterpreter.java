package com.vmware.edu.interpret.reference_refactoring;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.vmware.edu.interpret.reference_refactoring.commands.CalcCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.CountWordsCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.ReverseStringCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.ReverseWordsCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetDateVariableCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetNumberVariableCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetStringVariableCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.WordsCountCommand;
import com.vmware.edu.interpret.reference_refactoring.operations.MultiplyOperation;
import com.vmware.edu.interpret.reference_refactoring.operations.PlusOperation;
import com.vmware.edu.interpret.reference_refactoring.operations.SubstractOperation;

/**
 * This is the main class of Interpreter. It provide you the ability to start
 * the Interpreter and work with it. It can be used for searching and using
 * variables and commands through its static Maps too.
 * 
 * @author KSamardzhiev
 *
 */
public class CmdInterpreter {
	/**
	 * This is Collection of instances of all possible set command -
	 * SetStringCommand() class, SetNumberCommand() class and SetDateCommand()
	 * class
	 */
	private static final Collection<Command> SET_OPTIONS = Arrays.asList(new Command[] { new SetStringVariableCommand(),
			new SetNumberVariableCommand(), new SetDateVariableCommand() });
	/**
	 * This data structure contains mapped name of command and instance of this
	 * command for set particular variable (e.g "string" - new
	 * SetStringCommand())
	 */
	public static final Map<String, Command> SET_MAP = new HashMap<String, Command>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			for (Command command : SET_OPTIONS) {
				put(command.getCommandName(), command);
			}
		}
	};

	/**
	 * This map stores each new set variable in our Interpreter. The key is
	 * String - name of variable for easy searching in the map
	 */
	public static Map<String, Variable> variables = new HashMap<String, Variable>();

	/**
	 * This is Collection of instances of all command in our Interpreter
	 */
	private static final Collection<Command> COMMANDS = Arrays
			.asList(new Command[] { new ReverseStringCommand(), new CountWordsCommand(), new WordsCountCommand(),
					new ReverseWordsCommand(), new SetCommand(), new GetCommand(), new CalcCommand() });
	/**
	 * This data structure contains mapped name of command and instance of this
	 * command (e.g "reverse" - new ReverseStringCommand())
	 */
	private static final Map<String, Command> COMMAND_MAP = new HashMap<String, Command>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		{
			for (Command command : COMMANDS) {
				put(command.getCommandName(), command);
			}
		}
	};
	/**
	 * This is Collection of instances of all operation (calc) in our
	 * Interpreter
	 */
	private static final Collection<Operation> OPERATIONS = Arrays
			.asList(new Operation[] { new PlusOperation(), new SubstractOperation(), new MultiplyOperation() });
	/**
	 * This data structure contains mapped name of operation and instance of
	 * this operation implementation (e.g "+" - new PlusOperation())
	 */
	public static final Map<String, Operation> OPERATION_MAP = new HashMap<String, Operation>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		{
			for (Operation operation : OPERATIONS) {
				put(operation.getOperationName(), operation);
			}
		}
	};

	public static void main(String[] args) {
		InputStream instr = System.in;

		CmdInterpreter cmdInterpreter = new CmdInterpreter();
		cmdInterpreter.processInput(instr);
	}

	/**
	 * 
	 * @param instr
	 *            - type InputStream - System.in.
	 * @author Takes the user input and process it.
	 * @throws NoSuchElementException
	 *             if end of file is reached
	 */
	private void processInput(InputStream instr) {
		Scanner inscan = new Scanner(instr);
		try {
			while (true) {
				String line = inscan.nextLine().trim();
				processLine(line);
			}
		} catch (NoSuchElementException e) {
			// end of file reached
		} finally {
			inscan.close();
		}
	}

	/**
	 * 
	 * @param line
	 *            String of user input line (e.g reverse abra cadabra).
	 * @author Process the String - parse each command and take arguments after
	 *         it. The command is searched in COMMAND_MAP data structure. If it
	 *         doesn't contain the command the user will be informed with
	 *         message - "Err: Unknown command ..."
	 * @throws NoSuchElementException
	 *             if command can not be parse
	 * 
	 */
	private static void processLine(String line) {
		Scanner linescan = new Scanner(line);
		try {
			String command = linescan.next();

			String cmdargs = linescan.nextLine().trim();

			Command cmd = COMMAND_MAP.get(command);
			if (cmd == null) {
				System.out.println("Err: Unknown command " + command);
				return;
			}
			String result = cmd.execute(cmdargs);
			System.out.println(result);
		} catch (NoSuchElementException e) {
			System.out.println("Cannot parse command: " + line);
		} finally {
			linescan.close();
		}

	}
}
