

import java.util.*;
import java.io.*;
//Captain on duty.


import static java.lang.Math.*;

public class Main {

    static void compare(Main.pair a[], int n) {

        Arrays.sort(a, new Comparator<Main.pair>() {
            @Override
            public int compare(Main.pair p1, Main.pair p2) {
                return p1.f - p2.f;
            }
        });
    }

    public static boolean checkPalindrome(String s) {
        // reverse the given String
        String reverse = new StringBuffer(s).reverse().toString();

        // check whether the string is palindrome or not
        if (s.equals(reverse))
            return true;

        else
            return false;
    }

    static class pair implements Comparable {
        int f;
        int s;

        pair(int fi, int se) {
            f = fi;
            s = se;
        }

        public int compareTo(Object o)//desc order
        {
            pair pr = (pair) o;
            if (s > pr.s)
                return -1;
            if (s == pr.s) {
                if (f > pr.f)
                    return 1;
                else
                    return -1;
            } else
                return 1;
        }

        public boolean equals(Object o) {
            pair ob = (pair) o;
            if (o != null) {
                if ((ob.f == this.f) && (ob.s == this.s))
                    return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f + " " + this.s).hashCode();
        }


    }

    public static boolean palin(int l, int r, char[] c) {
        while (l <= r) {
            if (c[l] != c[r]) return false;
            l++;
            r--;
        }
        return true;
    }


    public static long gcd(long a, long b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
    public static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }

    public static long hcf(long a, long b) {
        long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static boolean isPrime(long n) {
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i <= Math.sqrt(n) + 1; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static String reverse(String str) {
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            str1 = str1 + str.charAt(str.length() - i - 1);
        }
        return str1;
    }


    public static double fact(long a) {
        if (a == 1)
            return 1;
        else
            return a * fact(a - 1);
    }

    static boolean isPerfectSquare(double x)
    {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }


    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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


    }


    public static void main(String[] args) {
        FastReader s = new FastReader();
        //System.out.println("Forces Babyy!!");



        int test=s.nextInt();
        while(test-->0)
        {

          int n=s.nextInt();
          int m=s.nextInt();

          int[] a=new int[n];
          int[] b=new int[m];
          HashSet h1=new HashSet();
          for(int i=0;i<n;i++)
          {
              a[i]=s.nextInt();
              h1.add(a[i]);
          }
          HashSet h2=new HashSet();
          for(int j=0;j<m;j++)
          {
              b[j]=s.nextInt();
              h2.add(b[j]);
          }
          int f=0;
          int ans=0;
          for(int i=0;i<n;i++)
          {
              if(h2.contains(a[i]))
              {
                  f=1;
                  ans=a[i];
                  break;
              }
          }
          if(f!=1)
          {
              for(int i=0;i<m;i++)
              {
                  if(h1.contains(b[i]))
                  {
                      f=1;
                      ans=b[i];
                      break;
                  }
              }
              if(f==1)
              {
                  System.out.println("YES");
                  System.out.println(1 + " " + ans);
              }
              else
                  System.out.println("NO");
          }
          else
          {
              System.out.println("YES");
              System.out.println(1 + " "+ ans);
          }


        }


    }

}