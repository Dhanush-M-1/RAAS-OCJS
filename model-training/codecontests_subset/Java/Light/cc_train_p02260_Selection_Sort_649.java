import java.util.Scanner;

public class Main {
  static int counter;
  public static void main(String[] args) {
    Scanner scanInt = new Scanner(System.in);
    int N = scanInt.nextInt();
    int[] nums = new int[N];
    for(int i = 0; i < N; i++){
      nums[i] = scanInt.nextInt();
    }

    for(int i = 0; i < N - 1; i++){
      int min = i;
      for(int j = i; j <= N - 1; j++){
        if(nums[min] > nums[j]){
          min = j;
        }
      }
      if(min != i){
        int dum = nums[min];
        nums[min] = nums[i];
        nums[i] = dum;
        counter++;
      }
    }

    for(int i = 0; i < N-1; i++){
      System.out.print(nums[i] + " ");
    }
    System.out.println(nums[N-1]);
    System.out.println(counter);
  }

}

