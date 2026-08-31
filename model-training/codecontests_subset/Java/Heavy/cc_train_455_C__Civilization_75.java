		                                import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


		    
		    
		    
		                                                public class Solution1 implements Runnable
		                                                {
		                                                    static final long MAX = 464897L;
		                                                    static class InputReader
		                                                    {
		                                                        private InputStream stream;
		                                                        private byte[] buf = new byte[1024];
		                                                        private int curChar;
		                                                        private int numChars;
		                                                        private SpaceCharFilter filter;
		                                                        private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		                                                 
		                                                        public InputReader(InputStream stream)
		                                                        {
		                                                            this.stream = stream;
		                                                        }
		                                                        
		                                                        public int read()
		                                                        {
		                                                            if (numChars==-1) 
		                                                                throw new InputMismatchException();
		                                                            
		                                                            if (curChar >= numChars)
		                                                            {
		                                                                curChar = 0;
		                                                                try 
		                                                                {
		                                                                    numChars = stream.read(buf);
		                                                                }
		                                                                catch (IOException e)
		                                                                {
		                                                                    throw new InputMismatchException();
		                                                                }
		                                                                
		                                                                if(numChars <= 0)                
		                                                                    return -1;
		                                                            }
		                                                            return buf[curChar++];
		                                                        }
		                                                     
		                                                        public String nextLine()
		                                                        {
		                                                            String str = "";
		                                                            try
		                                                            {
		                                                                str = br.readLine();
		                                                            }
		                                                            catch (IOException e)
		                                                            {
		                                                                e.printStackTrace();
		                                                            }
		                                                            return str;
		                                                        }
		                                                        public int nextInt()
		                                                        {
		                                                            int c = read();
		                                                            
		                                                            while(isSpaceChar(c)) 
		                                                                c = read();
		                                                            
		                                                            int sgn = 1;
		                                                            
		                                                            if (c == '-') 
		                                                            {
		                                                                sgn = -1;
		                                                                c = read();
		                                                            }
		                                                            
		                                                            int res = 0;
		                                                            do 
		                                                            {
		                                                                if(c<'0'||c>'9') 
		                                                                    throw new InputMismatchException();
		                                                                res *= 10;
		                                                                res += c - '0';
		                                                                c = read();
		                                                            }
		                                                            while (!isSpaceChar(c)); 
		                                                            
		                                                            return res * sgn;
		                                                        }
		                                                        
		                                                        public long nextLong() 
		                                                        {
		                                                            int c = read();
		                                                            while (isSpaceChar(c))
		                                                                c = read();
		                                                            int sgn = 1;
		                                                            if (c == '-') 
		                                                            {
		                                                                sgn = -1;
		                                                                c = read();
		                                                            }
		                                                            long res = 0;
		                                                            
		                                                            do 
		                                                            {
		                                                                if (c < '0' || c > '9')
		                                                                    throw new InputMismatchException();
		                                                                res *= 10;
		                                                                res += c - '0';
		                                                                c = read();
		                                                            }
		                                                            while (!isSpaceChar(c));
		                                                                return res * sgn;
		                                                        }
		                                                        
		                                                        public double nextDouble() 
		                                                        {
		                                                            int c = read();
		                                                            while (isSpaceChar(c))
		                                                                c = read();
		                                                            int sgn = 1;
		                                                            if (c == '-') 
		                                                            {
		                                                                sgn = -1;
		                                                                c = read();
		                                                            }
		                                                            double res = 0;
		                                                            while (!isSpaceChar(c) && c != '.') 
		                                                            {
		                                                                if (c == 'e' || c == 'E')
		                                                                    return res * Math.pow(10, nextInt());
		                                                                if (c < '0' || c > '9')
		                                                                    throw new InputMismatchException();
		                                                                res *= 10;
		                                                                res += c - '0';
		                                                                c = read();
		                                                            }
		                                                            if (c == '.') 
		                                                            {
		                                                                c = read();
		                                                                double m = 1;
		                                                                while (!isSpaceChar(c)) 
		                                                                {
		                                                                    if (c == 'e' || c == 'E')
		                                                                        return res * Math.pow(10, nextInt());
		                                                                    if (c < '0' || c > '9')
		                                                                        throw new InputMismatchException();
		                                                                    m /= 10;
		                                                                    res += (c - '0') * m;
		                                                                    c = read();
		                                                                }
		                                                            }
		                                                            return res * sgn;
		                                                        }
		                                                        
		                                                        public String readString() 
		                                                        {
		                                                            int c = read();
		                                                            while (isSpaceChar(c))
		                                                                c = read();
		                                                            StringBuilder res = new StringBuilder();
		                                                            do 
		                                                            {
		                                                                res.appendCodePoint(c);
		                                                                c = read();
		                                                            } 
		                                                            while (!isSpaceChar(c));
		                                                            
		                                                            return res.toString();
		                                                        }
		                                                     
		                                                        public boolean isSpaceChar(int c) 
		                                                        {
		                                                            if (filter != null)
		                                                                return filter.isSpaceChar(c);
		                                                            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		                                                        }
		                                                     
		                                                        public String next() 
		                                                        {
		                                                            return readString();
		                                                        }
		                                                        
		                                                        public interface SpaceCharFilter 
		                                                        {
		                                                            public boolean isSpaceChar(int ch);
		                                                        }
		                                                    }
		                                                     
		                                                    public static void main(String args[]) throws Exception
		                                                    {
		                                                        new Thread(null, new Solution1(),"Solution",1<<26).start();
		                                                    }   
		                                                    static int gcd(int a, int b) 
		                                                    { 
		                                                      if (b == 0) 
		                                                        return a; 
		                                                      return gcd(b, a % b);  
		                                                    } 
		                                                    
		                                                    long MOD = 1000000007;
		                                                    
		                                                    ArrayList<Integer> adj[];
		                                                    ArrayList<Pair> adj2[];
		                                                    public void run() 
		                                                    {
		                                                        
		                                                            //InputReader sc= new InputReader(new FileInputStream("input.txt"));
		                                                            //PrintWriter w= new PrintWriter(new FileWriter("output.txt"));
		                                                            InputReader sc = new InputReader(System.in);
		                                                            PrintWriter w = new PrintWriter(System.out);
		                                                            int n = sc.nextInt();
		                                                            int m = sc.nextInt();
		                                                            int q = sc.nextInt();
		                                                            arr = new int[n];
		                                                            dia = new int[n];
		                                                            adj = new ArrayList[n];
		                                                            size = new int[n];
		                                                            for(int i = 0;i < n;i++) {
		                                                            	arr[i] = i;
		                                                            	dia[i] = 0;
		                                                            	size[i] = 1;
		                                                            	adj[i] = new ArrayList();
		                                                            }
		                                                            for(int i = 0;i < m;i++) {
		                                                            	int a = sc.nextInt()-1;
		                                                            	int b = sc.nextInt()-1;
		                                                            	adj[a].add(b);
		                                                            	adj[b].add(a);
		                                                            	union(a,b,1);
		                                                            }
		                                                            visit = new boolean[n];
		                                                            for(int i = 0;i < n;i++) {
		                                                            	if(!visit[i]) {
		                                                            		max = 0;
		                                                            		ver = -1;
		                                                            		int ans1 = bfs(i);
		                                                            		max = 0;
		                                                            		if(ver != -1) {
		                                                            			int ans2 = bfs(ver);
		                                                            			dia[root(i)] = ans2;
		                                                            		}
		                                                            		
		                                                            		
		                                                            	}
		                                                            }
		                                                            while(q-- > 0) {
		                                                            	int x = sc.nextInt();
		                                                            	if(x == 2) {
		                                                            		int a = sc.nextInt()-1;
		                                                            		int b = sc.nextInt()-1;
		                                                            		if(find(a,b)) {
		                                                            			continue;
		                                                            		}
		                                                            		union(a,b,2);
		                                                            	}else {
		                                                            		int a = sc.nextInt()-1;
		                                                            		w.println(dia[root(a)]);
		                                                            	}
		                                                            }
		                                                            w.close();
		                                                     }
		                                                    int[] arr;
		                                                    int[] dia;
		                                                    int[] size;
		                                                    boolean[] visit;
		                                                    int root(int a) {
		                                                    	while(arr[a] != a) {
		                                                    		arr[a] = arr[arr[a]];
		                                                    		a = arr[a];
		                                                    	}
		                                                    	return a;
		                                                    }
		                                                    int ver = -1;
		                                                    int max = 0;
		                                                    int bfs(int a) {
		                                                    	visit[a] = true;
		                                                    	HashSet<Integer> visited = new HashSet();
		                                                    	HashMap<Integer,Integer> level = new HashMap();
		                                                    	visited.add(a);
		                                                    	Queue<Integer> q = new LinkedList();
		                                                    	level.put(a,0);
		                                                    	q.add(a);
		                                                    	while(!q.isEmpty()) {
		                                                    		int x = q.poll();
		                                                    		Iterator<Integer> it = adj[x].iterator();
		                                                    		while(it.hasNext()) {
		                                                    			int temp = it.next();
		                                                    			if(!visited.contains(temp)) {
		                                                    				level.put(temp,level.get(x) + 1);
		                                                    				if(max <= level.get(temp)) {
		                                                    					max=  level.get(temp);
		                                                    					ver = temp;
		                                                    					
		                                                    				}
		                                                    				visit[temp] = true;
		                                                    				visited.add(temp);
		                                                    				q.add(temp);
		                                                    			}
		                                                    		}
		                                                    		
		                                                    	}
		                                                    	return max;
		                                                    }
		                                                    void union(int x,int y,int val) {
		                                                    	int roota = root(x);
		                                                    	int rootb=  root(y);
		                                                    	if(size[roota] <= size[rootb]) {
		                                                    		arr[roota] = arr[rootb];
		                                                    		size[rootb] += size[roota];
		                                                    		if(val != 1)
				                                                    	dia[rootb] = Math.max(dia[roota],Math.max(dia[rootb],(dia[roota] + 1)/2 + (dia[rootb] + 1)/2 + 1));
		                                                    	}else {
		                                                    		arr[rootb] = arr[roota];
		                                                    		size[roota] += size[rootb];
		                                                    		if(val != 1)
				                                                    	dia[roota] = Math.max(dia[roota],Math.max(dia[rootb],(dia[roota] + 1)/2 + (dia[rootb] + 1)/2 + 1));
		                                                    	}
		                                                    	
		                                                    	
		                                                    }
		                                                    boolean find(int a,int b) {
		                                                    	if(root(a) == root(b)) {
		                                                    		return true;
		                                                    	}
		                                                    	return false;
		                                                    }
		                                                    class Pair implements Comparable<Pair>{
		                                                        long a;
		                                                        int b;
		                                                        //int c;
		                                                        Pair(long a,int b){
		                                                            this.b = b;
		                                                            this.a = a;
		                                                        }
		                                                        public boolean equals(Object o) {
		                                                            Pair p = (Pair)o;
		                                                            return this.a == p.a && this.b == p.b;
		                                                        }
		                                                        public int hashCode(){
		                                                            return Long.hashCode(a)*27 + Long.hashCode(b)* 31;
		                                                        }
		                                                        public int compareTo(Pair p) {
		                                                            return Long.compare(this.a,p.a);
		                                                        }
		                                                    }
		                                    }