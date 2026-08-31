import java.util.*;
public class Modulo 
{
	public static void main(String[] args)
	{
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int m=s.nextInt();
	int a[]=new int[n];
	int k[]=new int[n];
	 int b[]=new int[n];
 	int x=0;
	int ans=0;
 	for(int i=0;i<n;i++)
	{
	a[i]=s.nextInt();
	k[i]=a[i];
	}
        for(int i=0;i<n;i++)
	b[i]=s.nextInt();
	for(int i=0;i<n;i++)
	{
	if(b[0]-a[i]>=0)
	x=b[0]-a[i];
	else
	x=Math.max(0,m-a[i])+b[0];
	for(int j=0;j<n;j++)
	k[j]=a[j];
	for(int j=0;j<n;j++)
	k[j]=(k[j]+x)%m;
	Arrays.sort(b);
	Arrays.sort(k);
	boolean bl=true;
	for(int j=0;j<n;j++)
	{
	if(k[j]!=b[j])
	bl=false;
	}
	if(bl)
	ans=x;
	
	
	
	}
	System.out.println(ans);
	}
}
