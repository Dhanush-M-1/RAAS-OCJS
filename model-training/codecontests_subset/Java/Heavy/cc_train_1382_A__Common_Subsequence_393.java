import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
    
    public static int gcd(int a,int b){
        if(a==1 ||b==1)
        return 1;
        if(b==0)
        return a;
        return gcd(b, a%b);
    }
      public static HashMap<Integer,Integer> primeFactors(int n) 
    { 
      HashMap<Integer,Integer>  h=new  HashMap<>  ();
        while (n%2==0) 
        { 
            if(h.containsKey(2))
         h.put(2,h.get(2)+1);
    else
    h.put(2,1);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
                    if(h.containsKey(i))
         h.put(i,h.get(i)+1);
    else
    h.put(i,1);
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) {
               if(h.containsKey(n))
         h.put(n,h.get(n)+1);
    else
    h.put(n,1);
         
        }
        return h;
    } 
   public  static boolean isPowerOfTwo (int x) 
    { 
      /* First x in the below expression is  
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0); 
          
    } 
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in));
        StringBuilder out=new StringBuilder(); 
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
       StringTokenizer st=new StringTokenizer(br.readLine());
       int n=Integer.parseInt(st.nextToken());
       int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        HashSet<Integer> h =new HashSet<>();
       for(int i=0;i<n;i++){
        h.add(Integer.parseInt(st.nextToken()));
       }
               st=new StringTokenizer(br.readLine());
               boolean d=false;
       for(int i=0;i<m;i++){
           int l=Integer.parseInt(st.nextToken());
        if(h.contains(l)){
            out.append("YES\n");
            out.append(1+" "+l+"\n");
            d=true;
            break;
        }
       }
       if(!d)
       out.append("NO\n");
        }
System.out.println(out);


}}
// class Graph 
// { 
//     private int V;   // No. of vertices 
  
//     // Array  of lists for Adjacency List Representation 
//      ArrayList<pair> adj[]; 
  
//     // Constructor 
//     Graph(int v) 
//     { 
//         V = v; 
//         adj = new ArrayList[v]; 
//         for (int i=0; i<v; ++i) 
//             adj[i] = new ArrayList(); 
//     } 
  
//     //Function to add an edge into the graph 
//     void addEdge(int v, int w,int x) 
//     { 
//         adj[v].add(new pair(w,x));
//         adj[w].add(new pair(v,x));// Add w to v's list. 
//     } 
  
//     // A function used by DFS 
// }
// class pair{
//     int x;
//     int y;
//     public pair(int xx,int yy){
//         x=xx;
//         y=yy;
        
//     }
// }
// class SortT implements Comparator<String> 
// { 
   
//     public int compare(String a, String b) 
//     { 
       
//         return a.length() - b.length(); 
//     } 
// } 