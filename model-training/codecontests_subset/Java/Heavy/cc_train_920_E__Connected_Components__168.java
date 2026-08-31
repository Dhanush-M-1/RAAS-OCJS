import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.math.*;
 
     public class Sample implements Runnable
    { 
        
         
          static int n;
          static int m;
          static ArrayList<Integer>[] al=new ArrayList[200005];
          static ArrayList<Integer> all=new ArrayList();
          static Set<Integer> s1=new HashSet();
          static Set<Integer> s2=new HashSet();
          public  static void solve()
          {  
            n=i(); m=i();
            for(int i=1;i<=n;i++)
            {
              al[i]=new ArrayList();
            }
            for(int i=1;i<=m;i++)
            {
              int src=i(); int dest=i();
              al[dest].add(src);
              al[src].add(dest);
            }
            for(int i=1;i<=n;i++)s1.add(i);

            for(int i=1;i<=n;i++)
            {
              if(!s1.contains(i))continue;
              all.add(bfs(i));

            }
            out.println(all.size());
            Collections.sort(all);
            for(int i:all)out.print(i+" ");



            
          }  
        public static int bfs(int src)
        {
          s1.remove(src);
          int ans=1;
          Queue<Integer> q=new LinkedList();
          q.add(src);
          while(!q.isEmpty())
          {
            int node=q.remove();
            for(int i:al[node])
            {
              if(!s1.contains(i))continue;
              s1.remove(i);
              s2.add(i);
            }
            for(int x:s1)
            {
              q.add(x);
              ans++;
            }
            s1.clear();
            s1.addAll(s2);
            s2.clear();
          }
          return ans;
        }
          public void run()
          {   
              solve();
              out.close();
          }
 
          public static void main(String[] args) throws IOException
          { 
                new Thread(null, new Sample(), "whatever", 1<<26).start();
          }
           static class Pair implements Comparable<Pair>{ 
            int a;
            int b;
            
            Pair(){}
            Pair(int a,int b)
            {
                       this.a=a;
                       this.b=b;
            }
            public int compareTo(Pair p)
            {
              return  p.a-this.a;
            }
   
            
        }
        
       
         
    ////////////////////////////////////////////////////// Merge Sort ////////////////////////////////////////////////////////////////////////
     
   static class Merge 
   {
 
        public static void sort(long inputArr[]) 
        {
            int length = inputArr.length;
            doMergeSort(inputArr,0, length - 1);
        }
 
        private static void doMergeSort(long[] arr,int lowerIndex, int higherIndex) 
        {        
            if (lowerIndex < higherIndex) {
                int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
                doMergeSort(arr,lowerIndex, middle);
                doMergeSort(arr,middle + 1, higherIndex);
                mergeParts(arr,lowerIndex, middle, higherIndex);
            }
        }
 
        private static void mergeParts(long[]array,int lowerIndex, int middle, int higherIndex) 
        {
            long[] temp=new long[higherIndex-lowerIndex+1];
            for (int i = lowerIndex; i <= higherIndex; i++) 
            {
                temp[i-lowerIndex] = array[i];
            }
            int i = lowerIndex;
            int j = middle + 1;
            int k = lowerIndex;
            while (i <= middle && j <= higherIndex) 
            {
                if (temp[i-lowerIndex] < temp[j-lowerIndex]) 
                {
                    array[k] = temp[i-lowerIndex];
                    i++;
                } else {
                    array[k] = temp[j-lowerIndex];
                    j++;
                }
                k++;
            }
            while (i <= middle) 
            {
                array[k] = temp[i-lowerIndex];
                k++;
                i++;
            }
            while(j<=higherIndex)
            {
                array[k]=temp[j-lowerIndex];
                k++;
                j++;
            }
        }
 
    }
        
      
    /////////////////////////////////////////////////////////// Methods ////////////////////////////////////////////////////////////////////////
 
 
     static boolean isPal(String s)
     {
        for(int i=0, j=s.length()-1;i<=j;i++,j--)
        {
                if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
     }
     static String rev(String s)
     {
                StringBuilder sb=new StringBuilder(s);
                sb.reverse();
                return sb.toString();
     }
     static int gcd(int a,int b){return (a==0)?b:gcd(b%a,a);}
     static long gcdExtended(long a,long b,long[] x)
     {
 
        if(a==0){
            x[0]=0;
            x[1]=1;
            return b;
        }
        long[] y=new long[2];
        long gcd=gcdExtended(b%a, a, y);
 
        x[0]=y[1]-(b/a)*y[0];
        x[1]=y[0];
 
        return gcd;
    }
 
     boolean findSum(int set[], int n, long sum)
    {
      if (sum == 0)
         return true;
      if (n == 0 && sum != 0)
         return false;
      if (set[n-1] > sum)
         return findSum(set, n-1, sum);
      return findSum(set, n-1, sum) ||findSum(set, n-1, sum-set[n-1]);
    }
   
      public static long modPow(long base, long exp, long mod)
     {
        base = base % mod;
        long result = 1;
        while (exp > 0)
       {
            if (exp % 2 == 1) 
            {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp >> 1;
       }
        return result;
    }
 
    static long[] fac;
    static long[] inv;
    static long mod=(long)1e9+7;
    public static void cal() 
    {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i <= 1000000; i++)
        {
            fac[i] = (fac[i - 1] * i) % mod;
            inv[i] = (inv[i - 1] * modPow(i, mod - 2, mod)) % mod;
        }
    }
 
    public static long ncr(int n, int r) 
    {
        return (((fac[n] * inv[r]) % mod) * inv[n - r]) % mod;
    }
 
 
////////////////////////////////////////// Input Reader ////////////////////////////////////////////////////////////////////////////////////////////////////
     
    static InputReader sc = new InputReader(System.in);
    static PrintWriter out= new PrintWriter(System.out);   
    
    static class InputReader {
 
          private final InputStream stream;
          private final byte[] buf = new byte[8192];
          private int curChar, snumChars;
          private SpaceCharFilter filter;
 
          public InputReader(InputStream stream) {
                  this.stream = stream;
          }
 
          public int snext()
         {
                  if (snumChars == -1)
                          throw new InputMismatchException();
                  if (curChar >= snumChars) {
                          curChar = 0;
                          try {
                                  snumChars = stream.read(buf);
                          } catch (IOException e) {
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
                  do {
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
                  do {
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
 
          public long[] nextLongArray(int n)
          {
                  long a[] = new long[n];
                  for (int i = 0; i < n; i++) 
                  {
                          a[i] = nextLong();
                  }
                  return a;
          }
 
          
          public String nextLine()
         {
                  int c = snext();
                  while (isSpaceChar(c))
                          c = snext();
                  StringBuilder res = new StringBuilder();
                  do {
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
 
    static int i()
    {
        return sc.nextInt();
    }
    static long l(){
        return sc.nextLong();
    }
    static int[] iarr(int n)
    {
        return sc.nextIntArray(n);
    }
    static long[] larr(int n)
    {
        return sc.nextLongArray(n);
    }
    static String s(){
        return sc.nextLine();
    }
  
 
 }  
