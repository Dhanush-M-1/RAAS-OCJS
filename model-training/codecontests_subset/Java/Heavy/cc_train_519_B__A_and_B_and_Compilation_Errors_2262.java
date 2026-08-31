import java.util.*;
public class CF519B_AAndBCompilationErrors {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n - 1];
		int[] c = new int[n - 2];
		for(int i = 0; i < n; i ++)a[i] = in.nextInt();
		for(int i = 0; i < n - 1; i ++)b[i] = in.nextInt();
		for(int i = 0; i < n - 2; i ++)c[i] = in.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		for(int i = 0; i < n - 1; i ++){
			if(a[i] != b[i]){
				System.out.println(a[i]);
				break;
			}
			if(i == n - 2)System.out.println(a[i + 1]);
		}
		for(int i = 0; i < n - 2; i ++){
			if(b[i] != c[i]){
				System.out.println(b[i]);
				break;
			}
			if(i == n - 3)System.out.println(b[i + 1]);
		}
		
		
//		HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
//		HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
//		HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();
//
//		for(int i = 0; i < n; i ++){
//			int t = in.nextInt();
//			if(!a.containsKey(t))a.put(t, 0);
//			a.put(t, a.get(t) + 1);
//		}
//		for(int i = 0; i < n - 1; i ++){
//			int t = in.nextInt();
//			if(!b.containsKey(t))b.put(t, 0);
//			b.put(t, b.get(t) + 1);
//		}	
//		for(int i = 0; i < n - 2; i ++){
//			int t = in.nextInt();
//			if(!c.containsKey(t))c.put(t, 0);
//			c.put(t, c.get(t) + 1);
//		}
//		
//		for(int e: a.keySet()){
//			if(!b.containsKey(e) || b.get(e) != a.get(e))System.out.println(e);
//		}
//		for(int e: b.keySet()){
//			if(!c.containsKey(e) || c.get(e) != b.get(e))System.out.println(e);
//		}
	}
}
