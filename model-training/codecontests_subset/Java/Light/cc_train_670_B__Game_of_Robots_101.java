import java.util.ArrayList;
import java.util.Scanner;

/*
 * 670B--Game Of Robots
 */
public class GameOfRobots {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		long k = sc.nextLong();
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j=0;j<n;j++)
			list.add (sc.nextInt());
		while(count<k)
		{
			k -= count;
			count++;
		}
		System.out.println(list.get((int)k-1));
	}
}
