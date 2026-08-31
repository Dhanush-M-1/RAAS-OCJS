import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ads {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();

	for(int i=0;i<q;i++) {	
		int l=sc.nextInt();
		int r=sc.nextInt();
		int d=sc.nextInt();
		if(l>d) {
			System.out.println(d);
		}
		else {
			if(d>r)
				System.out.println(d);
			else
				System.out.println((d-r%d)+r);
			
		}
	}
	}
}
		