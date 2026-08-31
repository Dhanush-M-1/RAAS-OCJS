import java.util.Scanner;

class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int[] stair = new int[n+1];
    int mod = 1_000_000_007;
    for(int i=0;i<m;i++){
      stair[Integer.parseInt(sc.next())] = -1;
    }
    stair[0] = 1;
    for(int i=1;i<=n;i++){
      if(stair[i]==-1)continue;
      if(i>1){
        if(stair[i-2]!=-1)stair[i]+=stair[i-2];
        if(stair[i-1]!=-1)stair[i]+=stair[i-1];
        stair[i] = stair[i]%mod;
      }else{
        stair[i]+=1;
      }
    }
    System.out.print(stair[n]);
    System.out.flush();
  }
}