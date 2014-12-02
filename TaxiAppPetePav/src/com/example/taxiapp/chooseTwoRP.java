package com.example.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseTwoRP extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rpoption_activity);
        
        Button logoutButton = (Button) findViewById(R.id.logoutBtn);
        Button createTrip = (Button) findViewById(R.id.tripInfoBtn);
        Button viewProfile = (Button) findViewById(R.id.viewProfileBtn);
        
        logoutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
        
        createTrip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getTripInfo();
			}
        	
        	
        });       
        
        viewProfile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
        	
        	
        });
}
   
    private void getTripInfo(){
    	Intent tripInfoPage = new Intent(this, CarpoolController.class);
    	startActivity(tripInfoPage);
    }
}
