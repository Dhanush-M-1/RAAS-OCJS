import java.util.Scanner;


public class A_and_B {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int num = Integer.parseInt(in.nextLine());
		String[] first = in.nextLine().split(" ");
		String[] second = in.nextLine().split(" ");
		String[] third = in.nextLine().split(" ");
		
		long a = 0;
		long b = 0;
		long c = 0;
		
		for(int i = 0; i < first.length; i++)
			a += (long) Integer.parseInt(first[i]);
		
		for(int i = 0; i < second.length; i++)
			b += (long) Integer.parseInt(second[i]);
		
		for(int i = 0; i < third.length; i++)
			c += (long) Integer.parseInt(third[i]);
		
		System.out.println(a-b);
		System.out.println(b-c);
	}
}