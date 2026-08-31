import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();int ans = 2;
    int[] a = new int[n];
    int[] b = new int[n];
    for(int i=0;i<n;i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    if(n==1) ans--;

    for(int i=1;i<n-1;i++){
      if(a[i]-b[i]>a[i-1])ans++;
      else if(a[i+1]>a[i]+b[i]){
        ans++;
        a[i]+=b[i];
      }
    }
    System.out.println(ans);
  }
}
