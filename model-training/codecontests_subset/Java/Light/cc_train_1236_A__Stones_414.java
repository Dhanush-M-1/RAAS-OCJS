import java.io.*;
import java.util.*;
 
  
   
   public   class Solution{
         public static void main (String args[])throws IOException{
             
             BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
              
              
              int  t= Integer.parseInt(ob.readLine());
              while(t --> 0){
                  StringTokenizer st = new StringTokenizer(ob.readLine());
                  
                  int a = Integer.parseInt(st.nextToken());
                  int b = Integer.parseInt(st.nextToken());
                  int c = Integer.parseInt(st.nextToken());
                  
                  int count = 0;
                  boolean ok = true;
                  while(ok){
                         if(c >= 2 && b >= 1){
                             b--;
                             c-=2;
                             count += 3;
                         }else if(b >= 2 && a >= 1){
                             a--;
                             b-=2;
                             count += 3;
                         }else {
                             ok = false;
                         }
                  }
                  System.out.println(count);
              }
         }
     }