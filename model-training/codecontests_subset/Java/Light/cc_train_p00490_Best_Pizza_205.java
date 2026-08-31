import java.util.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int prcsum = sc.nextInt();
		int tp = sc.nextInt();
		int calsum = sc.nextInt();
		int[] cal = new int[n];
		
		for(int i =0; i< n;i++){
			cal[i] = sc.nextInt();
		}
		for(int i = 0; i<n;i++){
			for(int k=0;k<n;k++){
				if(cal[i]>cal[k]){
					int work = cal[i];
					cal[i] = cal[k];
					cal[k] = work;
				}
			}
		}
		
		int max = calsum / prcsum;

		for(int i = 0; i<n; i++){
			calsum += cal[i];
			prcsum += tp;
			int pizza = calsum / prcsum;
			if(max < pizza){
				max = pizza;
			}
		}
		System.out.println(max);
	}

}