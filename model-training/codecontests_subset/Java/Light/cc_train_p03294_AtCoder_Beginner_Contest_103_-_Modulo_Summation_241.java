import java.util.*;

class Main{
	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int arr[] = new int[N];
		int sum = 0;
		for(int n=0;n<N;n++){
			arr[n] = sc.nextInt();
			sum += arr[n];
		}

		System.out.println(sum-N);
	}
}