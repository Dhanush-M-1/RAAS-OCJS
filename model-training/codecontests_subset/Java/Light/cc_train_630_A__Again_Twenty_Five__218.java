import java.util.Scanner;

public class AgainTwentyFive {
	public static void main(String[]args) {
		Scanner sn = new Scanner(System.in);
		String s = sn.nextLine();
		if(s.length()==1) {
			if(Integer.parseInt(s)==0) {
				System.out.println("1");
			} else if(Integer.parseInt(s)==1) {
				System.out.println("5");
			} else {
				System.out.println("25");
			}
		} else {
			System.out.println("25");
		}
	}
}
