import java.io.*;
import java.util.*;
public final class kings_path
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static int maxn=(int)(2e5)+3;
	static ArrayList<Node>[] al;
	static ArrayList<Integer>[] al2;
	static List<Node> list;
	
	static int search(int x,int y)
	{
		return Collections.binarySearch(list,new Node(x,y));
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception
	{
		int x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt(),n=sc.nextInt();int[] a=new int[n];Triplet[] b=new Triplet[n];al=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			b[i]=new Triplet(sc.nextInt(),sc.nextInt(),sc.nextInt());a[i]=b[i].x;al[i]=new ArrayList<Node>();
		}
		Arrays.sort(a);boolean[] v=new boolean[maxn];List<Integer> now=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			int pos=Arrays.binarySearch(a,b[i].x);al[pos].add(new Node(b[i].y,b[i].z));
			if(!v[pos])
			{
				v[pos]=true;now.add(pos);
			}
		}
		list=new ArrayList<Node>();
		for(int i=0;i<now.size();i++)
		{
			int curr=now.get(i);Collections.sort(al[curr]);int last=0,map=a[curr];
			for(int j=0;j<al[curr].size();j++)
			{
				int s=Math.max(al[curr].get(j).x,last+1);
				for(int k=s;k<=al[curr].get(j).y;k++)
				{
					list.add(new Node(map,k));
				}
				last=Math.max(last,al[curr].get(j).y);
			}
		}
		/*
		for(Node x:list)
		{
			out.println(x.x+" "+x.y);
		}
		*/
		al2=new ArrayList[list.size()+1];Collections.sort(list);
		for(int i=0;i<list.size();i++)
		{
			al2[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<list.size();i++)
		{
			int[] d=new int[8];int x=list.get(i).x,y=list.get(i).y;d[0]=search(x,y+1);d[1]=search(x,y-1);d[2]=search(x+1,y);d[3]=search(x-1,y);d[4]=search(x-1,y-1);d[5]=search(x+1,y+1);d[6]=search(x-1,y+1);d[7]=search(x+1,y-1);
			for(int j=0;j<8;j++)
			{
				if(d[j]>=0)
				{
					al2[i].add(d[j]);
				}
			}
		}
		ArrayDeque<Node> pq=new ArrayDeque<Node>();int curr_pos=search(x1,y1);pq.add(new Node(curr_pos,0));a=new int[list.size()];Arrays.fill(a,Integer.MAX_VALUE);a[curr_pos]=0;
		while(pq.size()>0)
		{
			Node curr=pq.removeFirst();
			for(int x:al2[curr.x])
			{
				if(a[x]>a[curr.x]+1)
				{
					a[x]=a[curr.x]+1;pq.add(new Node(x,a[x]));
				}
			}
		}
		int f_pos=search(x2,y2);out.println(a[f_pos]<Integer.MAX_VALUE?a[f_pos]:-1);out.close();
	}
}
class Node implements Comparable<Node>
{
	int x,y;
	public Node(int x,int y)
	{
		this.x=x;this.y=y;
	}
	public int compareTo(Node x1)
	{
		if(this.x==x1.x)
		{
			return Integer.compare(this.y,x1.y);
		}
		return Integer.compare(this.x,x1.x);
	}
}
class Triplet
{
	int x,y,z;
	public Triplet(int x,int y,int z)
	{
		this.x=x;this.y=y;this.z=z;
	}
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}