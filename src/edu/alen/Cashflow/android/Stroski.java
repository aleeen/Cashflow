package edu.alen.Cashflow.android;


public class Stroski {
	private String name="Alen";
	private double Cena;
	private long dbID; //id  v tabeli
	
	
	public long getDbID() {
		return dbID;
	}

	public void setDbID(long dbID) {
		this.dbID = dbID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Stroski() 
	{
	  Cena=0;
	 
	}
	public Stroski(Stroski mojiStroski) {
		Cena=mojiStroski.Cena;
		name=mojiStroski.name;
	}
	
	public double GetCena()
	{
		return Cena;
	}
	
	public void setCena(double i) {
		  Cena=i;
	  }

	
	
}
