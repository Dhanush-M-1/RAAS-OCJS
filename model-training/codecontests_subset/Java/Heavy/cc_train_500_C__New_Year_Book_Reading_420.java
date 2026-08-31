import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main
{
    public static void process()throws IOException
    {
        int n=ni(),m=ni(),w[]=new int[n+1],b[]=new int[m+1];
        for(int i=1;i<=n;i++) w[i]=ni();
        for(int i=1;i<=m;i++) b[i]=ni();

        int res=0;

        HashSet<Integer> set = new HashSet<Integer>();
        Deque<Integer> q=new LinkedList<>();

        for(int i=1;i<=m;i++){
            if(!set.contains(b[i])){
                set.add(b[i]);
                q.add(b[i]);
            }
        }

        Deque<Integer> keep=new LinkedList<>();
        for(int i=1;i<=m;i++){
            Integer book=q.poll();
            int top=b[i];

            while(book!=b[i]){
                keep.add(book);
                res+=w[book];
                book=q.poll();
            }

            while(!keep.isEmpty()){
                Integer x=keep.pollLast();
                q.addFirst(x);
            }

            q.addFirst(top);//System.out.println(q);
        }

        pn(res);
    }
 
 
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new FastReader();
 
        long s = System.currentTimeMillis();
        int t=1;
       // t=ni();
        while(t-->0)
            process();
 
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }
    
    
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static int ni()throws IOException{return Integer.parseInt(sc.next());}
    static long nl()throws IOException{return Long.parseLong(sc.next());}
    static double nd()throws IOException{return Double.parseDouble(sc.next());}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    
    static long mod=(long)1e9+7l;
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}