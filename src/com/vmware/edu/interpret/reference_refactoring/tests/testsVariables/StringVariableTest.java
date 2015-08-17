package com.vmware.edu.interpret.reference_refactoring.tests.testsVariables;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.variables.NumberVariable;
import com.vmware.edu.interpret.reference_refactoring.variables.StringVariable;

public class StringVariableTest {

	private StringVariable firstString;
	private StringVariable secondString;
	private NumberVariable number;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStringVariableName() {
		firstString = new StringVariable("firstString", "Talent Boost Class 2015");
		assertEquals("firstString", firstString.getName());
	}

	@Test
	public void testStringVariableValue() {
		firstString = new StringVariable("firstString", "Talent Boost Class 2015");
		assertEquals("Talent Boost Class 2015", firstString.getValue());
	}

	@Test
	public void testStringVariableType() {
		firstString = new StringVariable("firstString", "Talent Boost Class 2015");
		assertEquals("String", firstString.getType());
	}

	@Test
	public void testCaclPlusStringVariable() {
		firstString = new StringVariable("firstString", "Talent Boost");
		secondString = new StringVariable("secondString", "Class 2015");
		assertEquals("Talent BoostClass 2015", firstString.calcPlus(secondString));
	}

	@Test
	public void testCaclPlusNumberVariable() {
		firstString = new StringVariable("firstString", "Talent Boost Class ");
		number = new NumberVariable("number", 2015);
		assertEquals("Talent Boost Class 2015", firstString.calcPlus(number));
	}

	@Test
	public void testCaclMultiplyNumberVariable() {
		firstString = new StringVariable("firstString", "2015");
		number = new NumberVariable("number", 3);
		assertEquals("201520152015", firstString.calcMultiply(number));
	}

	@Test
	public void testCaclSubstractStringVariable() {
		firstString = new StringVariable("firstString", "Talent Boost");
		secondString = new StringVariable("secondString", "Class 2015");
		assertEquals("It is not allowed to substract from String variables", firstString.calcSubstract(secondString));
	}
	
	@Test
	public void testCaclMultiplyStringVariable() {
		firstString = new StringVariable("firstString", "Talent Boost");
		secondString = new StringVariable("secondString", "Class 2015");
		assertEquals("It is not allowed to multiply two String variables", firstString.calcMultiply(secondString));
	}

}
