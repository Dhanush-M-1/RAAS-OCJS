import java.util.Scanner;

public class Main { 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] F = new int[N][10];
    for (int i =0; i<N; i++) {
      for (int j =0; j<10; j++) {
          F[i][j] = sc.nextInt();
      }
    }
    long[][] P = new long[N][11];
    for (int i =0; i<N; i++) {
      for (int j =0; j<11; j++) {
          P[i][j] = sc.nextInt();
      }
    }
    long max = Long.MIN_VALUE; 
    for(int i=1;i<(2<<9);i++) {
      int[] count = new int[N];
	  for(int j=0;j<10;j++) {
        int t = (i>>j)&1;
        if(t==1) {
          for(int k=0;k<N;k++) {
            if(F[k][j]==1) count[k]++;
          }
        }
      }   
      int sum = 0;
      for(int j=0;j<N;j++) {
        sum += P[j][count[j]];
      }
      max=Math.max(max, sum);
    }      
    System.out.println(max);  
  }
}