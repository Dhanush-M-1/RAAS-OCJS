import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long x = sc.nextLong();
		long ans = 1;
		if(a==1){
			System.out.println(x);
			return;
		}
		for(long i = 2; Math.pow(i,a)<=x; i++){
			double c = Math.pow(i,a);
			if(x%c==0){
				ans = Math.max(ans,i);
			}
		}
		
			System.out.println(ans);
	}
}