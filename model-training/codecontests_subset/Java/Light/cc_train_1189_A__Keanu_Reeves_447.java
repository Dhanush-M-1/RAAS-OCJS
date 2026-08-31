import java.util.Scanner;

public class KeanuReeves {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minimal = sc.nextInt();
		String input = sc.next();
		int ones = 0;
		int zeroes = 0;
		for(int i = 0;i<input.length();i++) {
			if(input.substring(i, i+1).equals("0"))zeroes++;
			else ones++;
		}
		if(input.length()%2!=0||ones!=zeroes) {
			System.out.println("1");
			System.out.println(input);
		}else {
			System.out.println("2");
			System.out.println(input.substring(0, 1)+ " " + input.substring(1));
		}

	}

}
