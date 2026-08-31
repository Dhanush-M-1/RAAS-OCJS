/*
 *
 * @author Mukesh Singh
 *
 */

/* Finding_the_Minimum_Window_in_S_which_Contains_All_Elements_from_T */

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
@SuppressWarnings("unchecked")
public class AB
{	
	int ar[] ;
	//solve test cases
	void solve() throws Exception 
	{
		int n = in.nextInt();
		int m = in.nextInt();
		ar = new int[n+1];
		for( int i = 1 ; i <= n ; i++ )
			ar[i] = in.nextInt();
		int br[] = new int[m+1];
		for(int i = 0 ; i < m ; i++ )
			br[i] = in.nextInt();
		int st[] = new int[n+1];
		int cur = -1 ;
		for(int i = 0 ; i < m ; i++ )
		{
			boolean found = false ;
			for(int j= 0 ;j <= cur ; j ++ )
			{
				if(st[j]==br[i])
				{
					found = true ;
					break ;
				}
			}
			if(!found)
			{
				cur++ ;
				st[cur] = br[i] ;
			}
		}
		long ans = 0 ;
		for( int i = 0 ;i  < m ; i ++ )
		{
			int read = br[i] ;
			int pos = 0; 
			while(read != st[pos])
			{
				ans = ans + ar[st[pos]] ;
				pos++ ;
			}
			//rearrange
			int temp = st[pos] ;
			while(pos > 0 )
			{
				st[pos] = st[pos-1] ;
				pos -- ; 
			}
			st[0] = temp ;
		}
		System.out.println(ans);
	}
	//@ main function
	public static void main(String[] args) throws Exception 
	{
		new AB();
	}
	
	InputReader in;
	PrintStream out ;
	DecimalFormat df ;
	AB() 
	{
		try 
		{
			File defaultInput = new File("file.in");
			if (defaultInput.exists()) 
				in = new InputReader("file.in");
			else 
				in = new InputReader();
			defaultInput = new File("file.out");
			if (defaultInput.exists()) 
				out = new PrintStream(new FileOutputStream("file.out"));
			else
				out = new PrintStream(System.out);
			df = new DecimalFormat("######0.00");
			solve();
			out.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(261);
		}
	}
	
	class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		InputReader(String fileName) throws FileNotFoundException {
			reader = new BufferedReader(new FileReader(new File(fileName)));
		}
		
		String readLine() throws IOException {
			return reader.readLine();
		}
		
		String nextToken() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(readLine());
			return tokenizer.nextToken();
		}
		
		boolean hasMoreTokens() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				String s = readLine();
				if (s == null)
					return false;
				tokenizer = new StringTokenizer(s);
			}
			return true;
		}
		
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(nextToken());
		}
		
		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(nextToken());
		}
		
		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(nextToken());
		}
	}
}
