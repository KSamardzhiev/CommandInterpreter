package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.commands.CalcCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;

public class CalcCommandTest {

	private CalcCommand calcTest;
	private SetCommand setTest;
	private GetCommand getTest;

	@Before
	public void setUp() throws Exception {
		calcTest = new CalcCommand();
		setTest = new SetCommand();
		getTest = new GetCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("calc", calcTest.getCommandName());

	}

	@Test
	public void testCalcPlusTwoStringVariables() {
		setTest.execute("a string Kostadin");
		setTest.execute("b string Samardzhiev");
		String result = calcTest.execute("c a + b");
		assertEquals("Ok", result);
		assertEquals("KostadinSamardzhiev", CmdInterpreter.variables.get("c").getValue());
		assertEquals("String", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[String] KostadinSamardzhiev", getTest.execute("c"));
	}

	@Test
	public void testCalcPlusStringVariableNumberVariable() {
		setTest.execute("a string Kostadin");
		setTest.execute("b number 6");
		String result = calcTest.execute("c a + b");
		assertEquals("Ok", result);
		assertEquals("Kostadin6", CmdInterpreter.variables.get("c").getValue());
		assertEquals("String", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[String] Kostadin6", getTest.execute("c"));
	}

	@Test
	public void testCalcPlusTwoNumberVariables() {
		setTest.execute("a number 12");
		setTest.execute("b number 6");
		String result = calcTest.execute("c a + b");
		assertEquals("Ok", result);
		assertEquals("18", CmdInterpreter.variables.get("c").getValue());
		assertEquals("Number", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[Number] 18", getTest.execute("c"));
	}

	@Test
	public void testCalcPlusTwoSignedNumberVariablesMinus() {
		setTest.execute("a number -12");
		setTest.execute("b number -6");
		String result = calcTest.execute("c a + b");
		assertEquals("Ok", result);
		assertEquals("-18", CmdInterpreter.variables.get("c").getValue());
		assertEquals("Number", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[Number] -18", getTest.execute("c"));
	}
	
	@Test
	public void testCalcMultiplyStringVariableNumberVariable() {
		setTest.execute("a string Kostadin");
		setTest.execute("b number 3");
		String result = calcTest.execute("c a * b");
		assertEquals("Ok", result);
		assertEquals("KostadinKostadinKostadin", CmdInterpreter.variables.get("c").getValue());
		assertEquals("String", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[String] KostadinKostadinKostadin", getTest.execute("c"));
	}
	
	@Test
	public void testCalcMultiplyTwoNumberVariables() {
		setTest.execute("a number 12");
		setTest.execute("b number 6");
		String result = calcTest.execute("c a * b");
		assertEquals("Ok", result);
		assertEquals("72", CmdInterpreter.variables.get("c").getValue());
		assertEquals("Number", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[Number] 72", getTest.execute("c"));
	}
	@Test
	public void testCalcSubstractTwoNumberVariables() {
		setTest.execute("a number 12");
		setTest.execute("b number 6");
		String result = calcTest.execute("c a - b");
		assertEquals("Ok", result);
		assertEquals("6", CmdInterpreter.variables.get("c").getValue());
		assertEquals("Number", CmdInterpreter.variables.get("c").getType());
		assertEquals("c", CmdInterpreter.variables.get("c").getName());
		assertEquals("[Number] 6", getTest.execute("c"));
	}


}
