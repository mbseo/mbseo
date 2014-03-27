package tc.wo.mbseo.server;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * 
 * 자바스크립트 통신 관련 기본 클래스.
 * 
 * AndroidManifest.xml
 * <uses-permission android:name="android.permission.INTERNET"/>
 * 
 * javascript
 * 
 * funciton callAndroid( args )
 * {
 * 		public void callwindow.android.androidFunction( args );
 * }
 * 
 * @file  BaseJavascriptInterface.java
 * @author  mbseo
 * @date  2014. 2. 21.
 */
public class BaseJavascriptInterface {
	
	private WebView webview;
	private Context context;
	
	public BaseJavascriptInterface( Context context , WebView webview )
	{
		this.context = context;
		this.webview = webview;
		init();
		
	}
	
	@SuppressLint("JavascriptInterface")
	private void init()
	{
		webview.addJavascriptInterface(	this , "android");
		
        WebSettings set = webview.getSettings();
        set.setJavaScriptEnabled(true);
	}
	
	
	public Context  getContext()
	{
		return context;
	}
	
	
}

