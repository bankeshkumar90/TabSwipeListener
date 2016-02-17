package com.cafe;

import com.cafe.util.CafeConstant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        if (!isTaskRoot()) {
	            final Intent intent = getIntent();
	            final String intentAction = intent.getAction();
	            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
	                 overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	                finish();
	                
	                return;
	            }
	        }
	        
	        setContentView(R.layout.splash);
	        final Splash splashActivity = this;
	        try{
	        	
	        	// Try catch SDCard Issues
	        	try{
	        		String versionString=getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
	    		 
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
	        	
	        	int version=Integer.valueOf(android.os.Build.VERSION.SDK);
	        	if(version>=10){
	        		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        		StrictMode.setThreadPolicy(policy);
	        	}
	        	
	        	new Thread() {
	    			@Override
	    			public void run() {
	    				try {
	    					synchronized(this){
	    						wait(CafeConstant.SPLASH_TIME);
	    					}
	    				} catch(InterruptedException e) {
	    					e.printStackTrace();
	    				}
	    				
	    				finally {
	    					finish();

	    					//start a new activity
	    					Intent i = new Intent();
	    					i.setClass(splashActivity, Home.class);
	    					startActivity(i);
	    				}
	    				
	    			}
	    		}.start();
	        	
	        }catch (Exception e) {
	        	final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    		alertDialog.setTitle("Error");
	    		alertDialog.setMessage("Failed to initialize sdcard. Please mount the sdcard and try again.");
	    		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dialog,int which) {
	    				if(alertDialog.isShowing())
	    					alertDialog.dismiss();
	    			}
	    		});
	    		
	    		alertDialog.show();
	    	}
	    }

	}