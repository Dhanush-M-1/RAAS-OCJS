import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int MOD =  1000000007;
    boolean move[] = new boolean[N+3];
    //初期化
    for (int i=0;i<N+3;i++){
      move[i] = true;
    }
    for (int i=0;i<M;i++){
      int a = sc.nextInt();
      move[a] = false;
    }
    
    int DParray[] = new int[N+5];
    for (int i=0;i<N+3;i++){
      DParray[i] = 0;
    }
    DParray[0] = 1;
    
    for (int i=0;i<N;i++){
      if(move[i+1]){
        DParray[i+1] += DParray[i];
        DParray[i+1] %= MOD;
      }
      if(move[i+2]){
        DParray[i+2] += DParray[i];
        DParray[i+2] %= MOD;
      }
    }
    
    System.out.println(DParray[N]%MOD);
  }
}
  