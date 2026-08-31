
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;


public class Histoletters {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in).useLocale(Locale.US);

        String a, b, c;

        a = kbd.nextLine();
        b = kbd.nextLine();
        c = kbd.nextLine();

        int [] histoA = new int['z' - 'a' + 1];
        int [] histoB = new int['z' - 'a' + 1];
        int [] histoC = new int['z' - 'a' + 1];
        processHisto(a, histoA);
        processHisto(b, histoB);
        processHisto(c, histoC);

        StringBuilder output = new StringBuilder();

        int multiplicityB = getMultiplicity(histoA, histoB);
        int multiplicityC = getMultiplicity(histoA, histoC);

        while (multiplicityB > 0 || multiplicityC > 0) {
            if (multiplicityB > multiplicityC) {
                multiplicityB--;
                output.append(b);
                subtractHisto(histoA, histoB);
                multiplicityC = getMultiplicity(histoA, histoC);
            }
            else {
                multiplicityC--;
                output.append(c);
                subtractHisto(histoA, histoC);
                multiplicityB = getMultiplicity(histoA, histoB);
            }
        }

        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            while (histoA[i]-- > 0)
                output.append((char) (i + 'a'));
        }

        System.out.println(output.toString());
    }

    static void processHisto(String a, int [] histo) {
        for (int i = 0; i < a.length(); i++) {
            histo[a.charAt(i) - 'a']++;
        }
    }

    static int getMultiplicity(int [] histA, int [] histB) {
        int minMult = Integer.MAX_VALUE;
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if (histB[i] != 0)
                minMult = Math.min(minMult, histA[i] / histB[i]);
        }
        
        return minMult;
    }

    static void subtractHisto(int [] histA, int [] histB) {
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            histA[i] -= histB[i];
        }
    }
}