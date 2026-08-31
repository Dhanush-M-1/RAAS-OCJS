import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    int length = scanner.nextInt();
		int A[] = new int[length];
        for(int i = 0; i < length; i++)
        	A[i] = scanner.nextInt();
        
        int key = 1000;
		int mini = 0;
		int count = 0;
		for (int i = 0; i < length; i++) {
			mini = i;
			for (int j = i; j < length; j++) {
				if (A[j] < A[mini])
					mini = j;
			}
			if (i != mini){
			key = A[mini];
			A[mini] = A[i];
			A[i] = key;
			count++;
			}
		}
		out_put(A);
		System.out.println(count);	
	}
	
	private static void out_put(int A[]){
        System.out.printf("%d", A[0]);
        for(int i = 1; i < A.length; i++){
            System.out.printf(" %d", A[i]);
        }
        System.out.printf("\n");
    }
}
