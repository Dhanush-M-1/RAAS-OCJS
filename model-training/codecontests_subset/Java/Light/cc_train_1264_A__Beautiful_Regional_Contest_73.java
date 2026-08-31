import java.util.*;

public class BeautifulRegionalContest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        for (int t = 0; t < tc; t++) {
            int l = s.nextInt();

            int[] arr = new int[l];
            for (int i = 0; i < l; i++) arr[i] = s.nextInt();

            if (l <= 3) {
                System.out.println("0 0 0");
                continue;
            }

            int bp = l/2 - 1;
            while (bp - 1 >= 0 && arr[bp] == arr[bp+1]) bp--;
            int bs = bp;
            while (bs - 1 >= 0 && arr[bs-1] == arr[bp]) bs--;

            int gp = 0;
            while (gp + 1 < arr.length && arr[0] == arr[gp+1]) gp++;
            int gl = gp + 1;

            while (true) {
                int sl = bs - gp - 1, bl = bp - bs + 1;

                //System.out.println(gl + " " + sl + " " + bl);

                if (gl < sl && gl < bl) {
                    System.out.println(gl + " " + sl + " " + bl);
                    break;
                } else if (bl >= sl) {
                    System.out.println("0 0 0");
                    break;
                }

                int tmp = bs-1;
                while (arr[bs-1] == arr[tmp]) bs--;
            }

        }
    }
}