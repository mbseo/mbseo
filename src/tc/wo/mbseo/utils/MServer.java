package tc.wo.mbseo.utils;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import android.os.Looper;

public class MServer {
	
	private String url;
	private JSONObject jsonParam;
	
	public MServer( String url )
	{
		this.url = url;
	}
	
	
	public void sendJson( JSONObject json )
	{
		jsonParam = json;
		
		 Thread t = new Thread() {

	            public void run() {
	                Looper.prepare();
	                HttpClient client = new DefaultHttpClient();
	                HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000);
	                HttpResponse response;
	                
	                try {
	                    HttpPost post = new HttpPost(url);
	                    StringEntity se = new StringEntity( jsonParam.toString());  
	                    se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	                    post.setEntity(se);
	                    response = client.execute(post);

	                    if(response!=null){
	                        InputStream in = response.getEntity().getContent();
	                    }

	                } catch(Exception e) {
	                    e.printStackTrace();
	                }

	                Looper.loop(); //Loop in the message queue
	            }
	        };

	        t.start(); 
	}

	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

}
