package edu.alen.Cashflow.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class StroskiActivity extends Activity implements OnClickListener {
	
	//DodajActivity dodaj;
	//Button Dodaj;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab2);
		
		
		//Dodaj=(Button)findViewById(R.id.dodaj);
		//Dodaj.setOnClickListener(this);
		
	}	

	public void onClick(View arg0) 
	{/*
		if(arg0.getId()==R.id.dodaj)
		{
			Intent i= new Intent(this.getApplicationContext(),DodajActivity.class);
			startActivity(i);
		}
		*/
	}
}