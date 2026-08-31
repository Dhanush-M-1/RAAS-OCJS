import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    // static Scanner in = new Scanner( new File("javain.txt"));
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length > 0){
			in = new Scanner( new File("javain.txt"));
		}
		int t = in.nextInt();
        for(int i = 0; i < t; i++){
            solve();
        }
    }

    public static void solve(){
			
		int n = in.nextInt();
		int m = in.nextInt();
		int data[] = new int[n];
		for(int i = 0; i < n; i++){
			data[i] = in.nextInt();
		}
		long sum[][] = new long[n][2];
		sum[0][0] = data[0];
		for(int i = 1; i < n; i++){
			sum[i][0] = sum[i - 1][0] + data[i];
			sum[i][1] = i;
		}
		long lastSum = sum[n - 1][0];
		long preMax = 0;
		int newLen = 0;
		for(int i = 0; i < n; i++){
			if(sum[i][0] > preMax){
				preMax = sum[i][0];
				sum[newLen][0] = sum[i][0];
				sum[newLen++][1]= sum[i][1];
			}
		}
		long ans[] = new long[m];
		for(int i = 0; i < m; i++){
			long target = in.nextLong();
			if(newLen == 0 || (target > sum[newLen-1][0] && lastSum <= 0)){
				ans[i] = -1;
				continue;
			}
			if(target <= sum[newLen-1][0]){
				ans[i] = bs(sum, newLen ,target);
			}else{
				long rounds = (target - sum[newLen-1][0] + lastSum - 1) / lastSum;
				target -= rounds * lastSum;
				ans[i] = rounds * n + bs(sum, newLen,target);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< m - 1; i++){
			sb.append(ans[i] + " ");
		}
		sb.append(ans[m-1]);
		System.out.println(sb.toString());
	}

	static int bs(long [][] arr, int n,long key){
//		System.out.println("find " + key + " n = " + n);
		int left=0, right=n - 1;
	    while(left<=right) {
		    int mid = (left+right)/2;
			if(arr[mid][0] >= key) right = mid-1;
			else if (arr[mid][0] < key) left = mid+1;
	    }	        //if( left < n && arr[left] == key) return left;    
		return (int)arr[left][1];
	}
}
