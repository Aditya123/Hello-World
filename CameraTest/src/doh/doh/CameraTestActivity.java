package doh.doh;    

import java.io.File;



import android.os.Build;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class CameraTestActivity extends Activity {
    /** Called when the activity is first created. */ 
	private static final String TAG = "CameraTestActivity.java";
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b = (Button) findViewById(R.id.button1);

        
        b.setOnClickListener(new OnClickListener() {
        
 
        	  EditText text = (EditText)findViewById(R.id.editText1); 
        	  EditText text2 = (EditText)findViewById(R.id.editText2);
            //EditText text3 = (EditText)findViewById(R.id.editText3);

            
        	
			@Override
			public void onClick(View v) {
				Calendar cal = Calendar.getInstance(); 
				
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				
				//final String position = s.getSelectedItem().toString();
				//Log.e(TAG, position); This just logs the position that someone selected
				final String name = text.getText().toString();
				final String apparatus = text2.getText().toString();
				//final String posLetter = name.substring(paren, position.length() - 1);
								
				//String place = placeName.substring(0,3);
	            //String direct  = name + place ;
	            String time = year + "-" + month + "-" + day;//Year Month Day part
	            String model = Build.MODEL;//The phone Model
	            
	            File folder = new File("/sdcard/OrganizePic/" + time + model + apparatus + "-" + name + "/");
				folder.mkdirs();
				
				Intent myIntent = new Intent(CameraTestActivity.this, Press.class);
				myIntent.putExtra("key", "/sdcard/OrganizePic/" + time + model + apparatus + "-" + name + "/");
				myIntent.putExtra("stan", name);
				myIntent.putExtra("hello", time);
				myIntent.putExtra("apparatus", apparatus);
				startActivity(myIntent);   
				
			}
		});
        
       
}
}