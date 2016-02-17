package com.cafe.util;


 
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
 

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;

import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.util.Log; 

import android.widget.Toast;
 
public class ServiceProxy {
	int TIMEOUT_MILLISEC = 60000;

	// int TIMEOUT_MILLISEC = 500000;// = 50 seconds
	public ServiceProxy() {
	}

/*	// User login request from here
	public String login(Activity ctx) {
		String responseData = "";
		try {
			JSONObject json = new JSONObject();
			json.put("method", "login");
			json.put("params", Login.screen.additionalData);
			System.out.println(json.toString(2));
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(
					ctx.getString(R.string.DUMMY_SERVICE_URL));
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			Log.i("Main", "Status Line: " + response.getStatusLine());
			responseData = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("Response Login: " + responseData);
			if (responseData.contains("\"serviceError\"")
					|| responseData.contains("\"Exception\""))
				return (responseData);
			else
				System.out.println("Response Login: " + responseData);
		} catch (Throwable t) {
			t.printStackTrace();
			return "network_issue";
		}

		if (!responseData.contains("true")&&(!responseData.contains("network_issue"))) {
		// Creating user session
		
		JSONObject js = null;
		JSONObject jObject = null;
		try {
			js = new JSONObject(responseData);
			jObject = js.getJSONObject("USER");
			String token_data = "";
			token_data = js.getString("token");
			System.out.println("Print Token" + token_data);
			Login.screen.user = new UserProfile(); // create the user profile 
													// object with the loggedin
													// user
			// MainView.screen.so = new SharedObject();
			Login.screen.user.setToken(js.getString("token"));
			Login.screen.user.setPancard(jObject.getString("PanCardNumber"));
			Login.screen.user.setEmailId(jObject.getString("EmailId"));
			Login.screen.user.setMobileNum(jObject.getString("MobileNumber")); 
			
			Login.screen.user.setGender(jObject.getString("Gender"));
			Login.screen.user.setSecurityQuestion(jObject.getString("SecurityQuestion"));
			Login.screen.user.setSecurityAnswer(jObject.getString("SecuirtyAnswer"));
			//Login.screen.user.setName(js.getString("Name")); 
			Login.screen.user.setAssesmentYear(js.getString("assesment_year"));
			
			Login.screen.user.setDob(jObject.getString("UserDOB")); 
			Login.screen.user.setResidentialStatus(jObject.getString("ResidentialStatus"));
			Login.screen.user.setfather_fname(jObject.getString("FatherFirstName"));
			Login.screen.user.setfather_mname(jObject.getString("FatherMiddleName")); 
			
			Login.screen.user.setemployee_category(jObject.getString("EmployerCategory"));
			Login.screen.user.setfather_lname(jObject.getString("FatherLastName"));
			Login.screen.user.setPortugesCivil(jObject.getString("PortugeseCivil")); 
			Login.screen.user.setpan_spouse(jObject.getString("PanOfSpouse"));
			Login.screen.user.set_user_aadhar(jObject.getString("userAadhar"));
		//	Login.screen.user.set_termsAccepted(jObject.getString("terms_accepted"));
			
			
			
			SharedPreferences pref = Login.screen.getSharedPreferences(
					Login.screen.getString(R.string.USER_SESS_PREF), 0); // 0 -
																			// for
																			// private
																			// mode
			Editor editor = pref.edit();
			 
			editor.putString("token", js.getString("token"));
			editor.putString("pancard", jObject.getString("PanCardNumber"));
			editor.putString("emailId", jObject.getString("EmailId"));
			editor.putString("mobileNum", jObject.getString("MobileNumber")); 
			
			editor.putString("Gender", jObject.getString("Gender"));
			editor.putString("SecurityQuestion", jObject.getString("SecurityQuestion"));
			editor.putString("SecurityAnswer", jObject.getString("SecuirtyAnswer"));
			editor.putString("EmployerCategory", jObject.getString("EmployerCategory")); 
		//	editor.putString("Name", jObject.getString("Name"));
			
			editor.putString("assesment_year", js.getString("assesment_year"));
			editor.putString("UserDOB", jObject.getString("UserDOB"));
			editor.putString("ResidentialStatus", jObject.getString("ResidentialStatus")); 
			editor.putString("FatherFirstName", jObject.getString("FatherFirstName"));
			
			editor.putString("FatherMiddleName", jObject.getString("FatherMiddleName"));
			editor.putString("FatherLastName", jObject.getString("FatherLastName"));
			editor.putString("PortugeseCivil", jObject.getString("PortugeseCivil"));
			editor.putString("PanOfSpouse", jObject.getString("PanOfSpouse")); 
			editor.putString("userAadhar", jObject.getString("userAadhar"));
		//	editor.putString("terms_accepted", jObject.getString("terms_accepted")); 
			
			editor.commit(); // commit changes
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			
		}
		return responseData;

	}

	public String registerUser(Activity ctx) {
		String responseData = "";
		try {
			JSONObject json = new JSONObject();
			json.put("method", "createNewUser");
			json.put("params", RegisterActivity.screen.additionalData);
			System.out.println(json.toString(2));
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(
					ctx.getString(R.string.DUMMY_SERVICE_URL));
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			Log.i("Main", "Status Line: " + response.getStatusLine());
			responseData = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("Response Login: " + responseData);
			if (responseData.contains("\"serviceError\"")
					|| responseData.contains("\"Exception\""))
				return (responseData);
			else
				System.out.println("Response Login: " + responseData);
		} catch (Throwable t) {
			t.printStackTrace();
			return "network_issue";
		}
		if (!responseData.contains("true")&&(!responseData.contains("network_issue"))) {
		JSONObject js = null;
		JSONObject jObject = null;
		try {
			js = new JSONObject(responseData);
			jObject = js.getJSONObject("USER");
			String token_data = "";
			token_data = js.getString("token");
			System.out.println("Print Token" + token_data);
			RegisterActivity.screen.user = new UserProfile();  
			// MainView.screen.so = new SharedObject();
			RegisterActivity.screen.user.setToken(js .getString("token"));
			RegisterActivity.screen.user.setPancard(jObject .getString("PanCardNumber"));
		//	RegisterActivity.screen.user.setName(jObject .getString("Name"));
			RegisterActivity.screen.user.setEmailId(jObject.getString("EmailId"));
			
			RegisterActivity.screen.user.setMobileNum(jObject.getString("MobileNumber")); 
			RegisterActivity.screen.user.setGender(jObject.getString("Gender"));
			RegisterActivity.screen.user.setDob(jObject.getString("UserDOB"));
			RegisterActivity.screen.user.setAssesmentYear(js.getString("assesment_year")); 
			
			RegisterActivity.screen.user.setemployee_category(jObject.getString("EmployerCategory"));
			RegisterActivity.screen.user.setSecurityQuestion(jObject.getString("SecurityQuestion"));
			RegisterActivity.screen.user.setSecurityAnswer(jObject.getString("SecuirtyAnswer"));
			RegisterActivity.screen.user.setResidentialStatus(jObject.getString("ResidentialStatus"));
			RegisterActivity.screen.user.setfather_fname(jObject.getString("FatherFirstName"));
			
			RegisterActivity.screen.user.setfather_mname(jObject.getString("FatherMiddleName")); 
			RegisterActivity.screen.user.setfather_lname(jObject.getString("FatherLastName"));
			RegisterActivity.screen.user.setPortugesCivil(jObject.getString("PortugeseCivil")); 
			RegisterActivity.screen.user.setpan_spouse(jObject.getString("PanOfSpouse"));  
			RegisterActivity.screen.user.set_user_aadhar(jObject.getString("userAadhar"));  
			 
			
			
			SharedPreferences pref =  RegisterActivity.screen.getSharedPreferences(
					 RegisterActivity.screen
							.getString(R.string.USER_SESS_PREF), 0); // 0 - for
																		// private
																		// mode
			Editor editor = pref.edit();
			
			editor.putString("token", js.getString("token"));
			editor.putString("pancard", jObject.getString("PanCardNumber"));
			editor.putString("emailId", jObject.getString("EmailId"));
			editor.putString("mobileNum", jObject.getString("MobileNumber")); 
			
			editor.putString("Gender", jObject.getString("Gender"));
			editor.putString("SecurityQuestion", jObject.getString("SecurityQuestion"));
			editor.putString("SecurityAnswer", jObject.getString("SecuirtyAnswer"));
			//editor.putString("Name", jObject.getString("Name"));

			editor.putString("EmployerCategory", jObject.getString("EmployerCategory")); 
			editor.putString("assesment_year", js.getString("assesment_year"));
			editor.putString("UserDOB", jObject.getString("UserDOB"));
			editor.putString("ResidentialStatus", jObject.getString("ResidentialStatus")); 
			editor.putString("FatherFirstName", jObject.getString("FatherFirstName"));
			
			editor.putString("FatherMiddleName", jObject.getString("FatherMiddleName"));
			editor.putString("FatherLastName", jObject.getString("FatherLastName"));
			editor.putString("PortugeseCivil", jObject.getString("PortugeseCivil"));
			editor.putString("PanOfSpouse", jObject.getString("PanOfSpouse")); 
			editor.putString("userAadhar", jObject.getString("userAadhar")); 
	  
			editor.commit(); // commit changes
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			
		}
		return responseData;

	}

	public String updateProfile(Activity ctx) {
		String responseData = "";
		try {
			JSONObject json = new JSONObject();
			json.put("method", "createNewUser");
			json.put("params", Update_Profile.screen.additionalData);
			System.out.println(json.toString(2));
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(
					ctx.getString(R.string.DUMMY_SERVICE_URL));
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			Log.i("Main", "Status Line: " + response.getStatusLine());
			responseData = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("Response Login: " + responseData);
			if (responseData.contains("\"serviceError\"")
					|| responseData.contains("\"Exception\""))
				return (responseData);
			else
				System.out.println("Response Login: " + responseData);
		} catch (Throwable t) {
			t.printStackTrace();
			return "network_issue";
		}
 
		if (!responseData.contains("true")&&(!responseData.contains("network_issue"))) {
		JSONObject js = null;
		JSONObject jObject = null;
		try {
			js = new JSONObject(responseData);
			jObject = js.getJSONObject("USER");
			String token_data = "";
			token_data = js.getString("token");
			System.out.println("Print Token" + token_data);
			Update_Profile.screen.user = new UserProfile();  
			// MainView.screen.so = new SharedObject();
			
			Update_Profile.screen.user.setToken(js .getString("token"));
			Update_Profile.screen.user.setPancard(jObject .getString("PanCardNumber"));
			//Update_Profile.screen.user.setName(jObject .getString("Name"));
			Update_Profile.screen.user.setEmailId(jObject.getString("EmailId"));
			
			Update_Profile.screen.user.setMobileNum(jObject.getString("MobileNumber")); 
			Update_Profile.screen.user.setGender(jObject.getString("Gender"));
			Update_Profile.screen.user.setDob(jObject.getString("UserDOB"));
			Update_Profile.screen.user.setAssesmentYear(js.getString("assesment_year")); 
 
			Update_Profile.screen.user.setemployee_category(jObject.getString("EmployerCategory"));
			Update_Profile.screen.user.setSecurityQuestion(jObject.getString("SecurityQuestion"));
			Update_Profile.screen.user.setSecurityAnswer(jObject.getString("SecuirtyAnswer"));
			Update_Profile.screen.user.setResidentialStatus(jObject.getString("ResidentialStatus"));
			Update_Profile.screen.user.setfather_fname(jObject.getString("FatherFirstName"));
			
			Update_Profile.screen.user.setfather_mname(jObject.getString("FatherMiddleName")); 
			Update_Profile.screen.user.setfather_lname(jObject.getString("FatherLastName"));
			Update_Profile.screen.user.setPortugesCivil(jObject.getString("PortugeseCivil")); 
			Update_Profile.screen.user.setpan_spouse(jObject.getString("PanOfSpouse"));  
			Update_Profile.screen.user.set_user_aadhar(jObject.getString("userAadhar"));  
			 
		  	 
			//Updating all data to local memory
			SharedPreferences pref =  Update_Profile.screen.getSharedPreferences(
					 Update_Profile.screen
							.getString(R.string.USER_SESS_PREF), 0); // 0 - for
																		// private
																		// mode
			Editor editor = pref.edit();
			
			editor.putString("token", js.getString("token"));
			editor.putString("pancard", jObject.getString("PanCardNumber"));
			editor.putString("emailId", jObject.getString("EmailId"));
			editor.putString("mobileNum", jObject.getString("MobileNumber")); 
			
			editor.putString("Gender", jObject.getString("Gender"));
			editor.putString("SecurityQuestion", jObject.getString("SecurityQuestion"));
			editor.putString("SecurityAnswer", jObject.getString("SecuirtyAnswer"));
			//editor.putString("Name", jObject.getString("Name"));

			editor.putString("EmployerCategory", jObject.getString("EmployerCategory")); 
			editor.putString("assesment_year", js.getString("assesment_year"));
			editor.putString("UserDOB", jObject.getString("UserDOB"));
			editor.putString("ResidentialStatus", jObject.getString("ResidentialStatus")); 
			editor.putString("FatherFirstName", jObject.getString("FatherFirstName"));
			
			editor.putString("FatherMiddleName", jObject.getString("FatherMiddleName"));
			editor.putString("FatherLastName", jObject.getString("FatherLastName"));
			editor.putString("PortugeseCivil", jObject.getString("PortugeseCivil"));
			editor.putString("PanOfSpouse", jObject.getString("PanOfSpouse")); 
			editor.putString("userAadhar", jObject.getString("userAadhar")); 
			
	  

			editor.commit(); // commit changes
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			
		}
		return responseData;
 	
		
	}

	public String forgotPassword(Activity ctx) {
		String responseData = "";
		try {
			JSONObject json = new JSONObject();
			json.put("method", "forgotpassword");
			json.put("params", Forgot_Password.screen.additionalData);
			System.out.println(json.toString(2));
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(
					ctx.getString(R.string.DUMMY_SERVICE_URL));
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			Log.i("Main", "Status Line: " + response.getStatusLine());
			responseData = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("Response Login: " + responseData);
			if (responseData.contains("\"serviceError\"")
					|| responseData.contains("\"Exception\""))
				return (responseData);
			else
				System.out.println("Response Login: " + responseData);
		} catch (Throwable t) {
			t.printStackTrace();
			return "network_issue";
		}
		if (!responseData.contains("true")&&(!responseData.contains("network_issue"))) {
		
		JSONObject js = null;
		JSONObject jObject = null;
		try {
			js = new JSONObject(responseData);
			jObject = js.getJSONObject("USER");
			String token_data = "";
			token_data = js.getString("token");
			System.out.println("Print Token" + token_data);
			Forgot_Password.screen.user = new UserProfile();  
			// MainView.screen.so = new SharedObject();
			
			Forgot_Password.screen.user.setToken(js .getString("token"));
			Forgot_Password.screen.user.setPancard(jObject .getString("PanCardNumber"));
			//Forgot_Password.screen.user.setName(jObject .getString("Name"));
			Forgot_Password.screen.user.setEmailId(jObject.getString("EmailId"));
			
			Forgot_Password.screen.user.setMobileNum(jObject.getString("MobileNumber")); 
			Forgot_Password.screen.user.setGender(jObject.getString("Gender"));
			Forgot_Password.screen.user.setDob(jObject.getString("UserDOB"));
			Forgot_Password.screen.user.setAssesmentYear(js.getString("assesment_year")); 
 
			Forgot_Password.screen.user.setemployee_category(jObject.getString("EmployerCategory"));
			Forgot_Password.screen.user.setSecurityQuestion(jObject.getString("SecurityQuestion"));
			Forgot_Password.screen.user.setSecurityAnswer(jObject.getString("SecuirtyAnswer"));
			Forgot_Password.screen.user.setResidentialStatus(jObject.getString("ResidentialStatus"));
			Forgot_Password.screen.user.setfather_fname(jObject.getString("FatherFirstName"));
			
			Forgot_Password.screen.user.setfather_mname(jObject.getString("FatherMiddleName")); 
			Forgot_Password.screen.user.setfather_lname(jObject.getString("FatherLastName"));
			Forgot_Password.screen.user.setPortugesCivil(jObject.getString("PortugeseCivil")); 
			Forgot_Password.screen.user.setpan_spouse(jObject.getString("PanOfSpouse"));
			Forgot_Password.screen.user.set_user_aadhar(jObject.getString("userAadhar"));
		//	Forgot_Password.screen.user.set_termsAccepted(jObject.getString("terms_accepted"));
			 
		  	 
			//Updating all data to local memory
			SharedPreferences pref =  Forgot_Password.screen.getSharedPreferences(
					 Forgot_Password.screen
							.getString(R.string.USER_SESS_PREF), 0); // 0 - for
																		// private
																		// mode
			Editor editor = pref.edit();
			
			editor.putString("token", js.getString("token"));
			editor.putString("pancard", jObject.getString("PanCardNumber"));
			editor.putString("emailId", jObject.getString("EmailId"));
			editor.putString("mobileNum", jObject.getString("MobileNumber")); 
			
			editor.putString("Gender", jObject.getString("Gender"));
			editor.putString("SecurityQuestion", jObject.getString("SecurityQuestion"));
			editor.putString("SecurityAnswer", jObject.getString("SecuirtyAnswer"));
			//editor.putString("Name", jObject.getString("Name"));

			editor.putString("EmployerCategory", jObject.getString("EmployerCategory")); 
			
			editor.putString("UserDOB", jObject.getString("UserDOB"));
			editor.putString("ResidentialStatus", jObject.getString("ResidentialStatus")); 
			editor.putString("FatherFirstName", jObject.getString("FatherFirstName"));
			
			editor.putString("FatherMiddleName", jObject.getString("FatherMiddleName"));
			editor.putString("FatherLastName", jObject.getString("FatherLastName"));
			editor.putString("PortugeseCivil", jObject.getString("PortugeseCivil"));
			editor.putString("PanOfSpouse", jObject.getString("PanOfSpouse")); 
			editor.putString("userAadhar", jObject.getString("userAadhar")); 
			editor.putString("assesment_year", js.getString("assesment_year"));
		//	editor.putString("terms_accepted", jObject.getString("terms_accepted"));

			editor.commit(); // commit changes
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			
		}
		
		
		return responseData;

	}

	public String changePassword(Activity ctx) {
		String responseData = "";
		try {
			JSONObject json = new JSONObject();
			json.put("method", "changepassword");
			json.put("params", Change_Password.screen.additionalData);
			System.out.println(json.toString(2));
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(
					ctx.getString(R.string.DUMMY_SERVICE_URL));
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			Log.i("Main", "Status Line: " + response.getStatusLine());
			responseData = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("Response Login: " + responseData);
			if (responseData.contains("\"serviceError\"")
					|| responseData.contains("\"Exception\""))
				return (responseData);
			else
				System.out.println("Response Login: " + responseData);
		} catch (Throwable t) {
			t.printStackTrace();
			return "network_issue";
		}

		return responseData;
		
		

	}

 
	
	 
	
	 
*/
}