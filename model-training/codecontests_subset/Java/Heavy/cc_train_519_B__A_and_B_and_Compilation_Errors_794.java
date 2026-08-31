import java.util.*;
public class ABCError {

	private static Scanner s;
	public static void main(String[] args)
	{
		s=new Scanner(System.in);
		int n=s.nextInt();
		s.nextLine();
		String[] val_A=s.nextLine().split(" ");
		String[] val_B=s.nextLine().split(" ");
		String[] val_C=s.nextLine().split(" ");
		long[] A=new long[n];
		long[] B=new long[n-1];
		long[] C=new long[n-2];
		for(int i=0;i<n;i++)
			A[i]=Integer.parseInt(val_A[i]);
		for(int i=0;i<n-1;i++)
			B[i]=Integer.parseInt(val_B[i]);
		for(int i=0;i<n-2;i++)
			C[i]=Integer.parseInt(val_C[i]);
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		finddiff(A,B);
		finddiff(B,C);
	}
	private static void finddiff(long[] x, long[] y) {
		int a=0;
		for(int i=0;i<y.length;i++)
		{
			if(x[i]!=y[i])
			{
				a=1;
				if(y[i]==x[i+1])
					System.out.println(x[i]);
				else
					System.out.println(y[i]);
				break;
			}
		}
		if(a==0)
			System.out.println(x[x.length-1]);
		
	}
}
