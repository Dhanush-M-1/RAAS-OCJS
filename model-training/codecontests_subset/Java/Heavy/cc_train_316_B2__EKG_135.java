import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt()-1;
		
		int[] A = new int[n];
		Integer[] B = new Integer[n];
		int zeroes = 0;
		for(int i=0; i<n; i++) {
			A[i] = in.nextInt()-1;
			if(A[i]>=0)
				B[A[i]] = i;
		}
		
		int start = 0;
		
		List<Integer> L = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			if(B[i]==null) {
				boolean has_x = false;
				int len = 1;
				int y = i;
				while(A[y] >= 0) {
					if(y==x) {
						start = len;
						has_x = true;
					}
					y = A[y];
					len++;
				}
				if(y==x) {
					start = len;
					has_x = true;
				}
				
				if(has_x)
					start = len-start+1;
				else L.add(len);
			}
		}
		
		boolean[] CAN = new boolean[n+1];
		CAN[start] = true;
		for(Integer len : L) {
			for(int i=n-len; i>=0; i--)
				if(CAN[i])
					CAN[i+len] = true;
		}
		
		for(int i=0; i<=n; i++)
			if(CAN[i])
				System.out.println(i);
	}
}
