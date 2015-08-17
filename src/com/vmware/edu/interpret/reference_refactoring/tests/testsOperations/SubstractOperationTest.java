package com.vmware.edu.interpret.reference_refactoring.tests.testsOperations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.operations.SubstractOperation;

public class SubstractOperationTest {

	private SubstractOperation substract;
	private SetCommand set;
	private GetCommand get;
	@Before
	public void setUp() throws Exception {
		substract = new SubstractOperation();
		set = new SetCommand();
		get = new GetCommand();
	}

	@Test
	public void testGetOperationName() {
		assertEquals("-",substract.getOperationName());
	}
	
	@Test
	public void testCalcSubstractNumberVariables() {
		set.execute("a number 12");
		set.execute("b number 6");
		assertEquals("Ok", substract.calc("c a - b"));
		assertEquals("[Number] 6",get.execute("c"));
	}
	
	@Test
	public void testCalcSubstractSignedNumberVariables() {
		set.execute("a number -12");
		set.execute("b number 6");
		assertEquals("Ok", substract.calc("c a - b"));
		assertEquals("[Number] -18",get.execute("c"));
	}

}
