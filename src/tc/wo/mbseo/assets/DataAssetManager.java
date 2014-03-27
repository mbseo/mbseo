package tc.wo.mbseo.assets;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;


/**
 * 외부에서 로드되는 asset을 관리합니다.
 * 
 * @file  DataAssetManager.java
 * @author  mbseo
 * @date  2014. 2. 21.
 */
public class DataAssetManager {
	private Map<String, Bitmap> bitmapAssets;
	private HashMap<String, InputStream> inputStreamAssets;
	
	static private DataAssetManager instance;
	
	static private DataAssetManager getInstance()
	{
		if( instance == null )
		{
			instance = new DataAssetManager();
		}
		
		return instance;
	}

	/**
	 * 에셋을 저장합니다.
	 * @param key 저장할 key 값
	 * @param bitmap 저장할 데이터.
	 */
	static public void putExtra( String key , Bitmap bitmap )
	{
		getInstance().put(key, bitmap);
	}
	

	/**
	 * 에셋을 저장합니다.
	 * @param key 저장할 key 값
	 * @param bitmap 저장할 데이터.
	 */
	static public void putExtra( String key , InputStream inputStream )
	{
		getInstance().put( key, inputStream );
	}
	
	/**
	 * 에셋을 가져옵니다.
	 * @param key 가져올 key 값
	 * @return 가져올 bitmap 데이터.
	 */
	static public Bitmap getBitmapExtra( String key )
	{
		return getInstance().getBitmap( key );
	}
	
	/**
	 * 에셋을 가져옵니다.
	 * @param key 가져올 key 값
	 * @return 가져올 bitmap 데이터.
	 */
	static public InputStream getInputStreamExtra( String key )
	{
		return getInstance().getInputStream( key );
	}
	
	
	public DataAssetManager()
	{
		init();
	}
	
	private void init()
	{
		bitmapAssets = new HashMap<String, Bitmap>();
		inputStreamAssets  = new HashMap<String, InputStream>();
	}
	
	/**
	 * bitmap데이터를 저장합니다.
	 * @param key
	 * @param bitmap
	 */
	private void put( String key , Bitmap bitmap )
	{
		bitmapAssets.put( key , bitmap );
	}
	
	/**
	 * inputStream데이터를 저장합니다.
	 * @param key
	 * @param bitmap
	 */
	private void put( String key , InputStream inputStream )
	{
		inputStreamAssets.put( key , inputStream );
	}
	
	
	public Bitmap getBitmap( String key )
	{
		return bitmapAssets.get( key );
	}
	
	public InputStream getInputStream( String key )
	{
		return inputStreamAssets.get( key );
	}
	
}
