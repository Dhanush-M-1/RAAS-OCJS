import java.util.Arrays;
import java.util.Scanner;


public class NEWFILE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		for(int a=0;a<N;a++){
			array[a]=sc.nextInt();
		}
		Arrays.sort(array);
		int best = array[N-1];
		long remain = best;
		for(int a=0;a<N-1;a++){
			int diff = array[N-1]-array[a];
			remain-=diff;
			if(remain<0)break;
		}
		while(remain>0){
			remain-=(N-1);
			best++;
		}
		System.out.println(best);
	}
}