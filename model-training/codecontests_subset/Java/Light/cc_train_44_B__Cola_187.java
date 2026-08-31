

import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
		int sum = 0;
		for (int i = 0; i <=b; ++i) {
			for (int j = 0; j <= c; ++j) {
				if(i+j*2<=n&&(n-(i+j*2))*2<=a){
					++sum;
				}
			}
		}
		System.out.println(sum);
	}

}
