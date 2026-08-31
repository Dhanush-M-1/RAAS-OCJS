import java.util.Scanner;

public class Remainder_560{

	public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();


		String num=scan.next();

		StringBuilder sb = new StringBuilder();

		sb.append(num);
		sb.reverse();

		num=sb.toString();
		
		int count=0;
		for(int i=0;i<x;i++){
			if(num.charAt(i)=='1')count++;
		
		}

		if (num.charAt(y)=='1')count--;
		else if (num.charAt(y)=='0')count++;

		System.out.println(count);
		
		
	}
}
