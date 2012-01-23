package doh.doh;

import java.io.File;

import java.io.IOException;

import android.media.ExifInterface;


import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



public class Press extends Activity {
	
	private static final int CAMERA_REQUEST = 1888; 
	private static final String TAG = "Press.java";
	int[] count = new int[8];//gonna be used to increment stuff
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.afterenter);
	    final String direct = this.getIntent().getStringExtra("key");
	    final String name = this.getIntent().getStringExtra("stan");
		final String time  = this.getIntent().getStringExtra("hello");
		final String apparatus = this.getIntent().getStringExtra("apparatus");
        final Spinner s = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(
                    Press.this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        
        
	    // TODO Auto-generated method stub
	    Button p = (Button) findViewById(R.id.button2);
	    p.setOnClickListener(new OnClickListener() {
	    Calendar cal = Calendar.getInstance();
	    
			@Override
			public void onClick(View v) {
		        String position = s.getSelectedItem().toString();
		        int paren = position.indexOf("(");
		        String posLetter = position.substring(paren + 1, position.length() - 1);
		        //int county = getCount(pos);
				final String file = direct + time + "-" + apparatus + "-" + name + "-" + posLetter + /*county +*/ ".jpeg";
				
				//these three following codes are for the Retake button 
				//int pos = incrementCount(posLetter);
				//int county = getCount(pos);
				//clearCount(pos);
				
				Intent camera= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				Uri uriSavedImage=Uri.fromFile(new File(file));
				camera.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uriSavedImage);
				int pos = incrementCount(posLetter);
				startActivityForResult(camera, CAMERA_REQUEST);

				/*				
				 * 				try {
					ExifInterface exifInterface = new ExifInterface(file);
					exifInterface.setAttribute(ExifInterface.TAG_MODEL, tagged);
					Log.e(TAG, "sucess");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Log.e(TAG, "File is non existant");
					//e.printStackTrace();
				}		
				*/		
			}
		});	    
	    
	Button np = (Button) findViewById(R.id.button3);
	np.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent next = new Intent(Press.this, CameraTestActivity.class);
			startActivity(next);
		}
	});	
	    
	}
	
	public int incrementCount(String str){
		if(str.equals("L")){
			count[0] = count[0]++;
			return 0;
		}
		else if(str.equals("LC")){
			count[1] = count[1]++;
			return 1;
		}
		else if(str.equals("C")){
			count[2] = count[2]++;
			return 2;
		}
		else if(str.equals("RC")){
			count[3] = count[3]++;
			return 3;
		}
		else if(str.equals("R")){
			count[4] = count[4]++;
			return 4;
		}
		else if(str.equals("TL")){
			count[5] = count[5]++;
			return 5;
		}
		else if(str.equals("TR")){
			count[6] = count[6]++;
			return 6;
		}
		else if(str.equals("TV")){
			count[7] = count[7]++;
			return 7;
		}
		return 0;
	}
	
	public int getCount(int i){
		return count[i];
	}
	
	public void clearCount(int i){
		count[i] = 0;
	}
	
	public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


	
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    	final String tagged = this.getIntent().getStringExtra("hello");
//        if(resultCode == RESULT_OK){
//        	if (requestCode == CAMERA_REQUEST) {  
//        		try {
//        			final String file = this.getRealPathFromURI(data.getData());
//        			ExifInterface exifInterface = new ExifInterface(file);
//        			exifInterface.setAttribute(ExifInterface.TAG_MODEL, tagged);
//        			Log.e(TAG, "sucess");
//        		} catch (IOException e) {
//        			// TODO Auto-generated catch block
//        			Log.e(TAG, "File is non existant");
//        			//e.printStackTrace();
//			}		
//        }  
//      }
//    }
	
}
