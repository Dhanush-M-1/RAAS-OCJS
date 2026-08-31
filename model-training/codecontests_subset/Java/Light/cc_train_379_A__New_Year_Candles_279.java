import java.util.Scanner;

public class Main {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args){
		int a = in.nextInt(), b = in.nextInt();
		int total = a;
		int storage = a;
		while(storage >= b){
			total += storage/b;
			storage = storage % b + storage / b;
		}
		System.out.println(total);
	}

}