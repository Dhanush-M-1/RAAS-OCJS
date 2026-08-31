import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays; 


public class Solution {
    
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
       
        String s = sc.next();
        int freq[] = new int[4];
        String snew = "";
        char ch=' ';
        
        if(s.length()==1) 
        snew = s;
        else {
        for(int i=0; i<s.length(); i++) 
        {
             if(i%2 != 0) continue;            
             
             ch = s.charAt(i);
             ++freq[Integer.valueOf(String.valueOf(ch))];
         }
         for(int i = 1; i <= 3; i++) 
         {
               if(freq[i]==0) continue;
              for(int j = 1; j <= freq[i]; j++)
              {
              snew = snew + String.valueOf(i) + "+";
         }
         }
         snew = snew.substring(0,(snew.length()-1));
        }
         
         System.out.println(snew);
         
    }
}
         