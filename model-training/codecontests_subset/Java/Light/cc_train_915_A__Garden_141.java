import java.util.Scanner;
public class a915 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt(); 
		int k = sc.nextInt();
		int minA=0;
		int minN=k+1;
		for(int i=0;i<n;i++) {
			int a=sc.nextInt();
			if (k%a==0 && k/a<minN) {
				minN = k/a;
				minA=a;
			}
		}
		System.out.println(k/minA);
	}
}
