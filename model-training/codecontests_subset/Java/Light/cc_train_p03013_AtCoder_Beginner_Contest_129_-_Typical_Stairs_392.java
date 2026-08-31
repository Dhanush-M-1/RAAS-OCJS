import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int mod=1000_000_007;
    int n=sc.nextInt();
    int[] a=new int[n+1];
    int m=sc.nextInt();
    Deque<Integer> dq=new ArrayDeque<>();
    for(int i=0;i<m;i++){
      dq.addLast(sc.nextInt());
    }
    dq.addLast(n*2);
//    System.err.println(dq);
    a[0]=1;
    if(dq.peekFirst()==1){
      a[1]=0;
      dq.pollFirst();
    }else{
      a[1]=1;
    }
    for(int i=2;i<=n;i++){
      if(i==dq.peekFirst()){
        a[i]=0;
        dq.pollFirst();
      }else{
        a[i]=(a[i-1]+a[i-2])%mod;
      }
    }
//    System.err.println(Arrays.toString(a));
    System.out.println(a[n]);
  }
}