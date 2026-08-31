import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> possibilities = new ArrayList<>();
        possibilities.add("0");
        possibilities.add("1");
        for (int i = 0; i < 9; i++) {
            possibilities = genOpen(possibilities);
        }
        
        possibilities.remove(0);
        int n = scanner.nextInt();
        String f[] = new String[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = "";
            for (int j = 0; j < 10; j++) {
                f[i] += scanner.nextInt();
            }
        }
        int[][] p = new int[n][11];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                p[i][j] = scanner.nextInt();
            }
        }
        long max = Long.MIN_VALUE;
        for (String pos: possibilities) {
            long profit = 0;
            for (int i = 0; i < f.length; i++) {
                profit += p[i][similar(pos, f[i])];
            }
            if (profit > max) max = profit;
        }
        System.out.println(max);
    }

    private static ArrayList<String> genOpen(ArrayList<String> possible){
        ArrayList<String> other = new ArrayList<>();

        for (String aPossible : possible) {
            other.add(aPossible + "0");
            other.add(aPossible + "1");

        }
        return other;
    }

    private static int similar(String x, String y){
        int ans = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1' && y.charAt(i) == '1') ans++;
        }
        return ans;
    }
}