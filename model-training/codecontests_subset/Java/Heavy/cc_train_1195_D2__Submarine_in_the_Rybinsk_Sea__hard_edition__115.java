import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args)
	{
		FastReader fr =new FastReader();	PrintWriter op =new PrintWriter(System.out);

		int n =fr.nextInt() ,i,i_ ;	
		long arr[] =new long[n] ,len[] =new long[11] ,ans =0l ,j ,k ,l ,sum ,m =998244353l ;

		for (i =0 ; i<n ; ++i) {
			String s =fr.next() ;	len[s.length()]++ ;	arr[i] =Long.parseLong(s) ;
		}
		for (i =0 ; i<n ; ++i) {
			sum =0l ;	j =1l ;

			for (i_ =1 ; i_<11 ; i_++) {
				k =arr[i]%10l ;		sum =( sum + ( k * j )%m )%m ;	

				k =(sum * 10l)%m ;

				k =(sum + k)%m ;	k =(k * len[i_])%m ;

				arr[i] /= 10l ;		j =(j * 100l)%m ;

				l =((arr[i] * j)%m * 2l)%m ;

				l =(l * len[i_])%m ;	k =(k + l)%m ;	ans =(ans + k)%m ;
			}
		}	op.println(ans) ;	op.flush();	op.close();
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

		String nextLine() {
			String str ="";

			try
			{
				str =br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next()) ;
		}
	}
}