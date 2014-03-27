package tc.wo.mbseo.utils;

import android.graphics.Point;

/**
 * 포인트에 대한 함수를 정의한다.
 * 
 * @file  PointUtil.java
 * @author  mbseo
 * @date  2014. 3. 26.
 */
public class PointUtil {
	
	/**
	 * 두점사이의 거리를 구한다.
	 * @param p1
	 * @param p2
	 * @return
	 */
	static public float distance( Point p1 , Point p2 )
	{
		return (float)Math.sqrt( Math.pow( p1.x - p2.x , 2) * Math.pow( p1.y - p2.y , 2) );
	}
}
