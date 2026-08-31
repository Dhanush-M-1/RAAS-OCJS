import java.util.*;
public class ParityAlternatedDeletions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		List<Integer> l = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			if(arr[i]%2==0) {
				l1.add(arr[i]);
			}
			else {
				l.add(arr[i]);
			}
		}
		boolean x = true;
		if(l.size()>=l1.size()) {
			for(int i=0;i<n;i++) {
				if(x) {
					if(l.size()==0) {
						break;
					}
					l.remove(l.size()-1);
					x = false;
				}
				else {
					if(l1.size()==0) {
						break;
					}
					l1.remove(l1.size()-1);
					x = true;
				}
			}
		}
		else {
			for(int i=0;i<n;i++) {
				if(x) {
					if(l1.size()==0) {
						break;
					}
					l1.remove(l1.size()-1);
					x = false;
				}
				else {
					if(l.size()==0) {
						break;
					}
					l.remove(l.size()-1);
					x = true;
				}
			}
		}
		int sum = 0;
		boolean f = false;
		if(l.size()==0 && l1.size()==0) {
			f = true;
		}
		else {
			if(l.size()>l1.size()) {
				for(int i=0;i<l.size();i++) {
					sum+=l.get(i);
				}
			}
			else {
				for(int i=0;i<l1.size();i++) {
					sum+=l1.get(i);
				}
			}
		}
		if(f) {
			System.out.println(0);
		}
		else {
			System.out.println(sum);
		}
	}

}