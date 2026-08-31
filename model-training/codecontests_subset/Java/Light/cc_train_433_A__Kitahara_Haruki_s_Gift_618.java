import java.io.* ;
import java.util.* ;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		int n = Integer.parseInt(br.readLine()) ;
		int h = 0 , t = 0 ;
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		while(n-- != 0)
		{
			if(Integer.parseInt(st.nextToken()) == 200)
				t++ ;
			else
				h++ ;
		}
		boolean hm2 = h % 2 == 0 , tm2 = t % 2 == 0 ;
		if(hm2 && tm2)
			System.out.println("YES");
		else
		{
			if(!hm2)
				System.out.println("NO");
			else
			{
				if(h > 0)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}