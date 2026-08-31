
import java.util.Scanner;


public class Main {
	

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

    	int n, k;
    	n = scanner.nextInt();
    	k = scanner.nextInt();
    	    	int[] arr = new int[n];
    	int[] vis = new int[n+1];
    	for(int i = 0;i < 4;i++) {
    		arr[i] = scanner.nextInt();
    		vis[arr[i]] = 1;
    	}
    	
    	if(k < n + 1 || n == 4) {
    		System.out.println(-1);
    		return;
    	}
    	
    	
    	int indx = 4, vrtx = 1;
    	while(indx < n) {
    		while(vis[vrtx] == 1) {
    			vrtx++;
    		}
    		arr[indx++] = vrtx;
    		vis[vrtx] = 1;
    	}
    	
//    	for(int i = 0;i < n;i++) {
//    		System.out.print(arr[i] + " ");
//    	}
//    	System.out.println("");
    	
    	int[] path = new int[n];
    	
    	//From vertex 0 to vertex 1
    	System.out.print(arr[0] + " " + arr[3] + " " );
		for(int i = 4;i < n;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[2] + " " + arr[1]);
		
    	if(n % 2 == 1) {
    		System.out.print(arr[2] + " " + arr[1] + " ");
    		for(int i = n - 1;i >= 4;i--) {
    			System.out.print(arr[i] + " ");
    		}
    		System.out.println(arr[0] + " " + arr[3]);
    	} else {
    		System.out.print(arr[2] + " " + arr[1] + " ");
    		for(int i = 4;i < n;i++) {
    			System.out.print(arr[i] + " ");
    		}
    		System.out.println(arr[0] + " " + arr[3]);
    	}
    }

}