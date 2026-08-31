import java.util.*;
import java.io.*;


public class cp{

	public static void main(String[] args) {

		Scanner sc = new Scanner();		
		
		int n = sc.nextInt();
		
		int two = 0;
		int one = 0;

		for(int i=0;i<n;i++)
		{
			if(sc.nextInt()==100)
			{
				one++;
			}else two++;
		}

		int a=0;
		int b = 0;

		if(two%2!=0)
		{
			a+=200;
		}

		if(one>=2)
		{
			one-=2;
			a=0;
		}
		if(one%2==0 && a==0)
		{
			out.println("YES");

		}else out.println("NO");
		

		

		

		out.close();	
	}
	
	static	PrintWriter out=new PrintWriter(System.out);
	static class Scanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String nextLine() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		char nextChar() {
			char c = '$';
				try { 
                                        c = (char)br.read();			               
                                } catch (IOException e) {}
			return c;
		}		
		int nextInt() {
			return Integer.parseInt(nextLine());
		}
		Double nextDouble() {
			return Double.parseDouble(nextLine());
		}
		long nextLong() {
			return Long.parseLong(nextLine());
		}
	}

}