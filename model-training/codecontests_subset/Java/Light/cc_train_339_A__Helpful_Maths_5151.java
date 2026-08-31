import java.util.Scanner;
import java.util.Arrays;

public class IncreasingOrderSum
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] output = new int[(s.length()/2)+1];
		int index = 0;

		for (char c : s.toCharArray()) {
			if (c != '+') {
				output[index] = Character.getNumericValue(c);
				index++;
			}
		}	
		Arrays.sort(output);

		for (int i = 0; i < output.length-1; i++) {
			System.out.print(output[i]+"+");
		}
		System.out.println(output[output.length-1]);
	}	
}
