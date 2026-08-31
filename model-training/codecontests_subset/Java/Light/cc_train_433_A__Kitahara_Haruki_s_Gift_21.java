import java.util.Scanner;

public class Apples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count1 = 0;
		int count2 = 0;
		for(int i=0; i<n;i++) {
			if(sc.nextInt()==100) count1++;
			else count2++;
		}
		if(count1%2==0&&count2%2==0) System.out.println("YES");
		
		else if(count1==0&&count2%2!=0) System.out.println("NO");
		else if(count1%2==0&&count2%2!=0) System.out.println("YES");
		else System.out.println("NO");
  }
}
