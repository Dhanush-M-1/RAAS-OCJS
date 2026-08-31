import java.util.*;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int aInt = sc.nextInt();
	int bInt = sc.nextInt();
	int seki = aInt * bInt;

	if((seki % 2) == 0) {
		System.out.println("Even");
	}else{
		System.out.println("Odd");
	}
	}
}