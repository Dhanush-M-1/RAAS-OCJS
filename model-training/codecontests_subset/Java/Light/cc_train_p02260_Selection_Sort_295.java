import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int A[] = new int[N];
		for(int i=0;i<N;i++){
			A[i]=Integer.parseInt(sc.next());
		}
		sc.close();
		
		int count=0;
		for(int i=0;i<N-1;i++){
			int minj=i;
			for(int j=i;j<N;j++){
				if(A[j]<A[minj]){
					minj=j;
				}
			}
			int temp=A[i];
			if(i!=minj){
				A[i]=A[minj];
				A[minj]=temp;
				count++;
			}
		}
		
		for(int i=0;i<N-1;i++){
			System.out.print(A[i]+" ");
		}
		System.out.println(A[N-1]);
		System.out.println(count);

	}

}