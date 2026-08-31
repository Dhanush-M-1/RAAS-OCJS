import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int A[] =new int[N+1];
    int B[] =new int[N+1];
    int C[] =new int[N];
    for(int i=0;i<N;i++){
      A[i]=sc.nextInt();}
    A[N]=0;
    B[0]=0;
    for(int j=1;j<N+1;j++){
      B[j]=B[j-1]+sc.nextInt();}
    int x=B[N];
    if(N==1){System.out.println(x);}
    for(int k=0;k<N-1;k++){
      C[k]=sc.nextInt();}
      for(int l=0;l<N;l++){
        if(A[l+1]==A[l]+1){x=x+C[A[l]-1];}}
    System.out.println(x);
  }
}