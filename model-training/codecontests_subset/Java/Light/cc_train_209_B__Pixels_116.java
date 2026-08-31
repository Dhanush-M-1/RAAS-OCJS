import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Test {
    public static void main(String[]args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine()," ");
      long arr[]=new long[3];
      arr[0]=Long.parseLong(st.nextToken());
      arr[1]=Long.parseLong(st.nextToken());
      arr[2]=Long.parseLong(st.nextToken());
      Arrays.sort(arr);
      long a=arr[0];
      long b=arr[1];
      long c=arr[2];
      if((b-a)%2==0){
          System.out.print(b);
      }
      else{
          if((c-b)%2==0||(c-a)%2==0){
              System.out.print(c);
          }
      }
       
       
     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
}