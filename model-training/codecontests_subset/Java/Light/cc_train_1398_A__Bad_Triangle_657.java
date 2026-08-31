import java.util.*;
public class BadTriangle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int a=sc.nextInt();
			int arr[]=new int[a];
			for(int j=0;j<a;j++) {
				arr[j]=sc.nextInt();
			}
			if((arr[0]+arr[1])<=(arr[a-1])) {
				System.out.println(1+" "+2+" "+a);
			}
			else {
				System.out.println("-1");
			}
		}

	}

}
