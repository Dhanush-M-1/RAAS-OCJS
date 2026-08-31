import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args)
	{
		FastReader fr =new FastReader();

		PrintWriter op =new PrintWriter(System.out);

		int n =fr.nextInt() ,x =fr.nextInt() ,y =fr.nextInt() ,c =0 ;

		String s =fr.next() ;

		for (int i =n-1 ; i>(n-1-x) ; i--) {
			if ((i == (n-1-y)) && (s.charAt(i) == '0')) c++ ;
			if (i != (n-1-y)) {
				if (s.charAt(i) != '0')	c++ ;
			}
		}
		op.println(c);
		op.flush();	op.close();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br =new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st==null || (!st.hasMoreElements())) 
			{
				try
				{
					st =new StringTokenizer(br.readLine());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}