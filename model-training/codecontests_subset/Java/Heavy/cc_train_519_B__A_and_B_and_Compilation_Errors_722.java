import java.util.Arrays;
import java.util.Scanner;

public class ABCompilationError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();

		Arrays.sort(a);

		int[] b = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			b[i] = in.nextInt();
		
		Arrays.sort(b);
		
		boolean f = false;
		for (int i = 0; i < n-1; i++)
			if (a[i] != b[i])
			{
				if (b[i] == a[i+1])				
					System.out.println(a[i]);
				else									
					System.out.println(b[i]);
				f = true;				
				break;
			}
		if (!f)
			System.out.println(a[n-1]);	
		f=false;
		int[] c = new int[n-2];
		for (int i = 0; i < n-2; i++) 
			c[i] = in.nextInt();		
		Arrays.sort(c);
		for (int i = 0; i < n-2; i++)
			if (b[i] != c[i])
			{
				if (c[i] == b[i+1])
					System.out.println(b[i]);
				else
					System.out.println(c[i]);
				f = true;
				break;
			}

		if (!f)
			System.out.println(b[n-2]);	
	}
		
}
