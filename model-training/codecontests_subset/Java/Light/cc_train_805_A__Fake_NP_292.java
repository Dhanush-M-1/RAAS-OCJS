import java.util.Scanner;

public class FakeNP {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long x = scn.nextLong();
		long y = scn.nextLong();
		if(x == y){
		    System.out.println(x);
		} else{
		System.out.println("2");
		}
	}
}