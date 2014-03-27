package tc.wo.mbseo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MIOUtils {
	
	/**
	 * byteArray로 변환한다.
	 * @param inputStream 변환할 inputStream
	 * @return 변환된 byteArray
	 */
	static public byte[] toByteArray( InputStream inputStream )
	{
		InputStream is = inputStream;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		try {
			
			while ((nRead = is.read(data, 0, data.length)) != -1) {
			  buffer.write(data, 0, nRead);
			}
			
			buffer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return buffer.toByteArray();
	}
}
