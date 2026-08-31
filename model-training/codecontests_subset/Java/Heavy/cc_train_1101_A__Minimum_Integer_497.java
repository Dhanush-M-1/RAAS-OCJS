import java.util.*;
import java.io.*;
import java.math.*;
public class main{
static FastScanner sc;
static PrintWriter pw;
static void pn(Object o){pw.println(o);}
static void p(Object o){pw.print(o);}
// static boolean arr[] = sieve(100001);
static int mod = (int) (1e9+7);
// static ArrayList<Long> primes = new ArrayList<>();
static ArrayList<Integer> divisors = new ArrayList<>();

// double a = 0.9;
// Setting the precision to 20 places
//     System.out.println(String.format("%.20f", a)); -> 0.99999999999999990000
//     double b = 1;
//     System.out.println(String.format("%.5f", b))  OR pn("%.5f",b); -> 1.00000

// **********************Code Begins From Here*********************

        public static void solve()
        {
            // ArrayList<Integer> al = new ArrayList<>();
            // Map<Integer,Integer> map = new HashMap<>();
            // Set<Integer> set = new TreeSet<>();
            // for(Map.Entry<Integer,Integer> e:map.entrySet())pn(e.getKey()+" "+e.getValue());
            // LinkedList ll = new LinkedList<>();
            // Stack<Integer>st = new Stack<>();
            
            long l = sc.l(),r=sc.l(),d=sc.l(),fg=0;
            if(d==1)
            {
                if(l==1)pn(r+1);
                else pn(1);
            }
            else if(d<l)pn(d);
            else
            {
                int c = (int)Math.floor(r/d);
                pn(d*(c+1));
            }
        }
        public static void main(String[] args) throws FileNotFoundException {
//	        Scanner sc = new Scanner(System.in);
            sc = new FastScanner();
            pw = new PrintWriter(System.out);
            // for(long i=0;i<arr.length;i++)
            // {
            //     if(arr[(int)i])
            //     {
            //         primes.add(i);
            //     }
            // }
            int tc = sc.i(); 
            for(int t=0;t<tc;t++)
            {
                // p("Case #"+(t+1)+": ");
                solve();
            }
            pw.close();
        }
        // public static int solve(int a[],int l , int r) {
		
        //     for(int i=l+1;i<r;i++) {
        //         if(a[i]<a[i-1]) {
        //             int mid = (l+r)/2;
        //             return Math.max(solve(a,l,mid),solve(a,mid,r));
        //         }
        //     }
        //     return r-l;
        // }
          static int LCSubStr(char X[], char Y[],int m, int n)
          {
                // Create a table to store
                // lengths of longest common
                // suffixes of substrings.
                // Note that LCSuff[i][j]
                // contains length of longest
                // common suffix of
                // X[0..i-1] and Y[0..j-1].
                // The first row and first
                // column entries have no
                // logical meaning, they are
                // used only for simplicity of program
                int LCStuff[][] = new int[m + 1][n + 1];
        
                // To store length of the longest
                // common substring
                int result = 0;
        
                // Following steps build
                // LCSuff[m+1][n+1] in bottom up fashion
                for (int i = 0; i <= m; i++)
                {
                    for (int j = 0; j <= n; j++)
                    {
                        if (i == 0 || j == 0)
                            LCStuff[i][j] = 0;
                        else if (X[i - 1] == Y[j - 1])
                        {
                            LCStuff[i][j]
                                = LCStuff[i - 1][j - 1] + 1;
                            result = Integer.max(result,
                                                LCStuff[i][j]);
                        }
                        else
                            LCStuff[i][j] = 0;
                    }
                }
                return result;
            }
        static int countDivisors(int n)
        {
            int cnt = 0;
            for(int i=1;i*i<=n;i++)
            {
                if(n%i==0)cnt++;
                divisors.add(i);
            }
            return cnt;
        }

        static ArrayList<Integer> countDivisorsList(int n)
        {
            for(int i=1;i*i<=n;i++)
            {
                if(n%i==0)
                divisors.add(i);
            }
            return divisors;
        }

        static boolean isStringSorted(String s)
        {
            for(int i=0;i<s.length()-1;i++)
            {
                if(s.charAt(i)>s.charAt(i+1))return false;
            }
            return true;
        }

        static boolean isPalindromeString(String s)
        {
            String temp = "";
            for(int i=s.length()-1;i>=0;i--)
            {
                temp+=s.charAt(i)+"";
            }
            return ((s.equals(temp))?true:false);
        }
        static boolean isSorted(int[] a)
        {
            int n = a.length;
            for(int i=1;i<n;i++)
            {
                if(a[i-1]>=a[i])return false;
            }
            return true;
        }
        static boolean solution(int n,int x)
        {
            int sum=0;
            while(n>0)
            {
                int digit=n%10;
                n/=10;
                sum+=digit;
            }
            return (sum==x)?true:false;
        }
        static ArrayList<Integer> perfectSquares(int n) 
        { 
            ArrayList<Integer> al = new  ArrayList<Integer>();
            for(int i=1;i<=n;i++)
            {
                al.add(i*i);
            }
            return al; 
        } 
    static boolean checkDuplicateAll(String s)
    {
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))return false;
        }
        return true;
    }
    static String reverseString(String s,int x)
    {
        String ans="",temp = s.substring(0,x);
        for(int i=x;i<s.length();i++)
        {
            ans = s.charAt(i)+ans;
        }
        return temp+ans;
    }
    static boolean checker(int num)
    {
        String s = num+"";
        if(s.contains("0"))return false;
        int temp = num;
        while(num>0)
        {
            int digit = num%10;
            num/=10;
            if(temp%digit==0)return false;
        }
        return true;
    }
    static boolean palindrome(int n)
    {
        int temp=n,rev=0;
        while(n>0)
        {
            int digit=n%10;
            n/=10;
            rev = rev*10+digit;
        }
        return (temp==rev)?true:false;
    }
    
    static boolean checkparanthesis(String s)
    {
        Stack<Character>st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')st.push('(');
            else
            {
                if(st.size()==0)return false;
                else st.pop();
            }
        }
        return (st.size()==0)?true:false;
    }
    static int[] reverse(int a[]){

        for(int i=0;i<a.length/2;i++)
        {
           int temp = a[i];
           a[i] = a[a.length-i-1];
           a[a.length-i-1] = temp;
        }
        return a;
        }
   static boolean[] sieve(int n)
   {
   	boolean[] isPrime = new boolean[n+1];
   	Arrays.fill(isPrime,true);
   	isPrime[0]=false;
   	isPrime[1]=false;
   	for(int i=2;i*i<=n;i++)
   	{
   		for(int j=i*i;j<=n;j+=i)
   		{
   			isPrime[j]=false;
   		}
   	}
   	return isPrime;
   }
   static int[][] graph(int from[], int to[], int n)
   {
       int g[][] = new int[n][];
       int cnt[] = new int[n];
       for (int i = 0; i < from.length; i++) {
           cnt[from[i]]++;
           cnt[to[i]]++;
       }
       for (int i = 0; i < n; i++) {
           g[i] = new int[cnt[i]];
       }
       Arrays.fill(cnt, 0);
       for (int i = 0; i < from.length; i++) {
           g[from[i]][cnt[from[i]]++] = to[i];
           g[to[i]][cnt[to[i]]++] = from[i];
       }
       return g;
   }
   
   static class Pair implements Comparable<Pair>{

       int x,y,z;
       
       Pair (int x,int y,int z){
           this.x=x;
           this.y=y;
           this.z=z;
       }
           
       public int compareTo(Pair o) {
           if (this.x == o.x)
               return Integer.compare(this.y,o.y);
           return Integer.compare(this.x,o.x);
           //return 0;
       }

       public boolean equals(Object o) {
           if (o instanceof Pair) {
               Pair p = (Pair)o;
               return p.x == x && p.y == y;
           }
           return false;
       }
       public int hashCode() {
           return new Integer(x).hashCode() * 31 + new Integer(y).hashCode();
       }
       
       @Override
       public String toString() {
           return x + " " + y;
       }
   
   } 
   
   static String rev(String s) {
       StringBuilder sb = new StringBuilder(s);
       sb.reverse();
       return sb.toString();
   }

   static long gcd(long x, long y) {
       if (y == 0) {
           return x;
       } else {
           return gcd(y, x % y);
       }
   }

   static int gcd(int x, int y) {
       if (y == 0) {
           return x;
       } else {
           return gcd(y, x % y);
       }
   }
   
   static int abs(int a, int b) {
       return (int) Math.abs(a - b);
   }

   static long abs(long a, long b) {
       return (long) Math.abs(a - b);
   }

   static int max(int a, int b) {
       if (a > b) {
           return a;
       } else {
           return b;
       }
   }

   static int min(int a, int b) {
       if (a > b) {
           return b;
       } else {
           return a;
       }
   }

   static long max(long a, long b) {
       if (a > b) {
           return a;
       } else {
           return b;
       }
   }

   static long min(long a, long b) {
       if (a > b) {
           return b;
       } else {
           return a;
       }
   }

   static long pow(long n, long p, long m) {
       long result = 1;
       if (p == 0) {
           return 1;
       }
       while (p != 0) {
           if (p % 2 == 1) {
               result *= n;
           }
           if (result >= m) {
               result %= m;
           }
           p >>= 1;
           n *= n;
           if (n >= m) {
               n %= m;
           }
       }
       return result;
   }

   static long pow(long n, long p) {
       long result = 1;
       if (p == 0) {
           return 1;
       }
       if (p == 1) {
           return n;
       }
       while (p != 0) {
           if (p % 2 == 1) {
               result *= n;
           }
           p >>= 1;
           n *= n;
       }
       return result;
   }
  
   static void debug(Object... o) {
           System.out.println(Arrays.deepToString(o));
   }

//    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() throws FileNotFoundException {
            
            if (System.getProperty("ONLINE_JUDGE") == null) {
                // Input is a file
                    br = new BufferedReader(new FileReader("input.txt")); 
    
                    // PrintWriter class prints formatted representations 
                    // of objects to a text-output stream. 
                    PrintStream pw = new PrintStream(new FileOutputStream("output.txt"));
                    System.setOut(pw);
              }
            else
            {
                // Input is System.in
                br = new BufferedReader(new InputStreamReader(System.in), 32768);
                st = null;
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
 
        int i() {
            return Integer.parseInt(next());
        }
 
        int[] intArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = i();
            return ret;
        }
 
        long l() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = l();
            return ret;
        }
 
        double d() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    // static class InputReader
//    {

//        private final InputStream stream;
//        private final byte[] buf = new byte[8192];
//        private int curChar, snumChars;
//        private SpaceCharFilter filter;

//        public InputReader(InputStream stream)
//        {
//                this.stream = stream;
//        }

//        public int snext()
//        {
//                if (snumChars == -1)
//                        throw new InputMismatchException();
//                if (curChar >= snumChars)
//                {
//                        curChar = 0;
//                        try
//                        {
//                                snumChars = stream.read(buf);
//                        } catch (IOException e)
//                        {
//                                throw new InputMismatchException();
//                        }
//                        if (snumChars <= 0)
//                                return -1;
//                }
//                return buf[curChar++];
//        }

//        public int nextInt()
//        {
//                int c = snext();
//                while (isSpaceChar(c))
//                {
//                        c = snext();
//                }
//                int sgn = 1;
//                if (c == '-')
//                {
//                        sgn = -1;
//                        c = snext();
//                }
//                int res = 0;
//                do
//                {
//                        if (c < '0' || c > '9')
//                                throw new InputMismatchException();
//                        res *= 10;
//                        res += c - '0';
//                        c = snext();
//                } while (!isSpaceChar(c));
//                return res * sgn;
//        }

//        public long nextLong()
//        {
//                int c = snext();
//                while (isSpaceChar(c))
//                {
//                        c = snext();
//                }
//                int sgn = 1;
//                if (c == '-')
//                {
//                        sgn = -1;
//                        c = snext();
//                }
//                long res = 0;
//                do
//                {
//                        if (c < '0' || c > '9')
//                                throw new InputMismatchException();
//                        res *= 10;
//                        res += c - '0';
//                        c = snext();
//                } while (!isSpaceChar(c));
//                return res * sgn;
//        }

//        public int[] nextIntArray(int n)
//        {
//                int a[] = new int[n];
//                for (int i = 0; i < n; i++)
//                {
//                        a[i] = nextInt();
//                }
//                return a;
//        }

//        public long[] nextLongArray(int n)
//        {
//                long a[] = new long[n];
//                for (int i = 0; i < n; i++)
//                {
//                        a[i] = nextLong();
//                }
//                return a;
//        }

//        public String readString()
//        {
//                int c = snext();
//                while (isSpaceChar(c))
//                {
//                        c = snext();
//                }
//                StringBuilder res = new StringBuilder();
//                do
//                {
//                        res.appendCodePoint(c);
//                        c = snext();
//                } while (!isSpaceChar(c));
//                return res.toString();
//        }

//        public String nextLine()
//        {
//                int c = snext();
//                while (isSpaceChar(c))
//                        c = snext();
//                StringBuilder res = new StringBuilder();
//                do
//                {
//                        res.appendCodePoint(c);
//                        c = snext();
//                } while (!isEndOfLine(c));
//                return res.toString();
//        }

//        public boolean isSpaceChar(int c)
//        {
//                if (filter != null)
//                        return filter.isSpaceChar(c);
//                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//        }

//        private boolean isEndOfLine(int c)
//        {
//                return c == '\n' || c == '\r' || c == -1;
//        }

//        public interface SpaceCharFilter
//        {
//                public boolean isSpaceChar(int ch);
//        }
}