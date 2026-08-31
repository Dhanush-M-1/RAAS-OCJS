import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A438 {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		String s = scan.next();
		int N = scan.nextInt();
		String[] list = new String[N];
		for(int i=0;i<N;i++){
			list[i] = scan.next();
		}
		
		int idx = 0;
		while(idx < s.length()){
			boolean found = false;
			for(String x : list){
				if(x.charAt(0)==s.charAt(idx) && x.charAt(1) == s.charAt(idx+1)){
					idx+=2;
					found = true;
					break;
				}
			}
			if(!found)break;
		}
		if(idx>=s.length()){
			System.out.println("YES");
			return;
		}
		
		boolean start = false, end = false;
		for(String x : list){
			if(x.charAt(1)==s.charAt(0))start=true;
			if(x.charAt(0)==s.charAt(s.length()-1))end=true;
		}
		
		if(start&&end){
			idx = 1;
			while(idx < s.length()-1){
				boolean found = false;
				for(String x : list){
					if(x.charAt(0)==s.charAt(idx) && x.charAt(1) == s.charAt(idx+1)){
						idx+=2;
						found = true;
						break;
					}
				}
				if(!found)break;
			}
			if(idx>=s.length()-1){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
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
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}
