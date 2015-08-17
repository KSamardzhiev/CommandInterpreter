package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.ReverseStringCommand;

public class ReverseStringCommandTest {

	private ReverseStringCommand reverse;
	@Before
	public void setUp() throws Exception {
		reverse = new ReverseStringCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("reverse",reverse.getCommandName());
	}
	@Test
	public void testReverseStringTwoLetters() {
		assertEquals("ba",reverse.execute("ab"));
	}
	
	@Test
	public void testReverseStringMoreLetters() {
		assertEquals("nidatsoK",reverse.execute("Kostadin"));
	}
	
	@Test
	public void testReverseStringTwoWords() {
		assertEquals("veihzdramaS nidatsoK",reverse.execute("Kostadin Samardzhiev"));
	}
	
	@Test
	public void testReverseNumbers() {
		assertEquals("12",reverse.execute("21"));
	}

}
