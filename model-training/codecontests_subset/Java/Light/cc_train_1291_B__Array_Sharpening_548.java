import java.util.*;

public class watermelon {

	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			int n = s.nextInt();
			int arr[] = new int[n];
			
			for(int i=0; i<n;i++) {
				arr[i] = s.nextInt();
			}
			
			int prefixend = -1, suffixend = n;
			for(int i=0; i<n;i++) {
				if(arr[i]<i) {
					break;
				}
				prefixend = i;
			}
			for(int i=n-1; i>=0;i--) {
				if(arr[i]< (n-1)-i) {
					break;
				}
				suffixend = i;
			}
			if(suffixend<=prefixend) {
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}