package com.cafe;

  
 
import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TabHost.OnTabChangeListener;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Income", "Deductions", "Taxes Paid"};
	public static Home screen ;
	Context context; 
	View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		initComponent();
	}
	private void initComponent()
	{
		screen = this;
		context = getApplicationContext();
		 
		getActionBar().setTitle(""); 
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff"))); 
 

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		//getActionBar().setDisplayHomeAsUpEnabled(true); 
		viewPager.setAdapter(mAdapter);
		//actionBar.setHomeButtonEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
		//actionBar.setDisplayUseLogoEnabled(true);
		// Adding Tabs
		/*for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		actionBar.setSelectedNavigationItem(1);*/
		 addingFragement();
		
		/*for (int i = 0; i < mAdapter.getCount(); i++) {
		    boolean preselected = (i == 1);
		    actionBar.addTab(actionBar.newTab().setText(
		        mAdapter.getPageTitle(i)).setTabListener(this), preselected);
		}*/
		initPageScroll();
		
	}

	private void addingFragement()
	{
		Tab tab_timeLine = actionBar
	            .newTab()
	            .setText("TimeStart")
	            .setTabListener(this);
	   // actionBar.addTab(tab_timeLine);

	    Tab tab_home = actionBar
	            .newTab()
	            .setText("Active")
	            .setTabListener(this);
	   // actionBar.addTab(tab_home);

	    Tab tab_fact = actionBar
	            .newTab()
	            .setText("Actual")
	            .setTabListener(this);
	   // actionBar.addTab(tab_fact);
	     
		actionBar.addTab(tab_timeLine, 0, false);
		actionBar.addTab(tab_home, 1, true);
		actionBar.addTab(tab_fact, 2, false); 
		
	}
	
	private void initPageScroll()
	{
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				
				String hasValues = ""; 
				actionBar.setSelectedNavigationItem(position); 
	        	viewPager.setCurrentItem(position);
				/*if(position == 0)
				{
					 
				 inc_fragment = new Incomefragment();
				 hasValues =  inc_fragment.checkFieldText(context);
				 
				 boolean isValid; 
					
					if(validate1.matches("false")&&validate12.matches("false")&&validate13.matches("false")){
						isValid = false;
					}
					else 
				 //System.out.println("validate1"+validate1 +"validate12"+validate12+"validate13"+validate13);
				 if(validate1.matches("")&&validate12.matches("")&&validate13.matches(""))
								 isValid = false; 
					else
						 isValid = true;
				 if(hasValues.matches(""))
					 isValid = false;
				 else
					 isValid = true;
				 
					 int currentPosition = 0;
					// <-- here, you need to check yourself valid or not
				        if (!isValid) {
				        	 actionBar.setSelectedNavigationItem(currentPosition); 
				        	viewPager.setCurrentItem(currentPosition); 
				        	inc_fragment.inputValidation(context);
				        //	MessageDialog.showMessage("Alert", "Income is mandatory.", ITRdata.screen);
				        }else{
				        	 actionBar.setSelectedNavigationItem(position); 
				        	viewPager.setCurrentItem(position);
				        	inc_fragment.inputValidation(context);
				        	//inc_fragment.saveToDataBase(context);
				            currentPosition = position;
				            
				           
				        } 
				}
				else if(position == 1)
				{
					
					 
					        	actionBar.setSelectedNavigationItem(currentPosition); 
					        	viewPager.setCurrentItem(currentPosition); 
					        	 
				}
				else if(position == 2)
				{
					actionBar.setSelectedNavigationItem(position); 
					viewPager.setCurrentItem(position);
					 ded_fragment = new Deductionsfragment();
					 ded_fragment.inputValidation(context);
					 boolean isValid; 
						
						if(validate2.matches("false")){
							isValid = false;
						}
						else if(validate2.matches(""))
							 isValid = false; 
						else
							 isValid = true;
						 int currentPosition = 0;
						// <-- here, you need to check yourself valid or not
					        if (!isValid) {
					        	//viewPager.setCurrentItem(position);
					        	//ded_fragment.inputValidation(context);
					        }else{
					        	//viewPager.setCurrentItem(position);
					        	//ded_fragment.inputValidation(context);
					        	//inc_fragment.saveToDataBase(context);

					        }
				}
				else  
				{
					actionBar.setSelectedNavigationItem(position); 
					viewPager.setCurrentItem(position);
				}*/
			//}
			}
			@Override
			public void onPageScrolled(int pos, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int pos) {
			}
		});
	}
	
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);

	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		 
		case R.id.settings: 
			openSettings();
			//Toast.makeText(getApplicationContext(), "Share this awesome app to your friends!", Toast.LENGTH_SHORT).show();
			return true;
		 	
				
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	 
	
	 
	private void openSettings()
	{
		Intent settingIntent = new Intent(getApplicationContext(),UserSetting.class);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		startActivity(settingIntent);
		
	}
	public  void shareApp()
	{
		String urlToshare = "https://play.google.com/store/apps/details?id=com.cafe";
		Uri uri = Uri.parse(urlToshare);
		String shareBody = "Hey,\nI just downloaded Cafe on my Android Mobile.Cafe make quick and convenient like never before.";

		Intent shareApp = new Intent(android.content.Intent.ACTION_SEND);
		shareApp.setType("text/plain");

		// now adding message to be shared

		//shareApp.putExtra(Intent.EXTRA_SUBJECT, shareBody);
		shareApp.putExtra(Intent.EXTRA_TEXT, shareBody+" Click to install "+ uri);
		startActivity(Intent.createChooser(shareApp, "Share Cafe."));


	}
}
