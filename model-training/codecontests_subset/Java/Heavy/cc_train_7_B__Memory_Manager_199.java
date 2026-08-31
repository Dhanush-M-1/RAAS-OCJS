import java.util.*;

public class CodeForces7B {
    // 返回开始的那个坐标

    public static int findPlace(int n, int m, int[] arr) {
        if (n > m) {
            return -1;
        }

        int num = 0;
        for (int i = 1; i <= m; i++) {
            if (arr[i] == 0) {
                ++num;
                if (num == n) {
                    return i - n + 1;
                }
            } else {
                num = 0;
            }
        }
        return -1;
    }
    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            int m = sc.nextInt();

            int[] arr = new int[105];
            Arrays.fill(arr, 0);

            int num = 0;
            for (int T = 1; T <= t; T++) {
                String command = sc.next();
                if (command.equals("alloc")) {
                    int n = sc.nextInt();
                    int loc = findPlace(n, m, arr);
                    if (loc == -1) {
                        System.out.println("NULL");
                    } else {
                        ++num;
                        for (int i = loc; i < loc + n; i++) {
                            arr[i] = num;
                        }
                        System.out.println(num);
                    }
                } else if (command.equals("erase")) {
                    int x = sc.nextInt();
                    if (x < 1 || x > num) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    } else {
                        boolean change = false;
                        for (int i = 1; i <= m; i++) {
                            if (arr[i] == x) {
                                arr[i] = 0;
                                change = true;
                            }
                        }
                        if (!change) {
                            System.out.println("ILLEGAL_ERASE_ARGUMENT");
                        }
                    }
                } else {
                    int id = 0;
                    for (int i = 1; i <= m; i++) {
                        if (arr[i] > 0)
                            arr[++id] = arr[i];
                    }
                    if (id < m)
                        Arrays.fill(arr, id + 1, m + 1, 0);
                }
                // System.out.println(Arrays.toString(arr));
            }
        }
    }
}
