import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        int a=0,b,c,diff,e,f,i,n,sum=0,max=0,r;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(i=0;i<n;i++)
        {
            a=sc.nextInt();
            if(max<a)
            {
                max=a;
            }
            sum=a+sum;
            
        }
        b=n*max;
        c=b-sum;
        if(c>sum)
        {
            r=max;
        }
        else
        {
            diff=sum-c;
            e=diff/n;
            f=diff%n;
            /*if(f!=0)
            {
                e=e+1;
            }*/
            
            r=max+e+1;
        }
        System.out.println(r);
     }
}