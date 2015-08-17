package com.vmware.edu.interpret.reference_refactoring.tests.testsOperations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.operations.MultiplyOperation;

public class MultiplyOperationTest {

	private MultiplyOperation multiply;
	private SetCommand set;
	private GetCommand get;

	@Before
	public void setUp() throws Exception {
		multiply = new MultiplyOperation();
		set = new SetCommand();
		get = new GetCommand();
	}

	@Test
	public void testGetOperationName() {
		assertEquals("*", multiply.getOperationName());
	}
	
	@Test
	public void testCalcMultiplyOperationNumberVariables() {
		set.execute("a number 8");
		set.execute("b number 4");
		assertEquals("Ok", multiply.calc("c a * b"));
		assertEquals("[Number] 32",get.execute("c"));
	}
	
	@Test
	public void testCalcMultiplyOperationDifferentVariables() {
		set.execute("a string VM");
		set.execute("b number 2");
		assertEquals("Ok", multiply.calc("c a * b"));
		assertEquals("[String] VMVM",get.execute("c"));
	}

}
