package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.WordsCountCommand;

public class WordsCountCommandTest {

	private WordsCountCommand wordsCountTest;

	@Before
	public void setUp() throws Exception {
		wordsCountTest = new WordsCountCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("words-count", wordsCountTest.getCommandName());
	}

	@Test
	public void testCommand() {
		String result = wordsCountTest.execute("test.txt");
		assertEquals("4 4 20", result);
	}

}
