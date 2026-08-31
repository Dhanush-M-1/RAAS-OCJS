
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;
public class me
{
 public static void main(String args[])
 {  
     
     
     
                                  /*HERE IS THE CODE*/
                                    /*MAIN PROGRAM*/
 Scanner br=new Scanner(System.in);
        double n=br.nextDouble();
        double x=br.nextDouble();
        double y=br.nextDouble();
        int num=(int)Math.ceil(y*n/100);
        if(num>x)
        System.out.print((int)(num-x));
        else
        System.out.print("0");

 
 }

    
         
    public static long  ways(int n, int r, long MOD)
    {
      //  vector<long long> f(n + 1,1);
        long f[]=new long[n+1];
        Arrays.fill(f,1);
        for (int i=2; i<=n;i++)
            f[i]= (f[i-1]*i) % MOD;
        return (f[n]*((InverseEuler(f[r], MOD) * InverseEuler(f[n-r], MOD)) % MOD)) % MOD;
    }  
    
                  
                  
                  
                   /*THIS IS FOR THE INVERSE EULER*/
    public static long  InverseEuler(long n, long MOD)
    {
        return pow(n,MOD-2,MOD);
    }
    
    
    
                   
                   /*THIS ID THE CHECK FOR THE PRIME*/
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }
    
    
    
                          /*TO CHECK FOR THE GCD IN LONG*/
public static long gcd(long x,long y)
{
    if(x%y==0)
        return y;
    else
        return gcd(y,x%y);
}
    
    
    
                             /* CHECK FOR THE GCD IN INT*/
public static int gcd(int x,int y)
{
    if(x%y==0)
        return y;
    else 
        return gcd(y,x%y);
}


                         /*CHECK FOR THE ABSOLUTE IN INT*/
public static int abs(int a,int b)
{
    return (int)Math.abs(a-b);
}



                        /*CHECK FOR THE ABSOLUTE IN LONG*/
public static long abs(long a,long b)
{
    return (long)Math.abs(a-b);
}


                       /*CHECK FOR MAX BETWEEN TWO NUMBERS IN INT*/
public static int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}



                       /*CHECK FOR MIN BETWEEN TWO NUMBERS IN INT*/
public static int min(int a,int b)
{
    if(a>b)
        return b;
    else 
        return a;
}


                       /*CHECK FOR MAX BETWEEN TWO NUMBERS IN LONG*/
public static long max(long a,long b)
{
    if(a>b)
        return a;
    else
        return b;
}

                     /*CHECK FOR MIN BETWEEN TWO NUMBERS IN LONG*/
public static long min(long a,long b)
{
    if(a>b)
        return b;
    else 
        return a;
}
                    /*check for power of two of any num*/
static boolean isPowerOfTwo (long v) {
    return (v & (v - 1)) == 0;
}
public static long pow(long n,long p,long m)
{
     long  result = 1;
      if(p==0)
        return 1;
    if (p==1)
        return n;
    while(p!=0)
    {
        if(p%2==1)
            result *= n;
        if(result>=m)
        result%=m;
        p >>=1;
        n*=n;
        if(n>=m)
        n%=m;
    }
    return result;
}

static class Pair implements Comparable<Pair>
{
    int a,b;
    Pair (int a,int b)
    {
        this.a=a;
        this.b=b;
    }

    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        if(this.a!=o.a)
        return Integer.compare(this.a,o.a);
        else
            return Integer.compare(this.b, o.b);
        //return 0;
    }
} 
                    /*SORT GIVEN ARRAY*/
static long sort(int a[],int n)
{   int b[]=new int[n]; 
    return mergeSort(a,b,0,n-1);}
static long mergeSort(int a[],int b[],long left,long right)
{ long c=0;if(left<right)
 {   long mid=left+(right-left)/2;
     c= mergeSort(a,b,left,mid);
     c+=mergeSort(a,b,mid+1,right);
     c+=merge(a,b,left,mid+1,right); }  
    return c;    }
static long merge(int a[],int  b[],long left,long mid,long right)
{long c=0;int i=(int)left;int j=(int)mid; int k=(int)left;
while(i<=(int)mid-1&&j<=(int)right)
{ if(a[i]<=a[j]) {b[k++]=a[i++]; }
else    { b[k++]=a[j++];c+=mid-i;}}
while (i <= (int)mid - 1)   b[k++] = a[i++]; 
while (j <= (int)right) b[k++] = a[j++];
for (i=(int)left; i <= (int)right; i++) 
    a[i] = b[i];  return c;  }
    
    
   static  class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt()
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
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
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
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public double readDouble() {
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
                    return res * Math.pow(10, readInt());
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
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public long readLong() {
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
            } while (!isSpaceChar(c));
            return res * sgn;
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

     static class OutputWriter
    {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects)
        {
            print(objects);
            writer.println();
        }

        public void close()
        {
            writer.close();
        }

        public void flush()
        {
            writer.flush();
        }

    }
   
  static   class IOUtils {

        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = in.readInt();
            return array;
    }
    }
    
         /*REMOVE ZERO FROM GIVEN NUM*/
static int removeZero(int num) {
        int ret = 0;
        int ten = 1;
        while (num>0) {
                int dig = num % 10;
                num /= 10;
                if (dig>0) {
                        ret += dig * ten;
                        ten *= 10;
                }
        }
        return ret;
}    

}