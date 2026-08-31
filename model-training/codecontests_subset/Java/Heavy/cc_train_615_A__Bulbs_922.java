import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulbs
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer( param.trim() );
		
		int k;
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		boolean [] numbers = new boolean [m];

		for( int i = 0; i < n; i++ )
		{
			param = br.readLine();
			st = new StringTokenizer( param.trim() );
			k = Integer.parseInt( st.nextToken() );
			
			for( int j = 0; j < k; j++ )
			{	numbers[ Integer.parseInt( st.nextToken() ) - 1 ] = true;	}
		}

		for( int i = 0; i < m; i++ )
		{
			if( numbers[i] == false )
			{
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
	}
}
