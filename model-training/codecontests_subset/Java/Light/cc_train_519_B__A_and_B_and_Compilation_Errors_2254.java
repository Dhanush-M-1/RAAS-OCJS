
import java.util.Scanner;

public class CF_519B {
	public static void main(String[] args) {
		new CF_519B().run();
	}
	public void run(){
		Scanner sc =new Scanner (System.in);
		int n = sc.nextInt();
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;
		for(int i = 0;i< n ;i++){
			sum1 += sc.nextLong();
		}
		for(int j = 0;j< n-1;j++){
			sum2 += sc.nextLong();
		}
		for(int k = 0;k < n-2;k++){
			sum3+= sc.nextLong();
		}
		System.out.println(sum1 - sum2);
		System.out.println(sum2- sum3);
	}
}

