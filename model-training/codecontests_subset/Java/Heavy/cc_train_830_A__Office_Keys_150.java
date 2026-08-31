import java.io.*;
import java.util.*;

public class D {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int[] peeps = new int[n];
		int[] keys = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++){
			peeps[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(peeps);
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < k ; i++){
			keys[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(keys);

		long begin = 0;
		long end = Math.max(Math.abs(peeps[0] - keys[k-1]) + Math.abs(keys[k-1] - p), Math.abs(peeps[n-1] - keys[0]) + Math.abs(keys[0] - p));
		while(begin != end){
			long mid = (begin + end)/2;
			if(time(n, k, p, peeps, keys, begin, end, mid)){
				end = mid;
			}
			else{
				begin = mid+1;
			}
		}
		out.println(end);
		out.flush();

	}

	private static boolean time(int n, int k, int p, int[] peeps, int[] keys, long begin, long end, long mid) {
		int ppl = 0, key = 0;
        while (ppl < n && key < k) {
            if (Math.abs(peeps[ppl] - keys[key]) + Math.abs(keys[key] - p) <= mid) {
                ppl++;
                key++;
            }
            else
                key++;
        }
        if(ppl != n){
        	return false;
        }
        else{
        	return true;
        }
	}
}
