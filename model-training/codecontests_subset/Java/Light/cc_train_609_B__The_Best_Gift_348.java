import java.util.HashMap;
import java.util.Scanner;

public class TheBestGift609B {
	private static Scanner in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);		
		int numOfBooks = in.nextInt();
		int numOfGenres = in.nextInt();		
		int[] map = new int[numOfGenres];
		
		int value;
		
		for (int i = 0; i < numOfBooks; i++)
		{
			value = in.nextInt();
			map[value - 1] = map[value - 1] + 1;
		}
		
		int result = 0;
		
		for (int j = 0; j < numOfGenres; j++)
		{
			for (int k = j + 1; k < numOfGenres; k++)
			{
				result = result + (map[j] * map[k]);
			} 
		}
		
		System.out.println(result);
	}

}
