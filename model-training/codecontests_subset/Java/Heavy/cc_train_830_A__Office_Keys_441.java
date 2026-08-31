import java.util.*;

public class Main{
    public static void main(String[] args) {
        //001 Appending Mex http://codeforces.com/contest/1054/problem/B
        /*
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = x.nextInt();
        int ans = -1;

        if (a[0] != 0)
            ans = 1;
        else {
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] < 0 || a[i] > max + 1) {
                    ans = i + 1;
                    break;
                }
                max = Math.max(max, a[i]);
            }
        }
        System.out.println(ans);
        */


        //002 Candies Distribution http://codeforces.com/contest/1054/problem/C
        /*
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++)
            l[i] = x.nextInt();
        for (int i = 0; i < n; i++)
            r[i] = x.nextInt();

        int id = 0; //the rank
        int zero = 0; //num of max values
        int[] nums = new int[n]; //left MAX values
        int[] res = new int[n];
        boolean w = true;

        while (true) {
            int numOfZero = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < 0)
                    continue; // visited
                l[i] -= nums[i];
                r[i] -= (zero - nums[i]);
                if (l[i] < 0 || r[i] < 0) {
                    w = false;
                    break;
                }
                if (l[i] == 0 && r[i] == 0) {
                    numOfZero++;
                    nums[i] = -1; //visited
                    res[i] = n - id; //right ans
                } else
                    nums[i] = numOfZero;
            }
            if (!w)
                break;
            if (numOfZero == 0) {
                w = false;
                break;
            }
            id += numOfZero;
            if (id == n)
                break;
            zero = numOfZero;
        }

        if (!w)
            System.out.println("NO");
        else {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.print(res[i]);
                System.out.print(" ");
            }
        }
        System.out.println("");
        */

        // 003 Office Keys http://codeforces.com/problemset/problem/830/A
        Scanner x = new Scanner(System.in);
        int numOfPerson = x.nextInt();
        int numOfPosition = x.nextInt();
        int office = x.nextInt();
        int[] person = new int[numOfPerson];
        int[] position = new int[numOfPosition];
        for (int i = 0; i < numOfPerson; i++)
            person[i] = x.nextInt();
        for (int i = 0; i < numOfPosition; i++)
            position[i] = x.nextInt();
        Arrays.sort(person);
        Arrays.sort(position);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + numOfPerson < numOfPosition + 1; i++) {
            int max = -1;
            for (int j = i; j - i < numOfPerson; j++) {
                max = Math.max(max, Math.abs(person[j - i] - position[j]) + Math.abs(position[j] - office));
            }
            min = Math.min(max, min);
        }
        System.out.println(min);
    }
}
