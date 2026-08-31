import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		int cnt = 0;
		int len = S.length;
		for (int i=0; i<S.length; i++) {
			if(S[i]=='S') cnt++;
			else if (cnt>0) {
				cnt--;
				len-=2;
			}
		}
		System.out.println(len);
		sc.close();
	}

}
