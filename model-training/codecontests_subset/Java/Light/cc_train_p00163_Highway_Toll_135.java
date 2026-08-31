import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dist = new int[]{0,6,7,5,5,20,15};
		int[][] toll = new int[][]{
				{},
				{6},
				{10,7},
				{12,9,5},
				{14,12,8,5},
				{27,23,20,17,12},
				{33,30,27,26,23,10}
			};
		
		while(true){
			int[] a = new int[6];
			a[0] = sc.nextInt();
			if(a[0]==0) break;
			
			for(int i=1;i<6;i++) a[i] = sc.nextInt();
			
			int t;
			if(a[0]>a[3]){
				t = a[0];
				a[0] = a[3];
				a[3] = t;
			}
			
			int sumd = 0;
			for(int i=a[0];i<a[3];i++) sumd += dist[i];

			boolean flag = false;
			if(sumd <= 40){
				for(int i=0;i<2;i++){
					if(a[1+3*i]==18 || (a[1+3*i]==17 && a[2+3*i]>=30) || (a[1+3*i]==19 && a[2+3*i]<=30)){
						flag = true;
						break;
					}
				}
			}
			
			t = toll[a[3]-1][a[0]-1];
			if(flag==true) t = (t+1)/2;
			System.out.println(t*50);
		}	
	}	
}