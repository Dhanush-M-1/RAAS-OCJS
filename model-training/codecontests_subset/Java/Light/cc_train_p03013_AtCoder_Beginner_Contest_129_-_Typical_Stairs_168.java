import java.util.Scanner;
import java.util.Arrays;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n+1];//0段目からn段目のNG
    int[] b = new int[n+1];//0段目からn段目の場合の数
    int count = 0;

    for(int i=0; i<m; i++){
      a[sc.nextInt()]=-1;
    }

    b[0] = 1;
    b[1] = (a[1]==-1)?0:1;
    for(int i=2; i<=n; i++){
      if(b[i]==-1){continue;}
      b[i-2] = (a[i-2]==-1)? 0:b[i-2];
      b[i-1] = (a[i-1]==-1)? 0:b[i-1];
      b[i]= b[i-1] + b[i-2];
      b[i]=b[i]%1000000007; //i段目の場合の数
    }
    System.out.println(b[n]);


  }
}