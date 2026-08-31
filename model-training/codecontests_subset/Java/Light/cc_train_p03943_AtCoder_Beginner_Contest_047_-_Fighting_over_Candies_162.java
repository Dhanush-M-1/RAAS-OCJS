import java.util.Scanner;
import java.util.Arrays;

class Main{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] candy = new int[3];
    for(int i=0; i<3; i++){
      candy[i] = Integer.parseInt(scanner.next());
    }

    Arrays.sort(candy);

    if(candy[2] == candy[0]+candy[1]){
      System.out.println("Yes");
    }else{
      System.out.println("No");
    }
  }
}
