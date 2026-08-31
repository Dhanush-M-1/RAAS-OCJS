import java.lang.*;
import java.util.*;
import java.io.*;
public class test
{  
  Scanner sc=new Scanner(System.in);
  PrintWriter pr=new PrintWriter(System.out,true);
  public static void main(String... args) 
  {
       test c=new test();
       c.prop();
  }
  public void prop() 
  {
    int a,b,c;
    a=sc.nextInt();
    b=sc.nextInt();
     c=a-b ;
       if(c<0)
        c=-1*c ;
      if(c%2==0)
      {
        c=c/2 ;
         c=c*(c+1) ;
      }else
      {
        c=c-1 ;
        c=c/2 ;
        c=c*(c+1)+(c+1) ;
      }
       pr.println(c) ;   

  }
}