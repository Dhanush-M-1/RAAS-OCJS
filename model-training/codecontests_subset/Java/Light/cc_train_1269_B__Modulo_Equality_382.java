import java.util.*;

public class CodeForces1269B{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0;i<n;i++){
			a[i] = input.nextInt();
		}

		for(int i = 0;i<n;i++){
			b[i] = input.nextInt();
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		int min = m+1;
		int ans = 0;

		for(int i = 0;i<n;i++){

			ans = (b[0]-a[i]+m)%m;
			boolean bool = true;
			for(int j = 1;j<n;j++){
				if((a[(i+j)%n]+ans)%m == b[j]) continue;
				bool = false;
			}

			if(bool){
				min = Math.min(ans,min);
			}
		}

		System.out.println(min);
	}
}