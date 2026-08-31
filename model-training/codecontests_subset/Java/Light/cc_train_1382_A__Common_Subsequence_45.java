import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 public class First {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
       int t=  Integer.parseInt(br.readLine());
        while(t-->0) {
           HashSet<Integer> hset = new HashSet<Integer>();        
           String no=  br.readLine();
           String [] m =  br.readLine().split(" ");
           String [] n =  br.readLine().split(" "); 
           int ans=-1;
           for(int i=0;i<m.length;i++){ hset.add(Integer.parseInt(m[i]));}
           for(int i=0;i<n.length;i++){
              if( hset.contains(Integer.parseInt(n[i]))) {
                  ans = Integer.parseInt(n[i]);
                  break;
              }
           }
           if(ans==-1) System.out.println("NO");
           else {System.out.println("YES");
               System.out.println("1 "+ans);
           }
           
        }
    }
}