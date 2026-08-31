
import java.io.*;
import java.util.*;

public class A{
	static Scanner sc=new Scanner();
	static int a,b;
	
	static int query(int c,int d) throws IOException
	{
		
		c|=a;
		d|=b;
		System.out.println("? "+c+" "+d);
		return sc.nextInt();
	}
	static void answer() {
		
		System.out.println("! "+a+" "+b);	
	}
	public static void main(String[] args) throws IOException {
		
		
		
		a=0;
		b=0;
		int ans=query(0,0);
		
		
		
		
			
	
		for(int bit=29;bit>=0;bit--)
		{
			int pow=1<<bit;
			if(ans==1)
			{
				int x=query(1<<bit,1<<bit);
				
				if(x==-1)
				{
					
					a|=pow;
					ans=query(0,0);
				}
				else
				{
					
					x=query(pow,0);
					if(x==-1)
					{
						a|=1<<bit;
						b|=1<<bit;
					}
				}
			}
			else if(ans==-1)
			{
				int x=query(1<<bit,1<<bit);
				if(x==1)
				{
					b|=pow;
					ans=query(0,0);
					
				}
				else
				{
					x=query(0,pow);
					if(x==1)
					{
						a|=1<<bit;
						b|=1<<bit;
					}
				}
			}
			else
			{
				int x=query(1<<bit,0);
				if(x==-1) {
					a|=1<<bit;
					b|=1<<bit;
				}
			}
			
		}
	
	
		answer();

		
	}
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		Scanner(String fileName) throws FileNotFoundException{
			br=new BufferedReader(new FileReader(fileName));
		}
		String next() throws IOException {
			while(st==null || !st.hasMoreTokens())
				st=new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		String nextLine() throws IOException {
			return br.readLine();
		}
		int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
		long nextLong()  throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
	}
}
