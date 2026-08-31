import java.util.Scanner;


public class removed_errors {


	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int sum=0;
		int tmp=n;
		while(tmp-->0){
			sum+=in.nextInt();
		}
		int sum1=0;
		tmp=n-1;
		while(tmp-->0){
			sum1+=in.nextInt();
		}
		int sum2=0;
		tmp=n-2;
		while(tmp-->0){
			sum2+=in.nextInt();
		}
		System.out.println(sum-sum1);
		System.out.println(sum1-sum2);
	}

}
