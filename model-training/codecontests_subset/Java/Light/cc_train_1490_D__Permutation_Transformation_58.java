import java.io.*;

public class Main {
	static int n;
	static int []a = new int[105];
	static int []d = new int[105];
	public static void main(String[] args) throws IOException {
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t = input.nextInt();
		while (t-- != 0){
			int n = input.nextInt();
			for (int i=0;i<n;i++){
				a[i] = input.nextInt();
				d[i] = -1;
			}
			solve(0,n-1,0);
			for (int i=0;i<n;i++){
				pr.print(d[i] + " ");
			}
			pr.println();
			pr.flush();
		}
	}
	public static void solve(int l,int r, int step){
		if (l > r) return;
		int max = 0, temp = -1;
		for (int i=l;i<=r;i++){
			if (a[i] > max){
				max = a[i];
				temp = i;
			}
		}
		d[temp] = step;
		solve(l,temp-1,step+1);
		solve(temp+1,r,step+1);
	}
	
	static class input{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StreamTokenizer in = new StreamTokenizer(br);
		static String next() throws IOException{
			return br.readLine();
		}
		static int nextInt() throws IOException{
			in.nextToken();
			return (int)in.nval;
		}
		static long nextLong() throws IOException{
			in.nextToken();
			return (long)in.nval;
		}
	}
}

 				 	 	   	 		 	 	   		   	 	