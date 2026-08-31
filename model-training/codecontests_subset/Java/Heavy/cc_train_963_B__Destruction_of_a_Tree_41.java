import java.io.*;
import java.util.*;
 
 
public class Myclass {
     static ArrayList a[]=new ArrayList[3000001];
     static boolean visited[]=new boolean [3000001];
     static boolean chk[]=new boolean [3000001];
     static int size[]=new int[300001];
     static int parent[]=new int[300001];
     static Stack<Integer>st=new Stack<>();
     static Vector<Integer>cola=new Vector<>();
     static void dfs(int n) {
		 st.add(n);
    	 visited[n]=true;
    	 for(int i=0;i<a[n].size();i++) {
    		 int id=(int) a[n].get(i);
    		 if(!visited[id]) {
    			 parent[id]=n;
    			 dfs(id);
    			 st.add(n);
    		 }
    	 }
    	 if(size[n]%2==0) {
    		 size[parent[n]]--;
    		 while(!st.isEmpty()) {
        		 int ele=st.pop();
        		 if(ele==parent[n])
        		 {
        			 st.add(parent[n]);
        			 break;
        		 }
    			 if(!chk [ele])
    			 {
    				 cola.add(ele);
    				 chk[ele]=true;
    			 }
    		 }
    	 }
     }
     public static void main(String[]args)
    {
        InputReader in=new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n=in.nextInt();
        int root=-1;
        for(int i=0;i<=n;i++)
        	a[i]=new ArrayList<Integer>();
        for(int i=1;i<=n;i++) {
        	int p=in.nextInt();
        	if(p!=0) {
        		a[p].add(i);
        		a[i].add(p);
        	}
        	else
        		root=i;
        }
        for(int i=1;i<=n;i++)
        	size[i]=a[i].size();
        dfs(root);
        if(cola.size()!=n) {
        	pw.println("NO");
        }
        else
        {
        	pw.println("YES");
        	for(int i=0;i<n;i++)
        		pw.println(cola.get(i));
        }
        pw.flush();
        pw.close();
 
    }
    private static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
   static class InputReader 
        {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) 
        { 
            this.stream = stream;
        }
        public int snext() 
        {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) 
            {
                curChar = 0;
                try 
                {
                    snumChars = stream.read(buf);
                } 
                
                catch (IOException e) 
                {
                    throw new InputMismatchException();
                }
                
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int nextInt() 
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public long nextLong()
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) 
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
            {
                a[i] = nextInt();
            }
            return a;
        }
        static class tri implements Comparable<tri> {
            int p, c, l;
 
            tri(int p, int c, int l) {
                this.p = p;
                this.c = c;
                this.l = l;
            }
 
            public int compareTo(tri o) {
                return Integer.compare(l, o.l);
            }
        }
 
        public String readString()
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() 
        {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) 
        {
            return c == '\n' || c == '\r' || c == -1;
        }
 
        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
   public static long modularExponentiation(long x,long n,long M)
   {
       long result=1;
       while(n>0)
       {
           if(n % 2 ==1)
               result=(result%M * x%M)%M;
           x=(x%M * x%M)%M;
           n=n/2;
       }
       return result;
   }
   
   public static long modInverse(int A,int M)
   {
       return modularExponentiation(A,M-2,M);
   }
   
   public static long modInverse(long A,long M)
   {
       return modularExponentiation(A,M-2,M);
   }
    static class pair implements Comparable<pair>{
        Integer x;
        Integer y;

        pair(int x,int w){
            this.x=x;
            this.y=w;
        }
        
        public int compareTo(pair o) {
                int result = x.compareTo(o.x);
                if(result==0)
                    result = y.compareTo(o.y);
                
            return result;
            }  
         public String toString(){
            return (x+" "+y);
        }
  }
    public static long GCD(long a,long b)
    {
        if(b==0)
            return a;
        else
            return GCD(b,a%b);
    }
  static class query{
      Double x;
      Integer y;
      query(double x,int y){
          this.x=x;
          this.y=y;
      }
      
	public String toString() {
    	  return ((x+" "+y));
      }
  }
    
}
 