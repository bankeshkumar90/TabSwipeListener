package com.cafe;
 
import android.app.ProgressDialog;
import android.content.Context; 
import android.net.ConnectivityManager;
import android.net.NetworkInfo; 
import android.os.Bundle; 
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup; 

public class Taxespaidfragment extends Fragment implements OnClickListener {

	 
	//retrieving 26 AS Information
	public ProgressDialog pdialog = null;
	Taxespaidfragment screen1;
	private String token = "";
	private Context context; 
	View rootView ;
	 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity().getApplicationContext(); 
    	screen1 = this; 
    	
    	rootView  = this.getView();
		rootView = inflater.inflate(R.layout.tab3, container, false);
 
		return rootView;
	}
 
		public void onResume(){
			super.onResume();
			 
		}
	
	  private boolean isNetworkavailable() {
			ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetworkInfo = connectivityManager
					.getActiveNetworkInfo();
			return activeNetworkInfo != null && activeNetworkInfo.isConnected();
		}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}	
	 
	
}