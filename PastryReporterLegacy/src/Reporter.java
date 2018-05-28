import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reporter {

	public static void main(String[] args) {
		
		HashMap<String, Integer> result = importFlavourNotes("./fixture.csv");
		
		Map<String,Integer> sortedResults = sortMap(result);
		System.out.println("Top 3 Flavour Notes:");
		Integer counter = 1;
		for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
			System.out.println(String.format("%s. %s (%s)", counter, entry.getKey(), entry.getValue()));
			if(counter >= 3) { break;}
			counter++;
		}
	}

	private static Map<String, Integer> sortMap(HashMap<String, Integer> result) {
		return result.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}

	public static HashMap<String, Integer> importFlavourNotes(String csvFile) {
		String line = "";
		String splitBy = ",";
		HashMap<String, Integer> notes = new HashMap<String, Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i > 0) {
					String[] row = line.split(splitBy);
					notes = incrementNote(notes, row[5]);
					notes = incrementNote(notes, row[6]);
				}
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
		return notes;
	}

	private static HashMap<String, Integer> incrementNote(HashMap<String, Integer> notes, String note) {
		if(notes.containsKey(note)) {
			notes.put(note, notes.get(note) + 1);
		} else {
			notes.put(note, 1);
		}
		return notes;
	}

}
