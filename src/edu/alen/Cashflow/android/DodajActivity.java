package edu.alen.Cashflow.android;

import java.io.IOException;
import java.io.PrintWriter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DodajActivity extends Activity implements OnClickListener {

	public static final int OPEN_DNEVI=99;
	public static final String FILE_NAME_STROSKI="stroski.txt";
	private static final String TAG = null;
	public static final String PREF_NAME="STROSKI";
	public PrintWriter myfile;
	
	private static final int TEST_LIST_ACTIVITY_ID = 1;
	
	Button Shrani;
	EditText Cena,Strosek;
	Application1 app;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dodaj);
		app = (Application1) getApplication();
		
		Strosek=(EditText)findViewById(R.id.strosek);
        Cena=(EditText)findViewById(R.id.cena);
        
        Shrani=(Button)findViewById(R.id.shrani);
        Shrani.setOnClickListener(this);    
	}

	
	public void onStart() {
		super.onStart();
		try {
			myfile = new PrintWriter(openFileOutput(FILE_NAME_STROSKI, Context.MODE_PRIVATE));
		} catch (IOException e) {
			Log.e(TAG,"Datoteka napake "+e.toString());
			e.printStackTrace();
	}
	}


	public void onClick(View v) 
	{
		switch (v.getId()) {
		case R.id.shrani:
			
				String b=Strosek.getText().toString();
				String a=Cena.getText().toString();
				
				if(!b.contentEquals(""))
				{
					Stroski st = new Stroski();
					st.setName(b);
					double aa= Double.parseDouble(a);
					st.setCena(aa);
					app.addDBStevci(st);
					Toast.makeText(this, "Va¹ stro¹ek je bil dodan", Toast.LENGTH_SHORT).show();
					
					Intent i = new Intent();
					i.setClass(this, StroskiListActivity.class);
					startActivityForResult(i, TEST_LIST_ACTIVITY_ID);
					
					st.GetCena(); 
					finish();
				}			
				else
				{
					Toast.makeText(this, "Ime str¹ka nesme biti prazno !!!!!", Toast.LENGTH_SHORT)
					.show();
				}
				double vsota=0;
				
				
				break;	
		}
	}
}
