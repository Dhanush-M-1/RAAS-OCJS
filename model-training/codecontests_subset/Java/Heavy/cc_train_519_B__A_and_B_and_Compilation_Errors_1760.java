import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			list1.add(sc.nextInt());
		}
		for(int i=1; i<=n-1; i++) {
			list2.add(sc.nextInt());
		}
		for(int i=1; i<=n-2; i++) {
			list3.add(sc.nextInt());
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);
		
		int i = 0;
		for(i=0; i<list2.size(); i++) {
			if(list1.get(i).intValue() != list2.get(i).intValue()) break;
		}
		System.out.println(list1.get(i));
		
		for(i=0; i<list3.size(); i++) {
			if(list2.get(i).intValue() != list3.get(i).intValue()) break;
		}
		System.out.println(list2.get(i));
	}
}
