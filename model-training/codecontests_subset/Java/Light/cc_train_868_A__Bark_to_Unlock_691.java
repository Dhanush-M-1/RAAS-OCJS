import java.util.Scanner;

public class BarktoUnlockk {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String pwd=scan.next();
		int n=scan.nextInt();
		String[] words = new String[n];
		for(int i=0;i<n;i++)
		{
			words[i]=scan.next();
		}

		for(int k=0;k<n;k++)
		{
			for(int j=0;j<n;j++)
			{
				String conct=words[k]+words[j];
				if(conct.contains(pwd))
				{
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
}