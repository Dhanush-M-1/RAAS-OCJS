import java.util.*;
public class Main {
	static final int maxn=(int)4e5+10;
	static int a[]=new int [maxn];
	static int indexnum[]=new int [maxn];
public static void main(String args[])
{
	//System.out.println(1);
	Scanner input=new Scanner(System.in);
	int t=input.nextInt();
	while(t-->0)
	{
		int n=input.nextInt();
		for(int i=1;i<=n;i++)
			a[i]=input.nextInt();
		if(a[1]==a[n])
		{
			System.out.println(0+" "+0+" "+0);
			continue;
		}
		int num=a[n/2];
		int r=n/2;
		if(a[n/2]==a[n/2+1])
		{
			for(int i=n/2-1;i>=1;i--)
			{
				if(a[i]==num)r=i;
				else
					{r=i;break;}
			}
			
		}
		for(int i=1;i<=n/2;i++)
			indexnum[i]=0;
		int prenum=a[1];indexnum[1]=1;int index=1;
		for(int i=2;i<=r;i++)
		{
			if(a[i]!=prenum)
			{
				prenum=a[i];index++;indexnum[index]=1;
			}
			else
				indexnum[index]++;
		}
		//for(int i=1;i<=index;i++)
		//	System.out.print(indexnum[i]+" ");
		//System.out.println(r);
		int k1=0,k2=0,k3=0;
		k1=indexnum[1];int sum=0;
		for(int i=2;i<=index;i++)
		{
			sum+=indexnum[i];
			if(sum>k1)
				{
				    k2=sum;k3=r-k1-sum;
				    break;
				}
		}
		if(k1>=k2||k1>=k3)
		{
			System.out.println(0+" "+0+" "+0);
			continue;
		}
		if(k2==0||k3==0)
		{
			System.out.println(0+" "+0+" "+0);
			continue;
		}
		System.out.println(k1+" "+k2+" "+k3);
		}
	}
	
}

  	 		   			 		 	 	  		  		  		