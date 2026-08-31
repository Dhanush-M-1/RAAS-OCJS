import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CompilationErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int sumA = 0;
		for (int i = 0; i < n; i++)
		{
			int a = in.nextInt();
			sumA += a;
		}
		
		int sumB = 0;
		for (int i = 0; i < n-1; i++)
		{
			int b = in.nextInt();
			sumB += b;
		}
		
		int sumC = 0;
		for (int i = 0; i < n - 2; i++)
		{
			int c = in.nextInt();
			sumC += c;
		}
		
		System.out.println(sumA-sumB);
		System.out.println(sumB-sumC);
	}

}
