import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n+1];
    int b[] = new int[n+1];
    int c[] = new int[n];
    int answer = 0;
    int before =0;
    for(int i=1;i<=n;i++){
      a[i]=sc.nextInt();
    }
    for(int i=1;i<=n;i++){
      b[i]=sc.nextInt();
    }
    for(int i=1;i<=n-1;i++){
      c[i]=sc.nextInt();
    }
    for(int i=1;i<=n;i++){
      answer = answer + b[a[i]];
      if(before+1==a[i]&&before!=0){
        answer = answer + c[before];
      }
      before = a[i];
    }
    System.out.println(answer);
  }
}