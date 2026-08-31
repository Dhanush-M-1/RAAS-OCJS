
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       while(t-->0){
           int n2 =0,n3=0;
           int n = sc.nextInt();
          // System.out.println(n); 
          while (n % 2 == 0) {
			n /= 2;
			++n2;
		}
         // System.out.println(n);
		while (n % 3 == 0) {
			n /= 3;
			++n3;
		}
		// System.out.println(n);
          
           if(n==1 && n2<=n3){
               System.out.println((n3-n2)+n3);
           }
           else {
        	   System.out.println(-1);
           }
          // System.out.println(n2+" "+n3);
       }
    }
   
}