import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by sgeisenh on 12/13/14.
 */
public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        String sn = s.replaceAll("#", ")#");
        char[] sc = sn.toCharArray();

        int[] ca = new int[sc.length];

        int lcount = 0;

        for(int i = 0; i < sc.length; i++) {
            if(sc[i] == '(') lcount++;
            else if(sc[i] == ')') lcount--;

            ca[i] = lcount;

            if(lcount < 0) {
                System.out.println(-1);
                return;
            }
        }

        int rcount = ca[ca.length-1];

        for(int i = ca.length - 1; i >= 0; i--) {
            if(ca[i] < rcount) rcount = ca[i];
            ca[i] = rcount;
        }

        Queue<Integer> out = new LinkedList<Integer>();

        int follow = 0;

        for(int i = 0; i < ca.length; i++) {
            if(sc[i] == '#') {
                out.add(ca[i] - follow + 1);
                lcount -= ca[i] - follow;

                follow = ca[i];
            }
        }

        if(lcount != 0) {
            System.out.println(-1);
            return;
        }

        while(!out.isEmpty()) {
            System.out.println(out.poll());
        }
    }
}
