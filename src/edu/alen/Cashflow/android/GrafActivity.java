package edu.alen.Cashflow.android;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class GrafActivity extends Activity implements OnClickListener {

	ImageView Graf;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab3);
		

		Graf= (ImageView) findViewById(R.id.graf);
		Drawable drawable = LoadImageFromWebOperations("http://www.shrani.si/f/3q/xO/1aIvHZbA/graf.png");    
		Graf.setImageDrawable(drawable);		
	}
	private Drawable LoadImageFromWebOperations(String url) 
	{
		try
		{
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		}
		catch (Exception e)
		{
			System.out.println("Exc="+e);
			return null;
		}
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
