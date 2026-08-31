import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int base_val = sc.nextInt();
		int tp_val = sc.nextInt();
		int base_cal = sc.nextInt();;
		int tp_cal[] = new int[n];
		for(int i=0; i<n; ++i) tp_cal[i]=sc.nextInt();
		int temp;
		int index=0;
		for(int i=0; i<n; ++i){
			int max=0;
			for(int j=i+1; j<n; ++j){
				if(max<tp_cal[j]){
					max=tp_cal[j];
					index=j;
				}
			}
			temp=tp_cal[i];
			tp_cal[i]=max;
			tp_cal[index]=temp;
		}
		int best = base_cal / base_val;
		int sum=0;
		for(int i=0; i<n; ++i){
			sum+=tp_cal[i];
			temp=(base_cal+sum)/(base_val+(i+1)*tp_val);
			if(best < temp){
				best=temp;
			}
		}
		System.out.println(best);
	}
}