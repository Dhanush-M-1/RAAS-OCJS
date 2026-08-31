import java.util.*;

public class Main {
	//static_val

	public static void main(String[] args){
		int N;
		int A,B,C;
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		A = scanner.nextInt();
		B = scanner.nextInt();
		C = scanner.nextInt();

		int[] cal = new int[N];

		for(int k=0;k<N;k++){
			cal[k] = scanner.nextInt();
		}
		Arrays.sort(cal);
		int max=C/A;
		int sum_money=A;
		int sum_cal=C;
		for(int i=cal.length-1;i>=0;i--){
			sum_cal+=cal[i];
			sum_money+=B;
			if(max<sum_cal/sum_money){
				max=sum_cal/sum_money;
			}
		}
		System.out.println(max);
	}
}