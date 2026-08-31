import java.io.*;
import java.util.*;

public class amit{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
       String s=br.readLine();
       int a=0,count=0;
       for(int i=0;i<n;i++)
       {
           char c=s.charAt(i);
           a=Integer.parseInt(c+"");
           if(a==8)
           count++;
       }
       int m=n/11;
       System.out.println(m<count?m:count);
           }
}