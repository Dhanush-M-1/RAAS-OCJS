/*
   Editorial Approach
*/
import java.util.*;
import java.io.*;
public class lp{ 
static PrintWriter out = new PrintWriter(System.out);
static class node
{
    long val;
    int in;
    node(long v,int i)
     {
          val=v;
          in =i;
     }
    node()
      { val=0;in=0;}
}
static long[] lazy;
static node[] tree;
static long max= 10000000000000000l;
static void update(int si, int ss, int se, int us,int ue,long diff){
 
        if (lazy[si] != 0) 
        {
            tree[si].val += lazy[si]; 
            if (ss != se) 
            {
                lazy[si * 2 + 1] += lazy[si]; 
                lazy[si * 2 + 2] += lazy[si]; 
            }
            lazy[si] = 0; 
        } 
 
        if (ss > se || ss > ue || se < us) 
            return; 
        if (ss >= us && se <= ue) 
        { 
            tree[si].val += diff; 
            if (ss != se) 
            { 
                lazy[si * 2 + 1] += diff; 
                lazy[si * 2 + 2] += diff; 
            } 
            return; 
        } 
 
        int mid = (ss + se) / 2; 
        update(si * 2 + 1, ss, mid, us, ue, diff); 
        update(si * 2 + 2, mid + 1, se, us, ue, diff); 
       // tree[si] = Math.min(tree[si * 2 + 1] , tree[si * 2 + 2]);
          if(tree[2*si+1].val< tree[2*si+2].val)
          {
             tree[si].val = tree[2*si+1].val;
             tree[si].in =  tree[2*si+1].in;
          }
        else if(tree[2*si+1].val> tree[2*si+2].val)
          {
             tree[si].val = tree[2*si+2].val;
             tree[si].in =  tree[2*si+2].in;
          }
        else{
                 tree[si].val = tree[2*si+1].val;
                 tree[si].in = Math.max(tree[2*si+1].in ,tree[2*si+2].in);
         }
    } 
static node merge(node n1,node n2)
{
     if(n1.val<n2.val)
         return n1;
     if(n2.val<n1.val)
         return n2;
     else
       {
           if(n1.in>n2.in)
               return n1;
               return n2;
       }
}  
static node get(int l, int r, int ql, int qr, int pos){
        if (lazy[pos] != 0) 
        { 
            tree[pos].val += lazy[pos]; 
            if (l != r) 
            { 
                lazy[pos * 2 + 1] += lazy[pos]; 
                lazy[pos * 2 + 2] += lazy[pos]; 
            } 
            lazy[pos] = 0; 
        } 
        if (l > r || l > qr || r < ql) 
            return new node(max,-1); 

        if (l >= ql && r <= qr) 
            return tree[pos]; 
  
        int mid = (l + r) / 2; 
        node n1 = get(l, mid, ql, qr, 2 * pos + 1);
        node n2 = get(mid + 1, r, ql, qr, 2 * pos + 2); 
         return merge(n1,n2);
}   
static void constructSTUtil(long arr[], int l, int r, int pos){ 
        if (l == r) 
        { 
            tree[pos] =new node(arr[l],l); 
            return; 
        }
        int mid = (l + r) / 2; 
        constructSTUtil(arr, l, mid, 2*pos + 1); 
        constructSTUtil(arr, mid + 1, r, 2*pos + 2); 
        if(tree[2*pos+1].val< tree[2*pos+2].val)
          {
             tree[pos].val = tree[2*pos+1].val;
             tree[pos].in =  tree[2*pos+1].in;
          }
        else if(tree[2*pos+1].val> tree[2*pos+2].val)
          {
             tree[pos].val = tree[2*pos+2].val;
             tree[pos].in =  tree[2*pos+2].in;
          }
        else{
                 tree[pos].val = tree[2*pos+1].val;
                 tree[pos].in = Math.max(tree[2*pos+1].in ,tree[2*pos+2].in);
         }
} 
public static void main(String[] args){

   int n = ni();
   long a[] = al(n);
   tree = new node[4*n];
   lazy = new long[4*n];
   for(int i=0;i<4*n;i++)
      tree[i] = new node();
   int ans[] = new int[n];
   constructSTUtil(a,0,n-1,0);
   for(int i=1;i<=n;i++)
     {
        node n1 = get(0,n-1,0,n-1,0);
       // System.out.println(" in :"+n1.in+" val :"+n1.val+" I :"+i);
        ans[n1.in]=i;
        update(0,0,n-1,n1.in,n-1,-i);
        update(0,0,n-1,n1.in,n1.in,max);
     }
   for(int i=0;i<n;i++)
       p(ans[i]+" ");
   out.flush();
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