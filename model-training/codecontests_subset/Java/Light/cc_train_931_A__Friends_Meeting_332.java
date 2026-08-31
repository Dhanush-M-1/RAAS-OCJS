import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] argv) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    
    int a = Math.min(n1,n2);
    int b = Math.max(n1,n2);
    
    int origA = a , origB = b;
    
    while(true){
       a++;
       if(a==b){
           System.out.println(fac(a-origA)+fac(origB-b));
           break;
       }
       b--;
       if(a==b){
           System.out.print(fac(a-origA)+fac(origB-b));
           break;
       }
    }
          
  }
  
  public static int fac(int n){
      int ans = 0;
     
      if(n==1)
        return 1;
      else if(n==0)
        return 0;
      
      ans = fac(n-1) + n;
          
      return ans;
  }
}