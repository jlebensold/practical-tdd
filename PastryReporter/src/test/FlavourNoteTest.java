package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PastryReporter.FlavourNote;

class FlavourNoteTest {

	@Test
	void testFlavourNote() {
		FlavourNote note = new FlavourNote("One", "Two");
		assertEquals(note.getPrimaryNote(), "One");
		assertEquals(note.getSecondaryNote(), "Two");
		
	}

}
