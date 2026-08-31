import java.util.*;

public class contest1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int tot = 0;
		
		for(int i =0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int max=a[0];
		for(int i=0;i<n;i++){
			
			tot += a[i];
			if(max < a[i]){
				max = a[i];
			}
		}
		
		int maxa = max;
		int tota = 0;
		while(tota < tot){
			tota = 0;
			for(int i=0;i<n;i++){
				tota += (maxa - a[i]);
			}
			if(tota > tot)
			{break;}
			else{
				maxa++;
			}
			
		}
		System.out.println(maxa);
		
	}
}