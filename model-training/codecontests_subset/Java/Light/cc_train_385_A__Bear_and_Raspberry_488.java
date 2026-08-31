import java.util.*;
public class S 
{       

         public static void main(String [] args)
         {
               Scanner obj = new Scanner(System.in);
               
               	    int n = obj.nextInt();
               	    int c = obj.nextInt();
               	    int [] a =new int[n];
               	   for(int i=0;i<n;i++)
               	  	  a[i] = obj.nextInt();
                    int max = Integer.MIN_VALUE;
                    int sum=0;
                     int req=0;
                    for(int i=0;i<n-1;i++)
                    {
                    	if(a[i]>a[i+1])
                         {
                         	sum=a[i]-a[i+1]-c;
                         	if(sum>max&&sum>0)
                         	{
                         		max=sum;
                         		req=max;
                         	}
                         }

                    }

                    System.out.println(req);


          
        }
}