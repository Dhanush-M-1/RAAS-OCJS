import java.util.*;
public class Codeforces{
 
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {
            long n=sc.nextInt();
            long ans=0;
            int count=0;
            int mvcount=0;
            for(;;)
            {
                if(n%6==0)
                {
                    n/=6;
                    count=0;
                    mvcount++;
                }
                else if(n!=1){
                    n*=2;
                    count++;
                    mvcount++;
                    if(count>3)
                    {
                        ans=-1;
                    }
                }
                if(ans==-1)
                {
                    break;
                }
                if(n==1)
                {
                    ans=mvcount;
                    break;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}