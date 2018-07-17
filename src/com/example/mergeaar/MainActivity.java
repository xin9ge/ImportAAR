package com.example.mergeaar;

import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Object Stringtxt = null;
		try {
			Class DispatcherClaz = Class.forName("com.example.yx.aarlibrary.Dispatcher");
			Method getInstanceMehtod = DispatcherClaz.getMethod("getInstance", null);
			Object instance = getInstanceMehtod.invoke(null, null);

			
			Method getStringMethod = DispatcherClaz.getMethod("getString", Context.class);
			Stringtxt = getStringMethod.invoke(instance, this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i("²âÊÔ", "²âÊÔÄÃµ½µÄ×Ö·û´®ÊÇ:"+ Stringtxt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
