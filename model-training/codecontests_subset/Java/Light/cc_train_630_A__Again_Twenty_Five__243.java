import java.io.*;
import java.util.*;
import java.lang.Math;
public class HelloWorld{

     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
       Long t=sc.nextLong();
       int ans=0;
       if(t==0)
       ans=1;
       else if(t==1)
       ans=2;
       else if(t>1)
       ans=25;
       System.out.println(ans);
     }
}