import java.util.*;	
public class D {
	public static void main(String...ed){
		Scanner seer = new Scanner(System.in);
		int n = seer.nextInt();
		int k = seer.nextInt();
		if(k < n+1 || n == 4){
			System.out.println("-1"); return;
		}
		int a = seer.nextInt();
		int b = seer.nextInt();
		int c = seer.nextInt();
		int d = seer.nextInt();
		HashSet<Integer> set = new HashSet<>();
		set.add(a); set.add(b); set.add(c); set.add(d);
		int[] res = new int[n];
		res[0] = a; res[n-1] = b;
		res[1] = c; res[3] = d;
		int u = 1;
		while(set.contains(u)) u++;
		res[2] = u; u++;
		for(int i = 4; i < n-1; i++){
			while(set.contains(u)) u++;
			res[i] = u; u++;
		}
		StringBuilder sb = new StringBuilder();
		for(int n0: res){
			sb.append(n0+" ");
		}
		System.out.println(sb.toString().trim());
		sb = new StringBuilder();
		sb.append(res[1]+" "+res[0]+" "+res[2]+" ");
		for(int i = n-1; i > 2; i--){
			sb.append(res[i]+" ");
		}
		System.out.println(sb.toString().trim());
	}
}
