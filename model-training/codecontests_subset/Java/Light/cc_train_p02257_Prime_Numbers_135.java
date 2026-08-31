import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		for(int i=1; i<=n; i++){
			int x=sc.nextInt();
			if(isprime(x)){
				count++;
			}
		}
		System.out.println(count);



	}
	public static boolean isprime(int x){
		if(x==2){
			return true;
		}
		if(x%2==0 || x<2){
			return false;
		}
		int i=3;
		while(i<=Math.sqrt(x)){
			if(x%i==0){
				return false;
			}
			i+=2;
		}
		return true;
	}

	}
