package edu.alen.Cashflow.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class StroskiListActivity extends ListActivity implements OnItemClickListener  {
	Application1 app;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baza_list); // še en list je falija v layouti
		app = (Application1) getApplication();
		setListAdapter(app.stevci);
		this.getListView().setOnItemClickListener(this);
		app.lista.clear();
		app.fillFromDB();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	
} 