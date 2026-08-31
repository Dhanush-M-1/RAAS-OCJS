            import java.util.*;
            import java.lang.*;
            import java.io.*;
            
                public class ProblemA {
           static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
      
                public static void main (String[] args) {
                    PrintWriter pw=new PrintWriter(System.out);
                    Scanner sc=new Scanner(System.in);
                  
                          long n=sc.nextLong();
                          long m=n,s=1;
                        
      
        for (long i = (long)Math.sqrt(n); i >=1; i--) 
        { 
          if(n%i==0){
            /*  int flag=0,i1=2;
                while(i1 <= i/2)
        {
            // condition for nonprime number
            if(i % i1 == 0)
            {
                flag = 1;
                break;
            }
            ++i1;
        }
        if(flag==0)
           {s=i;break;}*/
           if(gcd(i,n/i)==1){
           s=i;
           break;}
          }
        } 
       
                     /* if(a.get(a.size()-1)!=m/a.get(a.size()-1))
                      pw.println(a.get(a.size()-1)+" "+m/a.get(a.size()-1));
                      else
                      pw.println(1+" "+m);*/
                      pw.println(m/s+" "+s);
                    pw.close();
                	}
                }