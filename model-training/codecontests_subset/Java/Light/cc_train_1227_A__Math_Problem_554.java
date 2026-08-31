import java.util.*;

public class CodeForces1227A{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i = 0;i<t;i++){
			int n = input.nextInt();
			int x = 0;
			int y = Integer.MAX_VALUE;
			for(int j = 0;j<n;j++){
				x = Math.max(x,input.nextInt());
				y = Math.min(y,input.nextInt());
			}
			System.out.println(Math.max(x-y,0));
		}
	}
}