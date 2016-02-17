package com.cafe;

 
import android.content.Context;
import android.content.Intent; 
import android.os.Bundle; 
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction; 
import android.view.LayoutInflater; 
import android.view.View;
import android.view.View.OnClickListener;  
import android.view.ViewGroup;  

public class Incomefragment extends Fragment implements OnClickListener {
 
	Home screen;
	private Context context;
	private Intent j ;  
	View rootView;
	FragmentManager  fragmentManager;
	FragmentTransaction  fragmentTransaction;
	OnFrag1TextChanged sendValue,sendValue11,sendValue12;
	int id;
 
	
	View vi;		
	  
	public interface OnFrag1TextChanged{
		public void onEditText1Changed(String textValue);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity().getApplicationContext(); 
		rootView  = this.getView();
		rootView = inflater.inflate(R.layout.tab1, container, false);
		/*mydbhelper = new DBHelper(context);
		SharedPreferences pref = context.getSharedPreferences(
				context.getString(R.string.USER_SESS_PREF), 0);
		token = pref.getString("token", token);
		pancard = pref.getString("pancard", pancard);
		ass_year = pref.getString("assesment_year", ass_year);
		income_sal = "";
		intialiazeUIWidgets();
		
	 	//j = getActivity().getIntent();
	 //	checkLoginStatus();
		
		//registerUiWidgets(rootView);
	
		//income_fromsalary = j.getStringExtra("income_salary"); 
		//year  = j.getStringExtra("ASSESMENT_YEAR"); 
		
		if(!(income_fromsalary.matches("")))
		{
			income_salary_t.setText(income_fromsalary);
		}
		else
		{}
		income_salary_t.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!(s.toString().equals(""))){
					sendValue.onEditText1Changed(s.toString());
					income_sal = s.toString();
				}
				else
				{
					if(income_salary_t.getText().toString().matches(""))
					{
						sendValue.onEditText1Changed("false");
					}
					else
					sendValue.onEditText1Changed("true");
					
				}	
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
		});
		
		other_income_t.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!(s.toString().equals(""))){
					sendValue11.onEditText1Changed(s.toString());
					income_sal = s.toString();
				}
				else
					if(other_income_t.getText().toString().matches(""))
					{
						//sendValue11.onEditText1Changed("false");
					}
					else 
					sendValue11.onEditText1Changed("true");
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
		});
		house_property_income_t.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(!(s.toString().equals(""))){
					sendValue12.onEditText1Changed(s.toString());
					income_sal = s.toString();
				}
				else
					
					if(house_property_income_t.getText().toString().matches(""))
					{
						//sendValue12.onEditText1Changed("false");
					}
					else  
					sendValue12.onEditText1Changed("true");
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		//Right ImageButton Click Listener
		income_salary_t.setOnTouchListener(new OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            final int DRAWABLE_LEFT = 0;
	            final int DRAWABLE_TOP = 1;
	            final int DRAWABLE_RIGHT = 2;
	            final int DRAWABLE_BOTTOM = 3;

	            String inc_message = getResources().getString(R.string.info_income_salary);
	            
	            if(event.getAction() == MotionEvent.ACTION_UP) {
	                if(event.getRawX() >= (income_salary_t.getRight() - income_salary_t.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
	                    // your action here
	                	MessageDialog.showMessage("Info!",
	                			inc_message, ITRdata.screen);
	                 return true;
	                }
	            }
	            return false;
	        }
	    });
		
		
	
		other_income_t.setOnTouchListener(new OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            final int DRAWABLE_LEFT = 0;
	            final int DRAWABLE_TOP = 1;
	            final int DRAWABLE_RIGHT = 2;
	            final int DRAWABLE_BOTTOM = 3;

	            String inc_message = getResources().getString(R.string.info_other_income);
	            
	            if(event.getAction() == MotionEvent.ACTION_UP) {
	                if(event.getRawX() >= (other_income_t.getRight() - other_income_t.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
	                    // your action here
	                	MessageDialog.showMessage("Info!",
	                			inc_message, ITRdata.screen);
	                 return true;
	                }
	            }
	            return false;
	        }
	    });
		house_property_income_t.setOnTouchListener(new OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            final int DRAWABLE_LEFT = 0;
	            final int DRAWABLE_TOP = 1;
	            final int DRAWABLE_RIGHT = 2;
	            final int DRAWABLE_BOTTOM = 3;

	            String inc_message = getResources().getString(R.string.info_house_property);
	            
	            if(event.getAction() == MotionEvent.ACTION_UP) {
	                if(event.getRawX() >= (house_property_income_t.getRight() - house_property_income_t.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
	                    // your action here
	                	MessageDialog.showMessage("Info!",
	                			inc_message, ITRdata.screen);
	                 return true;
	                }
	            }
	            return false;
	        }
	    });
		checkDataBase(context);
		//income_salary.setText(income_fromsalary) ;	
		income_salary_t.setOnClickListener(this);*/
		return rootView;
	}
	
	 
	
	
	public void onResume(){
		super.onResume();
		 
		//rootview.setBackgroundColor(color);
		System.out.println("-------------Starter2");
		//Toast.makeText(getActivity(), "resume f2", Toast.LENGTH_SHORT).show();
	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}