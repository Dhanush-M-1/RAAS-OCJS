import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans[] = {"AC", "WA", "TLE", "RE"};
		int num[] = new int[4];
		for(int i = 0; i < n; ++i){
			String s = sc.next();
			for(int j = 0; j < 4; ++j){
				if(s.equals(ans[j])){
					num[j]++;
					break;
				}
			}
		}
		sc.close();
		for(int i = 0; i < 4; ++i){
			System.out.println(ans[i] + " " + "x " + num[i]);
		}
	}
}
