package edu.alen.Cashflow.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SkupajActivity extends Activity {
	
	Application1 app;
	//EditText text;
	TextView Skupaj;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		app = (Application1) getApplication();
		
		//text=(EditText)findViewById(R.id.editText1);	
		//text.setText(Double.toString(app.Strosek()));
		
		Skupaj=(TextView)findViewById(R.id.skupaj);	
		Skupaj.setText(Double.toString(app.Strosek()));
	}

	
	public void onStart() {
		super.onStart();
	
		//text.setText(Double.toString(app.Strosek()));
		Skupaj.setText(Double.toString(app.Strosek()));
	}
}
