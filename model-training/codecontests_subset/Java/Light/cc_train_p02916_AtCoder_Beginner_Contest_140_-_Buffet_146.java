import java.util.*;

public class Main{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a[]=new int[n+1];//食べた順番
    for (int i=1;i<=n;i++) {
      a[i]=sc.nextInt();
    }
    int b[]=new int[n+1];//料理の満足度
    for (int i=1;i<=n;i++) {
      b[i]=sc.nextInt();
    }
    int c[]=new int[n];//連続する番号の料理を食べた時の満足度の追加
    for (int i=1;i<=n-1;i++) {
      c[i]=sc.nextInt();
    }

    int total=0;

    for (int i=1;i<=n;i++) {
      //System.out.println(b[a[i]]);
      total+=b[a[i]];
      if (a[i]==a[i-1]+1) {
        total+=c[a[i-1]];
      }
    }

    System.out.println(total);

  }
}
