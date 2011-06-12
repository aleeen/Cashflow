package edu.alen.Cashflow.android;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class TabLayout extends TabActivity implements OnClickListener 
{
	Button Izhod;
	Button Nastavitve;
	Button Dodaj;
	
	
    public void onCreate(Bundle savedInstanceState) 
    {
    		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
  
        
        Izhod=(Button)findViewById(R.id.izhod);
        Nastavitve=(Button)findViewById(R.id.nastavitve);
        Dodaj=(Button)findViewById(R.id.dodaj);
        
		Dodaj.setOnClickListener(this);
		Izhod.setOnClickListener(this);
		Nastavitve.setOnClickListener(this);
        
        Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost

		Intent intent1 = new Intent(this, SkupajActivity.class);
		tabHost.addTab(tabHost.newTabSpec("Skupaj")
				.setIndicator("Skupaj", res.getDrawable(R.drawable.ic_tab_skupaj))
				.setContent(intent1));

		Intent intent2 = new Intent(this, StroskiActivity.class);
		tabHost.addTab(tabHost.newTabSpec("Stroski")
				.setIndicator("Stro¹ki", res.getDrawable(R.drawable.ic_tab_stroski))
				.setContent(intent2));
		tabHost.setCurrentTab(0);
		
		Intent intent3 = new Intent(this, GrafActivity.class);
		tabHost.addTab(tabHost.newTabSpec("Graf")
				.setIndicator("Graf", res.getDrawable(R.drawable.ic_tab_graf))
				.setContent(intent3));
		tabHost.setCurrentTab(0);

		// Set tabs Colors
		tabHost.setBackgroundColor(Color.parseColor("#87cefa"));
		tabHost.getTabWidget().setBackgroundColor(Color.parseColor("#87cefa"));

    }
    

	public void onClick(View v) {

		if(v.getId()==R.id.izhod)
		{
			setResult(RESULT_CANCELED);
			finish();
		}
		else if(v.getId()==R.id.nastavitve)
		{
			Intent i= new Intent(this.getApplicationContext(),NastavitveActivity.class);
			startActivity(i);
		}
		else if(v.getId()==R.id.dodaj)
		{
			Intent i= new Intent(this.getApplicationContext(),DodajActivity.class);
			startActivity(i);
		}
	}
}
