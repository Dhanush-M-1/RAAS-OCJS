import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String x = sc.next();
    int p = 0;
    ArrayList<Integer> lists = new ArrayList<Integer>();
    ArrayList<Integer> listt = new ArrayList<Integer>();
    int len = 0;
    for(int i = 0; i < x.length(); i++) {
      if(x.charAt(i) == 'S') {
        if(i == 0) {
          len++;
        } else {
          if(x.charAt(i - 1) == 'S') {
            len++;
          } else {
            if(p == 1) listt.add(len);
            len = 1;
          }
          if(i == (x.length() - 1)) lists.add(len);
        }
        p = 1;
      } else {
        if(i == 0) {
          len++;
        } else {
          if(x.charAt(i - 1) == 'S') {
            lists.add(len);
            len = 1;
          } else {
            len++;
          }
        }
        if((i == (x.length() - 1)) && (p == 1)) listt.add(len);        
      }
    }
    int t = 0;
    int sum = 0;
    for(int i = 0; i < lists.size(); i++) {
      if(listt.size() > i) {
        int a = lists.get(i) + sum;
        int b = listt.get(i);
        t += Math.min(a, b);
        sum = (a - Math.min(a, b)); 
      }
    }
    System.out.println(x.length() - 2 * t);
  }
}
