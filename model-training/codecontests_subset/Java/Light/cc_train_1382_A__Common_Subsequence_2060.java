import java.util.*;
import java.io.*;
public class MyClass {
    static PrintStream w;
    public static void main(String args[]) {
      
        Scanner sc = new Scanner(System.in);
         w=System.out;
        
        int t=Integer.parseInt(sc.nextLine());
        
      A: while(t-->0){
          int n=sc.nextInt();
          int m=sc.nextInt();
          int[] ar1=new int[n];
          int[] ar2=new int[m];
          HashSet<Integer> hs = new HashSet<>();
          
          for(int i=0;i<n; i++)
          {ar1[i]=sc.nextInt();
              if(!hs.contains(ar1[i]))
              hs.add(ar1[i]);
              
          }
          for(int i=0;i<m; i++)
          ar2[i]=sc.nextInt();
          
          
          for(int i=0; i<m; i++){
              if(hs.contains(ar2[i])){
                  
              w.println("YES");
              w.println("1 " + ar2[i]);
              continue A;
              }
          }
         
              w.println("NO");
          
        }
    }
    


}