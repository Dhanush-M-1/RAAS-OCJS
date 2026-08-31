import java.io.*;
import java.lang.*;
import java.util.*;

 public class Main{
  
 public static void main(String args[]){
   
  Scanner s = new Scanner(System.in);
   
   int x =s.nextInt();
  s.nextLine();
   int ac=0,wa=0,tle=0,re=0;
   while(x-- >0){
       String g = s.nextLine();
     if(g.equals("AC"))
       ac++;
     else if(g.equals("WA"))
       wa++;
     else if(g.equals("TLE"))
       tle++;
     else if(g.equals("RE"))
       re++;
         
   }
   
   System.out.println("AC x "+ac);
   System.out.println("WA x "+wa);
   System.out.println("TLE x "+tle);
   System.out.println("RE x "+re);
 }
  
}