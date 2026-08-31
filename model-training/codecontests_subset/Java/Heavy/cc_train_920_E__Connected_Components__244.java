import java.io.*;
import java.util.*;
public class s
{ 
static PrintWriter out = new PrintWriter(System.out);


public static void main(String[] args){
 
            int n = ni();
            int m = ni();
            HashSet<Long> edge = new HashSet();
            
             for(int i=0;i<m;i++){
                    int u=ni()-1;
                    int v=ni()-1;
                     if(u>v){ int t=u;u=v;v=t;}
                     long k = (long)(n)*(long)(u)+v;
                    edge.add(k);
             }
          TreeSet<Integer> vertices = new TreeSet();
          Queue<Integer> queue = new LinkedList(); 
          boolean visit[] = new boolean[n];
          ArrayList<Integer> toDelete = new ArrayList<Integer>();
          int count[] = new int[n];
          int cur=0;
          for(int i=0;i<n;i++)
             vertices.add(i);
         
         for(int i=0;i<n;i++){ 
        
               if(visit[i])
                   continue;
                vertices.remove(i); visit[i]=true;  queue.add(i);
                count[cur]++;
                   while(queue.size()>0){
                        int s = queue.poll();
                        
                        for(Integer I: vertices){
                             if(visit[I]) continue;
                             long k = (long)(n)*(long)Math.min(s,I)+Math.max(s,I);
                             if(!edge.contains(k)){
                                 toDelete.add(I);
                                 queue.add(I);
                                 visit[I]=true;
                                 count[cur]++;
                            }
                        }
                       for(Integer I : toDelete)
                         vertices.remove(I);
                          toDelete.clear();
                   }
                  
                         cur++;
        }
         Arrays.sort(count,0,cur);
         out.println(cur);
         for(int i=0;i<cur;i++)
            out.print(count[i]+" ");
      out.flush();
}
 
static long mod = 1000000007;
static void fact(long a[]){
         a[0]=1;
         for(int i=1;i<a.length;i++)
                a[i] = (i*a[i-1])%mod;
}
static long gcd(long a,long b){
 
  if(b%a==0) return a;
  return gcd(b%a,a);
}
static long pow(long a,long b,long mod){
 
long ans=1;
while(b>0){
if(b%2==1)
    ans = (ans*a)%mod;
    b=b/2;
    a=(a*a)%mod;
}
   return ans;
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