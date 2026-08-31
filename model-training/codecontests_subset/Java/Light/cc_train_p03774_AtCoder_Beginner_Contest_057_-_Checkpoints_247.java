import java.util.*;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] x = new int[m];
        int[] y = new int[m];
        for(int i = 0; i < n; i++){
        	a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
        	x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            long dis = Long.MAX_VALUE;
            int ans = 0;
        	for(int j = 0; j < m; j++){
            	if((Math.abs(a[i] - x[j]) + Math.abs(b[i] - y[j])) < dis){
                	ans = j + 1;
                    dis = Math.abs(a[i] - x[j]) + Math.abs(b[i] - y[j]);
                }
            }
            System.out.println(ans);
        }
	}
}