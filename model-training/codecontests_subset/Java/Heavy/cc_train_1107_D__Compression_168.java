	                                                    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


	                 
	                 
	                 
	                 
	                 
	                public class Solution2 implements Runnable
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
	                        new Thread(null, new Solution2(),"Solution2",1<<26).start();
	                    }   
	                    static long gcd(long a, long b) 
	                    { 
	                      if (b == 0) 
	                        return a; 
	                      return gcd(b, a % b);  
	                    } 
	                    static long lcm(long a,long b) {
	                        return (a*b)/gcd(a,b);
	                    }
	                    int maxn = 1000005;
	                    long MOD = 998244353;
	                    long prime = 29;
	                    
	                    TreeMap<Long,Long> tmap = new TreeMap();
	                    int[] val;
	                    int[] ans;
	                    int[][] prefix;
	                    public void run() 
	                    {
	                        InputReader sc = new InputReader(System.in);
	                        PrintWriter w = new PrintWriter(System.out);
	                        int n = sc.nextInt();
	                        prefix = new int[n+1][n+1];
	                        TreeMap<Character,String> decode = new TreeMap();
	                        decode.put('0',"0000");
	                        decode.put('1',"0001");
	                        decode.put('2',"0010");	
	                        decode.put('3',"0011");
	                        decode.put('4',"0100");
	                        decode.put('5',"0101");
	                        decode.put('6',"0110");
	                        decode.put('7',"0111");
	                        decode.put('8',"1000");
	                        decode.put('9',"1001");
	                        decode.put('A',"1010");
	                        decode.put('B',"1011");
	                        decode.put('C',"1100");
	                        decode.put('D',"1101");
	                        decode.put('E',"1110");
	                        decode.put('F',"1111");
	                        String[] s = new String[n+1];
	                        for(int i = 1;i <= n;i++) {
	                        	s[i] = sc.next();
	                        	for(int j = 0;j < s[i].length();j++) {
	                        		String temp = decode.get(s[i].charAt(j));
	                        		for(int k = 1;k <= 4;k++) {
	                        			prefix[i][j*4+k] = prefix[i][j*4 + k - 1] + ((temp.charAt(k-1) == '1') ? 1 : 0);
	                        		}
	                        	}
	                        }
	                        ArrayList<Integer> divisors = new ArrayList();
	                        for(int i = 1;i * i <= n;i++) {
	                        	if(n % i == 0) {
	                        		divisors.add(i);
	                        		if(n/i != i) {
	                        			divisors.add(n/i);
	                        		}
	                        	}
	                        }
	                        Collections.sort(divisors);
	                        int ans = 0;
	                        for(int i = 1;i  < divisors.size();i++) {
	                        	if(check(divisors.get(i))) {
	                        		ans = i;
	                        	}
	                        }
	                        w.println(divisors.get(ans));
	                        
	                        w.close();
	                    } 
	                    boolean check(int mid) {
	                    	for(int i = mid;i < prefix.length;i+=mid) {
	                    		for(int j = mid;j < prefix.length;j += mid) {
	                    			int count = 0;
	                    			for(int k = i;k > i - mid;k--) {
	                    				count += prefix[k][j] - prefix[k][j-mid];
	                    			}
	                    			if(count == mid*mid || count == 0) {
	                    				continue;
	                    			}else {
	                    				return false;
	                    			}
	                    		}
	                    	}
	                    	return true;
	                    }
	                    static class SegTreeLazy{
	                		long[] segTree;
	                		long[] lazy;
	                		public SegTreeLazy(int n){
	                			segTree = new long[4*n];
	                			lazy = new long[4*n];
	                		}
	                		void build(int l,int r,int pos,int[] arr) {
	                			if(l == r) {
	                				segTree[pos] = arr[l];
	                				return;
	                			}
	                			int mid = (l + r)/2;
	                			build(l, mid, 2*pos+1, arr);
	                			build(mid+1, r, 2*pos+2, arr);
	                			segTree[pos] = segTree[2*pos+1] + segTree[2*pos+2];
	                		}
	                		void update(int l,int r,int start,int end,int pos,long val) {
	                			
	                			if(lazy[pos] != 0) {
	                				segTree[pos] += (r - l + 1) * lazy[pos];
	                				if(l != r) {
	                					lazy[2*pos+1] += lazy[pos];
	                					lazy[2*pos+2] += lazy[pos];
	                				}
	                				lazy[pos] = 0;
	                			}
	                			if(l > r || l > end || r < start) {
	                				return;
	                			}
	                			if(l >= start && r <= end) {
	                				segTree[pos] += (r - l + 1) * val;
	                				if(l != r) {
	                					lazy[2*pos+1] += val;
	                					lazy[2*pos+2] += val;
	                				}
	                				return;
	                			}
	                			int mid = (l + r)/2;
	                			update(l, mid, start, end, 2*pos+1, val);
	                			update(mid+1, r, start, end, 2*pos+2, val);
	                			segTree[pos] = segTree[2*pos+1] + segTree[2*pos+2];
	                		}
	                		long query(int l,int r,int start,int end,int pos) {
	                			if(lazy[pos] != 0) {
	                				segTree[pos] += (r - l + 1) * lazy[pos];
	                				if(l != r) {
	                					lazy[2*pos+1] += lazy[pos];
	                					lazy[2*pos+2] += lazy[pos];
	                				}
	                				lazy[pos] = 0;
	                			}
	                			if(l > r || l > end || r < start) {
	                				return 0;
	                			}
	                			if(l >= start && r <= end) {
	                				return segTree[pos];
	                			}
	                			int mid = (l + r)/2;
	                			long p1 = query(l, mid, start, end, 2*pos+1);
	                			long p2 = query(mid+1, r, start, end, 2*pos+2);
	                			return p1 + p2;
	                		}
	                	}
	                	
	                    static long power(long a,long b,long mod) {
                            long ans = 1;
                            a = a % mod;
                            while(b != 0) {
                                if(b % 2 == 1) {
                                    ans = (ans * a) % mod;
                                }
                                a = (a * a) % mod;
                                b = b/2;
                            }
                            return ans;
                        }
	                    class Pair implements Comparable<Pair>{
	                        int a;
	                        int b;
	                        int c;
	                        Pair(int a,int b,int c){
	                            this.b = b;
	                            this.a = a;
	                            this.c = c;
	                        }
	                        public boolean equals(Object o) {
	                            Pair p = (Pair)o;
	                            return this.a == p.a && this.b == this.b;
	                        }
	                        public int hashCode(){
	                            return Long.hashCode(a)*27 + Long.hashCode(b)*31;
	                        }
	                        public int compareTo(Pair p) {
	                            return Long.compare(this.a,p.a);
	                        }
	                    }
	                    
	                }