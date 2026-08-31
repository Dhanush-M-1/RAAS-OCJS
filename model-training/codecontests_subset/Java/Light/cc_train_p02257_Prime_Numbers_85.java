import java.util.Scanner;

class Main {
  public static void main(String[] args){
    Scanner nyuryoku = new Scanner(System.in);
    int n = nyuryoku.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++){
      num[i] = nyuryoku.nextInt();
    }
    int ans = prime(n, num);
    System.out.println(ans);
  }
  public static int prime(int n, int[] num){
    int count = 0;
    IN:for (int i = 0; i < n; i++){
      for (int j = 2; j*j <= num[i];j++)
        if (num[i] % j == 0) {continue IN;}
    count++;
    }
    return count;
  }
}
