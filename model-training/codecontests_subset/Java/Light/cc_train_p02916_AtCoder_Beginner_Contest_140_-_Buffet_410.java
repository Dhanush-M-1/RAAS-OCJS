import java.util.*;
public class Main {
    public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[]A = new int[N];
    int[]B = new int[N];
    int[]C = new int[N];

    int all = 0;
    for(int i=0; i<N; i++){
        A[i] = sc.nextInt();
}
    for(int i=0; i<N; i++){
        B[i] = sc.nextInt();
           all += B[i];
}
    for(int i=0; i<N-1; i++){
        C[i] = sc.nextInt();
    }    
   for(int j=0; j<N-1; j++){
    if(A[j+1]==A[j]+1){
       all += C[A[j]-1];
    }
}
    System.out.println(all);
 }
}
