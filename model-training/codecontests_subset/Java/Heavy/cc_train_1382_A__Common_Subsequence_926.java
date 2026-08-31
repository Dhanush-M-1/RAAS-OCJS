import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		// Scanner scan = new Scanner(new File("inputf.in"));
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			HashMap<Integer,Boolean> map = new HashMap<>();
			int num = 0;
			for(int i=0;i<n;i++) {
				arr1[i] = scan.nextInt();
				map.put(arr1[i],true);
			}
			for(int i=0;i<m;i++) {
				arr2[i] = scan.nextInt();
				if(map.getOrDefault(arr2[i],false)) {
					num = arr2[i];
				}
			}
			if(num == 0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
				System.out.println("1 " + num);
			}
		}
	}
}