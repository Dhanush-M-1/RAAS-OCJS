import java.io.*;
import java.util.*;

public class Test
{
    static PrintWriter pw = new PrintWriter(System.out);

    static TreeMap<Integer , A> m = new TreeMap();
    static TreeMap<Integer , A> v = new TreeMap();
    static TreeMap<Integer , B> dis = new TreeMap();
    
    static class p{
    	int x , y;
    	p(int a , int b){
    		x =a; y = b;
    	}
    }
    
    static class A
    {
    	TreeSet<Integer> st  = new TreeSet();
  
    	void add(int x) {
    		st.add(x);
    	}
    	
    	boolean get(int x) {
    		return st.contains(x);
    	}
    }
    
    static class B
    {
    	TreeMap<Integer , Long> st  = new TreeMap();
    	B(int x , long y)
    	{
    		st.put(x , y);
    	}
    	
    	void add(int x , long y) {
    		st.put(x, y);
    	}
    	

    	long get(int x)
    	{
    		return st.get(x);
    	}
    }
    
    static void bfs(int i , int j)
    {
    	Queue<p> q = new LinkedList();
    	q.add(new p(i,j));
    	v.get(i).add(j);
    	
    	while(!q.isEmpty())
    	{
    		p p = q.poll();
    		
    		
    		int[] x = {0 , 0 , -1 , -1 , -1 , 1 , 1 ,1 };
    		int[] y = {-1 , 1 , -1 , 0 , 1 , -1 , 0 , 1};
    		
    		for(int z = 0 ; z<8 ; z++)
    		{
    			int a = p.x + x[z];
    			int b = p.y + y[z];
    
    			if(a < 1 || a > (int)1e9 || b<1 || b > (int)1e9 || !m.containsKey(a) || !m.get(a).get(b)  || v.get(a).get(b))continue;
    			
    			
    			long f = dis.get(p.x).get(p.y);
    			v.get(a).add(b);
    			if(dis.containsKey(a))dis.get(a).add(b, f  + 1);
    			else {
    				dis.put(a , new B(b, f  + 1));
    			}
    			q.add(new p(a , b));
    		}
    		
    	}
    }
    
    public static void main(String[] args)throws Exception
    {
        Reader.init(System.in);
       
        int x1 = Reader.nextInt();
        int y1 = Reader.nextInt();
        int x2 = Reader.nextInt();
        int y2 = Reader.nextInt();
        

        dis.put(x1 , new B(y1 , 0));
        
        int n = Reader.nextInt();
        for(int i = 0 ; i<n ; i++)
        {
        	int r = Reader.nextInt();
        	if(!v.containsKey(r))v.put(r , new A());
        	if(!m.containsKey(r))m.put(r , new A());
        	
        	int a = Reader.nextInt();
        	int b = Reader.nextInt();
        	
        	for(int j = a ; j<=b ; j++)
        	{
        		m.get(r).add(j);
        		
        	}
        	
        }
        
        bfs(x1 , y1);
        
        if(v.get(x2).get(y2))
        	pw.print(dis.get(x2).get(y2));
        else pw.print(-1);
        
        pw.close();
   
    }


}



class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    public static int pars(String x) {
        int num = 0;
        int i = 0;
        if (x.charAt(0) == '-') {
            i = 1;
        }
        for (; i < x.length(); i++) {
            num = num * 10 + (x.charAt(i) - '0');
        }

        if (x.charAt(0) == '-') {
            return -num;
        }

        return num;
    }

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static void init(FileReader input) {
        reader = new BufferedReader(input);
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return pars(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    

}