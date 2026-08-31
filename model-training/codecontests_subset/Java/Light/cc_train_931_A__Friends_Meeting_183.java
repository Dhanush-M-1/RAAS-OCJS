import java.io.*;
import java.util.*;
public class HelloWorld{

     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int a=sc.nextInt();
         int b=sc.nextInt();
         int ans=Math.abs(a-b)/2;
         if(Math.abs(a-b)%2==0)
          System.out.println(ans*(ans+1));
          else
           System.out.println((ans+1)*(ans+1));
         
     }
}