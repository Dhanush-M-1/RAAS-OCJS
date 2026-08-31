import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 入力値を取得
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a*b%2 == 0){
			System.out.println("Even");
		}else{
			System.out.println("Odd");
		}
	}
}