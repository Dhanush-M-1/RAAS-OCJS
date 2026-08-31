import java.util.Scanner;

public class woodcutter {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] trees = new int[N][2];
//		int[][] num = new int[N][3];
		for(int i = 0; i < N; i++)
		{
			trees[i][0] = sc.nextInt();
			trees[i][1] = sc.nextInt();
		}
//		
//		num[0][0] = 1;
//		num[0][1] = 0;
//		if(N > 1 && trees[0][0]+trees[0][1] < trees[1][0])
//			num[0][2] = 1;
//		
//		for(int j = 1; j < N-1; j++)
//		{
//			
//		}
		int count = 0;
		int right = trees[0][0];
		for(int j = 1; j < N-1; j++)
		{
			int x = trees[j][0];
			int h = trees[j][1];
			if(x-h > right)
			{
				count++;
				right = x;
			}
			else if(x+h < trees[j+1][0])
			{
				count++;
				right = x+h;
			}
			else
			{
				right = x;
			}
		}
		if(N > 1)
			count+=2;
		else
			count++;
		System.out.println(count);
	}
}