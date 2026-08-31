import java.io.*;
import java.util.*;

public class Solution {
   
     public static void main(String[] args)throws IOException{
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
         int t=Integer.parseInt(br.readLine());
         while(t-->0)
         {
            int n=Integer.parseInt(br.readLine());
            int twoc=0;
            int threec=0;
            while(n%2==0)
            {
                twoc++;
                n=n/2;
            }
            while(n%3==0)
            {
                threec++;
                n=n/3;
            }
            
            if(n==1&&twoc<=threec)
            {
                int ans=threec-twoc+threec;
                bw.write(ans+"\n");
                
            }
            else
            {
                bw.write("-1\n");
            }
            
         }
        bw.close();
       
    }
}