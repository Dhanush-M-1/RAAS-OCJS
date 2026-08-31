import java.util.*;
class Main{
  public static void main(String args[]){
    int[] nums = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
    int k;
    Scanner s = new Scanner(System.in);
    k = s.nextInt();
    System.out.println(""+nums[k-1]);
  }
}