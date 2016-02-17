package com.cafe;

 
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class UserSetting extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_setting);
		
		getActionBar().setTitle(""); 
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
		getActionBar().setDisplayHomeAsUpEnabled(true); 
		
	}
	
	// back button listener
			@Override
			public boolean onOptionsItemSelected(MenuItem item) {
				switch (item.getItemId()) {
				case android.R.id.home:
					// app icon in action bar clicked; goto parent activity.
					finish();
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
					return true;
				default:
					return super.onOptionsItemSelected(item);
				}
			}
}
