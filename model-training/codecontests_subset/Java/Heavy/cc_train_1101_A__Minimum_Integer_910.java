
import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner inputReceiver = new Scanner(System.in);
        int q = inputReceiver.nextInt();
        int[] answers = new int[q];
        int l;
        int r;
        int d;
        for (int i = 0; i < q; i ++) {
            l = inputReceiver.nextInt();
            r = inputReceiver.nextInt();
            d = inputReceiver.nextInt();
            if (d < l|| d > r) {
                answers[i] = d;
            }
            else {
                if ((r + 1) % d == 0) {
                    answers[i] = r + 1;
                }
                else {
                    answers[i] = (r + 1) + (d - (r + 1) % d);
                }
            }

        }
        for (int i = 0; i < q; i ++) {
            System.out.println(answers[i]);
        }
    }
}









