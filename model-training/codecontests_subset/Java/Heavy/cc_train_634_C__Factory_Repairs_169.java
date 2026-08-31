import java.io.*;
import java.util.StringTokenizer;

public class D635 {

    private static int[] lowerTree;
    private static int[] higherTree;
    private static int[] demand;
    private static int higherProduce;
    private static int lowerProduce;

    public static void main(String[] args) throws IOException {
        ContestsScanner sc = new ContestsScanner();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int totalDays = sc.nextInt();
        int repairTime = sc.nextInt();
        higherProduce = sc.nextInt();
        lowerProduce = sc.nextInt();
        int questionCount = sc.nextInt();
        lowerTree = new int[totalDays + 5];
        higherTree = new int[totalDays + 5];
        demand = new int[totalDays + 5];
        for (int i = 0; i < questionCount; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int day = sc.nextInt();
                int count = sc.nextInt();
                update(day, count);
            } else {
                int day = sc.nextInt();
                int lower = query(lowerTree, day - 1);
                int higher = (query(higherTree, higherTree.length - 1) -
                        query(higherTree, day + repairTime - 1));
                out.println(lower + higher);
            }
        }
        out.close();
    }

    private static int query(int[] tree, int day) {
        int solution = 0;
        for (int i = day; i > 0; i -= (i & -i)) {
            if (i < tree.length) {
                solution += tree[i];
            }
        }
        return solution;
    }

    private static void update(int day, int count) {
        int oldDemand = demand[day];
        demand[day] += count;
        int lowerUpdate = Math.min(demand[day], lowerProduce) - Math.min(lowerProduce, oldDemand);
        int higherUpdate = Math.min(demand[day], higherProduce) - Math.min(higherProduce, oldDemand);
        for (int i = day; i < lowerTree.length; i += (i & -i)) {
            lowerTree[i] += lowerUpdate;
            higherTree[i] += higherUpdate;
        }
    }

    public static class ContestsScanner {

        private final BufferedReader br;
        private StringTokenizer tokenizer;

        public ContestsScanner() throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer(br.readLine());
        }

        String nextToken() {
            if (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        String nextLine() {
            if (tokenizer.hasMoreTokens()) {
                return tokenizer.nextToken("\n");
            } else {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "";
        }

        int nextInt() {
            return Integer.valueOf(nextToken());
        }

        long nextLong() {
            return Long.valueOf(nextToken());
        }
    }
}