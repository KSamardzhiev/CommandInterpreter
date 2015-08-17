package com.vmware.edu.interpret.reference_refactoring.tests.testsCommands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.commands.ReverseWordsCommand;

public class ReverseWordsCommandTest {

	private ReverseWordsCommand reverseWords;
	
	@Before
	public void setUp() throws Exception {
		reverseWords = new ReverseWordsCommand();
	}

	@Test
	public void testGetCommandName() {
		assertEquals("reverse-words", reverseWords.getCommandName());
	}
	
	@Test
	public void testRevesrseTwoWords() {
		assertEquals("Samardzhiev Kostadin", reverseWords.execute("Kostadin Samardzhiev"));
	}
	@Test
	public void testRevesrseSentence() {
		assertEquals("2015 Class Boost Talent", reverseWords.execute("Talent Boost Class 2015"));
	}

}
