import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Asmall411 {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		
		int l = scan.nextInt(), r = scan.nextInt();
		if(r-l+1 > 6){
			System.out.println(2);
		}else{
			
			HashMap<Integer, Integer> count = new HashMap<>();
			for(int i=l;i<=r;i++){
				
				for(int j=1;j<=Math.sqrt(i);j++){
					if(i%j==0){
						if(count.containsKey(j))count.put(j, count.get(j)+1);
						else count.put(j, 1);
						if(i/j == j)continue;
						if(count.containsKey(i/j))count.put(i/j, count.get(i/j)+1);
						else count.put(i/j, 1);
					}
				}
			}
			
			int max = 0, maxIdx = -1;
			for(int i : count.keySet()){
				if(i==1)continue;
				if(count.get(i)>max){
					max = count.get(i);
					maxIdx = i;
				}
			}
			System.out.println(maxIdx);
		}
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
