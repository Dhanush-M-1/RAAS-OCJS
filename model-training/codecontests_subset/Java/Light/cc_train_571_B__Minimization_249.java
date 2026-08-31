import java.util.Arrays;
import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		long [] ary = new long[N];
		for(int i=0;i<N;i++) {
			ary[i]=in.nextInt();
		}
		Arrays.sort(ary);
		long acc = 0;
		long [] diffs = new long[N]; 
		for(int i=0;i<N-1;i++) {
			diffs[i]=Math.abs(ary[i]-ary[i+1]);
			acc+=diffs[i];
		}
		int len = N/K;
		int numb = N%K;
		int numa = K-numb;
		long [][] mins = new long[numa+1][numb+1];
		for(int i=1;i<=numa;i++) {
			mins[i][0]=mins[i-1][0]+diffs[len*i-1];
		}
		for(int i=1;i<=numb;i++) {
			mins[0][i]=mins[0][i-1]+diffs[(len+1)*i-1];
		}
		for(int i=1;i<=numa;i++) {
			for(int j=1;j<=numb;j++) {
				mins[i][j]=Math.max(mins[i-1][j], mins[i][j-1]) + diffs[len*(i+j)+j-1];
			}
		}
		System.out.println(acc-mins[numa][numb]);
	}
}
