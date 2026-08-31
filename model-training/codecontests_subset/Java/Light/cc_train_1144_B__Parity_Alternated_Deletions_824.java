import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PolyCarpParity {

    public static void main(String [] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(bufferedReader.readLine());
        String val = bufferedReader.readLine();
        String[] split = val.split(" ");
        int parity = parity(split);
        System.out.println(parity);
    }

    public static int parity(String [] input) {
        if(input.length <= 1) {
            return 0;
        }
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        for(int i=0; i< input.length; i++) {
            int value = Integer.parseInt(input[i]);
            if(value % 2 == 0) {
                evens.add(value);
            }
            else odds.add(value);
        }
        if(Math.abs(evens.size() - odds.size()) <= 1) {
            return 0;
        }
        if(evens.size() > odds.size()) {
            return getOverflow(evens, odds);
        }
        else return getOverflow(odds, evens);
    }

    public static int getOverflow(ArrayList<Integer> largerVal, ArrayList<Integer> lowerval) {
        largerVal.sort(Integer::compareTo);
        int sum = 0;
        for(int i=0; i<largerVal.size() - lowerval.size() - 1; i++) {
            sum += largerVal.get(i);
        }
        return sum;
    }
}
