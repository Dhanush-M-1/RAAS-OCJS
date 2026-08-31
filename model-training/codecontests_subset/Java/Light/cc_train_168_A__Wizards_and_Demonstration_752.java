import java.util.*;
public class Main {
    
 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	     int n = s.nextInt();
         int x = s.nextInt();
         int y = s.nextInt();
         double per = n*1.0*((y*1.0)/100);
         int ans = (int)Math.ceil(per)-x;
         if(ans>0)
         System.out.println(ans);
         else{
             System.out.println("0");
         }
	    }

        

	}