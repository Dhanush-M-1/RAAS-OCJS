import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
    
//     public static int gcd(int a,int b){
//         if(a==1 ||b==1)
//         return 1;
//         if(b==0)
//         return a;
//         return gcd(b, a%b);
//     }
//       public static HashMap<Integer,Integer> primeFactors(int n) 
//     { 
//       HashMap<Integer,Integer>  h=new  HashMap<>  ();
//         while (n%2==0) 
//         { 
//             if(h.containsKey(2))
//          h.add(2,h.get(2)+1);
//     else
//     h.put(2,1);
//             n /= 2; 
//         } 
  
//         // n must be odd at this point.  So we can 
//         // skip one element (Note i = i +2) 
//         for (int i = 3; i <= Math.sqrt(n); i+= 2) 
//         { 
//             // While i divides n, print i and divide n 
//             while (n%i == 0) 
//             { 
//                     if(h.containsKey(i))
//          h.add(i,h.get(i)+1);
//     else
//     h.put(i,1);
//                 n /= i; 
//             } 
//         } 
  
//         // This condition is to handle the case whien 
//         // n is a prime number greater than 2 
//         if (n > 2) {
//               if(h.containsKey(n))
//          h.add(n,h.get(n)+1);
//     else
//     h.put(n,1);
         
//         }
//         return h;
//     } 
//   public  static boolean isPowerOfTwo (int x) 
//     { 
//       /* First x in the below expression is  
//         for the case when x is 0 */
//         return x!=0 && ((x&(x-1)) == 0); 
          
//     } 
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in));
        StringBuilder out=new StringBuilder(); 
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
       int t=n;
       ArrayList<Integer> bo=new ArrayList<>();
         ArrayList<Integer> aa=new ArrayList<>();
           ArrayList<Integer> bb=new ArrayList<>();
        while(t-->0){
        st=new StringTokenizer(br.readLine());
     int s=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      if(a==1 && b==1)
      bo.add(s);
      else if(a==0 && b==1)
      bb.add(s);
      else if(b==0 && a==1)
      aa.add(s);
        }
       
        if(aa.size()+bo.size()<k || bb.size()+bo.size()<k)
        {
            out.append(-1);
            
        }else{
            long ans=0;
             int i=0,j=0,l=0;
             int s1=k,s2=k;
             Collections.sort(bo);
              Collections.sort(bb);
               Collections.sort(aa);
             while(i<bo.size() ||j<aa.size()||l<bb.size()){
                 if(s1==0 && s2==0)
                 break;
                 long a1,a2,a3;
                 if(i>=bo.size())
                 a1=Integer.MAX_VALUE;
                 else
                 a1=bo.get(i);
                  if(j>=aa.size())
                 a2=Integer.MAX_VALUE;
                 else
                 a2=aa.get(j);
                  if(l>=bb.size())
                 a3=Integer.MAX_VALUE;
                 else
                 a3=bb.get(l);
                 if(a1<=a2+a3){
                     s1--;s2--;
                     ans=ans+a1;
                     i++;
                 }else{
                     s1--;s2--;
                     ans=ans+a2+a3;
                     j++;l++;
                 }
              //   System.out.println(a1+"*"+a2+"*"+a3+"/"+ans);
             }
             out.append(ans);
        }
       
System.out.println(out);


}
}
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
class SortT implements Comparator<String> 
{ 
   
    public int compare(String a, String b) 
    { 
       
        return a.length() - b.length(); 
    } 
} 