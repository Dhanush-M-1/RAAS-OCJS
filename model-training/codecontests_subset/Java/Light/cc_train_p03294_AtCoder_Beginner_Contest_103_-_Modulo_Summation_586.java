import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		int ans=0;
		for(int i=0;i<N;i++){
			ans=ans+sc.nextInt();
		}
		ans=ans-N;
		System.out.println(ans);
	}
}
