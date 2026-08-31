import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(method_Max(l, r));
	}

	private static int method_Max(int l, int r) {
		// TODO Auto-generated method stub
		if(l==r)
		 return l; 
		else 
		return 2;
	}
}