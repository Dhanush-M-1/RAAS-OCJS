import java.io.*;
import java.util.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      new Solution().run();
   }
   
   void run() throws IOException
   {
      Scanner in = new Scanner(System.in);
    
      int n = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      
      int c_a = 2*n;
      int c_b = n;
      int c_c = n/2;
      
      //fix third parametr
      
      int V = 0;
      int max = n/2;
      if(max>c){
          max = c;
      }
      
      long ans = 0; //колво способов
      
      //max -- макс колво 2л
      
      for(int i =0; i<=max; i++){
          V = n - 2*i;
          
          int y = V;
          int x = 0;
          if(y > b){
              x = 2*(y-b);
              y = b;
              
          }
          //сколько можно отнять от y? столько и добавить
          
          if((x <= a)&&(x>=0)){
              ans++;
              int may = (a-x)/2;
              
              if(may > y){
                  may = y;
              }
              
              ans += may;
              //if()
              //System.out.println(V + " " +ans +" "+ x+" "+y+" "+i);
          }
          
      }
      
      System.out.print(ans+"");
   }
}