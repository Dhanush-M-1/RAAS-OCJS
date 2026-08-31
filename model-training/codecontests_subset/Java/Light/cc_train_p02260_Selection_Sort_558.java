import java.util.*;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int minj, count = 0, temp;
		
		for(int i = 0; i < N; i++){
			minj = i;
			for(int j = i; j < N; j++) if(A[j] < A[minj]) minj = j;
			if(A[i] != A[minj]){
				temp = A[i];
				A[i] = A[minj];
				A[minj] = temp;
				count++;
			}
		}
		
		System.out.print(A[0]);
		for(int i = 1; i < N; i++) System.out.print(" " + A[i]);
		System.out.println();
		System.out.println(count);
	}
}
