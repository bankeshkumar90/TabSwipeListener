package com.cafe;
 
 
import org.json.JSONObject;
 
import com.triazine.pulltorefresh.library.PullToRefreshBase;
import com.triazine.pulltorefresh.library.PullToRefreshScrollView;
import com.triazine.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
  
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent; 
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment; 
import android.view.LayoutInflater; 
import android.view.View;
import android.view.View.OnClickListener; 
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView; 
public class Deductionsfragment extends Fragment implements OnClickListener {
 
	private Context context; 
	 
	private Intent j ;  
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

	PullToRefreshScrollView mPullRefreshScrollView;
	ScrollView mScrollView;
	
	public interface OnFrag2TextChanged{
		public void onEditText2Changed(String textValue);
	}
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	context = getActivity().getApplicationContext();
    	screen1 = this;
    	rootView = inflater.inflate(R.layout.tab2, container, false);
    	
    	pullRefresh(rootView);
        return rootView;
    }
     
	
	public void onResume(){
		super.onResume();
		 
		//rootview.setBackgroundColor(color);
		System.out.println("-------------Starter2");
		//Toast.makeText(getActivity(), "resume f2", Toast.LENGTH_SHORT).show();
	}
	private void pullRefresh(View view)
	{
		 mPullRefreshScrollView = (PullToRefreshScrollView)view. findViewById(R.id.pull_refresh_scrollview);
			mPullRefreshScrollView.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

				@Override
				public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
					new GetDataTask().execute();
				}
			});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				 
				Thread.sleep(500); 
				try {
					 
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			// Do some stuff here

			// Call onRefreshComplete when the list has been refreshed.
			mPullRefreshScrollView.onRefreshComplete();
			try {
				 
				//changeExpiredColor();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			super.onPostExecute(result);
		}
	}
}