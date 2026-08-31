import java.util.*;
class Main{
  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    int N=scan.nextInt();
    int[] A=new int[N];
    int[] B=new int[N];
    int[] C=new int [N];
    for(int i=0;i<N;i++){
      A[i]=scan.nextInt();
    }
    for(int i=0;i<N;i++){
      B[i]=scan.nextInt();
    }
    for(int i=0;i<N-1;i++){
      C[i]=scan.nextInt();
    }
    int sum=0;
    int before=A[0];
    for(int i=0;i<N;i++){      
      sum+=B[A[i]-1];
      if(A[i]==before+1){
        sum+=C[before-1];
      }
      before=A[i];
    }
        System.out.println(sum);
      }
    }