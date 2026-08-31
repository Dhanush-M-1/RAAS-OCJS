import java.util.Arrays;
import java.util.Scanner;

public class AA {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int nb=scan.nextInt();
		int[] T=new int[nb];
		for(int i=0;i<nb;i++)T[i]=scan.nextInt();
		Arrays.sort(T);
		int countA=0;
		int countB=0;
		int init=T[nb-1];
		while(countA<=countB) {
			countA=0;
			countB=0;
			for(int i=0;i<nb;i++) {
				countA+=init-T[i];
				countB+=T[i];
			}
			init++;
		}
		System.out.println(init-1);
	}

}
