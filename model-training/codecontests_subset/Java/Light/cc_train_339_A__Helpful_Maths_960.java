import java.util.*;

public class HelpfulMaths{
   public static void main(String[] Args){
      Scanner sc = new Scanner(System.in);
      int[] n = new int[3];
      String s = sc.next();
      for(int k =0;k<s.length();k++)
         if(s.charAt(k)!='+')
            n[s.charAt(k)-'1']++;
      boolean x = false;
      int ind = -1;
      while(!x){
         ind++;
         if(n[ind]!=0){
            System.out.print((ind+1));
            x = true;
            n[ind]--;
         }
      }
      while(ind!=3){
         if(n[ind]==0){
            ind++;
         }
         else{
            System.out.print("+"+(ind+1));
            n[ind]--;
         }
      }
      System.out.println();
   }
}
