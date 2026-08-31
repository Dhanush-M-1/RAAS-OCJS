
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class WizardsAndDemonstration {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(reader.readLine());
        int n = parseInt(tok.nextToken());
        int x = parseInt(tok.nextToken());
        int y = parseInt(tok.nextToken());
        double z = Math.ceil(n * y / 100.0);
        System.out.println(z >= x ? (int) z - x : 0);
    }

}
