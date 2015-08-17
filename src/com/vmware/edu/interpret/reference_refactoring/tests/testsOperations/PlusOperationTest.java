package com.vmware.edu.interpret.reference_refactoring.tests.testsOperations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.operations.PlusOperation;

public class PlusOperationTest {

	private PlusOperation plus;
	private SetCommand set;
	private GetCommand get;

	@Before
	public void setUp() throws Exception {
		plus = new PlusOperation();
		set = new SetCommand();
		get = new GetCommand();
	}

	@Test
	public void testGetOperationName() {
		assertEquals("+", plus.getOperationName());
	}

	@Test
	public void testCalcPlusOperationNumberVariables() {
		set.execute("a number 8");
		set.execute("b number 4");
		assertEquals("Ok", plus.calc("c a + b"));
		assertEquals("[Number] 12",get.execute("c"));
	}
	
	@Test
	public void testCalcPlusOperationStringVariables() {
		set.execute("a string VM");
		set.execute("b string ware");
		assertEquals("Ok", plus.calc("c a + b"));
		assertEquals("[String] VMware", get.execute("c"));
	}
	
	@Test
	public void testCalcPlusOperationDifferentVariables() {
		set.execute("a string VM");
		set.execute("b number 1");
		assertEquals("Ok", plus.calc("c a + b"));
		assertEquals("[String] VM1", get.execute("c"));
	}

}
