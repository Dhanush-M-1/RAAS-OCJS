
import java.util.*;

public class RobotWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
			int[] a = new int[3];
			a[0]=input.nextInt();
			a[1]=input.nextInt();
			a[2]=a[0]^a[1];
			int n = input.nextInt();
			System.out.println(a[n%3]);
		}
	}
}
