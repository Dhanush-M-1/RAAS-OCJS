import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		Scanner file = new Scanner(System.in);
		int N = file.nextInt();
		int x = file.nextInt();
		int y = file.nextInt();
		char[] chars = file.next().toCharArray();
		int sum = 0;
		for(int i = 0;i<x;i++)
			if((i==y) ^ (chars[chars.length-i-1]!='0'))
				sum++;
		System.out.println(sum);
	}
	
}
