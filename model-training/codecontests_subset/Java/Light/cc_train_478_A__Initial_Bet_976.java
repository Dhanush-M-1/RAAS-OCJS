import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5;i++) sum += in.nextInt();
		System.out.println(sum % 5 != 0 || sum == 0 ? "-1" : sum / 5);			
	}
}