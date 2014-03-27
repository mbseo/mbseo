package tc.wo.mbseo.loader;

import java.io.InputStream;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * 웹상의 xml을 로드합니다.
 * 
 * @file  XMLLoader.java
 * @author  mbseo
 * @date  2014. 2. 24.
 */
public class XMLLoader extends Loader implements Runnable{
	

	static public class XMLLoadData implements Loader.LoadData
	{
		private XmlPullParser xmlData;
		
		public XMLLoadData( XmlPullParser xmlData )
		{
			this.xmlData = xmlData;
		}
		
		public XmlPullParser getData()
		{
			return xmlData;
		}
	}
	
	
	
	private String url = "";
	private Thread thread;
	
	
	
	
	@Override
	public void load( String url )
	{
		this.url = url;
		
		thread = new Thread( this );
		thread.start();
	}

	@Override
	public void run() {
		
		try {
			URL newsURL = new URL( url );
			
			//xml데이터를 읽어서 inpuitstream에 저장
	        InputStream in;
			
			in = newsURL.openStream();
			
	        //XmlPullParser를 사용하기 위해서
	        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	       
	        //네임스페이스 사용여부
	        factory.setNamespaceAware(true);
	        //xml문서를 이벤트를 이용해서 데이터를 추출해주는 객체
	        XmlPullParser xml = factory.newPullParser();
	       
	        //XmlPullParser xml데이터를 저장
	        
	        xml.setInput(in, "euc-kr");
	        
	        data = new XMLLoadData( xml );
	        
	        onLoadComplete();
	        
		} catch (Exception e) {
			e.printStackTrace();
			onLoadError();
		}
	}
	
}
