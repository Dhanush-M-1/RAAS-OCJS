import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ZepoLabA {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n=in.nextInt();
		String s=in.nextToken();
		
		for(int i=0;i<n;i++){
			for(int j=1;j<=n;j++){
				int cnt=0;
				for(int k=0;k<5;k++){
					if(i+k*j<n&&s.charAt(i+k*j)=='*')
						cnt++;
				}
				if(cnt==5){
					System.out.println("yes");
					return;
				}
					
			}
		}
		System.out.println("no");
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br=new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st==null||!st.hasMoreElements())
				try{st=new StringTokenizer(br.readLine());}catch(Exception e){}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
