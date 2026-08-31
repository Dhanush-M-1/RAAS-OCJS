import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class zizo {
	public static void main(String[]args) throws IOException {
		Scanner zizo=new Scanner(System.in);
		PrintWriter wr=new PrintWriter(System.out);
				
		int n=zizo.nextInt();
		String s=zizo.nextLine();
		TreeMap<String,Integer>map=new TreeMap<>();
		int max=0;
		String r="";
		for(int i=0;i<n-1;i++) {
			String x=s.charAt(i)+""+s.charAt(i+1);
			if(!map.containsKey(x)) {
			
				map.put(x,1);
				if(map.get(x)>max) {
					max=map.get(x);r=x;
				}
			}
			else {
				map.put(x,map.get(x)+1);
				if(map.get(x)>max) {
					max=map.get(x);r=x;
				}
			}
		}
		wr.println(r);
		wr.close();
	}
}
class Edge implements Comparable<Edge>{
	int i,l,r;
	Edge(int a,int b,int c){i=a;l=b;r=c;}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(l!=o.l)return l-o.l;
		else return r-o.r;
	}
}
class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine(), ",| ");
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}

	public double nextDouble() throws IOException 
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if(x.charAt(0) == '-')
		{
			neg = true;
			start++;
		}
		for(int i = start; i < x.length(); i++)
			if(x.charAt(i) == '.')
			{
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			}
			else
			{
				sb.append(x.charAt(i));
				if(dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg?-1:1);
	}


}