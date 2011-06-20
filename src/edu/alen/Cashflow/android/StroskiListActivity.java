package edu.alen.Cashflow.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class StroskiListActivity extends ListActivity implements OnItemLongClickListener, OnItemClickListener  {
	Application1 app;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baza_list); // �e en list je falija v layouti
		app = (Application1) getApplication();
		setListAdapter(app.stevci);
		this.getListView().setOnItemClickListener(this);
		this.getListView().setOnItemLongClickListener(this);
		app.lista.clear();
		app.fillFromDB();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.getListView().invalidate();
	}

	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// dodaj dialog: Ali res zelis izbrisati element?!
		app.deleteElement(arg2);
		return false;
	}
	
	
} 