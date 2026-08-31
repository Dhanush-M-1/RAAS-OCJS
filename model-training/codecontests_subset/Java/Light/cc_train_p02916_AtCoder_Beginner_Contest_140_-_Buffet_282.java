import java.util.*;
public class Main {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
  	int ANS = 0;
  	int[] A = new int[N];
    int[] B = new int[N];
    int[] C = new int[N-1];
  	for(int i=0;i<N;i++){
      A[i] = sc.nextInt();
    }
  	for(int j=0;j<N;j++){
      B[j] = sc.nextInt();
    }
  	for(int k=0;k<N-1;k++){
      C[k] = sc.nextInt();
    }
  	
  	for(int m=0;m<N;m++){
     	ANS += B[A[m]-1]; 
      	if(m>0){
	      	if(A[m]==A[m-1]+1){
              ANS += C[A[m]-2];
            }
        }
    }
  	
  	System.out.println(ANS);

	}
}