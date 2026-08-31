import java.util.Scanner;
public class Ishu
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int n,i,j,swap,odd=0,even=0,sum=0,sum1=0;
	int[] a=new int[2000];
	n=scan.nextInt();
	for(i=0;i<n;++i)	
		{
		a[i]=scan.nextInt();	
		sum+=a[i];
		if(a[i]%2==1)
			++odd;
		else
			++even;
		}
	for(i=0;i<n;++i)
		for(j=0;j<n-1;++j)
			if(a[j+1]>a[j])
				{
				swap=a[j+1];
				a[j+1]=a[j];
				a[j]=swap;
				}
	if(odd<even)
		even=odd+1;
	else if(odd>even)
		odd=even+1;
	for(i=0;i<n;++i)
		{
		if(odd>0&&a[i]%2==1)
			{
			sum1+=a[i];
			--odd;
			}
		else if(even>0&&a[i]%2==0)
			{
			sum1+=a[i];
			--even;
			}
		}
	sum-=sum1;
	System.out.println(sum);
	}			
}