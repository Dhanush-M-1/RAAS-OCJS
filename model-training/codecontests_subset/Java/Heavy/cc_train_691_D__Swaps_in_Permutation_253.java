import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;
public class C{
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter wr=new PrintWriter(System.out);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[]=new int [n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		UnionFind uf=new UnionFind(n);
		while(m-->0)uf.unionSet(sc.nextInt()-1, sc.nextInt()-1);
		ArrayList<Integer>par=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(uf.p[i]==i)par.add(i);
		}
		for(int i=0;i<par.size();i++) {
			ArrayList<Integer> mem=uf.trav[par.get(i)].members();
			
			Collections.sort(mem);
			ArrayList<Integer> des=new ArrayList<>();
			for(int j=0;j<mem.size();j++)des.add(-a[mem.get(j)]);
			
			Collections.sort(des);
			for(int j=0;j<mem.size();j++) {
				a[mem.get(j)]=-des.get(j);
			}
		}
		for(int i=0;i<n;i++) {
			wr.print(a[i]+" ");
		}
		wr.close();
		
		}

}
class Node{
	int val;
	Node nxt;
	Node(int a){
		val=a;
	}
}
class LinkedList{
	Node head;Node last;
	LinkedList(){
		
	}
	public  void add(int x) {
		Node n=new Node(x);
		if(head==null) {
			head=n;
			last=n;
		}
		else {
			last.nxt=n;
			last=n;
		}
	}
	public  void add(LinkedList x) {
		
		last.nxt=x.head;
		last=x.last;
	}
	public ArrayList<Integer> members(){
		ArrayList<Integer> a=new ArrayList<>();
		Node cur=head;
		while(cur!=null) {
			a.add(cur.val);
			cur=cur.nxt;
		}
		return a;
	}
}

class UnionFind {                                              
	int[] p, rank, setSize;
	LinkedList trav[]; 
	int numSets;

	public UnionFind(int N) 
	{
		p = new int[numSets = N];
		rank = new int[N];
		setSize = new int[N];
		trav = new LinkedList[N];
		for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1;trav[i]=new LinkedList(); trav[i].add(i);}
	}

	public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

	public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) 
	{ 
		if (isSameSet(i, j)) 
			return;
		numSets--; 
		int x = findSet(i), y = findSet(j);
		if(rank[x] > rank[y]) {
			p[y] = x; setSize[x] += setSize[y];
			trav[x].add(trav[y]);
			}
		else
		{	p[x] = y; setSize[y] += setSize[x];
			if(rank[x] == rank[y]) rank[y]++; 
			trav[y].add(trav[x]);
		} 
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}
class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

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

	public boolean ready() throws IOException {return br.ready();}


}