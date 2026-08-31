import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;A[i++]=sc.nextInt());
		int m = 1,f = (int)(1e6);
		long time = 0;
		for(int i=0;i<n;i++){
			if(m >= A[i] || f <= A[i]){
				time += 0;
			}else{
				if((A[i]-m) <= (f-A[i])){
					time += (A[i]-m);
					f -= (A[i]-m);
					m = A[i];
				}else{
					time += (f-A[i]);
					m += (f-A[i]);
					f = A[i];
				}
			}
		}
		System.out.println(time);	

	}

}
