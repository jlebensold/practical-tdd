import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reporter {

	public static void main(String[] args) {

		String csvFile = "./fixture.csv";
		String line = "";
		HashMap<String, Integer> notes = new HashMap<String, Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i > 0) {
					String[] row = line.split(",");
					if (notes.containsKey(row[5])) {
						notes.put(row[5], notes.get(row[5]) + 1);
					} else {
						notes.put(row[5], 1);
					}
					if (notes.containsKey(row[6])) {
						notes.put(row[6], notes.get(row[6]) + 1);
					} else {
						notes.put(row[6], 1);
					}
				}
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Integer> sortedResults = notes.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("Top 3 Flavour Notes:");
		Integer counter = 1;
		for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
			System.out.println(String.format("%s. %s (%s)", counter, entry.getKey(), entry.getValue()));
			if (counter >= 3) {
				break;
			}
			counter++;
		}
	}
}
