import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int n = sc.nextInt();
    int [][] a = new int [3][n];
    for(int i =0; i < n; i++){
      a[0][i] = sc.nextInt();
      }
    for(int i =0; i < n; i++){
      a[1][i] = sc.nextInt();
      }
    for(int i =0; i < n; i++){
        if((i+1)==n){
          a[2][i]=0;
        }else{
          a[2][i] = sc.nextInt();
        }
      }
    for(int i = 0; i < n; i++){
      sum += a[1][i];
    }
    for(int i = 0;i < n -1;i++){
      if(((a[0][i])-(a[0][i + 1])) == -1){
        sum += a[2][a[0][i]-1];
      }
    }
    System.out.println(sum);
  }
}