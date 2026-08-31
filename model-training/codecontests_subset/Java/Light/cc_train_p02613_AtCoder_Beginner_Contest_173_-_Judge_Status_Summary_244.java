import java.util.*;
 
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Map<String, Integer> countMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String s = sc.next();
      countMap.merge(s, 1, Integer::sum);
    }
    String[] verdicts = {"AC", "WA", "TLE", "RE"};
    for (String verdict : verdicts) {
	    System.out.println(verdict + " x " + countMap.getOrDefault(verdict, 0));
    }
  }
}