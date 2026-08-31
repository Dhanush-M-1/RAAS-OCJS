import java.util.Scanner;

public class Main
{
	static int[] A;
	
	static boolean isValid()
	{
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == i + 1) return false;
		}
		return true;
	}
	
	public static void main(String[] Arguments)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++)
		{
			A[i] = sc.nextInt();
		}
		int count = 0;
		while (!isValid())
		{
			for (int i = 0; i < A.length - 1; i++)
			{
				if (A[i] == i + 1)
				{
					count++;
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
				}
			}
			if (A[A.length - 1] == A.length)
			{
				count++;
				int temp = A[A.length - 1];
				A[A.length - 1] = A[A.length - 2];
				A[A.length - 2] = temp;
			}
		}
		System.out.println(count);
	}
}
