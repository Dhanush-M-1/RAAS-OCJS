import java.util.*;
public class median
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String word = s.next();
		char[] word_array = word.toCharArray();

		char current;
		char next = word_array[0];

		int[][] frequency = new int[26][26];
		int max = 0;
		int current_frequency = 0;
		String answer = "";

		for(int i = 0; i < n - 1; i++)
		{
			current = next;
			next = word_array[i + 1];
			current_frequency = ++frequency[(int)current - 65][(int)next - 65];
			if(current_frequency > max)
			{
				max = current_frequency;
				answer = Character.toString(current) + Character.toString(next);
			}
		}

		System.out.println(answer);
	}
}