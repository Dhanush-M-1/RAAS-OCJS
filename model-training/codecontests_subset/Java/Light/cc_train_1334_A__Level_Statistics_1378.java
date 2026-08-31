import java.util.*;
public class MOOCProject {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			int i = 0;
			while(n-->0) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				a[i] = p;
				b[i] = c;
				i++;
			}
		if(a[0]<b[0]) {
			System.out.println("NO");
		}
		else {
		 boolean flag = true;
		 for(int j = 1 ; j<a.length;j++) {
			 if(a[j] >= a[j-1] && b[j]>=b[j-1] && b[j]<= (a[j]-a[j-1])+b[j-1]) {
				 continue;
			 }
			 else {
				 flag = false;
				 break;
			 }
		 }
		 if(flag) {
			 System.out.println("YES");
		 }
		 else {
			 System.out.println("NO");
		 }
		}
		}
	}
	
		}
	}
