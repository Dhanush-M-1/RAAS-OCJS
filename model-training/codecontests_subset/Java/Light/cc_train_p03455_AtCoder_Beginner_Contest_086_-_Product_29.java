

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		if(in.nextInt() * in.nextInt() % 2 == 1) {
			System.out.println("Odd");
		}
		else
			System.out.println("Even");
	}

}
