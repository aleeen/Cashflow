package edu.alen.Cashflow.android.baza;

import edu.alen.Cashflow.android.Stroski;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;



public class DBAdapterStrosek implements BaseColumns {
	
	public static final  String TAG="DBAdapterZdravila";
	public static final  String CENA = "i_value";
	public static final  String STROSEK = "s_name";
	public static final  int POS__ID=0;
	public static final  int POS_STROSEK=1;
	public static final  int POS_CENA=2;
	public static final  String TABLE="STROSEK";

	private final Context context;

	private DatabaseHelper DBHelper;
	private SQLiteDatabase DBStroski;

	public DBAdapterStrosek(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}


	//---opens the database---
	public DBAdapterStrosek open() throws SQLException 
	{
		DBStroski = DBHelper.getWritableDatabase();
		return this;
	}

	//---closes the database---    
	public void close() 
	{
		DBHelper.close();
	}

	//---insert a stevec
	public long insertStroski(Stroski stevec) 
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(STROSEK, stevec.getName()); 
		initialValues.put(CENA, stevec.GetCena()); 
		return DBStroski.insert(TABLE, null, initialValues);
	}

	//---deletes a particular title---
	public boolean deleteStroski(long rowId) 
	{
		return DBStroski.delete(TABLE, _ID + "=" + rowId, null) > 0;
	}

	//---retrieves all the titles---
	public Cursor getAll() 
	{
		return DBStroski.query(TABLE, new String[] {
				_ID,       //POS__ID=0;
				STROSEK,      //POS_NAME=1
				CENA},    //POS_VALUE =2
				null, 
				null, 
				null, 
				null, 
				null);
	}
	
	//---retrieves a particular title---
	public Cursor getRezultat(long rowId) throws SQLException 
	{
		Cursor mCursor =
			DBStroski.query(true, TABLE, new String[] {
					_ID, 
					STROSEK,
					CENA}, 
					_ID + "=" + rowId, 
					null,
					null, 
					null, 
					null, 
					null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	//---update---
	public boolean updateStroski(Stroski tmp) 
	{
		ContentValues args = new ContentValues();
		args.put(STROSEK, tmp.getName());
		args.put(CENA, tmp.GetCena());
		return DBStroski.update(TABLE, args, 
				_ID + "=" + tmp.getDbID(), null) > 0;
	}
	
}