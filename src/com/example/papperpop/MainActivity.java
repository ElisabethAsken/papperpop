package com.example.papperpop;

import android.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
//		
		dialog = new Dialog(MainActivity.this); //Detta låg efter onClicklistener vilket innebar att knapparna inte fanns 
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_layout); //Här läses knapparna in innan dess kan man inte leta upp dem med findviewById
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		
		Button yes = (Button) dialog.findViewById(R.id.button1); //Här var det lite fel stod id.button1 ???
		yes.setOnClickListener(dialogListener);
		
		Button no = (Button) dialog.findViewById(R.id.button2);
		no.setOnClickListener(dialogListener);

	}
		
	
	public void onBackPressed() {
		dialog.show();
		return;
	}

	
	public OnClickListener dialogListener = new OnClickListener(){

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.button1:
		Intent intent = new Intent (v.getContext(), activity2.class);
		startActivityForResult(intent, 0);
		break;
		}
		switch(v.getId()){
		case R.id.button2:
		dialog.cancel();
		break;
		}
		
	}
	};
	
	

}
