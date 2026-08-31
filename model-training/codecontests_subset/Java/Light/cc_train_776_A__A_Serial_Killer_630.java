import java.util.*;

public class killer {

   public static void main (String [] args) {
   
      Scanner sc = new Scanner(System.in);
      String a = sc.next();
      String b = sc.next();
      System.out.println(a+" "+b);
      int N = sc.nextInt();
      for (int k=0; k<N; k++) {
         String t1 = sc.next();
         String t2 = sc.next();
         if (t1.hashCode()==a.hashCode()) 
            a=t2;
         else
            b=t2;
         System.out.println(a+" "+b);
      }
   }
}