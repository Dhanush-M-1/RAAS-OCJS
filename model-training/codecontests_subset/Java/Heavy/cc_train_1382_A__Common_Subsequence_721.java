import java.util.*;
public class No {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int s=sc.nextInt();
			int l=sc.nextInt();
			int ar[]=new int[s];
			int arr[]=new int[l];
			for(int i=0;i<s;i++)
				ar[i]=sc.nextInt();
			for(int j=0;j<l;j++)
				arr[j]=sc.nextInt();
			int g=0;
			for(int i=0;i<ar.length;i++)
			{
				for(int j=0;j<arr.length;j++)
				{
					if(ar[i]==arr[j])
					{
						System.out.println("YES");
						System.out.println(1+" "+ar[i]);
						g=1;
						break;
					}
					
				}
				if(g==1)
					break;
			}
			if(g==0)
				System.out.println("NO");
		}

	}

}