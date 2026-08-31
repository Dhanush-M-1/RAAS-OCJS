import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int numTrees = in.nextInt();
        int [] x_arr = new int[numTrees];
        int [] h_arr = new int[numTrees];
        ArrayList<Integer> fell = new ArrayList<Integer>();
        int firstTree = in.nextInt();
        int firstHeight = in.nextInt();
        fell.add(firstTree-firstHeight);
        x_arr[0] = firstTree;
        h_arr[0] = firstHeight;
        for (int i = 1; i < numTrees; i++) {
            int x = in.nextInt();
            int h = in.nextInt();
            x_arr[i] = x;
            h_arr[i] = h;
        }

        for (int i = 1; i < numTrees; i++) {
            int left = x_arr[i] - h_arr[i];
            int right = x_arr[i] + h_arr[i];
            int prev = fell.size()-1;
            if (left > fell.get(prev) && left > x_arr[i-1]) {
                fell.add(left);

            } else if (i == numTrees - 1 || right < x_arr[i + 1]) {
                fell.add(right);
            }
        }

        System.out.println(fell.size());
    }
}
