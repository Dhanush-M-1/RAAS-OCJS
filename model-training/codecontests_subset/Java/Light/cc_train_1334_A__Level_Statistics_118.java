import java.util.*;
public class p {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int n  = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			if(a[0]<b[0]){
				System.out.println("NO");
				continue;
			}
			int flag = 0;
			for(int i=1;i<n;i++){
				if(b[i-1]>a[i] || a[i]<a[i-1] || b[i]<b[i-1]||b[i]>a[i] || (b[i]-b[i-1])>(a[i]-a[i-1])){
					flag=1;
					break;
				}
				if((a[i-1]==a[i] && b[i-1]<b[i])){
					flag = 1;
					break;
				}
			}
			if(flag == 0)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
