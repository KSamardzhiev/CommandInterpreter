package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.CountWordsCommand;

public class CountWordsCommandTest {

	private CountWordsCommand countWordsTest;
	@Before
	public void setUp() throws Exception {
		countWordsTest = new CountWordsCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("count-words", countWordsTest.getCommandName());
	}
	
	@Test
	public void testWordsCount() {
		String result = countWordsTest.execute("Java is interesting language");
		assertEquals("4", result);
	}
	
	@Test
	public void testWordsCountWithNumbers() {
		String result = countWordsTest.execute("Lily have 3 apples");
		assertEquals("4", result);
	}
	
	@Test
	public void testWordsCountOneWord() {
		String result = countWordsTest.execute("Lily");
		assertEquals("1", result);
	}
	
	


}
