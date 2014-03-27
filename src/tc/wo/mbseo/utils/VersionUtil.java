package tc.wo.mbseo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class VersionUtil {

	static public String getVersionName(Context context) {
    	Log.i("Version", "here in getVersionName");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
        	Log.i("Version", "err NameNotFoundException -> " + e.toString());
            return null;
        }
    }
}
