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
    int n,count=0;
     n=sc.nextInt();
    String s=sc.next() ;
      for (int i=0;i<n ;++i) {
            if(s.charAt(i)=='8')
              ++count ;
       } 
      if(count<=n/11)
          pr.println(count);  
     else
        pr.println(n/11);
        
  }
  
}