import java.util.Scanner;

class Main {
	public static void main(String[] $) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),sum=0;
		for(int i=0;i<n;i++)sum+=sc.nextInt()-1;
		System.out.println(sum);
	}
}

