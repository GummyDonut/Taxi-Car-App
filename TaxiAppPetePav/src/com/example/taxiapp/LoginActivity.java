package com.example.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	private String emailDummy = "hello";
	private String passDummy = "world";

	private Editable getEmail;
	private Editable getPass;

	TextView success;
	TextView loginError;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Button loginButton = (Button) findViewById(R.id.loginBtn);
		Button regButton = (Button) findViewById(R.id.regBtn);
		loginError = (TextView) findViewById(R.id.failedLogin);
		final EditText emailText = (EditText) findViewById(R.id.emailTxtField);
		final EditText passText = (EditText) findViewById(R.id.passwrdTextField);
		success = (TextView) findViewById(R.id.Success);


		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getEmail = emailText.getText();
				getPass = passText.getText();

				if(emailDummy.equals(getEmail.toString())){
					if(passDummy.equals(getPass.toString())){
						success.setVisibility(View.VISIBLE);
						loginError.setVisibility(View.INVISIBLE);
						loggedIn();
					}else{
						success.setVisibility(View.INVISIBLE);
						loginError.setVisibility(View.VISIBLE);
					}
				}else{
					success.setVisibility(View.INVISIBLE);
					loginError.setVisibility(View.VISIBLE);
				}
			}
		});

		regButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				register();
			}
		});
	}


	//@Override
	/* boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}*/

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

	private void loggedIn(){
		Intent onwards =  new Intent(this, chooseTwoRP.class);
		startActivity(onwards);
	}

	private void register(){
		Intent register = new Intent(this, register.class);
		startActivity(register);
	}
}
