import java.util.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) {
    Scanner sc= new Scanner(System.in);
    PrintStream w=System.out;
    
    int t = sc.nextInt();
    while(t-->0){
        int n=sc.nextInt();
      int[] ar = new int[n];
      for(int i=0; i<n; i++){
          ar[i]=sc.nextInt();
      }
       if(check(ar,n))
       w.println("YES");
       else
       w.println("NO");
        
    }
    }
    
    static boolean check(int[] ar, int n){
      if(n%2==0)
      {
          for(int i=0; i<n/2; i++){
              if(ar[i]<i || ar[n-i-1]<i)
              return false;
          }
          if(ar[n/2-1]>=n/2 || ar[n/2]>=n/2)
          return true;
          else
          return false;
      }
      else{
          for(int i=0; i<n/2; i++){
              if(ar[i]<i || ar[n-i-1]<i)
              return false;
          }
          if(ar[n/2]>=n/2)
          return true;
          else
          return false;
      }
    }
}