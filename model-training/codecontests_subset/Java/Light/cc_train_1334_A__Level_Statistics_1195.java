import java.util.*;
import java.io.*;

public class ProblemA
{
	private static Scanner infile = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int numTestCases = infile.nextInt();
		testCase:for(int c = 1; c <= numTestCases; c++)
		{
			int numMoments = infile.nextInt();
			int[][] moments = new int[numMoments][2];
			for(int i = 0; i < numMoments; i++)
			{
				moments[i][0] = infile.nextInt();
				moments[i][1] = infile.nextInt();
			}
			int numPlays = moments[0][0];
			int numClears = moments[0][1];
			if(numPlays < numClears)
			{
				System.out.println("NO");
				continue testCase;
			}
			for(int i = 1; i < numMoments; i++)
			{
				int newPlays = moments[i][0];
				int newClears = moments[i][1];
				if(numPlays > newPlays || numClears > newClears || (numClears < newClears && numPlays == newPlays) || newPlays < newClears || (newClears - numClears > newPlays - numPlays))
				{
					System.out.println("NO");
					continue testCase;
				}
				numPlays = newPlays;
				numClears = newClears;
			}
			System.out.println("YES");
		}
	}
}