import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class compete604c {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int j = 0; j < t; j++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) / 2;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int last = Integer.parseInt(st.nextToken());
			while(n > 0 && arr[n - 1] == last) {
				n--;
			}
			
			int g = 0; int s = 0; int b = 0;
			if(n >= 5){
				while(3 * g + 2 <= n && arr[g] == arr[g + 1]) {
					g++;
				}
				if(arr[g] == arr[g + 1]) {
					g = 0;
				} else {
					g++;
				}
				if(g > 0) {
					s = g + 1;
					while(n - g - s > g && arr[g + s - 1] == arr[g + s]) {
						s++;
					}
					if(n - g - s <= g) {
						s = 0; g = 0;
					} else {
						b = n - g - s;
					}
				}
			}
			System.out.println(g + " " + s + " " + b);
		}

	}

}
