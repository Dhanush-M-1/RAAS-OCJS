import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<String> a;
	private static Scanner in=new Scanner(new BufferedInputStream(System.in));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=in.nextInt();
		a=new ArrayList<>();
		String s=in.next();
		for(int i=2;i<=n;i++) {
			a.add(s.substring(i-2,i));
		}
		Collections.sort(a);
		int t=1;
		s=a.get(0);
		int sum=1;
		String ans=s;
		n=a.size();
		for(int i=1;i<n;i++) {
			if(s.equals(a.get(i))) {
				t++;
			}
			else {
				if(t>sum) {
					sum=t;
					ans=s;
				}
				s=a.get(i);
				t=1;
			}
		}
		if(t>sum) {
			sum=t;
			ans=s;
		}
		System.out.println(ans);
	}
}