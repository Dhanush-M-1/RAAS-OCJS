import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String str = sc.nextLine(),temp;
		int swaps = 0, mini;
		String[] A = str.split(" ");
		for(int i=0; i<=A.length-1; i++) {
			mini = i;
			for(int j=i; j<=A.length-1; j++) {
				if(Integer.valueOf(A[j]) < Integer.valueOf(A[mini])) {
					mini = j;
				}
			}
			if(i!=mini) {
				temp = A[i];
				A[i]=A[mini];
				A[mini]=temp;
				swaps++;
			}
		}
		for(int i=0;i<A.length-1;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println(A[A.length-1]+"\n"+swaps);
	}

}

