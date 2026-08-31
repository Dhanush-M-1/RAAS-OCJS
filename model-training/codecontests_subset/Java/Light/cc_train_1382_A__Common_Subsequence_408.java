import java.util.*;
import java.lang.*;
import java.io.*;
public class Subse {
   public static void main (String[]args) {
   
      Scanner it = new Scanner (System.in);
      int a = it.nextInt();
      it.nextLine();
      String[] num = new String[a];
      String [] ans = new String [a];
     
      for (int x =0; x< a; x++) {
          boolean ind = false;

         int nLen = it.nextInt();
         it.nextLine();
         String [] mS = it.nextLine().split(" ");
         String [] nS = it.nextLine().split(" ");
      
         for (int y = 0; y < mS.length; y++) {
         if (ind){
         break;
         }
            for (int z = 0; z < nS.length; z++) {
               if (mS[y].equals(nS[z])) {
                  ind = true;
                  num[x] = mS[y];
                  break;
               }
            }
         }
         
         if (ind) {
            ans[x] = "YES";
         }
         else {
            ans[x] = "NO";
            num[x] = "-1";
         }
         
         
      
      }
      
      for (int u = 0; u < ans.length; u++) {
      if (ans[u].equals("YES")) {
         System.out.println(ans[u]);
         System.out.println("1 " + num[u]);
         }
         else {
         System.out.println(ans[u]);
         }
      }
   
   }

}