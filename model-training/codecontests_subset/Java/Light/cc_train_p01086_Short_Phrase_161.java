import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = Integer.parseInt(sc.nextLine());/* 入力単語数 */
			if(n == 0) break;
			
			String[] words = new String[n];
			for(int i = 0 ; i < n; i++) {
				words[i] = sc.nextLine();
			}

			int n1, n2, n3, n4, n5;
			for(int i = 0; i < n; i++) {
				n1 = n2 = n3 = n4 = n5 = 0;
				for(int j = i; j < n; j++) {
					if(n1 < 5) {
						n1 += words[j].length();
						if(n1 > 5) break;
					}else if(n2 < 7) {
						n2 += words[j].length();
						if(n2 > 7) break;
					}else if(n3 < 5) {
						n3 += words[j].length();
						if(n3 > 5) break;
					}else if(n4 < 7) {
						n4 += words[j].length();
						if(n4 > 7) break;
					}else if(n5 < 7) {
						n5 += words[j].length();
						if(n5 > 7) break;
					}
				}
				if(n5 == 7) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}

}

