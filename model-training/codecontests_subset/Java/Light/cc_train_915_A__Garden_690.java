import java.util.Scanner;


public class Main{
	public static void main(String args[])
	{
		
		
		Scanner scan=new Scanner(System.in);
		int ar[]=new int[102];
		
		int aa=scan.nextInt();
		int bb=scan.nextInt();
		for(int i=0;i<aa;i++)
		{
			ar[i]=scan.nextInt();
		}
		
		
		for(int i=0;i<aa;i++)
		{
			for(int j=i+1;j<aa;j++)
			{
				
				if(ar[i]<ar[j])
				{
				int temp=ar[i];
				 ar[i]=ar[j];
				 ar[j]=temp;
				}
				
			}
		}
		
		
		int cnt=0;
		for(int i=0;i<aa;i++)
		{
			if(bb%ar[i]==0)
			{
				cnt=bb/ar[i]; break;
			}
		}
		
		System.out.println(cnt);
		
	}

}
