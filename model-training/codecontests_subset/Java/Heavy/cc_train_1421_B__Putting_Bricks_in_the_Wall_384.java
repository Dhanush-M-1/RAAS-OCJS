import java.io.*;
import java.util.*;
import java.util.Collections;
public class div2_676_B implements Runnable
{
    public void run()
    {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            char ch[][] = new char[n][];
            for(int i=0;i<n;i++)
            {
                ch[i]=sc.next().toCharArray();
            }

            if(ch[0][1]==ch[1][0])
            {
                if(ch[n-1][n-2]==ch[n-2][n-1] && ch[n-1][n-2] != ch[0][1])
                {
                    System.out.println(0);
                }
                else if(ch[n-1][n-2]==ch[n-2][n-1] && ch[n-1][n-2] == ch[0][1])
                {
                    System.out.println("2");
                    System.out.println(n+" "+(n-1));
                    System.out.println((n-1)+" "+n);
                }
                else if(ch[n-1][n-2] != ch[n-2][n-1])
                {
                    if(ch[n-1][n-2]==ch[0][1])
                    {
                        System.out.println("1");
                        System.out.println(n+" "+(n-1));
                    }
                    else if(ch[n-2][n-1]==ch[1][0])
                    {
                        System.out.println("1");
                        System.out.println((n-1)+" "+n);
                    }
                }
            }
            else
            {
                if(ch[n-1][n-2]==ch[n-2][n-1])
                {
                    if(ch[n-1][n-2]==ch[0][1])
                    {
                        System.out.println("1");
                        System.out.println("1 2");
                    }
                    else if(ch[n-1][n-2] == ch[1][0])
                    {
                        System.out.println("1");
                        System.out.println("2 1");
                    }
                }
                else
                {
                    if(ch[n-1][n-2]==ch[0][1])
                    {
                        System.out.println("2");
                        System.out.println("1 2");
                        System.out.println((n-1)+" "+n);
                    }
                    else if(ch[n-1][n-2]==ch[1][0])
                    {
                        System.out.println("2");
                        System.out.println("2 1");
                        System.out.println((n-1)+" "+n);
                    }
                }
            }
        }
    }

    static class sortintarray {
        public static void sort(int[] arr) {
            int n = arr.length, mid, h, s, l, i, j, k;
            int[] res = new int[n];
            n--;
            for (s = 1; s <= n; s <<= 1) {
                for (l = 0; l < n; l += (s << 1)) {
                    h = Math.min(l + (s << 1) - 1, n);
                    mid = Math.min(l + s - 1, n);
                    i = l;
                    j = mid + 1;
                    k = l;
                    while (i <= mid && j <= h) res[k++] = (arr[i] <= arr[j] ? arr[i++] : arr[j++]);
                    while (i <= mid) res[k++] = arr[i++];
                    while (j <= h) res[k++] = arr[j++];
                    for (k = l; k <= h; k++) arr[k] = res[k];
                }
            }

        }
    }

    static class sortchararray {
        public static void sort(char[] arr) {
            int n = arr.length, mid, h, s, l, i, j, k;
            char[] res = new char[n];
            n--;
            for (s = 1; s <= n; s <<= 1) {
                for (l = 0; l < n; l += (s << 1)) {
                    h = Math.min(l + (s << 1) - 1, n);
                    mid = Math.min(l + s - 1, n);
                    i = l;
                    j = mid + 1;
                    k = l;
                    while (i <= mid && j <= h) res[k++] = (arr[i] <= arr[j] ? arr[i++] : arr[j++]);
                    while (i <= mid) res[k++] = arr[i++];
                    while (j <= h) res[k++] = arr[j++];
                    for (k = l; k <= h; k++) arr[k] = res[k];
                }
            }
        }
    }

    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}

    long factorial(long n){    
      if (n == 0)    
        return 1;    
      else    
        return(n * factorial(n-1));    
    }

    boolean isPrime(int n) 
    {
        if (n <= 1){
            return false;
        }

        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false; 
            }
      
        }  
        return true; 
    }

    long ceil(long a,long b)
    {
        if(a%b==0)
        {
            return a/b;
        }
        else
        {
            return (a/b)+1;
        }
    }
    int ceil(int a,int b)
    {
        if(a%b==0)
        {
            return a/b;
        }
        else
        {
            return (a/b)+1;
        }
    }

    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U x;
        public V y;
    
        public Pair(U x, V y) {
            this.x = x;
            this.y = y;
        }
    
        public int hashCode() {
            return (x == null ? 0 : x.hashCode() * 31) + (y == null ? 0 : y.hashCode());
        }
    
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<U, V> p = (Pair<U, V>) o;
            return (x == null ? p.x == null : x.equals(p.x)) && (y == null ? p.y == null : y.equals(p.y));
        }
    
        public int compareTo(Pair<U, V> b) {
            int cmpU = x.compareTo(b.x);
            return cmpU != 0 ? cmpU : y.compareTo(b.y);
        }
    
        public String toString() {
            return String.format("(%s, %s)", x.toString(), y.toString());
        }
    
    }   

    static class InputReader 
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
       
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
           
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
               
                if(numChars <= 0)              
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
           
            while(isSpaceChar(c))
                c = read();
           
            int sgn = 1;
           
            if (c == '-') {
                sgn = -1;
                c = read();
            }
           
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
           
            return res * sgn;
        }
       
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
           
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
       
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
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
       
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
           
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() {
            return readString();
        }
       
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new div2_676_B(),"Main",1<<27).start();
    }
}   