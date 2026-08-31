import java.util.*;
public class MultiplyBy2DivideBy6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t--!=0) {
			int n = sc.nextInt();
			int count2=0,count3=0 ;
			while(n%2==0) {
				n/=2;
				count2++;
			}
			while(n%3==0) {
				n/=3;
				count3++;
			}
			if(n==1 && count3>=count2) System.out.println(2*count3 - count2);
			else System.out.println(-1);
		}

	}

}
