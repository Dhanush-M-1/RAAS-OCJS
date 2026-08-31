/*
TO LEARN
1-segment trees
2-euler tour
3-fenwick tree and interval tree
*/
/*
TO SOLVE 
uva 1103
*/
/*
bit manipulation shit
1-Computer Systems: A Programmer's Perspective
2-hacker's delight
3-(02-03-bits-ints)
4-machine-basics
5-Bits Manipulation tutorialspoint
*/
            import java.util.*;
		    import java.math.*;
		    import java.io.*; 
		    import java.util.stream.Collectors;
 
		     public class A{
		     
		  static InputStream inputStream = System.in;
            static FastReader scan=new FastReader(inputStream);
		     public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
static class comp1 implements Comparator<Pair> {
   
    public int compare(Pair o1, Pair o2)
    {
        return (int)(o1.y-o2.y);
    }
}
	public static void main(String[] args)  throws Exception 
      {
	
		  // scan=new FastReader("two2.in");
		 //  out = new PrintWriter("peacefulsets.out");
		 
		 /*
		 currently doing 
		 1-digit dp
		 2-ds like fenwick and interval tree and sparse table 
		 */
		 /*
		 READING 
		 1-Everything About Dynamic Programming codeforces
		 2-DYNAMIC PROGRAMMING: FROM NOVICE TO ADVANCED topcoder
		 */


		    int tt=1;

//tt=scan.nextInt();


	 outer:while(tt-->0)
		    {
		    	 		  int n=scan.nextInt();
		    	 		  int arr[]=new int[n];
		    	 		   PriorityQueue<Pair>pq=new PriorityQueue<Pair>();
		    	 		  for(int i=0;i<n;i++){
		    	 		  	arr[i]=scan.nextInt();
		    	 		  	pq.add(new Pair(arr[i],i));
		    	 		  }
		    	 		  //out.println(pq);
		    	 		  //pq.poll();
		    	 		  //System.out.println(pq.poll());
		    	 		  //out.println(pq);
		    	 		  int m=scan.nextInt();
		    	 		  for(int i=0;i<m;i++)
		    	 		  {
		    	 		  	int k=scan.nextInt(),pos=scan.nextInt();
		    	 		  	PriorityQueue<Pair>tmp=new PriorityQueue<Pair>(pq);
		    	 		  	ArrayList<Pair>list=new ArrayList<Pair>();
		    	 		  	int idx=Integer.MAX_VALUE;
		    	 		  	int val=-1;
		    	 		  	while(k>0)
		    	 		  	{
		    	 		  		k--;
		    	 		  		Pair p=tmp.poll();
		    	 		  		list.add(new Pair(p.x,p.y));
		    	 		  	}
		    	 		  //	out.println(list);
		    	 		  	Collections.sort(list,new comp1());
		    	 		  	out.println(list.get(pos-1).x);
		    	 		  }
           }
		  	    out.close();
		    	 		  
		   
		}
		static class special{
			char x,y;
			//int id;
			special(char x,char y)
			{
				this.x=x;
				this.y=y;
				//this.id=id;
			}
			@Override
			    public int hashCode() {
		                return (int)(x + 31 * y);
		            }
		              @Override
		            public boolean equals(Object o){
		                if (o == this) return true;
		                if (o.getClass() != getClass()) return false;
		                special t = (special)o;
		                return t.x == x && t.y == y;
		            }
		}

		   
		     static long binexp(long a,long n)
		    {
		        if(n==0)
		            return 1;
		        long res=binexp(a,n/2);
		        if(n%2==1)
		            return res*res*a;
		        else 
		            return res*res;
		    }
		     
		    static long powMod(long base, long exp, long mod) {
		           if (base == 0 || base == 1) return base;
		           if (exp == 0) return 1;
		           if (exp == 1) return (base % mod+mod)%mod;
		           long R = (powMod(base, exp/2, mod) % mod+mod)%mod;
		           R *= R;
		           R %= mod;
		           if ((exp & 1) == 1) {
		               return (base * R % mod+mod)%mod;
		           }
		           else return (R %mod+mod)%mod;
		       }
		    static double dis(double x1,double y1,double x2,double y2)
		    {
		        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		    }
		    static long mod(long x,long y)
		        {
		            if(x<0)
		                x=x+(-x/y+1)*y;
		            return x%y;
		        }
		     public static  long pow(long b, long e) {
		                long r = 1;
		                while (e > 0) {
		                    if (e % 2 == 1) r = r * b ;
		                    b = b * b;
		                    e >>= 1;
		                }
		                return r;
		            }
		    private static void sort(long[] arr) {
		            List<Long> list = new ArrayList<>();
		            for (long object : arr) list.add(object);
		            Collections.sort(list);
		        //Collections.reverse(list);
		            for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
		        }
		    private static void sort2(long[] arr) {
		            List<Long> list = new ArrayList<>();
		            for (Long object : arr) list.add(object);
		            Collections.sort(list);
		        Collections.reverse(list);
		            for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
		        }
		      public static class FastReader {
                    BufferedReader br;
                    StringTokenizer root;
                    
             
                    public FastReader(InputStream stream) {
                      br = new BufferedReader(new InputStreamReader(stream), 32768);
            root = null;
                    }
                    FastReader(String filename)throws Exception
                    {
             
                        br=new BufferedReader(new FileReader(filename));
                    }
             
                    boolean hasNext(){
                        String line;
                        while(root.hasMoreTokens())
                            return true;
                        return false;
                    }
             
                    String next() {
                        while (root == null || !root.hasMoreTokens()) {
                            try {
                                root = new StringTokenizer(br.readLine());
                            } catch (Exception addd) {
                                addd.printStackTrace();
                            }
                        }
                        return root.nextToken();
                    }
             
                    int nextInt() {
                        return Integer.parseInt(next());
                    }
             
                    double nextDouble() {
                        return Double.parseDouble(next());
                    }
             
                    long nextLong() {
                        return Long.parseLong(next());
                    }
             
                    String nextLine() {
                        String str = "";
                        try {
                            str = br.readLine();
                        } catch (Exception addd) {
                            addd.printStackTrace();
                        }
                        return str;
                    }
                     public int[] nextIntArray(int arraySize) {
                        int array[] = new int[arraySize];
             
                        for (int i = 0; i < arraySize; i++) {
                            array[i] = nextInt();
                        }
             
                        return array;
                    }
            }
		     static class Pair implements Comparable<Pair>{
		            public long x, y,z;
		            public Pair(long x1, long y1,long z1) {
		                x=x1;
		                y=y1;
		                z=z1;
		            }
		             public Pair(long x1, long y1) {
		                x=x1;
		                y=y1;
		    
		            }
		            
		            @Override
		            public int hashCode() {
		                return (int)(x + 31 * y);
		            }
		            public String toString() {
		                return x + " " + y+" "+z;
		            }
		            @Override
		            public boolean equals(Object o){
		                if (o == this) return true;
		                if (o.getClass() != getClass()) return false;
		                Pair t = (Pair)o;
		                return t.x == x && t.y == y&&t.z==z;
		            }
		    public int compareTo(Pair o)
		    {
		    	if(x==o.x)
		    	{
		    		return (int)(y-o.y);
		    	}
		    	return (int)(o.x-x);
		     
		        }
		     
		    }
		     static class tuple{
		            int x,y,z;
		            tuple(int a,int b,int c){
		                x=a;
		                y=b;
		                z=c;
		            }
		        }
		        static class Edge{
		            int d,w;
		            Edge(int d,int w)
		            {
		                this.d=d;
		                this.w=w;
		            }
		        }
		    }

		     
