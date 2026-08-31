import java.util.Scanner;

public class codeForces572A {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		
		int zeros=0;
		int ones=0;
		String temp="";
		for(int i=0;i<n;i++) {
			char current=s.charAt(i);
			if(current=='0') {
				zeros++;
			}
			else {
				ones++;
			}
			if(i!=n-1)
				temp+=current;
		}
		if(ones==zeros) {
			System.out.println(2);
			System.out.println(temp+" "+s.charAt(n-1));
		}
		else {
			System.out.println(1);
			System.out.println(s);
		}
		
		sc.close();
	}
}
