import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long s = sc.nextLong();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++)
      arr[i] = sc.nextLong();
    sc.close();
    
    int median = n/2;
    Arrays.sort(arr); long op = 0l;
    
    if(arr[median] == s)
      op = 0;
    else if(arr[median]>s){
      for(int i = median; i >= 0; i--){
        if(arr[i]<=s)
          break;
        else
          op += arr[i] - s;
      }
    }
    else {
      for(int i = median; i < n; i++){
        if(arr[i]>=s)
          break;
        else
          op += s - arr[i];
      }
    }
    
    System.out.println(op);
  }

}
