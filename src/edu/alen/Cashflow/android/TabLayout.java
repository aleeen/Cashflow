package edu.alen.Cashflow.android;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;

public class TabLayout extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost

		Intent intent = new Intent(this, StroskiActivity.class);
		tabHost.addTab(tabHost.newTabSpec("Skupaj")
				.setIndicator("Skupaj", res.getDrawable(R.drawable.ic_tab_skupaj))
				.setContent(intent));

		Intent intent2 = new Intent(this, GrafActivity.class);
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
}