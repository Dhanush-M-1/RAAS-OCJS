import java.util.*;
 
public class Codeforces{
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int u=0;u<t;u++)
        {
            int n=sc.nextInt();
            int p[]=new int[n];
            int c[]=new int[n];
            int count=0;
            for(int i=0;i<n;i++)
            {
                p[i]=sc.nextInt();
                c[i]=sc.nextInt();
            }
            int P=0;
            int C=0;
            boolean f1=true;
            for(int i=0;i<n;i++)
            {
                if(p[i]<P||c[i]<C||(c[i]-C)>(p[i]-P))
                {
                    f1=false;
                }
                P=p[i];
                C=c[i];
            }
            if(f1)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}