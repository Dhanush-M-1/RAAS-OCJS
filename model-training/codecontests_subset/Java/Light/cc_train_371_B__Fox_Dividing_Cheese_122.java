import java.util.*;
import java.awt.*;

public class FoxDividingCheese {
	Scanner in = new Scanner(System.in);

	public static void main(String args[]) {

		new FoxDividingCheese().go();
	}

	public void go() {
		int a = in.nextInt();
		int b = in.nextInt();
		boolean done=false;
		int t=a;
		int ans_a=a;
		int ans_b=b;
		int a2=0;
		int a3=0;
		int a5=0;
		int b2=0;
		int b3=0;
		int b5=0;
		while(ans_a%2==0){
			a2++;
			ans_a/=2;
		}
		while(ans_a%3==0){
			a3++;
			ans_a/=3;
		}
		while(ans_a%5==0){
			a5++;
			ans_a/=5;
		}
		while(ans_b%2==0){
			b2++;
			ans_b/=2;
		}
		while(ans_b%3==0){
			b3++;
			ans_b/=3;
		}
		while(ans_b%5==0){
			b5++;
			ans_b/=5;
		}
		
		if(ans_b!=ans_a){
			System.out.println(-1);
		}
		else{
			System.out.println(Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5));
		}
	}
}