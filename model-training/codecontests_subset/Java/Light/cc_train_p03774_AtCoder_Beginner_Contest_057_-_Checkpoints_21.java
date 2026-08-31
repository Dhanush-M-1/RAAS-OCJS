import java.util.*;
 
public class Main {
  	static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[]$) {
    	int n = scanner.nextInt();
    	int m = scanner.nextInt();
      	int[] a = new int[n];
      	int[] b = new int[n];
      	for (int i = 0; i < n; i++) {
        	a[i] = scanner.nextInt();
        	b[i] = scanner.nextInt();
        }
      	int[] c = new int[m];
      	int[] d = new int[m];
      	for (int i = 0; i < m; i++) {
        	c[i] = scanner.nextInt();
        	d[i] = scanner.nextInt();
        }
      	for (int i = 0; i < n; i++) {
          	int min = Integer.MAX_VALUE;
          	int index = -1;
      		for (int j = m - 1; j >= 0; j--) {
              	int dist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
   	   	   	   	if (min >= dist) {
                    min = dist;
               	   	index = j + 1;
                }
            }
            System.out.println(index);
        }
    }
}