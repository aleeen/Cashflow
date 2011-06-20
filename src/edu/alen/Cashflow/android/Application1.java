package edu.alen.Cashflow.android;

import java.util.ArrayList;
import edu.alen.Cashflow.android.baza.DBAdapterStrosek;

import android.app.Application;
import android.database.Cursor;


public class Application1 extends Application{
	public ArrayList<Stroski> lista;
	StroskiArrayAdapter stevci;
	Stroski MojiStroski;
	DBAdapterStrosek DBStevci;
	public ArrayList<String> array_spinner1;
	public void onCreate() {
        super.onCreate(); //ne pozabi
        DBStevci= new DBAdapterStrosek(this);
        lista = new ArrayList<Stroski>(); //inicializirat
         init();
         fillFromDB();
        stevci = new StroskiArrayAdapter(this, R.layout.tab2,lista); //Step 4.10 Globalna lista
       
	}
	
	public double Strosek()
	{
		DBStevci.open();
		Cursor c = DBStevci.getAll();
		double e=0;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			e+=c.getDouble(DBAdapterStrosek.POS_CENA);	
		}
		c.close();
		DBStevci.close();
		return e;
	}
	
	public void fillFromDB() {
		DBStevci.open();
		Cursor c = DBStevci.getAll();
		Stroski tmp;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			tmp = new Stroski();
			tmp.setName(c.getString(DBAdapterStrosek.POS_STROSEK));
			tmp.setCena(c.getInt(DBAdapterStrosek.POS_CENA));
			tmp.setDbID(c.getLong(DBAdapterStrosek.POS__ID));
			lista.add(tmp); 
		}
		c.close();
		DBStevci.close();
	}
	public void init() {
		 MojiStroski = new Stroski();
		//mojRezultat.setName();
		lista.add(MojiStroski);
	}
		
	public void addStevci(Stroski a)
	{
		Stroski tmp = new Stroski(MojiStroski);
		addDBStevci(tmp);
		  //Step 4.10 Globalna lista
		
	}
	public void remove(Stroski a) {
		//lista.add(a);
		if (a!=null)
		stevci.remove(a); //Step 4.10 Globalna lista
	}
	public void addDBStevci(Stroski s) {
		DBStevci.open();
		s.setDbID(DBStevci.insertStroski(s));
		stevci.add(s);
		DBStevci.close();	
	}

	public void deleteElement(int arg2) {
		Stroski tmps = stevci.getItem(arg2);
		stevci.remove(tmps);
		DBStevci.open();
		DBStevci.deleteStroski(tmps.getDbID());
		DBStevci.close();
	}

	
}
