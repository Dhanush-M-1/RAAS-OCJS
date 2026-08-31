import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;
		int[] a =new int[53];
		Arrays.fill(a,0);
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int su;
			String mrk;
			mrk=scan.next();
			su=scan.nextInt();
			if(mrk.equals("H"))
				su=su+13;
			if(mrk.equals("C"))
				su=su+26;
			if(mrk.equals("D"))
				su=su+39;
			a[su]=1;
		}
		for(int i=1;i<53;i++)
		{
			if(a[i]==1) 
				continue;
			if(i<=13)
				System.out.println("S "+i);
			if(13<i&&i<=26)
				System.out.println("H "+(i-13));
			if(26<i&&i<=39)
				System.out.println("C "+(i-26));
			if(39<i)
				System.out.println("D "+(i-39));
		}
		
	}
}