import java.util.Arrays;
import java.util.Scanner;

class Main{


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			//文字の入力
		int a = sc.nextInt();
		int b  =sc.nextInt();
		int c = sc.nextInt();
		int[] data = {a,b,c};
		Arrays.sort(data);
		if(data[2] == (data[0] + data[1])){
			System.out.println("Yes");
		}else{
			System.out.println("No");

		}
		
				
	}
}