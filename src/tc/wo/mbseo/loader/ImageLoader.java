package tc.wo.mbseo.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageLoader extends StreamLoader{

	
	static public class ImageLoadData implements Loader.LoadData
	{
		private Bitmap bitmapData;
		
		public ImageLoadData( Bitmap bitmapData )
		{
			this.bitmapData = bitmapData;
		}
		
		public Bitmap getData()
		{
			return bitmapData;
		}
	}
	
	@Override
	public void onLoadComplete()
	{
		StreamLoader.StreamLoadData streamLoadData = (StreamLoader.StreamLoadData) data;
		byte[] b;
		
		if( streamLoadData != null )
		{
			b = streamLoadData.getData();
			data = new ImageLoadData( BitmapFactory.decodeByteArray( b , 0, b.length ) );
		}
		
		super.onLoadComplete();
	}
}
