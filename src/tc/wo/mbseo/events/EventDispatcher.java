package tc.wo.mbseo.events;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * EventDispatcher 클래스는 이벤트를 전달하는 모든 클래스의 기본 클래스입니다. 
 * 
 * @file  EventDispatcher.java
 * @author  mbseo
 * @date  2014. 2. 24.
 */
public class EventDispatcher {
	
	private ArrayList<OnEventLisener> listenerList;
	
	static public interface OnEventLisener
	{
	}
	
	public EventDispatcher()
	{
		listenerList = new ArrayList<OnEventLisener>();	
	}
	
	
	/**
	 * 이벤트가 발생될겨우 콜이 발생될 리스너를 등록한다.
	 * @param onListener
	 */
	public void addOnListener( EventDispatcher.OnEventLisener onListener )
	{
		listenerList.add( onListener );
	}
	
	/**
	 * 이벤트가 발생될겨우 콜이 발생될 리스너를 삭제한다.
	 * @param onListener
	 * @return 삭제 여부
	 */
	public boolean removeOnListener( EventDispatcher.OnEventLisener onListener )
	{
		int i = listenerList.size();
		Boolean result = false;
		
		while( --i > -1 )
		{
			if( listenerList.get( i ) == onListener )
			{
				result = listenerList.remove( onListener );
			}
		}

		return result;
	}
	
	/**
	 * 리스너를 담은 이터널을 리턴한다.
	 * @return 리스너를 담은 이터널.
	 */
	public Iterator<OnEventLisener> iterator()
	{
		return listenerList.iterator();
		
	}
	
	
	
	
}
