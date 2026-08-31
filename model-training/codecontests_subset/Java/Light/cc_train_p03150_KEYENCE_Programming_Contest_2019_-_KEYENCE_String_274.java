import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] S = sc.next().split("");
		int slen = S.length;
		String[] key = {"k","e","y","e","n","c","e"};
		int keylen = key.length;
		sc.close();

		if(!(S[0].equals(key[0]))&&!(S[slen-1].equals(key[keylen-1]))) {
			System.out.println("NO");
			return;
		}
		int cnt = 0;
		for(int i=0,j=0;i<keylen&&j<keylen;i++) {
			if(S[i].equals(key[j])) {
				j++;
				cnt++;
			}else {
				break;
			}
		}
		if(cnt >= keylen) {
			System.out.println("YES");
			return;
		}
		for(int i=slen-1,j=keylen-1;j>=0&&i>=0;i--) {
			if(S[i].equals(key[j])) {
				j--;
				cnt++;
			}else {
				break;
			}
		}

		if(cnt >= keylen) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}