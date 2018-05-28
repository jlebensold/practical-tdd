package test;

import static org.junit.jupiter.api.Assertions.*;
import PastryReporter.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
class PastryTest {
	String[] row = {"Eclair", "0.2", "0.1", "0.3", "0.4", "Crispy", "Creamy"};
	String fixturePath = "./fixture.csv";

	@Test
	void testName() {
		Pastry pastry = new Pastry();
		pastry.setName("Eclair");
		assertEquals(pastry.getName(), "Eclair");
	}
	
	@Test
	void testFactoryMethodFromRow() {
		Pastry pastry = Pastry.fromRow(row);
		assertThat(pastry, instanceOf(Pastry.class));
	}
	
	@Test
	void testAssertPastryAttributesFromRow() {		
		Pastry pastry = Pastry.fromRow(row);
		assertEquals("Eclair", pastry.getName());
		assertEquals(0.2, pastry.getButter());
		assertEquals(0.1, pastry.getSugar());
		assertEquals(0.3, pastry.getFlour());
		assertEquals(0.4, pastry.getEggs());
	}
	
	@Test
	void testAssertFlavourNotesFromRow() {
		Pastry pastry = Pastry.fromRow(row);
		assertEquals("Crispy", pastry.getPrimaryNote());
		assertEquals("Creamy", pastry.getSecondaryNote());
	}

	@Test
	void testImportFromCSV() throws IOException {
		ArrayList<Pastry> pastries = PastryImporter.fromCSV(fixturePath);
		assertEquals(8, pastries.size());
	}
}
