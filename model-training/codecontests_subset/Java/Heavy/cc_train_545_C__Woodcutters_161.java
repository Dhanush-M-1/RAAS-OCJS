import java.util.Scanner;

/**
 * @author Sergey
 */
public final class C_Woodcutters {

    private static final class TreeInfo {
        private final int x;
        private final int h;

        public TreeInfo(int x, int h) {
            this.x = x;
            this.h = h;
        }

        public int startWhenCutToLeft() {
            return x - h;
        }

        public int endWhenCutToLeft() {
            return x;
        }

        public int endWhenCutToRight() {
            return x + h;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeInfo[] trees = new TreeInfo[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new TreeInfo(in.nextInt(), in.nextInt());
        }
        int count = 1;
        int maxTreeX = trees[0].x;
        for (int i = 1; i < n - 1; i++) {
            if (trees[i].startWhenCutToLeft() > maxTreeX) {
                count++;
                maxTreeX = trees[i].endWhenCutToLeft();
            } else if (trees[i].endWhenCutToRight() < trees[i + 1].x) {
                count++;
                maxTreeX = trees[i].endWhenCutToRight();
            } else {
                maxTreeX = trees[i].x;
            }
        }
        if (n > 1) {
            count++;
        }
        System.out.println(count);
    }

}
