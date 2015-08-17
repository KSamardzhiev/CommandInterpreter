package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;

public class SetCommandTest {

	private SetCommand testSet;
	
	@Before
	public void setUp() throws Exception {
		testSet = new SetCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("set", testSet.getCommandName());
	}
	
	@Test
	public void testExecuteStringVariable(){
		testSet.execute("test string tester");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("tester",CmdInterpreter.variables.get("test").getValue());
		assertEquals("String",CmdInterpreter.variables.get("test").getType());
	}
	
	@Test
	public void testExecuteStringVariableSentence(){
		testSet.execute("test string tester is good");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("tester is good",CmdInterpreter.variables.get("test").getValue());
		assertEquals("String",CmdInterpreter.variables.get("test").getType());
	}
	
	@Test
	public void testExecuteNumberVariable(){
		testSet.execute("test number 12");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("12",CmdInterpreter.variables.get("test").getValue());
		assertEquals("Number",CmdInterpreter.variables.get("test").getType());
	}
	
	@Test
	public void testExecuteNumberVariableSignedNumberMinus(){
		testSet.execute("test number -12");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("-12",CmdInterpreter.variables.get("test").getValue());
		assertEquals("Number",CmdInterpreter.variables.get("test").getType());
	}
	
	@Test
	public void testExecuteNumberVariableSignedNumberPlus(){
		testSet.execute("test number +12");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("12",CmdInterpreter.variables.get("test").getValue());
		assertEquals("Number",CmdInterpreter.variables.get("test").getType());
	}

	@Test
	public void testExecuteNumberVariableZero(){
		testSet.execute("test number 0");
		assertEquals("test",CmdInterpreter.variables.get("test").getName());
		assertEquals("0",CmdInterpreter.variables.get("test").getValue());
		assertEquals("Number",CmdInterpreter.variables.get("test").getType());
	}
}
