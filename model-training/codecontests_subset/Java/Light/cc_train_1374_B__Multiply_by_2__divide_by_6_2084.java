import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution {
    public static void main(String[] args)throws IOException {
        
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk;    
    
   int t=Integer.parseInt(br.readLine());
   
   for(int test=0;test<t;test++)
   {
        tk=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(tk.nextToken());
        
        int count3=0;
        while(n>0 && n%3==0)
        {
            count3++;
            n=n/3;
            
        }
        
        int count2=0;
        while(n>0 && n%2==0)
        {
            count2++;
            n=n/2;
        }
        
        if(n>1)
        {
            System.out.println("-1");
        }
       else
        {
            
            if(count3<count2)
            {
                System.out.println("-1");
            }
            else
            {
                int ans= (count3-count2) +count3;
                System.out.println(ans);
            }
            
        }
       
   }
  
  
      
    
 }
 
}
 