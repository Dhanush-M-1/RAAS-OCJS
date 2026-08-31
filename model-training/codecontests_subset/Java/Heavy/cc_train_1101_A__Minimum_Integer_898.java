import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class j19 {
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
   while(n-->0){
          st = new StringTokenizer(br.readLine());
          int l = Integer.parseInt(st.nextToken());
          int r = Integer.parseInt(st.nextToken());
          int d = Integer.parseInt(st.nextToken());
          int res = -1;
          if(d<l){
              res = d;
          }
          else{
              int temp = r/d;
              res = (temp+1)*d;
          }
          System.out.println(res);
      }
   }
}