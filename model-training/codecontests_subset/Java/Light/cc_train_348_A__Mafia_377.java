import java.util.Scanner;
public class Mafia {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long num = 0;
		long num2 = 0;
		long max = 0;
		for(int i=0;i<n; i++) {
			num2 = sc.nextInt();
			if(num2 > max) max = num2;
			num += num2;
		}
		if((num / (n-1) + 1) < max) {
			System.out.println(max);
		}
		else if(num % (n-1) == 0){
			System.out.println(num / (n-1));
		}
		else {
			System.out.println(num / (n-1) + 1);
		}
	}
}
