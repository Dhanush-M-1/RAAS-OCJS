import java.io.*;
import java.util.*;
public class d2prac implements Runnable 
{
	private boolean console=false;

	boolean ans=true;
	ArrayList<Integer> adj[];
	public void solve()
	{
		int i; int n=in.ni(); adj=new ArrayList [n];
		for(i=0;i<n;i++)
			adj[i]=new ArrayList();
		for(i=0;i<n-1;i++)
		{
			int u=in.ni()-1; int v=in.ni()-1;
			adj[u].add(v); adj[v].add(u);
		}
		if(n==3)
		{
			out.println("NO");
			return;
		}
		dfs(0,-1);
		if(ans)
			out.println("YES");
		else
			out.println("NO");
	}	
	public void dfs(int v,int p)
	{
		boolean not=false;
		if(adj[v].size()>1)
			not=true;
		int count=0;
		for(int node:adj[v])
		{
			if(adj[node].size()==1)
				count++;
			if(node==p)
				continue;
			else
				dfs(node,v);
		}
		if(not&&count<2)
		{
			int c=0;
			for(int node:adj[v])
			{
				if(adj[node].size()==1)
					continue;
				c++;
			}
			if(count==0&&c<3||count==1&&c<2)
				ans=false;
		}
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;
		
		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new d2prac().run();	 }

	private void init() throws FileNotFoundException {
		InputStream inputStream = System.in; 	 OutputStream outputStream = System.out;
		try {  if (!console && System.getProperty("user.name").equals("sachan")) {
			outputStream = new FileOutputStream("/home/sachan/Desktop/output.txt");
			inputStream = new FileInputStream("/home/sachan/Desktop/input.txt");   	}
		}	catch (Exception ignored) {	}
		out = new PrintWriter(outputStream); 	 in = new FastInput(inputStream);
	}
	static class FastInput { InputStream obj;
	public FastInput(InputStream obj) {	this.obj = obj;	}
	byte inbuffer[] = new byte[1024];  int lenbuffer = 0, ptrbuffer = 0;
	int readByte() { if (lenbuffer == -1) throw new InputMismatchException();
	if (ptrbuffer >= lenbuffer) { ptrbuffer = 0;
	try { lenbuffer = obj.read(inbuffer);  }
	catch (IOException e) { throw new InputMismatchException(); } }    
	if (lenbuffer <= 0) return -1;return inbuffer[ptrbuffer++]; }

	String ns() { int b = skip();StringBuilder sb = new StringBuilder();
	while (!(isSpaceChar(b)))	  { sb.appendCodePoint(b);b = readByte(); }return sb.toString();}

	int ni() { int num = 0, b;boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
	if (b == '-') { minus = true;b = readByte(); }
	while (true) { if (b >= '0' && b <= '9') { num = num * 10 + (b - '0'); } else {
		return minus ? -num : num; }b = readByte(); }}

	long nl() { long num = 0;int b;boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
	if (b == '-') { minus = true;b = readByte(); }
	while (true) { if (b >= '0' && b <= '9') { num = num * 10L + (b - '0'); } else {
		return minus ? -num : num; }b = readByte(); } }

	boolean isSpaceChar(int c) { return (!(c >= 33 && c <= 126)); }
	int skip() { int b;while ((b = readByte()) != -1 && isSpaceChar(b)) ;return b; }
	float nf() {return Float.parseFloat(ns());}
	double nd() {return Double.parseDouble(ns());}
	char nc() {return (char) skip();}
	}
}
