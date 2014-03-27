package tc.wo.mbseo.time;

import java.util.ArrayList;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * 지정시간에 Tick을 발생시킨다.
 * 
 * @file  TimeChecker.java
 * @author  mbseo
 * @date  2014. 2. 19.
 */
public class TimeChecker {
	
	static public interface OnTimeCheckerHandler
	{
		
		/**
		 * 매 반복 됩니다.
		 */
		public void tick();
		
		/**
		 * 시간완료시 호출됩니다.
		 */
		public void timeComplete();
	};
	
	private ArrayList<OnTimeCheckerHandler> onTimeCheckerHandlerList;
	private Handler handler;
	private int time;
	private int dTime;
	private int cycle;
	
	public TimeChecker( int cycle , int delayTime )
	{
		this.cycle = cycle;
		dTime = delayTime;
		
		init();
	}
	
	private void init()
	{
		onTimeCheckerHandlerList = new ArrayList<TimeChecker.OnTimeCheckerHandler>();
	}
	
	/**
	 * 타임체커를 구동합니다.
	 */
	public void start()
	{
		timeCheck( cycle , dTime );
	}
	
	/**
	 * 타임 체커를 정지시킵니다.
	 */
	public void stop()
	{
		reset();
	}
	
	/**
	 * 최초의 생성상태로 객체를 리셋한다.
	 */
	public void reset()
	{
		dTime =cycle = time = 0;
	}
	
	public void addOnTimeCheckerHandler( OnTimeCheckerHandler onTimeCheckerHandler)
	{
		onTimeCheckerHandlerList.add( onTimeCheckerHandler );
	}
	
	public void removeOnTimeCheckerHandler( OnTimeCheckerHandler onTimeCheckerHandler)
	{
		int i = onTimeCheckerHandlerList.size();
		OnTimeCheckerHandler handler;
		while( --i > -1 )
		{
			handler = (OnTimeCheckerHandler)onTimeCheckerHandlerList.get( i );
			
			if( handler == onTimeCheckerHandler )
			{
				onTimeCheckerHandlerList.remove( i );
				break;
			}			
		}
	}
	
	/**
	 * 한번 회전씩 매번 발생됩니다.
	 */
	protected void onTick()
	{
		int i = onTimeCheckerHandlerList.size();
		
		while( --i > -1 )
		{
			onTimeCheckerHandlerList.get(i).tick();
		}
		
	}
	
	/**
	 * 타임체커가 완료시 실행됩니다.
	 */
	protected void onComplete()
	{
		_isPlaying = false;
		int i = onTimeCheckerHandlerList.size();
		
		while( --i > -1 )
		{
			onTimeCheckerHandlerList.get(i).timeComplete();
		}
	}
	
	
	/**
	 * 지정시간 tick을 발생시킵니다.
	 * @param cycle 반복횟수
	 * @param delayTime 반복시간
	 */
	public void timeCheck( int cycleCnt , int delayTime )
	{
		this.cycle = cycleCnt;
		this.dTime = delayTime;
		
		handler = new Handler() {
            public void handleMessage(Message msg) {
            	
            		if( time < cycle || cycle == 0 )
            		{
            			onTick();
                		handler.sendEmptyMessageDelayed( 0, dTime );
            		}
            		else
            		{
            			onComplete();
            		}

            		time++;
                }
         };
         
         _isPlaying = true;
         handler.sendEmptyMessage( 0 );
	}
	
	private boolean _isPlaying = false;
	
	/**
	 * 시간 체크의 진행여부를 확인합니다.
	 * @return
	 */
	public boolean isPlaying()
	{
		return _isPlaying;
	}

}
