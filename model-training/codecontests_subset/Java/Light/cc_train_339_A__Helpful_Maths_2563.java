import java.util.*;

public class HelpfulMaths {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int len = (s.length() / 2) + 1;
    int[] a = new int[len];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '+') {
        // System.out.println(s.charAt(i));
        int val = Integer.parseInt(String.valueOf(s.charAt(i)));
        // System.out.println(val);
        a[j] = val;
        j++;
      }
    }
    // for (int i = 0; i < a.length; i++) {
    // System.out.println(a[i]);
    // }
    Arrays.sort(a);
    // char[] plus = new char[len - 1];
    // for (int i = 0; i < plus.length; i++) {
    // plus[i]='+';
    // }
    // System.out.println(plus.length);
    j = 0;
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
      if (j < len - 1) {
        System.out.print("+");
        j++;
      }
    }
    sc.close();
  }

}

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.*;

// class Solutioner
// {
// public static void main(String args[]) throws Exception
// {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int t = Integer.parseInt(br.readLine());
// while(t-->0)
// {

// }
// }
// }
