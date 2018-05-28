package PastryReporter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PastryImporter {

	public static ArrayList<Pastry> fromCSV(String csvFile) {
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Pastry> pastries = new ArrayList<Pastry>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i > 0) {
					Pastry pastry = Pastry.fromRow(line.split(cvsSplitBy));
					pastries.add(pastry);
				}
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
		return pastries;
	}

}
