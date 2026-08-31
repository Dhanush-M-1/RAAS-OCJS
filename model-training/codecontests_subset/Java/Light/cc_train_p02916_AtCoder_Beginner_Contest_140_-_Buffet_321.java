import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i = 0;i<n;i++)a[i]=sc.nextInt();
    int[] b = new int[n];
    for(int i = 0;i<n;i++)b[i]=sc.nextInt();
    int[] c = new int[n];
    for(int i = 0;i<n-1;i++)c[i]=sc.nextInt();
    c[n-1]=0;

    int count = 0;
    int now;
    int before=n-1;
    int satisfaction = 0;
    while(count<n){
      now = a[count]-1;
      satisfaction+=b[now];
      if(before+1==now)satisfaction+=c[before];
      before=now;
      count++;
    }
    System.out.println(satisfaction);
  }
}
