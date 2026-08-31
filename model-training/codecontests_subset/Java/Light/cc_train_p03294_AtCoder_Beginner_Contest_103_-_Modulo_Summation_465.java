import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//C
		int N = sc.nextInt();
		//int[] a = new int[N];
		int sum = 0;
		for(int i = 0 ; i < N ; i++){
			//a[i]= sc.nextInt();
			sum += (sc.nextInt()-1);
		}
		System.out.println(sum);
	}
}