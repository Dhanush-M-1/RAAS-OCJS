
import java.util.*;


public class Round560A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String[] firstNs = firstLine.split(" ");
        int[] first = new int[firstNs.length];
        for (int i = 0; i < firstNs.length; i++) {
            first[i] = Integer.parseInt(firstNs[i]);
        }
        int n = first[0];
        int x = first[1];
        int y = first[2];
        
        String line = in.nextLine();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(line.charAt(i)+"");
        }

        int count = 0;
        for (int i = n-x; i < n; i++) {
            if (i == n-y-1) {
                if (num[i] == 0) {
                    count++;
                }
            } else {
                if (num[i] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
