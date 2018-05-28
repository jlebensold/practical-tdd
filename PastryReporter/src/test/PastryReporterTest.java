package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import PastryReporter.Pastry;
import PastryReporter.Reporter;

class PastryReporterTest {

	private ArrayList<Pastry> pastriesFixture() {
		String[] p1 = {"Top", "0.2", "0.1", "0.3", "0.4", "Crispy", "Creamy"};
		String[] p2 = {"Flop", "0.2", "0.1", "0.3", "0.4", "Crispy", "Creamy"};
		String[] p3 = {"Blop", "0.2", "0.1", "0.3", "0.4", "Crispy", "Fluffy"};
		ArrayList<Pastry> list = new ArrayList<Pastry>();
		list.add(Pastry.fromRow(p1));
		list.add(Pastry.fromRow(p2));
		list.add(Pastry.fromRow(p3));
		return list;
	}
	
	@Test
	void testReportsExtractNotes() {
		Reporter pastryReporter = new Reporter(pastriesFixture());
		assertEquals("Crispy", pastryReporter.extractNotes().get(0).getPrimaryNote());
	}
	
	@Test
	void testReportsTopFlavourNotes() {
		Reporter pastryReporter = new Reporter(pastriesFixture());
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1. Crispy (3)");
		expected.add("2. Creamy (2)");
		expected.add("3. Fluffy (1)");
		assertEquals(expected,pastryReporter.topFlavourNotes(3));
	}
	
}
