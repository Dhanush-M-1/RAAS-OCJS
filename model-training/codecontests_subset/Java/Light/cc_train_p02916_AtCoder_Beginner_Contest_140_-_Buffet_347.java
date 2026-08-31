import java.util.*;

public class Main {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int N = Integer.parseInt(sc.next());
	  
	  int[] A = new int[N];
	  for(int i = 0; i < A.length; i++)
		  A[i] = Integer.parseInt(sc.next());
	  
	  int[] B = new int[N];
	  for(int i = 0; i < B.length; i++)
		  B[i] = Integer.parseInt(sc.next());
	  
	  int[] C = new int[N-1];
	  for(int i = 0; i < C.length; i++)
		  C[i] = Integer.parseInt(sc.next());
 	  
	  int temp = 0;
	  for(int i = 0; i < A.length; i++) {
		  temp += B[A[i] -1];
		  if(i > 0 && A[i] == A[i-1] +1) {
			  temp += C[A[i-1] -1];
		  }
	  }
	  
	  System.out.println(temp);
	  
	  sc.close();
	  
  }
}
