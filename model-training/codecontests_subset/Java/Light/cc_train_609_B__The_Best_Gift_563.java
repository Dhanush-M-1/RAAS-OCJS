import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem609B
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] genre = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++)
		{
			genre[Integer.parseInt(st.nextToken())-1]++;
		}
		int combinations = 0;
		for(int i=0 ; i<m ; i++)
		{
			for(int j=i+1 ; j<m ; j++)
			{
				combinations += genre[i] * genre[j];
			}
		}
		System.out.println(combinations);
	}
}
