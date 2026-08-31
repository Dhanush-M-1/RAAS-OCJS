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
		
		int k, l, sum = 0;
		int n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		boolean [] numbers = new boolean [m];

		for( int i = 0; i < n; i++ )
		{
			param = br.readLine();
			st = new StringTokenizer( param.trim() );
			k = Integer.parseInt( st.nextToken() );
			
			for( int j = 0; j < k; j++ )
			{
				l = Integer.parseInt( st.nextToken() );
				
				if( numbers[l-1] == false)
				{
					numbers[ l - 1 ] = true;
					sum += l;
				}
			}
		}


		if( sum == (m * (m + 1)) / 2 )
		{	System.out.println("YES");	}
		
		else
		{	System.out.println("NO");	}
	}
}