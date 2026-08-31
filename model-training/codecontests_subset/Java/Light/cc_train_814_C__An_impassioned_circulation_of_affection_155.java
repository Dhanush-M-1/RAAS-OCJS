import java.util.Scanner;
public class Main{
	public static void main(String[]__){
		Scanner s=new Scanner(System.in);
		int l=s.nextInt();
		String t=s.next();
		int q=s.nextInt(),dp[][]=new int[26][l+1];

		for(int i=0;i<l;i++) {
			char c=t.charAt(i);
			int r=0;
			for(int j=i;j<l;j++) {
				if(c!=t.charAt(j))r++;
				dp[c-'a'][r]=Math.max(dp[c-'a'][r],j-i+1);
			}
		}

		for(int[]o:dp)for(int i=1;i<=l;i++)
			o[i]=Math.max(Math.min(l,o[i-1]+1),o[i]);

		for(int i=0;i<q;i++){
			int v=s.nextInt();
			System.out.println(dp[s.next().charAt(0)-'a'][v]);
		}
	}
}
