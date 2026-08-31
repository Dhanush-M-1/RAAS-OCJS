import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int cltopping[] = new int [num];
		int prdough = in.nextInt();
		int prtopping = in.nextInt();
		int cldough = in.nextInt();
		for(int i = 0; i < num; i++){
			cltopping[i] = in.nextInt();
		}
		Arrays.sort(cltopping);
	if(num == 1){
			System.out.println( ((cldough + cltopping[0]) / (prdough + prtopping)));
		}
		else{
			int sum = 0;
			for(int i = 2; i <= num; i++){
				int totalcltp = 0;
				int totalcl = 0;
				int clperdol = 0;
				for(int k = 0; k < i; k++){
					totalcltp += cltopping[num - 1 - k];
				}
				totalcl = totalcltp + cldough;
				clperdol = totalcl / (i * prtopping + prdough);
				if(sum < clperdol){
					sum = clperdol;
				}	
			}
			System.out.println(sum);
		}
	
	}
}