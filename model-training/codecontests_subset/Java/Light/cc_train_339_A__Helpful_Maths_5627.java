import java.util.Arrays;
import java.util.Scanner;
public class HelpfulMaths 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String arr[]=sc.nextLine().split("\\+");
		Arrays.sort(arr);
		System.out.println(String.join("+", arr));
	}
}