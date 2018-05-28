package PastryReporter;

import java.io.IOException;
import java.util.ArrayList;

public class PastryReporter {

	public static void main(String[] args) {
		String fixturePath = "./fixture.csv";
		ArrayList<Pastry> pastries;
		try {
			pastries = PastryImporter.fromCSV(fixturePath);
			Reporter pastryReporter = new Reporter(pastries);
			System.out.println("Top 3 Flavour Notes:");
			for(String result : pastryReporter.topFlavourNotes(3)) {
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
