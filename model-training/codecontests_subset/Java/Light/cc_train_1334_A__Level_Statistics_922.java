import java.util.Scanner;

public class lstat
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int n=sc.nextInt();
			int a[][]=new int[n][2];
			for(i=0;i<n;i++)
			{
				a[i][0]=sc.nextInt();
				a[i][1]=sc.nextInt();
			}
			String ans="YES";
			int lpc=a[0][0], lcc=a[0][1];
			if(lpc<lcc)
			{
				System.out.println("NO");
				continue;
			}
			int flag=0;
			int difp=0,difc=0;
			
			for(i=1;i<n;i++)
			{
				if((a[i][0]<lpc)||(a[i][1]<lcc)||(a[i][0]<a[i][1]))
				{
					flag=1;
					ans="NO";
					break;
				}
				difp=a[i][0]-lpc;
				difc=a[i][1]-lcc;
				if(difp<difc)
				{
					ans="NO";
				}
				lpc=a[i][0];
				lcc=a[i][1];
				
			}
			
			System.out.println(ans);
		}
		
	}
}