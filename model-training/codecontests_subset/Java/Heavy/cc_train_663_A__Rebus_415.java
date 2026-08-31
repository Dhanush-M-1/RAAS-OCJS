import java.util.Scanner;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String string = sc.nextLine(); 
    String[] arr = string.trim().split("\\s+");
    int x = 1, y = 0;
    int n = 0;
    for (String str : arr) {
      if (str.equals("?")) continue;
      if (str.equals("+")) {
        x++;
      } else if (str.equals("-")) {
        y++;
      }
    }
    n = Integer.parseInt(arr[arr.length-1]);
    if (n*x < n+y || x > n+n*y) {
      System.out.println("Impossible");
      return;
    }

    System.out.println("Possible");
    int ar[] = {x, n*x, n+y, n+n*y};
    Arrays.sort(ar);
    int[] left = new int[x];
    int[] right = new int[y];
    int ss = (ar[1]+ar[2])/2;
    left[0] = ss/x;
    int sum = left[0];
    for (int i = 1; i < x; ++i) {
      left[i] = (ss*(i+1)/x)-sum;
      sum += left[i];
    }
    ss -= n;
    if (y > 0) {
	right[0] = ss/y;
	sum = right[0];
    }
    for (int i = 1 ; i < y ; ++i) {
       right[i] = ss*(i+1)/y - sum;
	sum += right[i];
    }
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    boolean pos = true;
    for (String str : arr) {
	if (str.equals("+")) {
		pos = true;
		sb.append(" "+str);
	} else if (str.equals("-")){
		pos = false;
		sb.append(" "+str);
	} else if (str.equals("?")) {
		if (pos) {
			sb.append(" "+left[i++]);
		} else {
			sb.append(" "+right[j++]);
		}
	} else {
		sb.append(" "+str);
	}
    }
    System.out.println(sb.toString().trim());
  }
}
