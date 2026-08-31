import java.util.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  test{
	
	// ArrayList<Integer> lis = new ArrayList<Integer>();
	// ArrayList<String> lis = new ArrayList<String>();
	// PriorityQueue<Integer> que = new PriorityQueue<Integer>();
	//  Stack<Integer> que = new Stack<Integer>();
    //	static long sum=0;
	// int a,b,c;
	// 1000000007 (10^9+7)
	//static int mod = 1000000007;
	static int mod = 1000000009;
   // static int dx[]={1,-1,0,0};
//	static int dy[]={0,0,1,-1};
	static int dx[]={1,-1,0,0,1,1,-1,-1};
    static int dy[]={0,0,1,-1,1,-1,1,-1};
	//static long H,L;
	
public  static void main(String[] args)   throws Exception, IOException{
   //String line=""; throws Exception, IOException
   //(line=br.readLine())!=null
	//Scanner sc =new Scanner(System.in);
	// !!caution!! int long //  
	Reader sc = new Reader(System.in);
  // while( ){
	  // int  n=sc.nextInt(),m=sc.nextInt();//a[]=new int[n],b[]=new int[n];
	int  x=sc.nextInt(),y=sc.nextInt(),xx=sc.nextInt(),yy=sc.nextInt(),n=sc.nextInt();
	
	HashMap<Integer,ArrayList<P>> map = new HashMap<Integer,ArrayList<P>>();
	HashMap<Integer,ArrayList<Integer>> vis = new HashMap<Integer,ArrayList<Integer>>();
	
	
	
	for(int i=0;i<n;i++){
	 int r=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
	 if( map.containsKey(r) )map.get(r).add(new P(a,b));
	 else { ArrayList<P> lis = new ArrayList<P>(); map.put(r, lis ); lis.add(new P(a,b)); }
	}
	int ma=1000000001;
	 LinkedList<PP> que = new LinkedList<PP>();  
	 que.add(new PP(x,y,0));
	 vis.put(x,  new ArrayList<Integer>());
	 vis.get(x).add(y);
	 while(!que.isEmpty()){
		 PP p=que.poll();
		// db(p.a,p.b,p.d);
		 for(int i=0;i<8;i++){
			  int xa=p.a+dx[i],ya=p.b+dy[i]; 
			  boolean b=false;
		     if( xa==xx&&ya==yy ) { System.out.println(p.d+1);return; }
		     if(p.d==100000)continue;
		     
			 if( xx<0 || xx==ma || yy<0 || yy==ma )continue;
			 if( vis.containsKey(xa) ){
				 if(vis.get(xa).contains(ya))continue;;
			 }

			 if( map.containsKey(xa) ){
				 ArrayList<P> lis =map.get(xa);
				 for(int t=0;t<lis.size();t++){ if( lis.get(t).a<=ya && ya<=lis.get(t).b ){b=true;break;}  }
				
			 }
			 else continue;
			 if(b){que.add(new PP(xa,ya,p.d+1)); if( vis.containsKey(xa) )vis.get(xa).add(ya);else{
				 vis.put(xa,  new ArrayList<Integer>());
				 vis.get(xa).add(ya);
				 
			 }  }
		  }
		 
	 }
	System.out.println(-1);
	
/*	for(int i=0;i<50 ;i++){
		if(map.containsKey(i)){
			 ArrayList<P> lis =map.get(i);
			 for(int t=0;t<lis.size() ;t++){ db(i,lis.get(t).a,lis.get(t).b ); }		
		}
		
	}*/
	
    System.out.println();
    
    
}

static void db(Object... os){
    System.err.println(Arrays.deepToString(os));

}
}

class Reader
{
	private BufferedReader x;
	private StringTokenizer st;
	
	public Reader(InputStream in)
	{
		x = new BufferedReader(new InputStreamReader(in));
		st = null;
	}
	public String nextString() throws IOException
	{
		while( st==null || !st.hasMoreTokens() )
			st = new StringTokenizer(x.readLine());
		return st.nextToken();
	}
	public int nextInt() throws IOException
	{
		return Integer.parseInt(nextString());
	}
	public long nextLong() throws IOException
	{
		return Long.parseLong(nextString());
	}
	public double nextDouble() throws IOException
	{
		return Double.parseDouble(nextString());
	}
}


class P {
//	implements Comparable<P>
	int a,b;
	P(int a,int b){
		this.a=a;
		this.b=b;
	} 
}
class PP {
//	implements Comparable<P>
	int a,b,d;
	PP(int a,int b,int d){
		this.a=a;
		this.b=b;
		this.d=d;
	} 
}