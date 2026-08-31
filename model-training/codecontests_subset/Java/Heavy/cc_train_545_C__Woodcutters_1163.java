
import java.util.Scanner;

public class WoodCutters {
    public static void main(String asd[])throws Exception
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
        }  
        int c=2,s=2;long x=a[0];
        /*for(int i=1;i<n-1;i++)
        {
            if((a[i]-b[i])>x)
            {
                c+=1;
                x=a[i];
            }
            else if(a[i]+b[i]<a[i+1])
            {
                x=a[i]+b[i];
                c+=1;
            }
        }
        System.out.println(c);*/
        for(int i=1;i<n-1;i++){
		if(a[i]-a[i-1]>b[i])s++;
		else if(a[i+1]-a[i]>b[i]){s++;a[i]+=b[i];}
        }
        System.out.println(n==1?1:s);
        }
    }
