package tc.wo.mbseo.loader;

import java.util.Iterator;

import tc.wo.mbseo.events.EventDispatcher;

/**
 * 로드 객체의 기본 클래스 입니다.
 * 
 * @file  Loader.java
 * @author  mbseo
 * @date  2014. 2. 25.
 */
public class Loader extends EventDispatcher{
	
	protected LoadData data;
	
	static public interface OnLoader extends EventDispatcher.OnEventLisener 
	{
		void onLoadComplete( LoadData data );
		
		void onLoadError();
	}
	
	static public interface LoadData
	{
	}
	
	public Loader()
	{	
	}
	
	/**
	 * 로드를 시작합니다.
	 * @param url 로드할 주소.
	 */
	public void load( String url )
	{
		//Override me.
	}
	
	/**
	 * 로드 완료시 호출 됩니다.
	 */
	public void onLoadComplete()
	{
		Iterator<OnEventLisener> lisenerIterator = iterator();
		
		OnLoader onLoader;
		
		while( lisenerIterator.hasNext() )
		{
			onLoader = (OnLoader)lisenerIterator.next();
			
			if( onLoader != null )
			{
				onLoader.onLoadComplete( data );
			}			
		}
	}
	
	/**
	 * 로드 에러시 호출됩니다.
	 */
	public void onLoadError()
	{
		Iterator<OnEventLisener> lisenerIterator = iterator();
		
		OnLoader onLoader;
		
		while( lisenerIterator.hasNext() )
		{
			onLoader = (OnLoader)lisenerIterator.next();
			
			if( onLoader != null )
			{
				onLoader.onLoadError();
			}			
		}
	}
}
