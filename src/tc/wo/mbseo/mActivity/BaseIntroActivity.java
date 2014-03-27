package tc.wo.mbseo.mActivity;

import tc.wo.mbseo.time.TimeChecker;
import android.app.Activity;
import android.os.Bundle;

/**
 * 인트로에 사용되는 Activity의 추상클래스.
 * 
 * @file  BaseIntroActivity.java
 * @author  mbseo
 * @date  2014. 2. 26.
 */
public abstract class BaseIntroActivity extends Activity implements TimeChecker.OnTimeCheckerHandler{

	private TimeChecker timeChecker;
	protected int delayItme = 0;

	protected boolean bLoad = false;
	protected boolean bDelay = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		init();
	}
	
	private void init()
	{
		timeChecker = new TimeChecker( 1 , getMinimumDelayTime() );
		timeChecker.addOnTimeCheckerHandler( this );
		
		timeChecker.start();
		
		load();
	}
	
	
	/**
	 * 필요한 객체들을 로드합니다.
	 */
	protected void load()
	{
		onloadComplete();
	}
	
	/**
	 * 로딩 완료시 호출 됩니다.
	 */
	protected void onloadComplete()
	{
		bLoad = true;
		checkFinish();
	}
	
	
	/**
	 * 로딩 & 딜레이 모두 완료를 검사합니다.
	 */
	public void checkFinish()
	{
		if( bLoad && bDelay )
		{
			finish();
		}
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * 로딩화면에서 최소 대기시간을 지정한다.
	 * @return
	 */
	protected int getMinimumDelayTime()
	{
		return 3000;
	}

	
	
	@Override
	public void timeComplete()
	{
		bDelay = true;
		checkFinish();
	}
}
