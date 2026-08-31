import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.math.BigInteger;
import java.lang.Math; 

public class Solution {

    

    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
      String s=sc.nextLine();
      ArrayList al=new ArrayList();
       for(int i=0;i<s.length();i++){
         if(s.charAt(i)!='+'){
           al.add(Integer.parseInt(s.charAt(i)+""));
         }
       }
      Collections.sort(al);
       System.out.print(al.get(0));
      for(int i=1;i<al.size();i++){
         System.out.print("+"+al.get(i));
       }
      
     
    }
}
