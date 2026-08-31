import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Stream;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Main {
	
static class NumberTheoryUtils {
		private long MOD = (long)(1e9 + 7);
		long[]fact, inverseFact;
		boolean factsMade = false;
		public long gcd(long a, long b) {
			if(b == 0)return a;
			return gcd(b, a%b);
		}
		public int gcd(int a, int b) {
			if(b == 0)return a;
			return gcd(b, a%b);
		}
		public long lcd(long a, long b) {
			return a * b / gcd(a, b);
		}
		public int lcm(int a, int b) {
			return (int) 1L * a * b / gcd(a, b);
		}
		public void makeFacts(int maxLength) {
			getFactorialsModulo(maxLength);
			getInverseFactorialsModulo(maxLength);
		}
		public int[] getLPFArray(int maxLength) {
			int[]lpf = new int[maxLength+5];
			for(int i=2; i<=maxLength; i++) {
				if(lpf[i] == 0) {
					for(int j=i; j<=maxLength; j+=i) {
						if(lpf[j] == 0) {
							lpf[j] = i;
						}
					}
				}
			}
			return lpf;
		}
		public boolean[]getSieve(int maxLength){
			boolean[]isPrime = new boolean[maxLength+5];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			for(int i=2; i<=maxLength; i++) {
				if(isPrime[i]) {
					for(int j=2*i; j<=maxLength; j+=i) {
						if(isPrime[j]) {
							isPrime[j] = false;
						}
					}
				}
			}
			return isPrime;
		}
		public void setMod(long MOD) {
			this.MOD = MOD;
		}
		public long powerModulo(long base, long exponent) {
			if(exponent == 0)return 1L;
			long tempValue = powerModulo(base, exponent / 2L);
			long res = (tempValue * tempValue) % MOD;
			if(exponent % 2 != 0)res = (res * base) % MOD;
			return res;
		}
		public long inverseModulo(long value) {
			return this.powerModulo(value, MOD - 2L);
		}
		
		public long inverseModuloForNonPrime(long value) {
			
			long gcd = this.gcd(value, MOD);
			if(gcd != 1) return -1;
			
			long eulerPhi = this.eulerTotientFunctionForSingleValue(MOD);
			
			long ans = this.powerModulo(value, eulerPhi - 1);
			
			return ans;
			
		}
		
		public long nCr(int n, int r) {
			if(n < r || n < 0 || r < 0)return 0L;
			return (((fact[n]
					* inverseFact[n-r]) % MOD) * inverseFact[r]) % MOD;
		}
		
		public long[]getFactorialsModulo(int maxLength){
			this.fact = new long[maxLength];
			fact[0] = 1L;
			for(int i=1; i<maxLength; i++) {
				fact[i] = (fact[i-1] * i) % MOD;
			}
			this.factsMade = true;
			return fact;
		}
		public long[]getInverseFactorialsModulo(int maxLength){
			this.inverseFact = new long[maxLength];
			if(!this.factsMade) {
				this.getFactorialsModulo(maxLength);
			}
			for(int i=0; i<maxLength; i++) {
				inverseFact[i] = this.inverseModulo(fact[i]);
			}
			return inverseFact;
		}
		
		public TreeMap<Integer, Integer> getPrimeFactors(long n){
			TreeMap<Integer, Integer> answer = new TreeMap<Integer, Integer>();
			int twoCount = 0;
			while(n % 2 == 0) {
				n /= 2;
				twoCount++;
			}
			if(twoCount > 0)answer.put(2, twoCount);
			for(int i=3; 1L*i*i<=n; i+=2) {
				int iCount = 0;
				while(n % i == 0) {
					n /= i;
					iCount++;
				}
				if(iCount > 0) {
					answer.put(i, iCount);
				}
			}
			return answer;
		}
		public long eulerTotientFunctionForSingleValue(long n) {
			// Complexity O(sqrt(n))
			long result = n;
			for(int i=2; 1L*i*i <= n; i++) {
				if(n % i == 0) {
					while(n % i == 0) {
						n /= i;
					}
					result -= result / i;
				}
			}
			if(n > 1) {
				result -= result / n;
			}
			return result;
		}
		public int[]eulerTotientFunctionForRange(int n){
			int[]phi = new int[n+1];
			for(int i=1; i<=n; i++) {
				phi[i] = i;
			}
			for(int i=2; i<=n; i++) {
				if(phi[i] == i) {
					for(int j=i; j<=n; j+=i) {
						phi[j] -= phi[j] / i;
					}
				}
			}
			return phi;
		}
		public long addModulo(long a, long b) {
			return (a + b) % MOD;
		}
		public long multiplyModulo(long a, long b) {
			return (a * b) % MOD;
		}
		public long subtractModulo(long a, long b) {
			return (a - b + MOD) % MOD;
		}
		public long divideModulo(long a, long b) {
			return this.multiplyModulo(a, this.inverseModulo(b));
		}

	}



public static void main(String[] args){
 
   new Thread(null, null, "Anshum Gupta", 99999999) {
        public void run() {
            try {
                solve();
            } catch(Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }.start();
}
 

static final long INF_LONG = (long)(1e18 + 5), MOD = (long)1e9 + 7;//998244353; 
static final int MXN = (int)(2e5 + 5), MXV = (int)(2e5 + 5), log = 18, INF = (int)1e9 + 500;
static ArrayList<ArrayList<Integer>> adj;
static boolean[][] vis;
static char[] S;
static int[] A, lpf;
static long[] dp;
static int N, M, K, Q, H, W;


public static void solve() throws Exception {
	   // solve the problem here
		s = new MyScanner();
   		out = new MyWriter(new BufferedOutputStream(System.out));
   		
        int T = s.nextInt();
        
    	
    	dp = new long[MXN];
    	for(int i = 0; i <= 8; i++) dp[i] = 2;
    	dp[9] = 3;
    	for(int i = 10; i < MXN; i++) {
    		dp[i] = (dp[i - 9] + dp[i - 10]) % MOD;
    	}
        
        for(int i = 1; i <= T; i++) testcase();
          
        out.flush();
        out.close();
}






static void testcase() {
	
	int N = s.nextInt();
	int M = s.nextInt();
	
	long ans = 0;
	
	while(N > 0) {
		int digit = N % 10;
		
		if(M + digit < 10) {
			ans += 1;
		}
		else {
			ans += dp[M - 10 + digit];
		}
		ans %= MOD;
		N /= 10;
	}
	
	out.println(ans);
	
}






public static MyWriter out;
public static MyScanner s;
static void shuffleArray(int[] a) {
	Random random = new Random();
	for (int i = a.length-1; i > 0; i--) {
		int index = random.nextInt(i + 1);
		int tmp = a[index];
		a[index] = a[i];
		a[i] = tmp;
	}
}
static void shuffleSort(int[] a) {
	shuffleArray(a);
	Arrays.parallelSort(a);
}

static void shuffleArray(long[] a) {
	Random random = new Random();
	for (int i = a.length-1; i > 0; i--) {
		int index = random.nextInt(i + 1);
		long tmp = a[index];
		a[index] = a[i];
		a[i] = tmp;
	}
}
static void shuffleSort(long[] a) {
	shuffleArray(a);
	Arrays.parallelSort(a);
}

static void reverse(int[] a) {
	int[] copy = Arrays.copyOf(a, a.length);
	for(int i = 0; i < a.length; i++) {
		a[a.length - 1 - i] = copy[i];
	}
}

static class MyScanner {
 
    BufferedReader br;
    StringTokenizer st;
 
    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public MyScanner(String fileName) {
    	try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    int[] nextIntArray(int n){
    	int[] a = new int[n];
    	for(int i = 0; i < n; i++) {
    		a[i] = this.nextInt();
    	}
    	return a;
    }
    long[] nextlongArray(int n) {
    	long[] a = new long[n];
    	for(int i = 0; i < n; i++) {
    		a[i] = this.nextLong();
    	}
    	return a;
    }
    Integer[] nextIntegerArray(int n){
    	Integer[]a = new Integer[n];
    	for(int i=0; i<n; i++) {
    		a[i] = this.nextInt();
    	}
    	return a;
    }
    Long[] nextLongArray(int n) {
    	Long[]a = new Long[n];
    	for(int i=0; i<n; i++) {
    		a[i] = this.nextLong();
    	}
    	return a;
    }
    char[][] next2DCharArray(int n, int m){
    	char[][]arr = new char[n][m];
    	for(int i=0; i<n; i++) {
    		arr[i] = this.next().toCharArray();
    	}
    	return arr;
    }
    ArrayList<ArrayList<Integer>> readUndirectedUnweightedGraph(int n, int m) {
    	ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < n; i++)adj.add(new ArrayList<Integer>());
    	for(int i = 0; i < m; i++) {
    		int u = s.nextInt();
    		int v = s.nextInt();
    		u--; v--;
    		adj.get(u).add(v);
    		adj.get(v).add(u);
    	}
    	return adj;
    }
    ArrayList<ArrayList<Integer>> readDirectedUnweightedGraph(int n, int m) {
    	ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < n; i++)adj.add(new ArrayList<Integer>());
    	for(int i = 0; i < m; i++) {
    		int u = s.nextInt();
    		int v = s.nextInt();
    		u--; v--;
    		adj.get(u).add(v);
    	}
    	return adj;
    }
    String nextLine(){
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
 
static class MyWriter extends PrintWriter {
    MyWriter(OutputStream out) {
        super(out);
    }
    void println(int[] x) {
        println(x, " ");
    }
    void println(int[] x, String delimiter) {
        if (x.length > 0) {
            print(x[0]);
            for (int i = 1; i < x.length; i++) {
                print(delimiter);
                print(x[i]);
            }
        }
        println();
    }
    void println(long[] x) {
        println(x, " ");
    }
    void println(long[] x, String delimiter) {
        if (x.length > 0) {
            print(x[0]);
            for (int i = 1; i < x.length; i++) {
                print(delimiter);
                print(x[i]);
            }
        }
        println();
    }
    void println(Iterable<?> iterable) {
        println(iterable, " ");
    }
    void println(Iterable<?> iterable, String delimiter) {
        Iterator<?> i = iterable.iterator();
        if (i.hasNext()) {
            print(i.next());
            while (i.hasNext()) {
                print(delimiter);
                print(i.next());
            }
        }
        println();
    }
    void printLines(int[] x) {
        println(x, System.lineSeparator());
    }
    void printLines(long[] x) {
        println(x, System.lineSeparator());
    }
    void printLines(Iterable<?> iterable) {
        println(iterable, System.lineSeparator());
    }
}
 
}