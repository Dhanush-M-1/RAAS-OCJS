import java.util.*;
import java.lang.*;
public class HelloWorld{

     public static void main(String []args){
        //System.out.println("Hello World");
        long n,f_1=1,f_2=1000000,mid=500000,d_1=0,d_2=0;
        long e_2=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextLong();
    //ng a[]=new long[n];
        long a[];
        //MEMORY ALLOCATION FOR LONG ARRAY
        a = new long[1000000];
        for(int i=0;i<n;i++)
        {
            
            a[i]=sc.nextLong();
            if(a[i]<=mid)
            {
               d_1=a[i]-f_1;
            }
            else{
                d_2=f_2-a[i];
                if(d_2>e_2)
                e_2=d_2;
            }
        }
        
        long val=Math.max(d_1, e_2);
        
        System.out.println(val);
        
     }      
}