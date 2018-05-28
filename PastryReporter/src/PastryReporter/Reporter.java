package PastryReporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reporter {

	private ArrayList<Pastry> pastries;

	public Reporter(ArrayList<Pastry> pastries) {
		this.pastries = pastries;
		
	}

	public ArrayList<String> topFlavourNotes(int limit) {
		HashMap<String, Integer> notes = new HashMap<String, Integer>();
		for(FlavourNote note: extractNotes()) {
			notes = incrementNote(notes, note.getPrimaryNote());
			notes = incrementNote(notes, note.getSecondaryNote());
		}
		
		Map<String, Integer> sortedResults = sortNotes(notes);
		
		ArrayList<String> output = new ArrayList<String>();
		Integer counter = 1;
		for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
			output.add(String.format("%s. %s (%s)", counter, entry.getKey(), entry.getValue()));
			if(counter >= limit) { break;}
			counter++;
		}
		return output;
	}

	public ArrayList<FlavourNote> extractNotes() {
		ArrayList<FlavourNote> notes = new ArrayList<FlavourNote>();
		for(Pastry pastry: pastries) {
			notes.add(pastry.getFlavourNote());
		}
		return notes;
	}
	

	private  HashMap<String, Integer> incrementNote(HashMap<String, Integer> notes, String note) {
		if(notes.containsKey(note)) {
			notes.put(note, notes.get(note) + 1);
		} else {
			notes.put(note, 1);
		}
		return notes;
	}
	

	private Map<String, Integer> sortNotes(HashMap<String, Integer> result) {
		return result.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}
}
