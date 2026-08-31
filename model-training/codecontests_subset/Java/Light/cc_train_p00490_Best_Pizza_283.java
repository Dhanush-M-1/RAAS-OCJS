import java.util.*;
import java.util.Arrays;
     
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	int C = sc.nextInt();
    	
    	int[] D = new int[N];
    	int s = 0;
    	double[] answer = new double[N + 1];
    	
    	for(int i = 0;i < N;i++){
    		D[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(D);
    	
    	for(int j = 0;j < N;j++){
    		int kal_sum = C;
    		int pay_sum = A + B * s;
    		for(int i = N - 1;i > N - 1 - s;i--){
    			kal_sum += D[i];
    		}
    		//System.out.println(j+" "+kal_sum+" "+pay_sum);
    		answer[s] = kal_sum / pay_sum;
    		s++;
    	}
    	
    	int max = (int)answer[0];
    	for(int i = 0;i < N + 1;i++){
    		if(max < answer[i])
    			max = (int)answer[i];
    	}
    	
    	System.out.println(max);
    	
    	
    }
}