import java.util.Scanner;

public class Main
{
	static int selectionSort(int A[], int n)
	{
		int ret = 0;
		for (int i = 0; i < n; i++)
		{
			int minj = i;
			for (int j = i; j < n; j++)
			{
				if(A[j] < A[minj])
				{
					minj = j;
				}
			}
			if(minj != i)
			{
				int temp = A[i];
				A[i] = A[minj];
				A[minj] = temp;
				++ret;
			}
		}
		return ret;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			A[i] = sc.nextInt();
		}
		int ans = selectionSort(A, n);
		for (int i = 0; i < n; i++)
		{
			System.out.print(A[i]);
			if(i < n - 1)
			{
				System.out.print(" ");
			}
		}
		System.out.println("\n" + ans);
		sc.close();
	}
}
