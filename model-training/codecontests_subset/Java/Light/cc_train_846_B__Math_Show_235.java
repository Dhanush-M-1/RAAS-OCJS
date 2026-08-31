import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BEdu28 {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int N = scan.nextInt(), K = scan.nextInt(), M = scan.nextInt();
		int[] time = new int[K];
		for(int i=0;i<K;i++)time[i] = scan.nextInt();
		int sum = 0;
		for(int i : time)sum+=i;
		Arrays.sort(time);
		int sol = 0;
		for(int i=0;i<=N;i++){
			if(i*sum>M)break;
			int temp = M-i*sum;
			int score = (K+1)*i;
			for(int j=0;j<K;j++){
				if((N-i)*time[j]>temp){
					int count = (temp/time[j]);
					score+=count;
					temp-=count*time[j];
					break;
				}else{
					score+=(N-i);
					temp-=(N-i)*time[j];
				}
			}
			sol = Math.max(sol, score);
		}
		System.out.println(sol);
		
	}
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
