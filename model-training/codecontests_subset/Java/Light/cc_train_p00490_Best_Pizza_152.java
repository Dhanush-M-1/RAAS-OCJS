import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int[] d = new int[n];
			int[] e = new int[n+1];
			
			for(int i=0;i<n;i++){
				d[i] = sc.nextInt();
			}
			Arrays.sort(d);
				
			int sum = c;
			for(int i=0;i<n;i++){
				sum += d[n-1-i];
				e[i] = sum/(a+b*(i+1));
			}
			e[n] = c/a;
			Arrays.sort(e);
			
			System.out.println(e[n]);
		}
	}
}