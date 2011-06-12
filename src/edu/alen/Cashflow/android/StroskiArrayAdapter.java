package edu.alen.Cashflow.android;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class StroskiArrayAdapter extends ArrayAdapter<Stroski> { //Step 4.8 POPRAVI Stevec -> Rezultati
	LayoutInflater mInflater;
	public StroskiArrayAdapter(Context context, int textViewResourceId, List<Stroski> objects) { //Step 4.8 POPRAVI Stevec ->Rezultati
		super(context, textViewResourceId,objects);
	    mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Stroski tmp = getItem(position);
		ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.tab2, null);
	
			holder = new ViewHolder();
			holder.one = (TextView) convertView.findViewById(R.id.tv1); //Step 4.8 POPRAVI
			holder.two = (TextView) convertView.findViewById(R.id.tv2); //Step 4.8 POPRAVI		
			convertView.setTag(holder);
		} 
		else 
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.one.setText(Double.toString(tmp.GetCena())); //Step 4.8 POPRAVI
		holder.two.setText(""+tmp.getName()); //Step 4.8 POPRAVI
		//holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
		return convertView;
	}
	static class ViewHolder {
		TextView one; //Step 4.8 POPRAVI
		TextView two; //Step 4.8 POPRAVI
		
	}
}

