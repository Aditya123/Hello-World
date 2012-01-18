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
import android.widget.Button;



public class Press extends Activity {
	
	private static final int CAMERA_REQUEST = 1888; 
	private static final String TAG = "Press.java";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.afterenter);
	    final String direct = this.getIntent().getStringExtra("key");
	    final String name = this.getIntent().getStringExtra("stan");
		final String tagged = this.getIntent().getStringExtra("hello");
	    
	    // TODO Auto-generated method stub
	    Button p = (Button) findViewById(R.id.button2);
	    p.setOnClickListener(new OnClickListener() {
	    
			@Override
			public void onClick(View v) {
				Calendar cal = Calendar.getInstance();
				int i = cal.get(Calendar.DAY_OF_YEAR);
				int a = cal.get(Calendar.HOUR_OF_DAY);
				int b = cal.get(Calendar.MINUTE);
				int c = cal.get(Calendar.SECOND);
				final String file = direct + name + i + a + b + c + ".jpeg";
				Log.e(TAG, file);
				
				
				
				Intent camera= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				Uri uriSavedImage=Uri.fromFile(new File(direct + name + i + a + b + c + ".jpeg"));
				camera.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uriSavedImage);
				startActivityForResult(camera, CAMERA_REQUEST);
/*				try {
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
