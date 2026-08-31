import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test=0; test<T; test++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] a = new int[N+1];
			for(int i=1; i<=N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean check = false;
			boolean check2 = false;
			int one = 1;
			int two = 2;
			int three = N;
			while(a[one] + a[two] > a[three]) {
				if(one == N-2) {
					check = true;
					break;
				}
				if(!check2) {
					if(two==N-1) {
						check2 = true;
					}
					two++;
				}else {
					one++;
				}
			}
			if(check) {
				System.out.println(-1);
			}else {
				System.out.println(one +" "+ two +" "+ three);
			}
			
			
		}
		


	}

}
