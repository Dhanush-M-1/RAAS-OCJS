import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeForces_CowsandPokerGame {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n;
        String line;
        while ((n = br.readLine()) != null) {

            line = br.readLine();
            System.out.println(getAns(line , Integer.parseInt(n)));
        }
    }

    private static int getAns(String line , int n) {
        // TODO Auto-generated method stub

        int count = 0;
        int Is = 0;
        int As = 0;
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'I') {
//              count++;
                Is++;
//              if (As != 0) {
//                  count -= As;
//                  As = 0;
//              }
            } else if (line.charAt(i) == 'A') {
//              if (Is == 0)
//                  count++;
                As++;
            }
        }
        
        if(Is ==1)
            count++;
        
        if( As > 0 && Is == 0)
            count+=As;
        return count;
    }
}
