package PastryReporter;

public class Pastry {

	private double butter;
	private double sugar;
	private double flour;
	private double eggs;
	private String name;
	private FlavourNote flavourNote;

	public Pastry(String name, double butter, double sugar, double flour, double eggs) {
		this.setName(name);
		this.setButter(butter);
		this.setSugar(sugar);
		this.setFlour(flour);
		this.setEggs(eggs);
	}

	public Pastry() {
	}

	public String getName() {
		return name;
	}

	public static Pastry fromRow(String[] row) {
		String name = row[0];
		double butter = Double.parseDouble(row[1]);
		double sugar = Double.parseDouble(row[2]);
		double flour = Double.parseDouble(row[3]);
		double eggs = Double.parseDouble(row[4]);
		Pastry pastry = new Pastry(name, butter, sugar, flour, eggs);
		pastry.setFlavourNote(new FlavourNote(row[5], row[6]));
		return pastry;
	}

	public double getEggs() {
		return eggs;
	}

	public void setEggs(double eggs) {
		this.eggs = eggs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFlour() {
		return flour;
	}

	public void setFlour(double flour) {
		this.flour = flour;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getButter() {
		return butter;
	}

	public void setButter(double butter) {
		this.butter = butter;
	}

	public String getSecondaryNote() {
		return getFlavourNote().getSecondaryNote();
	}

	public String getPrimaryNote() {
		return getFlavourNote().getPrimaryNote();
	}

	public FlavourNote getFlavourNote() {
		return flavourNote;
	}

	public void setFlavourNote(FlavourNote flavourNote) {
		this.flavourNote = flavourNote;
	}
}
