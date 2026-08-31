//package ladder.less1300;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths197A 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String input[]=sc.nextLine().split("\\+");
		Arrays.sort(input);
		System.out.println(String.join("+",input));
		sc.close();
	}
}
