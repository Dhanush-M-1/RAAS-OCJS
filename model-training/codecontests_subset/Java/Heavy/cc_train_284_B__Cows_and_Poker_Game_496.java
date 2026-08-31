import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static int countA ;
	public static int countF ;
	public static int countI ;
	
	public static int n ;
	public static char cur ;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in ) );
		StringTokenizer token = new StringTokenizer( bf.readLine() ) ;
		n = Integer.valueOf( token.nextToken() ); 
		String line = bf.readLine() ;
		countA = countF = countI = 0 ;
		for( int i = 0 ; i < n ; i++ ){
			
			switch ( line.charAt( i )) {
			case 'A': countA++;break;
			case 'F': countF++;break;
			case 'I': countI++;break;

			default:
				break;
			}
			
		}
		int result = 0 ;
		if( countA != 0 || countF != 0 ){
			
			if( countI != 0 ){
				if( countI == 1 )
					result = 1 ;
			}
			else
				result += countA ;
			System.out.println( result );
		}else
			System.out.println( "0" );
		
	}

}
