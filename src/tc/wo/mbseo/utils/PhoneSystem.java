package tc.wo.mbseo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.telephony.TelephonyManager;

public class PhoneSystem {

	/**
	 * 핸드폰의 번호를 가져옵니다. 
     * <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	 * @param context
	 * @return
	 */
    static public String getPhoneNumber( Context context )
    {
    	TelephonyManager systemService = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE); 
		return systemService.getLine1Number();
    }
    
    
    /**
     * 핸드폰을 진동합니다.
     * @param context
     * @param time 진동이 울리는 시간.
     */
    @SuppressLint("NewApi")
	static public void vibrate( Context context , int time )
    {
    	Vibrator mVibrator;
    	mVibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);

    	if(mVibrator.hasVibrator())
    	{
    		mVibrator.vibrate( time );
    	}
    }
    
    
}
