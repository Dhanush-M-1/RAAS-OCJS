import java.util.*;
import java.io.*;
import java.math.*;
import java.math.BigInteger;
public class Tester {
    private static boolean[] visited;
 public static void main(String args[])
	{
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		int n=in.nextInt(),m=in.nextInt(),i,j,k,l;
		int arr[]=new int[m];
		Arrays.fill(arr,0);
		for(i=0;i<n;i++)
		{
			j=in.nextInt();
			for(k=0;k<j;k++)
			{
				l=in.nextInt();
				arr[l-1]=1;
			}
		}
		for(i=0;i<m;i++)
		{
			if(arr[i]==0)
			{
				break;
			}
		}
		if(i==m)
			out.println("YES");
		else
			out.println("NO");
		out.close();
	}
	static void possibleSubsets(int A[],int N)
	{
		int  count=0,l,m,k,sum=0;
		double cube,d=0,num=0;
		int D[]=new int[N];
	    for(int i = 0;i < (1 << N); ++i)
	    {
	        for(int j = 0;j < N;++j)
	        {
	            if((i & (1 << j))!=0)
	            {
	            	//System.out.print("j is "+j);
	                D[count]=A[j];
	                count++;
	            }
	        }
	        if(count==3)
            {
            	d++;
            	for(k=0;k<3;k++)
            	{
            		sum+=D[k];
            	}
            	cube=Math.cbrt(sum);
            	if(cube==Math.ceil(cube))
            	{
            		num++;
            	}
            }
	        count=0;sum=0;
	    }
	    num=num/d;
	    String s = String.format("%.9f", num);
	    System.out.println(s);
	    //max=Integer.MIN_VALUE;
	}
	/*static long gcd(long arr,long arr2)
	{
		long r;
		while(arr2!=0)
		{
			r=arr%arr2;
			arr=arr2;
			arr2=r;
		}
		return arr;
	}*/
static class Graph {
    	
    	private static Deque<Integer> stack = new ArrayDeque<Integer>();
 		private int least,count,v;
 		
		Set<Integer>[] cities;
    	private int[] risk;
    	
    	Graph(int n,String[] risk){
    		
    		cities = new HashSet[n];
    		this.risk = new int[n];
    		for(int i =0;i<n;i++){
    			cities[i] = new HashSet<>();
    		}
    		for(int i =0;i<n;i++){
    			this.risk[i] = Integer.parseInt(risk[i]);
    		}
    		visited = new boolean[n];
    	}
    	
    	
    	public void add(int x,int y){
    		cities[x].add(y);
    		cities[y].add(x);
    	}
    	
    	/*public int DFS(int root) {
    		Iterator<Integer> itr;
    		count=0;least=Integer.MAX_VALUE;
    		Stack s=new Stack<Integer>();
    		//visited[root]=true;
    		s.push(root);
    		while(!s.isEmpty())
    		{
    			int v=(int) s.pop();
    			if(!visited[v])
    			{
    				visited[v]=true;
    				itr=cities[v].iterator();
    				if(risk[v]<least)
    				{
    					least=risk[v];
    					count=1;
    				}
    				else if(risk[v]==least)
    				{
    					count++;
    				}
    				while(itr.hasNext())
    				{
    					int next=itr.next();
    					if(!visited[next])
    					{
    						s.push((int)next);
    					}
    				}
    			}
    		}
    		return count;
    	}*/
}
	//Read more at http://www.java2blog.com/2015/12/depth-first-search-in-java.html#QtIzfIwfOTa5QJAs.99
	/*static void weighted_union(int arr[],int size[],int a,int b)
	{
		int root_a=root(arr,a);
		int root_b=root(arr,b);
		if(root_a!=root_b)
		{
			if(size[root_a]<size[root_b])
			{
				arr[root_a]=arr[root_b];
				size[root_b]+=size[root_a];
				if(size[root_b]>max)
					max=size[root_b];
				if(size[root_b]<min)
					min=size[root_b];
			}
			else
			{
				arr[root_b]=arr[root_a];
				size[root_a]+=size[root_b];
				if(size[root_a]>max)
					max=size[root_a];
				if(size[root_a]<min)
					min=size[root_a];
			}
		}
	}*/
/*	public static void dfsUsingStack(int adjacency_matrix[][], Node node)
{ 
	Stack<Node> stack=new Stack<Node>(); 
	stack.add(node); node.visited=true; 
	while (!stack.isEmpty()) 
	{
		Node element=stack.pop();
		System.out.print(element.data + "\t"); 
		ArrayList<Node> neighbours=findNeighbour(adjacency_matrix,element); 
		for (int i = 0; i < neighbours.size(); i++) 
		{ 
			Node n=neighbours.get(i);
			if(n!=null && !n.visited) 
			{ 
				stack.add(n); 
				n.visited=true; 
			} 
		}
	}
}
*/
	static int root(int arr[],int i)
	{
		while(arr[i]!=i)
		{
			i=arr[i];
		}
		return i;
	}
	static boolean find(int arr[],int a,int b)
	{
		if(root(arr,a)==root(arr,b))
		{
			return true;
		}
		else
			return false;
	}
	static int max_sub_array(int arr[],int n)
	{
		int i;
		int sum=0,max_end_here=0,max_so_far=0;
		for(i=0;i<n;i++)
		{
			max_end_here=max_end_here+arr[i];
			if(max_end_here<0)
				max_end_here=0;
			else if(max_so_far<max_end_here)
				max_so_far=max_end_here;
		}
		return max_so_far;
	}
	static class Pair implements Comparable<Pair>
	{
		private long first;
		private long index;
		//private long second;;

		public Pair(long i, long j) 
		{ 
			this.first = i;
			this.index = j;
		}
		public long getFirst() { return first; }
		//public long getSecond() { return second; }
		public long getIndex() { return index ;}
		public void setFirst(long k) { this.first=k ; }
		public void setIndex(long k) { this.index=k ;}
		//public void setSecond(long k) { this.second=k ;}
		@Override
		public int compareTo(Pair o) 
		{
			return Long.compare(this.first, o.first);
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
