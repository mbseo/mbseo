package tc.wo.mbseo.utils;



/**
 * string형태에서 자릿수로 구분되는 형태의 데이터를 파싱합니다.
 * 
 * @file  IntercomStringParser.java
 * @author  mbseo
 * @date  2014. 3. 13.
 */
public class StringParser {
	
	/**
	 * 인터콤에서 전달되는 스트링형태의 데이터 파서입니다.
	 * @param data String 데이터
	 * @param parseStringLengthData 데이터 파싱 정보.
	 * @return
	 */
	static public String[] parse( String data , int[] parseStringLengthData )
	{
		int length = parseStringLengthData.length;
		String str = data;
		int[] stringLengthData = checkParseData( parseStringLengthData , str.length() );
		int i , endPointer;
		
		String[] result = new String[length];
		
		int startPointer = 0;
		try
		{
			for( i = 0; i < length; i++ )
			{
				endPointer = stringLengthData[i];
				
				result[ i ] = str.substring( startPointer , startPointer + endPointer );
				startPointer += endPointer;
			}
		}
		catch( RuntimeException e )
		{
			throw new RuntimeException( "IntercomStringParser.parse() 데이터와 파싱 데이터가 일치하지 않습니다." );
		}
		
		return result;
	}
	
	/**
	 * parse데이터중 하나의 갯수를 알수없는 데이터( -1 )의값을 찾아서 자릿수를 채운후 리턴합니다.
	 * @param parseLengthData
	 * @return
	 */
	static public int[] checkParseData( int[] parseStringLengthData , int length )
	{
		int i = parseStringLengthData.length;
		int n = -1;
		int checkNum;
		int result = length;
		
		while( --i > -1 )
		{
			checkNum = parseStringLengthData[ i ];
			
			if( checkNum == -1 )
			{
				n = i;
			}
			else
			{
				result -= checkNum;
			}
		}
		
		if( n != -1 )
		{
			parseStringLengthData[ n ] = result;
		}
		
		return parseStringLengthData;
	}
	
}
