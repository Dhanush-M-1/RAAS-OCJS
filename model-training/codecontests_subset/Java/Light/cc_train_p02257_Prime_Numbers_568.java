import java.util.Scanner;

class Main{

	public static void main(String[] args){

		Scanner sc =new Scanner(System.in);

		int n=sc.nextInt();
		int x,count=0;

		for(int i=0;i<n;i++) {

			x=sc.nextInt();

			if(judge_prime(x)) count++;

		}

		System.out.println(count);

	}


	private static  boolean judge_prime(int x) {
		
		if(x<=2) return true;
		
		else if(x%2==0) return false;

		for(int i=3;i<=Math.sqrt(x);i+=2)
			if(x%i==0) return false;

		return true;
	}
}
