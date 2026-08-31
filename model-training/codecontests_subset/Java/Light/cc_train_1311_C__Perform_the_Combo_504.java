import java.util.Scanner;

public class que3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		StringBuilder sb=new StringBuilder();
		while (test-- > 0) {
			int n = scn.nextInt();
			int p = scn.nextInt();
			String s = scn.next();
			int[] arr = new int[p];
			int[] art = new int[s.length()];
			for (int i = 0; i < p; i++) {
				int val = scn.nextInt();
				art[val - 1]++;
			}
			art[s.length() - 1]++;
			for (int i = n - 2; i >= 0; i--) {
				art[i] += art[i + 1];
			}
			int []ans=new int[26];
			for (int i = 0; i < s.length(); i++) {
                  int  ch=s.charAt(i)-'a';
                  ans[ch]+=art[i];
			}
            for(int i=0;i<26;i++){
            	sb.append(ans[i]+" ");
            }
            sb.append("\n");
		}
System.out.println(sb);
	}

}
