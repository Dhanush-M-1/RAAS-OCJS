import java.util.Scanner;
public class CF615A {
	
	public static void main(String[] agrs)
	{
		int[] num = new int[105];
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(),cnt = 0;
		for(int i=0; i<n; i++)
		{
			int k = scan.nextInt();
			for(int j=0; j<k; j++)
			{
				int a = scan.nextInt();
				if(num[a]==0)
					cnt++;
				num[a]=1;
			}
		}
		if(cnt==m)
			System.out.println("YES");
		else
			System.out.println("NO");
		scan.close();
	}
}
