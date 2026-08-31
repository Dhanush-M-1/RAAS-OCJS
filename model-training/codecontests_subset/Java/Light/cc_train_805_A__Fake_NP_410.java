import java.util.Scanner;


public class A_Fake_NP {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		if (a == b){
			System.out.println(a);
		}else{
			System.out.println(2);
		}
	}

}
