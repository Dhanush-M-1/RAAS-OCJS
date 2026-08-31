import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] home = new int[n];
		int[] guest = new int[n];
		int count = 0;
		for(int i=0; i<n; i++){
			home[i] = sc.nextInt();
			guest[i] = sc.nextInt();
		}
		for(int k=0; k<n; k++){	
			for(int j=0; j<n; j++){
				if(home[k]==guest[j]){
					count++;
				}
			}
		}
		System.out.println(count);
	}
}