import java.util.*;
public class Main
{
    public static void main(String as[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int t=0;t<T;t++)
        {
            int n=sc.nextInt(),count=0,f=1;
            while(n>1)
            {
                if(n%3!=0){
                 f=0;
                 break;
             } 
             if(n%6==0)
             {
                 n=n/6;
                 count++;
             }
             else {
                 n=n*2;
                 count++;
             }
             
            }
            if(f==1) System.out.println(count);
            else System.out.println(-1);
            
        }
            
    }
}