import java.util.ArrayList;
import java.util.Scanner;

/*
 * 670B--Game Of Robots
 */
public class GameOfRobots {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt(),count = 0;
		long k = sc.nextLong();
		int list[] = new int[n];
		for(int j=0;j<n;j++)
			list[j] = sc.nextInt();
		while(count<k)
		{
			k -= count;
			count++;
		}
		System.out.println(list[((int)k-1)]);
	}
}
