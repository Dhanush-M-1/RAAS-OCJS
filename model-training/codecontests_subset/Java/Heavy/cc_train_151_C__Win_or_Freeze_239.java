import java.io.*;
import java.util.*;


  public class Solution {

      static List<Long>primess = new ArrayList<>();
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          long x = sc.nextLong();
          long y = x;
          seive(3162278);
          int cnt = 0;
          long div = 1;


          for(int pos = 0 ; primess.get(pos) * primess.get(pos) <= x ; pos++){

              while (x % primess.get(pos) == 0){
                  if(cnt == 2) {
                      System.out.println(1);
                      System.out.println(div);
                      return;
                  }
                  cnt++;
                  div*= primess.get(pos);
                  x /= primess.get(pos);
              }
          }

          if(x > 1){
              if(cnt == 2) {
                  System.out.println(1);
                  System.out.println(div);
                  return;
              }
              cnt++;
              div*= x;
          }

          if(cnt == 2)
              System.out.println(2);
          else{
              System.out.println(1);
              System.out.println(0);
          }
      }



      public static void seive(int n){
          boolean[] s = new boolean[n+1];
          s[0] = true;
          s[1] = true;
          for(int i=2 ; i*i <= n ; i++){
              if(!s[i]){
                  for (int j = i*i ; j<=n ; j+=i){
                      s[j] = true;
                  }
              }
          }
          for(int i=2 ; i<=n ; i++){
              if(!s[i]){
                  primess.add((long)i);
              }
          }
      }

  }


