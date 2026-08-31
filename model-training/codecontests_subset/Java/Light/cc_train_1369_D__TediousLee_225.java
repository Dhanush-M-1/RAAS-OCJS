import java.util.*;
import java.lang.*;
import java.io.*;

//run without debug: ctrl+a
//clear terminal: ctrl+space

public class D_TediousLee
{   

     public static void main(String[] args) throws java.lang.Exception 
    {

          Scanner s = new Scanner(System.in);
          long t = s.nextLong();
          List<Long>dp=new ArrayList();
          dp.add(0,(long)0);
          dp.add(1,(long)0);
          dp.add(2,(long)0);
          dp.add(3,(long)4);
          long M=1000000007;
          for(int i=4;i<=2000005;i++)
          {
                long a1=dp.get(i-1)+2*dp.get(i-2)+((i%3==0)?(long)4:(long)0);
                a1%=M;
                dp.add(i,a1);
          }

          while (t-- > 0) {
                long n=s.nextLong();
               
            long ans=0;
            System.out.println(dp.get((int)n));

            

       }     
	}
}