package com.cafe;
 

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
 
 

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
  
public class Deductionsfragment extends Fragment implements OnClickListener {
 
	private Context context; 
	 
	private Intent j ; 
	private String requestFor = "";
	private boolean isNetworkavailable;
	//private ServiceProxy sp;
	public static JSONObject additionalData = null;
	public ProgressDialog pdialog = null;
	Deductionsfragment screen1;
	private String token;
	
	private static TextView tipText;
	private String tipMessage ="";
	
	//fragments
	 View rootView ;
	Button rule_80g_case,other_deductions,save_btn;
	private static EditText rule_80c_t,rule_80ccc_t,rule_80ccd_employees_t,rule_80d_t,rule_80ccd_employer_t;
	private static TextView total_text;
	String pancard = "";
	String ass_year = "";
	String usr_pancard = ""; 
	String fromClass = "";  
	String type_id = ""; 
	
	private String deduction_80c = "";
	private String deduction_80ccc = "";
	private String deduction_80ccd_employees = "";
	private String deduction_80ccd_employer = "";
	private String deduction_80d = "";
	
	private String deductionof_80ccd_employer  = "";
	private String deductionof_80ccg  = ""; 
	private String deductionof_80dd  = "";
	private String deductionof_80ddb  = "";
	private String deductionof_80e  = "";
	private String deductionof_80ee  = "";
	//private String deductionof_80g  = "";
	private String deductionof_80gg  = "";
	private String deductionof_80gga  = "";
	private String deductionof_80ggc  = "";
	private String deductionof_80qqb  = "";
	private String deductionof_80rrb  = "";
	private String deductionof_80tta  = "";
	private String deductionof_80u  = ""; 
	
	
	boolean dataAvailable = false; 
	
	String deduction_check1 = "";
	String deduction_check2 = "";
	String deduction_check3 = "";
	String deduction_check4 = "";
	String deduction_check5 = "";
	OnFrag2TextChanged sendValue2;
	
	public interface OnFrag2TextChanged{
		public void onEditText2Changed(String textValue);
	}
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	context = getActivity().getApplicationContext();
    	screen1 = this;
    	rootView = inflater.inflate(R.layout.tab2, container, false);
        return rootView;
    }
     
	
	public void onResume(){
		super.onResume();
		 
		//rootview.setBackgroundColor(color);
		System.out.println("-------------Starter2");
		//Toast.makeText(getActivity(), "resume f2", Toast.LENGTH_SHORT).show();
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