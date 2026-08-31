import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Letter {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String poker = sc.next();
    int a=0, i=0;
    for(char c : poker.toCharArray()){
        if(c == 'A') a++;
        else if(c == 'I') i++;
        if(i > 1) break;
    }
    int ans = 0;
    if(i == 1)
        ans = 1;
    else if(i == 0)
        ans = a;
    System.out.println(ans);
    
    sc.close();
  }
}
