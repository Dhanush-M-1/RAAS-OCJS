import java.util.Scanner;


public class B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res = 0;
		int []n  = {2,3,5};
		for(int i : n){
			int c1 = 0, c2=0;
			while(a%i==0){c1++;a/=i; }
			while(b%i==0){c2++;b/=i; }
			res += Math.abs(c1-c2);
		}
		if(a==b)System.out.println(res);
		else System.out.println(-1);
		
		
		
	}
}
