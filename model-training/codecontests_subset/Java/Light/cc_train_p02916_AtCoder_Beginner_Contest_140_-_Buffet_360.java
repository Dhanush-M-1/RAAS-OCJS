import java.util.*;
public class Main{
	public static void main(String[] a){
    	buffet();
    }
  	public static void buffet(){
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] as = new int[n];
    	int[] bs = new int[n];
		int[] cs = new int[n-1];
    	for (int i = 0; i < n; i++){
    		as[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++){
			bs[i] = s.nextInt();
		}
		for (int i = 0; i < n - 1; i++){
			cs[i] = s.nextInt();
		}

		int sum = 0;
		for (int a : as){
			sum += bs[a-1];
		}
		for (int i=0; i < n - 1; i++){
			if (as[i] + 1 == as[i + 1])
				sum += cs[as[i] - 1];
		}
		System.out.println(sum);
	}

}