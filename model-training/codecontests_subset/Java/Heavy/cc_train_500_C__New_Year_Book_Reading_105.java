import java.util.*;
import java.io.*;
public class lifting {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] weights = new int[N];
		st = new StringTokenizer(f.readLine());
		for(int i=0;i<N;i++){
			weights[i] = Integer.parseInt(st.nextToken());
			
		}
		int[] calls = new int[M];
		TreeMap<Integer, Integer> firstInstanceOf = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(f.readLine());
		for(int i=0;i<M;i++){
			calls[i] = Integer.parseInt(st.nextToken())-1;
		}
		boolean[] seen = new boolean[N];
		for(int i=0;i<M;i++){
			if(!seen[calls[i]]){
				firstInstanceOf.put(i, calls[i]);
				seen[calls[i]] = true;
			}
		}
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(Integer i : firstInstanceOf.keySet()){
			a.add(firstInstanceOf.get(i));
		}
		Collections.reverse(a);
//		System.out.println(a);
		int ans = 0;
		for(int i=0;i<M;i++){
			int book = calls[i];
			int r = a.indexOf((Integer) book);
//			int now = 0;
			for(int i2=r+1;i2<a.size();i2++){
				ans += weights[a.get(i2)];
			}
//			System.out.println(a);
//			System.out.println(now);
//			ans += now;
			a.remove(r);
			a.add(book);
//			System.out.println(a);
		}
		System.out.println(ans);
	}
}
