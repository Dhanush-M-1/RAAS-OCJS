import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		Integer[] A=Arrays.asList(sc.nextLine().split(" "))
				.stream().map(Integer::valueOf).toArray(Integer[]::new);
		Integer[] B=Arrays.asList(sc.nextLine().split(" "))
				.stream().map(Integer::valueOf).toArray(Integer[]::new);
		Integer[] C=Arrays.asList(sc.nextLine().split(" "))
				.stream().map(Integer::valueOf).toArray(Integer[]::new);
		int result=0;
		for(int i=0;i<N;i++) {
			result+=B[A[i]-1];
			if(i<(N-1)&&A[i+1]==A[i]+1) {
				result+=C[A[i]-1];
			}
		}
		System.out.println(result);
	}
}