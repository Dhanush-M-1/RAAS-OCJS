import java.util.*;
public class Sol
{
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=1,j=1000000;
        int a[]=new int[n];
        int k=0,cnt=0,max=-1,min=0;
        for(k=0;k<n;k++)
            a[k]=sc.nextInt();
        for(k=0;k<n;k++)
        {
            if(a[k]-1<1000000-a[k])
                min=a[k]-1;
            else
                min=1000000-a[k];
            if(max<min)
                max=min;
        }
        System.out.println(max);
	}
}