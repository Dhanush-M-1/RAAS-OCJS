        import java.util.*;
        import java.io.*;
        import java.lang.*;
        import java.math.*;
        
         
         
        public class test2{
           public static boolean cp(int a) {
              for(int j=2;j*j<=a;j++)
              {
                 if(a%j==0)
                 {
                    return false;
                 }
              }
              return true;
           }
  public static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    // method to return LCM of two numbers 
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
          public static void main (String [] args) throws IOException
          {
           
        	  
        	  try {
        		  Scanner sc=new Scanner(System.in);
        		  
        		     int t=sc.nextInt();
        		     
        		     
        		     
        		     for(int i=0;i<t;i++)
        		     {
        		       int n=sc.nextInt();
        		       int m=sc.nextInt();
        		       
        		       int[] a=new int[10000];
        		       int[] b=new int[10000];
        		       
        		       boolean flag=false;
        		       int ans=0;
        		       for(int j=0;j<n;j++)
        		       {
        		          a[sc.nextInt()]=1;
        		       }
        		       for(int j=0;j<m;j++)
        		       {
        		          int temp=sc.nextInt();
        		          b[temp]=1;
        		         
        		          
        		          if(a[temp]==1 && flag==false)
        		          {
        		             ans=temp;
        		             flag=true;
        		          }
        		       }
        		       if(flag)
        		       {
        		           System.out.println("YES");
        		          System.out.println("1 "+ans);
        		       }
        		       
        		       else
        		       {
        		          System.out.println("NO");
        		       }
        		       
        		       
        		      
        		     }
        		     
        		     
        		     
        		     
        		  }
                  
        	  	 
        	  
        	  catch (Exception e) {
        		return;
        	}
         
        }
         
        }  