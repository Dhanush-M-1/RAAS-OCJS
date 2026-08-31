import java.io.*;
import java.util.*;

public class C{
	public static boolean DEBUG = true;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		StringTokenizer st = getst(br);
		
		int n = nextInt(st);
		int m = nextInt(st);
		
		int[] weights = new int[n];
		boolean[] read = new boolean[n];
		
		st = getst(br);
		
		for(int i = 0; i < n; i++){
			weights[i] = nextInt(st);
		}
		
		st = getst(br);
		
		int sum = 0;
		long ans = 0;
		
		ArrayList<Integer> books = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++){
			int next = nextInt(st)-1;
			if(!read[next]){
				books.add(next);
				read[next] = true;
				ans += sum;
				sum += weights[next];
			} else {
				int s = 0;
				for(int j = books.size()-1; j >= 0; j--){
					if(books.get(j) == next){
						books.remove(j);
						ans += s;
						break;
					} else {
						ans += weights[books.get(j)];
					}
				}
				
				books.add(next);
			}
		}
		
		pw.println(ans);
		
		br.close();
		pw.close();
	}
	
	public static void debug(Object o){
		if(DEBUG){
			System.out.println("~" + o);
		}
	}
	
	public static StringTokenizer getst(BufferedReader br) throws Exception{
		return new StringTokenizer(br.readLine(), " ");
	}
	
	public static int nextInt(BufferedReader br) throws Exception{
		return Integer.parseInt(br.readLine());
	}
	
	public static int nextInt(StringTokenizer st) throws Exception{
		return Integer.parseInt(st.nextToken());
	}
}