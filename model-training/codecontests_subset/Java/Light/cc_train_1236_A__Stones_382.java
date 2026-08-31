import java.util.*;
public class Stone {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		int [] b = new int[n];
		int [] c = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt(); b[i]=sc.nextInt(); c[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			int count=0;
			while(true) {
				if((c[i]>=2)&&(b[i]>=1)) {c[i]-=2; b[i]-=1; count+=3;}
				else if((b[i]>=2)&&(a[i]>=1)) {b[i]-=2; a[i]-=1; count+=3;}
			     	else  break;
			}
			System.out.println(count);
		}
	}
}