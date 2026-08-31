import java.util.*;

public class Main {
  public static void main(String[] args ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int sum=0;
    int A[]=new int[N];
    int B[]=new int[N];
    int C[]=new int[N-1];
    for(int i=0;i<N;i++){
     A[i]=sc.nextInt();
     }
    for(int i=0;i<N;i++){
     B[i]=sc.nextInt();
     }
    for(int i=0;i<N-1;i++){
      C[i]=sc.nextInt();
    }
    for(int i=0;i<N;i++){
      if(i>0){
      if(A[i]-A[i-1]==1){
      	sum+=B[A[i]-1]+C[A[i]-2];
       }else{
        sum+=B[A[i]-1];
      }
      }else{
        sum+=B[A[i]-1];
      }
    } System.out.println(sum);
  }
}

