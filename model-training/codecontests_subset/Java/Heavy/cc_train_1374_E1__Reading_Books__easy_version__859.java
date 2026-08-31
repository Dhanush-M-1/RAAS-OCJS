import java.util.*;

public class Solution1374E1 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        ArrayList<Integer>[] arrayLists = new ArrayList[4];

        for (int i = 0; i < 4; ++i) {
            arrayLists[i] = new ArrayList<>();
        }

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 0; i < n; ++i)
        {
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            arrayLists[a * 2 + b].add(t);
        }

        ArrayList<Integer>[] prefixSum = new ArrayList[4];

        for (int i = 0; i < 4; ++i)
        {
            Collections.sort(arrayLists[i]);

            prefixSum[i] = new ArrayList<>();
            prefixSum[i].add(0);

            List<Integer> cur = arrayLists[i];

            for (Integer single : cur)
            {
                prefixSum[i].add(single + prefixSum[i].get(prefixSum[i].size() - 1));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int cnt = 0; cnt < Math.min(k + 1, prefixSum[3].size()); ++cnt)
        {
            if ((k - cnt) < prefixSum[1].size() && (k - cnt) < prefixSum[2].size())
            ans = Math.min(ans, prefixSum[3].get(cnt) + prefixSum[1].get(k - cnt) + prefixSum[2].get(k - cnt));
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }
}
