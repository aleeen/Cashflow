package edu.alen.Cashflow.android.baza;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class DatabaseHelper extends SQLiteOpenHelper 
{	

	public static final  String TAG="DatabaseHelper";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME1 = "STROSKI";
	private static final String DATABASE_CREATE1 =
		"create table "+DBAdapterStrosek.TABLE+" ("+DBAdapterStrosek._ID+" integer primary key autoincrement, "
		+ DBAdapterStrosek.STROSEK+" TEXT not null, "+DBAdapterStrosek.CENA+" INTEGER );";
	
	
	DatabaseHelper(Context context) 
	{
		super(context, DATABASE_NAME1, null, DATABASE_VERSION);
		
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		try {
		db.execSQL(DATABASE_CREATE1);
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterStrosek.TABLE);
		db.execSQL(DATABASE_CREATE1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			int newVersion) 
	{
		Log.w(TAG, "Upgrading database from version " + oldVersion 
				+ " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterStrosek.TABLE);
		onCreate(db);
	}
}
