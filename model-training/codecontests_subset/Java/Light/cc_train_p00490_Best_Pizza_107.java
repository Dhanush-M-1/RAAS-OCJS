import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		
		final int A = sc.nextInt();
		final int B = sc.nextInt();
		
		
		int cal = sc.nextInt();
		int dol = A;
		
		int[] tops = new int[N];
		
		for(int i = 0; i < N; i++){
			tops[i] = sc.nextInt();
		}
		
		Arrays.sort(tops);
		
		for(int i = N - 1; i >= 0; i--){
			if(((double)cal) / dol < ((double)cal + tops[i]) / (dol + B)){
				cal += tops[i];
				dol += B;
			}
		}
		
		System.out.println((int)(cal / dol));
		
	}

}