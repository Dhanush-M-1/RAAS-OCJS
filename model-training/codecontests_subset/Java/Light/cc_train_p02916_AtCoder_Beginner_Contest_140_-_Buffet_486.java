import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int A[] = new int[N];
	int B[] = new int[N];
	int C[] = new int[N];
	
	sc.nextLine();
	for (int i=0; i<N; i++){
	  A[i] = sc.nextInt();
	}
    sc.nextLine();
	for (int i=0; i<N; i++){
	  B[i] = sc.nextInt();
	}
	sc.nextLine();
	for (int i=0; i<N-1; i++){
	  C[i] = sc.nextInt();
	}
	
    int cuisine = A[0];
	int SatisfacationP = B[cuisine-1];
    
	for (int i=1; i<N; i++){
	  cuisine = A[i];
	  SatisfacationP += B[cuisine-1];
	  if((A[i-1] + 1) == A[i]){
	    SatisfacationP += C[cuisine-2];
      }
	}
    
    System.out.println(SatisfacationP);
  }
}