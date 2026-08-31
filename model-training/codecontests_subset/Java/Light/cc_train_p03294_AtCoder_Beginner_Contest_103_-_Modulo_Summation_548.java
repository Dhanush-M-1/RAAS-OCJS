import java.util.Scanner;

public class Main {// AtCoderは必ずMainクラスで提出する
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int count  = sc.nextInt();
		int[] num = new int[count];
		int sum = 0;
		for(int i = 0 ;i < count;i++) {
			num[i] = sc.nextInt() - 1;
			sum += num[i];
		}
		System.out.println(sum);
	}
}