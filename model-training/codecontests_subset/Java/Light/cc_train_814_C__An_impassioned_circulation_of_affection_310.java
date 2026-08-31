import java.util.Scanner;

public class Main{
	static final Scanner s=new Scanner(System.in);
	public static void main(String[] __){
		int l=s.nextInt();
		String in=s.next();
		int q=s.nextInt();
		int[][]dp=new int[26][l+1];

		for(int i=0;i<l;i++) {
			char c1=in.charAt(i);
			int replace=0;
			for(int j=i;j<l;j++) {
				char c2=in.charAt(j);
				if(c1!=c2)replace++;
				dp[c1-'a'][replace]=Math.max(dp[c1-'a'][replace],j-i+1);
			}
		}
		for(int c=0;c<26;c++)for(int i=1;i<=l;i++)
			dp[c][i]=Math.max(Math.min(l,dp[c][i-1]+1),dp[c][i]);
//		Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);

		for(int i=0;i<q;i++){
			int v=s.nextInt();
			char c=s.next().charAt(0);
			System.out.println(dp[c-'a'][v]);
		}
	}
}
