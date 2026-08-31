
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

//    Scanner cin = new Scanner(new FileReader("input.txt"));
    Scanner cin = new Scanner(System.in);

    String item = "keyence";
    String in = cin.next();

    int pos = in.indexOf(item);
    int pos2 = in.lastIndexOf(item);
    if (pos==0||pos2==in.length()-item.length()) {
      System.out.println("YES");
      return;
    }

    for (int i=0;i<item.length();i++) {
      String a = item.substring(0,i+1);
      String b = item.substring(i+1,item.length());
      //System.out.println(a);
      //System.out.println(b);
      int posA = in.indexOf(a);
      int posB = in.lastIndexOf(b);

      if (posA==0&&posB==in.length()-b.length()){
        System.out.println("YES");
        return;
      }
      else {
        continue;
      }

    }
    System.out.println("NO");

  }

}