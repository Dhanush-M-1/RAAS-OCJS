import java.util.*;

class Main{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    char[] arr = scan.next().toCharArray();
    int result = arr.length;
    int scount = 0;
    for(char c : arr) {
      if(c=='S') scount++;
      else {
        if(scount>0) {
          scount--;
          result-=2;
        }
      }
    }
    System.out.println(result);
  }
}
