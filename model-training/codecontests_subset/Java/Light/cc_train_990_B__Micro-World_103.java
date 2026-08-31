import java.util.*;
public class A_GENERAL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count[] = new int[2000001];
		int a[] = new int[n];
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			count[a[i]]++;
			hs.add(a[i]);
		}
//		Arrays.sort(a);
		ArrayList<Integer> al = new ArrayList<>(hs);
		Collections.sort(al);
		
		int tot = 0;
		for(int i = 0; i < al.size()-1; ) {
			if(al.get(i) == al.get(i+1)) {
				i += count[al.get(i)]-1;
			}
			else if(al.get(i)+k >= al.get(i+1)) {
//				System.out.println(a[i]+ ", "+ count[a[i]]);
				tot += count[al.get(i)];
				i++;
			}
			else {
				i++;
			}
		}
//		for(int i = 0; i < n-1; ) {
//			if(a[i] == a[i+1]) {
//				i += count[a[i]]-1;
//			}
//			else if(a[i]+k >= a[i+1]) {
////				System.out.println(a[i]+ ", "+ count[a[i]]);
//				tot += count[a[i]];
//				i++;
//			}
//			else {
//				i++;
//			}
//		}
		System.out.println(n-tot);
		
		sc.close();
		
	}
	
}