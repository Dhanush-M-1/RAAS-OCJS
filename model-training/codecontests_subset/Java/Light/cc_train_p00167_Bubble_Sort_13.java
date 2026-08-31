import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int[] a = new int[n];
			for(int i=0;i<n;i++) a[i] = sc.nextInt();
			int count = 0;
			int temp = 0;
			int tempB = 0;
			while(true){
				for(int i=0;i<n-1;i++){
					if(a[i]>a[i+1]){
						temp = a[i+1];
						a[i+1] = a[i];
						a[i] = temp;
						count++;
					}
				}
				if(tempB==count) break;
				tempB = count;
			}
			System.out.println(count);
		}
	}	
}