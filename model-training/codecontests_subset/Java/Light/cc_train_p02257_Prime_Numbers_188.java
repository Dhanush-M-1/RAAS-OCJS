import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		long temp=0;

		for(int i=0;i<n;i++) {
			temp=sc.nextLong();
			if(temp==2||temp%2!=0) {
				count += sosu(temp);
			}
		}
		System.out.println(count);

	}

	public static int sosu(long num) {
		int res=1;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				res=0;
				break;
			}
		}
		return res;
	}
}

