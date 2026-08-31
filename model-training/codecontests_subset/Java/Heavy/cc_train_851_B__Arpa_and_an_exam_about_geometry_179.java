import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static boolean isStraight(long x1,long y1,long x2,long y2,long x3,long y3)
 {
     long slope1=(y2-y1)*(x3-x2);
     long slope2=(y3-y2)*(x2-x1);
     if(slope1!=slope2)
         return false;
     else
         return true;
 }
 public static void main(String[] args) {
     try{
         Scanner s1 = new Scanner(System.in);
         long x1=s1.nextLong();
         long y1=s1.nextLong();
         long x2=s1.nextLong();
         long y2=s1.nextLong();
         long x3=s1.nextLong();
         long y3=s1.nextLong();
         long dist1=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
         long dist2=(x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
         if((isStraight(x1,y1,x2,y2,x3,y3)) ||(dist1!=dist2))
             System.out.println("No");
         else
             System.out.println("Yes");
     }
     catch(Exception e)
     {}
        
   }
}
