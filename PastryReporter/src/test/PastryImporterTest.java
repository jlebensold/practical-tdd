package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import PastryReporter.Pastry;
import PastryReporter.PastryImporter;

class PastryImporterTest {

	String fixturePath = "./fixture.csv";
	
	@Test
	public void testPastryFomCSV() throws IOException {
		ArrayList<Pastry> pastries = PastryImporter.fromCSV(fixturePath);
		assertEquals(8, pastries.size());
	}
	
	@Test
	public void testThrowsIOWithBadPath(){

	assertThrows(FileNotFoundException.class, () -> {
		  PastryImporter.fromCSV("badPath");
	  });

		
	}

}
