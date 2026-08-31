

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LevkoAndArrayRecovery {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer tk = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());

		int[][] commands = new int[M][4];
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine());
			for (int j = 0; j < 4; j++) {
				commands[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		int[] arr = new int[N];
		boolean[] set = new boolean[N];
		for(int i = M-1; i>=0;i--) {
			int l = commands[i][1]-1;
			int r = commands[i][2]-1;
			if(commands[i][0] == 1){
				int d = commands[i][3];
				for(int j=l;j<=r;j++) {
					if(set[j]){
						arr[j] -= d;
					}
				}
			}else{
				int m = commands[i][3];
				for(int j=l;j<=r;j++) {
					if(set[j]){
						arr[j] = Math.min(m, arr[j]);
					}else{
						set[j] = true;
						arr[j] = m;
					}
				}
			}
		}
		int[] arrCopy = arr.clone();
		boolean good = true;
		
		for(int i =0; i< M;i++){
			int l = commands[i][1]-1;
			int r = commands[i][2]-1;
			if(commands[i][0] == 1){
				int d = commands[i][3];
				for(int j=l;j<=r;j++) {
					arr[j] += d;
				}
			}else{
				int m = commands[i][3];
				int max = Integer.MIN_VALUE;
				for(int j=l;j<=r;j++) {
					max = Math.max(max, arr[j]);
				}
				if(max!=m){
					good = false;
					break;
				}
			}
		}
		if(good){
			out.println("YES");
			for(int i=0;i<arrCopy.length;i++){
				out.print(arrCopy[i] + " ");
			}
		}else{
			out.println("NO");
		}
		
		out.close();
	}
}
