import java.util.*;
import java.io.*;
public class lp{ 
static PrintWriter out = new PrintWriter(System.out);
static long max = 10000000000000l;

static boolean ok(long mid,long s,long t,int g[])
{
     int prev=0;
     long tt=0;
     for(int i=0;i<g.length;i++)
        {
          long d =g[i]-prev;
          if(d>mid)
             return false; 
          long fast_mode = Math.min(d,mid-d);
          long slow_mode = d-fast_mode;
           tt = tt + fast_mode + slow_mode*2; 
    
           prev = g[i];
        }
           long d =s-prev;
          if(d>mid)
             return false; 
          long fast_mode = Math.min(d,mid-d);
          long slow_mode = d-fast_mode;
           tt = tt + fast_mode + slow_mode*2; 
       if(tt<=t)
           return true;
           return false;
}
static void solve() throws Exception{

int n = ni();
int k = ni();
long s = nl();
long t = nl();
int c[] = new int[n];
int v[] = new int[n];
for(int i=0;i<n;i++)
{
    c[i] = ni();
    v[i] = ni();
}
int g[] = ai(k);

Arrays.sort(g);
long l=0,r=max;
while((r-l)>1)
{
   long mid = (l+r)/2;
   if(ok(mid,s,t,g))
       r=mid;
   else
       l=mid;
}
long price= max;

for(int i=0;i<n;i++)
       if(v[i]>=r)
         price = Math.min(price,c[i]);
  if(price==max)
     price=-1;
  pn(price);

   out.flush();
}
public static void main(String[] args){

// use this block when you need more recursion depth
new Thread(null, null, "Name", 99999999) {
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
static int[] ai(int n)  // it will give in array of size n
{
    int a[] = new int[n];
    for(int i=0;i<n;i++)
        a[i] = ni();
    return a;
}
static long[] al(int n)  // it will give in array of size n
{
    long a[] = new long[n];
    for(int i=0;i<n;i++)
        a[i] = nl();
    return a;
}
 
static void p(Object o)
{
   out.print(o);
}
static void pn(Object o)
{
    out.println(o);
}
static int abs(int x)
{
    return x>0 ? x : -x;
}
static long gcd(long a,long b)
{
       if(b%a==0)
          return a;
          return gcd(b%a,a);
}
static int count_set(int n)
{
   int c=0;
while(n>0)
{
   if(n%2==1)
     c++;
     n=n/2;
}
   return c;
}
static void subtract_1(char s[]) // it will subtract 1 from the given number.  number should be positive
{
      if(s[0]=='0') // number is zero
          return;
     int n = s.length,i=n-1;
     while(s[i]=='0')
       i--;
     s[i] = (char)((int)(s[i]-'0') + 47);
   
     for(int j=i+1;j<n;j++)
         s[j]='9';
}
static long pow(long a,long b,long md)
{ 
    long ans=1;
    while(b>0)
    {
         if(b%2==1)
           ans = (ans*a)%md;
           a = (a*a)%md;
           b = b/2;
    }
   return ans;
}
static long min(long a,long b){
 
     return a<b ? a : b;
}
static long max(long a,long b){
     return a>b ? a : b;
}
static boolean pal(String s)
{
   int n = s.length(),i1=0,i2=n-1;
 
     while(i1<i2)
     {
        if(s.charAt(i1)!=s.charAt(i2))
             return false;
             i1++; i2--;
     }
       return true;
}
static String rev(String r)
{
    String s = "";
    int i= r.length()-1;
 
    while(i>=0)
    {
        s=s+r.charAt(i);
        i--;   
    }
       return s;
}
static FastReader sc=new FastReader(); 
 
      static int ni(){
                 int x = sc.nextInt();
                 return(x);
        }
      static long nl(){
              long x = sc.nextLong();
              return(x);
         }
      static String n(){
                 String str = sc.next();
                     return(str);
       }
     static String ns(){
                 String str = sc.nextLine();
                   return(str);
      }
     static double nd(){
               double d = sc.nextDouble();
                 return(d);
       }
  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
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
    } 
}