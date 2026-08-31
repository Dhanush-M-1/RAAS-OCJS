import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),M=sc.nextInt();
		long[][] ab = new long[N][2];
		long[][] cd = new long[M][2];
		long[] array = new long[N];
		long min = 9223372036854775807L;

		for(int i=0;i<N;i++) {
			ab[i][0] = sc.nextLong();
			ab[i][1] = sc.nextLong();
		}
		for(int i=0;i<M;i++) {
			cd[i][0] = sc.nextLong();
			cd[i][1] = sc.nextLong();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				long buff = Math.abs((ab[i][0]-cd[j][0]))+Math.abs((ab[i][1]-cd[j][1]));
				//System.out.print(buff+" ");
				if(min>buff){
					array[i] = j;
					min = buff;
				}
			}
			//System.out.println();
			min = 9223372036854775807L;
		}


		for(int i=0;i<N;i++) {
			System.out.println(array[i]+1);
		}
	}

	public static int sample() {
		return 1;
	}

}
