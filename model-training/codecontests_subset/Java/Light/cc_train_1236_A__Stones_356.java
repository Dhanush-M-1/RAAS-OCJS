import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int lim = in.nextInt();
    in.nextLine();
    for(int i = 0; i < lim; i++){
      new Solution(in.nextInt(), in.nextInt(), in.nextInt());
      in.nextLine();
    }
  }
}
class Solution{
  private int one;
  private int two;
  private int three;
  private int stones = 0;

  public Solution(int one, int two, int three){
    this.one = one;
    this.two = two;
    this.three = three;
    System.out.println(runSolution());
  }

  public int runSolution(){
    if(this.one < 1 && this.two < 1){
      return 0;
    }
    else if(this.two < 2 && this.three < 2){
      return 0;
    }
    else{
      int option1 = 0;
      int option2 = 0;
      int onetemp = this.one;
      int twotemp = this.two;
      int threetemp = this.three;
      while(onetemp >= 1 && twotemp >= 2){
        option1 += 3;
        onetemp -= 1;
        twotemp -= 2;
      }
      while(twotemp >= 1 && threetemp >= 2){
        option1 += 3;
        twotemp -= 1;
        threetemp -= 2;
      }
      onetemp = this.one;
      twotemp = this.two;
      threetemp = this.three;
      while(twotemp >= 1 && threetemp >= 2){
        option2 += 3;
        twotemp -= 1;
        threetemp -= 2;
      }
      while(onetemp >= 1 && twotemp >= 2){
        option2 += 3;
        onetemp -= 1;
        twotemp -= 2;
      }
      return Math.max(option1, option2);
    }
  }
}