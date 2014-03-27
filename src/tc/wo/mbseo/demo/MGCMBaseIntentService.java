package tc.wo.mbseo.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gcm.GCMBaseIntentService;

public class MGCMBaseIntentService extends GCMBaseIntentService{
	//<service android:name="com.ksignage.pushproject.GCMIntentService" />
	
	 public static String mID = ""; 
	    
	    //register
	    
	    public MGCMBaseIntentService( String senderId )
	    {
	    	super( senderId );
	    }
	    
	    @Override 
	    protected void onError(Context context, String errorId) {
	        Log.v("GCMIntentService", "onError - " + errorId); 
	    } 

	    @SuppressLint("NewApi")
		@Override 
	    protected void onMessage(Context context, Intent intent) {
	    	Log.i( TAG , "onMessage" );
	    	/*
	    	//알림음.
	    	Uri ringtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(),RingtoneManager.TYPE_NOTIFICATION);
	    	Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), ringtoneUri);
	    	ringtone.play();
	    	//
	    	
	    	//진동.
	    	Vibrator mVibrator;
	    	mVibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

	    	if(mVibrator.hasVibrator())
	    	{
	    		mVibrator.vibrate(1000);
	    	}*/
	    	//
			
	    }
	 
	    @Override 
	    protected void onRegistered(Context context, String regId) {
	        final String mID = regId; 
	        Log.i( TAG , "onRegistered : "+regId );
	        
	    } 
	 
	    
	    

		@Override
		protected void onUnregistered(Context arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}
}
