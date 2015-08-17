package com.vmware.edu.interpret.reference_refactoring.tests.testsVariables;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.variables.NumberVariable;

public class NumberVariableTest {

	private NumberVariable number;
	private NumberVariable secondNumber;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNumberVariableName() {
		number = new NumberVariable("a", 6);
		assertEquals("a", number.getName());
	}

	@Test
	public void testNumberVariableValue() {
		number = new NumberVariable("a", 12);
		assertEquals("12", number.getValue());
	}

	@Test
	public void testNumberVariableType() {
		number = new NumberVariable("a", 3);
		assertEquals("Number", number.getType());
	}

	@Test
	public void testSignedNumberVariableName() {
		number = new NumberVariable("a", -6);
		assertEquals("a", number.getName());
	}

	@Test
	public void testSignedNumberVariableValue() {
		number = new NumberVariable("a", -12);
		assertEquals("-12", number.getValue());
	}

	@Test
	public void testSignedNumberVariableType() {
		number = new NumberVariable("a", -3);
		assertEquals("Number", number.getType());
	}

	@Test
	public void testCalcPlusNumberVariable() {
		number = new NumberVariable("a", 3);
		secondNumber = new NumberVariable("b", 9);

		assertEquals("12", number.calcPlus(secondNumber));
	}

	@Test
	public void testCalcMultiplyNumberVariables() {
		number = new NumberVariable("a", 3);
		secondNumber = new NumberVariable("b", 9);

		assertEquals("27", number.calcMultiply(secondNumber));
	}

	@Test
	public void testCalcMultiplySignedNumberVariables() {
		number = new NumberVariable("a", -3);
		secondNumber = new NumberVariable("b", -9);

		assertEquals("27", number.calcMultiply(secondNumber));
	}

	@Test
	public void testCalcMultiplySignedNumberVariable() {
		number = new NumberVariable("a", 3);
		secondNumber = new NumberVariable("b", -9);

		assertEquals("-27", number.calcMultiply(secondNumber));
	}

	@Test
	public void testCalcSubstractNumberVariable() {
		number = new NumberVariable("a", 3);
		secondNumber = new NumberVariable("b", 9);

		assertEquals("-6", number.calcSubstract(secondNumber));
	}

}
