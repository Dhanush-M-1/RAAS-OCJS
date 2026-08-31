import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    sc.close();
    Arrays.sort(arr);
    int elo = 0;
    for(int i = 0; i < n; i++)
      elo += arr[i];
    //System.out.println(elo);
    int k = arr[n-1];
    int awk = 0;
    while(awk<=elo){
      awk = 0;
      for(int i = 0; i < n; i++){
        awk += k - arr[i];
      }
      //System.out.println(awk);
      if(awk>elo){
        System.out.println(k);
        return;
      } else {
        k++;
      }
    }
  }

}
