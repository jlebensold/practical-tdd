package PastryReporter;

public class FlavourNote {
	private String primaryNote;
	private String secondaryNote;

	public FlavourNote(String primaryNote, String secondaryNote) {
		this.setPrimaryNote(primaryNote);
		this.setSecondaryNote(secondaryNote);
	}

	public String getSecondaryNote() {
		return secondaryNote;
	}

	public void setSecondaryNote(String secondaryNote) {
		this.secondaryNote = secondaryNote;
	}

	public String getPrimaryNote() {
		return primaryNote;
	}

	public void setPrimaryNote(String primaryNote) {
		this.primaryNote = primaryNote;
	}
}
