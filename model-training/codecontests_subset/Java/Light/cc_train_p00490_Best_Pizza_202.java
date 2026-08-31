import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
 
public class Main {

	static long MOD = 1_000_000_007;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//int N = Integer.parseInt(sc.next());
		//long L = Long.parseLong(sc.next());
		//char[] c = sc.next().toCharArray();
		int INF = Integer.MAX_VALUE;
		int INF_MIN = -1000;//Integer.MIN_VALUE;
		
		Scanner sc = new Scanner(System.in);
		

		int N = Integer.parseInt(sc.next());
		int A = Integer.parseInt(sc.next());
		int B = Integer.parseInt(sc.next());
		int base_cal = Integer.parseInt(sc.next());
		int[] cal = new int[N];
		for(int i=0; i<N; i++){
			cal[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(cal);
		int total_cal = base_cal;
		int cost = A;
		double rate_cal = (double)base_cal/(double)A;
		for(int i=N-1; i>=0; i--){
			int tmp_total = total_cal + cal[i];
			int tmp_cost = cost + B;
			double new_rate_cal = (double)tmp_total/(double)tmp_cost;
			if(new_rate_cal>rate_cal){
				total_cal = tmp_total;
				cost = tmp_cost;
				rate_cal = new_rate_cal;
			}
			//System.out.println("cal: "+total_cal+" cost:"+cost);
		}
		
		int ans = total_cal/cost;

		System.out.println(ans);
		
	
		
		
	}
}


