import java.util.Scanner;


public class A {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		String s = in.next();
		char[] sym = new char[s.length() / k];
		int[] kl = new int[s.length() / k];
		int kol = 0;
		int ans = 1;
		for(int i = 0; i < s.length(); i ++){
			char a = s.charAt(i);
			int pr = 0;
			for(int j = 0; j < kol; j++){
				if(a == sym[j]){
					kl[j]++;
					pr++;
				}
			}
			if(pr == 0 && kol < s.length() / k){
				sym[kol] = a;
				kl[kol]++;
				kol++;
			}else if(pr == 0){
				ans = 0;
			}
		}
		if(ans == 1){
			for(int i = 0; i < kol; i++){
				if(kl[i] % k != 0){
					ans = 0;
				}
			}
			if(ans ==1){
				for(int sc = 0; sc < k; sc++){
					for(int i = 0; i < kol; i++){
						for(int j = 0; j < kl[i] / k; j++){
							System.out.print(sym[i]);
						}
					}
				}
			}
		}
		if(ans == 0){
			System.out.println(-1);
		}
	}
}
