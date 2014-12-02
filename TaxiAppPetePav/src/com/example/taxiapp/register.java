package com.example.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends Activity {

	private String[] regVals = new String[5];

	private String[] emailHalves;
	private String[] emailEnd;
	private String[] dateOfBirth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registerpage_activity);
		Button regSubmit = (Button) findViewById(R.id.regSubmitBtn);

		final TextView nameErrorNotif = (TextView) findViewById(R.id.nameError);
		final TextView passErrorNotif = (TextView) findViewById(R.id.passError);
		final TextView emailErrorNotif = (TextView) findViewById(R.id.emailError);
		final TextView ageErrorNotif = (TextView) findViewById(R.id.ageError);
		final EditText regFirstNametxt = (EditText) findViewById(R.id.firstNameReg);
		final EditText regLastNametxt = (EditText) findViewById(R.id.lastNameReg);
		final EditText regEmailtxt = (EditText) findViewById(R.id.emailReg);
		final EditText regDoBtxt = (EditText) findViewById(R.id.DoBReg);
		final EditText regPasstxt = (EditText) findViewById(R.id.regPassword);

		regSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*regFirstName = regFirstNametxt.getText();
					regLastName = regLastNametxt.getText();
					regEmail = regEmailtxt.getText();
					regDoB = regDoBtxt.getText();
					regPasswrd = regPasstxt.getText();*/

				regVals[0] = regFirstNametxt.getText().toString();
				regVals[1] = regLastNametxt.getText().toString();
				regVals[2] = regEmailtxt.getText().toString();
				regVals[3] = regDoBtxt.getText().toString();
				regVals[4] = regPasstxt.getText().toString();

				if((regVals[0].length() < 1) || (regVals[1].length() < 1)){
					nameErrorNotif.setVisibility(nameErrorNotif.VISIBLE);
				}else{
					nameErrorNotif.setVisibility(nameErrorNotif.INVISIBLE);
				}
				
				if(regVals[2].length() > 3){
					emailHalves = regVals[2].split("@");
					if(emailHalves.length == 2){
						emailEnd = emailHalves[1].split("\\.");
						if(emailEnd.length == 2){
							emailErrorNotif.setVisibility(View.INVISIBLE);		
						}else{
							emailErrorNotif.setVisibility(View.VISIBLE);
						}

					}else{
						emailErrorNotif.setVisibility(View.VISIBLE);
					}
				}else{
					emailErrorNotif.setVisibility(View.VISIBLE);
				}
				
				if(regVals[3].length() >= 8){
					dateOfBirth = regVals[3].split("/");
					if(dateOfBirth.length == 3){
						if((2014 - Integer.parseInt(dateOfBirth[2])) < 18){
							ageErrorNotif.setVisibility(ageErrorNotif.VISIBLE);
						}else{
							ageErrorNotif.setVisibility(ageErrorNotif.INVISIBLE);
						}
					}
				}else{
					ageErrorNotif.setVisibility(ageErrorNotif.VISIBLE);
				}
				
				if(regVals[4].length() < 1){
					passErrorNotif.setVisibility(passErrorNotif.VISIBLE);
				}else{
					passErrorNotif.setVisibility(passErrorNotif.INVISIBLE);
				}
				
				if((passErrorNotif.getVisibility() == passErrorNotif.INVISIBLE) && (ageErrorNotif.getVisibility() == ageErrorNotif.INVISIBLE) && (emailErrorNotif.getVisibility() == emailErrorNotif.INVISIBLE) && (nameErrorNotif.getVisibility() == nameErrorNotif.INVISIBLE)){
					Registered();
				}
			}
			
		});
	}
	
	private void Registered(){
		finish();
	}
}