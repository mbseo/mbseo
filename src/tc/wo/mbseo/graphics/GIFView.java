package tc.wo.mbseo.graphics;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

//android:hardwareAccelerated="false"

/**
 * GIF를 화면에 표시하여 준다.
 * 하지만, Android에서는 GIF를 비 권장 함.
 * @file  GIFView.java
 * @author  ?
 * @date  ?
 */
public class GIFView extends View{

	private Movie _movie;
	private InputStream _is = null;
	private long _movieStart;
	private Context _context;
	
	int _resid;
	int _duration;

	public GIFView(Context context, AttributeSet attrs) {
		super(context, attrs);
		_context = context;		
	}

	public GIFView(Context context) {
		super(context);
		
		_context = context;
	}
	
	public GIFView(Context context , int resid){
		super( context );
		setImage( resid );
	}

	public void setImage(int resid) {
		_resid = resid;
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		init();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		free();
	}

	private void init() {
		try {
			InputStream is = _context.getResources().openRawResource(_resid);
			byte[] array = streamToBytes(is);
			_movie = Movie.decodeByteArray(array, 0, array.length);
		}
		catch(Exception x) {
			x.printStackTrace();
		}
	}
	private void free() {
		try {
			if(_is != null)
				_is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static byte[] streamToBytes(InputStream is) {
		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
		byte[] buffer = new byte[1024];
		int len;
		try {
			while ((len = is.read(buffer)) >= 0) {
				os.write(buffer, 0, len);
			}
		} catch (java.io.IOException e) {
		}
		return os.toByteArray();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if(_movie == null)
			return;

		long now = SystemClock.uptimeMillis();
		if(_movieStart == 0){
			_movieStart = now;
		}

		if (_movie != null) {
			int dur = _movie.duration();
			if (dur == 0) {
				dur = 1000;
			}
			int relTime = (int)((now - _movieStart) % dur);
			_movie.setTime(relTime);
			_movie.draw(canvas, (getWidth() - _movie.width())/2,(getHeight() - _movie.height())/2);
			
			
			
			this.invalidate();
		}
	}

}
