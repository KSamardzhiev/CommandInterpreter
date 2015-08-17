package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;

public class GetCommandTest {

	private SetCommand testSet;
	private GetCommand testGet;

	@Before
	public void setUp() throws Exception {
		testSet = new SetCommand();
		testGet = new GetCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("get", testGet.getCommandName());
	}
	
	@Test
	public void testGetStringVariable() {
		testSet.execute("test string tester");
		assertEquals("[String] tester", testGet.execute("test"));
	}
	@Test
	public void testGetStringVariableSentence() {
		testSet.execute("test string tester is good");
		assertEquals("[String] tester is good", testGet.execute("test"));
	}
	
	@Test
	public void testGetNumberVariable() {
		testSet.execute("test number 56");
		assertEquals("[Number] 56", testGet.execute("test"));
	}
	
	@Test
	public void testGetNumberVariableSignedMinus() {
		testSet.execute("test number -56");
		assertEquals("[Number] -56", testGet.execute("test"));
	}
	
	@Test
	public void testGetNumberVariableSignedPlus() {
		testSet.execute("test number +96");
		assertEquals("[Number] 96", testGet.execute("test"));
	}
	
	@Test
	public void testGetNumberVariableZero() {
		testSet.execute("test number 0");
		assertEquals("[Number] 0", testGet.execute("test"));
	}
	
	@Test
	public void testGetVariableNotInTheMap() {
		assertEquals("This variable doesn't exist", testGet.execute("a"));
	}
	
	

}
