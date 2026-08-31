import java.io.*;
import java.util.*;
import java.math.*;
 
public class Education_89_2
{
	InputReader in;PrintWriter pw;

	boolean decide(int c,int k)
	{
		if(c==k) return true;
		return false;
	}
	void solve(int test) throws Exception
	{
		int n=ni(),k=ni(),n1=0,n2=0,n3=0;
		int both[] = new int[n];
		int alice[] = new int[n];
		int bob[] = new int[n];

		 for(int i=0;i<n;i++)
		 {
		 	int time=ni(),a=ni(),b=ni();
		 	if(a==1 && b==1)
		 	{
		 		both[n1++] = time;
		 	}
		 	else if(a==1)
		 	{
		 		alice[n2++] = time;
		 	}	
		 	else if(b==1)
		 	{
		 		bob[n3++] = time;
		 	}
		 }

		 Arrays.sort(both,0,n1);
		 Arrays.sort(alice,0,n2);
		 Arrays.sort(bob,0,n3);

		 if(Math.min(n2,n3)+n1<k)
		 {
		 	pn("-1");
		 }
		 else
		 {
		 	int l=0,r=0,count=0,ans=0;
		 	while(l<n1 && r< Math.min(n2,n3))
		 	{
		 		if(both[l]<alice[r]+bob[r])
		 		{
		 			ans += both[l];
		 			l++;count++;
		 		}
		 		else
		 		{
		 			ans += alice[r]+bob[r];
		 			r++;count++;
		 		}
		 		if(decide(count,k)){pn(ans);return;}
		 	}
		 	while(l<n1)
		 	{
		 		ans += both[l];
		 		l++;count++;
		 		if(decide(count,k)){pn(ans);return;}
		 	}
		 	while(r< Math.min(n2,n3))
		 	{
		 		ans += alice[r]+bob[r];
		 		r++;count++;
		 		if(decide(count,k)){pn(ans);return;}
		 	}
		 }
	}
	void run() throws Exception 
	{
		in = new InputReader();
		pw = new PrintWriter(System.out);
		int test = 1;
		while(test--!=0){solve(test);}
		pw.close();
	}
	public static void main(String[] args) throws Exception
	{
		new Education_89_2().run();
	}
	void p(Object o){pw.print(o);}
	void pn(Object o){pw.println(o);}
	void pn(){pw.println();}
	void spn(Object o){System.out.println(o);};
	String nln() throws Exception {return in.nextLine();}
	int ni() throws Exception {return Integer.parseInt(in.next());}
	double nd() throws Exception {return Double.parseDouble(in.next());}
	long nl() throws Exception {return Long.parseLong(in.next());}
	class InputReader
	{
		BufferedReader br;
		StringTokenizer st;
 
		public InputReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public InputReader(String s) throws IOException
		{
			br = new BufferedReader(new FileReader(s));
		}
 
		String next() throws Exception
		{
			if(st==null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e)
				{
					throw new Exception(e.toString());
				}
			}
			return st.nextToken();
		}
 
		String nextLine() throws Exception
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch(IOException e)
			{
				throw new Exception(e.toString());
			}
			return str;
		}
	}
}
