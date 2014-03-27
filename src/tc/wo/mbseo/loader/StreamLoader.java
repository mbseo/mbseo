package tc.wo.mbseo.loader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;

import tc.wo.mbseo.utils.MIOUtils;

/**
 * 스트림을 로드합니다.
 * 
 * @file  StreamLoader.java
 * @author  mbseo
 * @date  2014. 2. 25.
 */
public class StreamLoader  extends Loader implements Runnable{

	static public class StreamLoadData implements Loader.LoadData
	{
		private byte[] StreamData;
		
		public StreamLoadData( byte[] StreamData )
		{
			this.StreamData = StreamData;
		}
		
		public byte[] getData()
		{
			return StreamData;
		}
	}
	
	private String loadURL;
	
	
	@Override
	public void load( String url )
	{
		this.loadURL = url;
		
		Thread thread = new Thread( this );
		thread.start();
	}

	@Override
	public void run() {
		try {
    	   URL url = new URL( loadURL );
    	   HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    	   conn.setDoInput(true);
    	   conn.connect();
    	   InputStream is = conn.getInputStream(); // InputStream is 변수에 받아온 InputStream을 저장합니다.
    	   
    	   
    	   data = new StreamLoadData( MIOUtils.toByteArray( is ) );
    	   
    	   is.close();
    	   
    	   onLoadComplete();
	    	   
	  } catch (Exception e) {
		  onLoadError();
	  }
		
	}
}

