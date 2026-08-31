import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class R438A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		String pass=in.next();
		int n=in.nextInt();
		String [] arr= new String[n];
		Set<Character> s1=new HashSet<Character>();
		Set<Character> s2=new HashSet<Character>();
		boolean knew=false;
		for(int i=0;i<n;i++) {
			arr[i]=in.next();
			s1.add(arr[i].charAt(1));
			s2.add(arr[i].charAt(0));
			if(arr[i].equals(pass)) knew=true;
		}
		if(knew) {
			System.out.println("YES");
			return;
		}
		for(Character c1: s1) {
			for(Character c2: s2) {
				if(pass.equals(""+c1+c2)) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}

}