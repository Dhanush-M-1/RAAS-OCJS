import java.util.Scanner;


public class Problem519B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3];
		int sum = 0;
		for(int i=0;i<N;i++){
			int temp = sc.nextInt();
			sum += temp;
		}
		arr[0] = sum;
		sum=0;
		for(int i=0;i<N-1;i++){
			int temp = sc.nextInt();
			sum += temp;
		}
		arr[1] = sum;
		sum=0;
		for(int i=0;i<N-2;i++){
			int temp = sc.nextInt();
			sum += temp;
		}
		arr[2] = sum;
		System.out.println(arr[0]-arr[1]);
		System.out.println(arr[1]-arr[2]);
	}
}
