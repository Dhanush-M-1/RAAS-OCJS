
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ekrylov
 * Date: 1/6/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class B {

    private BufferedReader in;
    private PrintWriter out;
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    public void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (isDate(sub)) {
                if (!map.containsKey(sub)) {
                    map.put(sub, 0);
                }
                map.put(sub, map.get(sub) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String res = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        out.print(res);
        out.flush();
    }

    private boolean isDate(String s) {
        if (s.charAt(2)!='-' || s.charAt(5)!='-') {
            return false;
        }

        String year = s.substring(6);
        if (!year.equals("2013") && !year.equals("2014") && !year.equals("2015")) {
            return false;
        }

        String mm = s.substring(3,5);
        if (!mm.equals("01") && !mm.equals("02") && !mm.equals("03") && !mm.equals("04") && !mm.equals("05") && !mm.equals("06") && !mm.equals("07") && !mm.equals("08") && !mm.equals("09") && !mm.equals("10") && !mm.equals("11") && !mm.equals("12")) {
            return false;
        }

        String dd = s.substring(0, 2);
        if (mm.equals("01") || mm.equals("03") || mm.equals("05") || mm.equals("07") || mm.equals("08") || mm.equals("10") || mm.equals("12")) {
            if (!dd.equals("01") && !dd.equals("02") && !dd.equals("03") && !dd.equals("04") && !dd.equals("05") && !dd.equals("06") && !dd.equals("07") && !dd.equals("08") && !dd.equals("09") && !dd.equals("10") && !dd.equals("11") && !dd.equals("12") && !dd.equals("13") && !dd.equals("14") && !dd.equals("15") && !dd.equals("16") && !dd.equals("17") && !dd.equals("18") && !dd.equals("19") && !dd.equals("20") && !dd.equals("21") && !dd.equals("22") && !dd.equals("23") && !dd.equals("24") && !dd.equals("25") && !dd.equals("26") && !dd.equals("27") && !dd.equals("28") && !dd.equals("29") && !dd.equals("30") && !dd.equals("31") ) {
                return false;
            }
        } else if (mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) {
            if (!dd.equals("01") && !dd.equals("02") && !dd.equals("03") && !dd.equals("04") && !dd.equals("05") && !dd.equals("06") && !dd.equals("07") && !dd.equals("08") && !dd.equals("09") && !dd.equals("10") && !dd.equals("11") && !dd.equals("12") && !dd.equals("13") && !dd.equals("14") && !dd.equals("15") && !dd.equals("16") && !dd.equals("17") && !dd.equals("18") && !dd.equals("19") && !dd.equals("20") && !dd.equals("21") && !dd.equals("22") && !dd.equals("23") && !dd.equals("24") && !dd.equals("25") && !dd.equals("26") && !dd.equals("27") && !dd.equals("28") && !dd.equals("29") && !dd.equals("30")) {
                return false;
            }
        } else {
            if (!dd.equals("01") && !dd.equals("02") && !dd.equals("03") && !dd.equals("04") && !dd.equals("05") && !dd.equals("06") && !dd.equals("07") && !dd.equals("08") && !dd.equals("09") && !dd.equals("10") && !dd.equals("11") && !dd.equals("12") && !dd.equals("13") && !dd.equals("14") && !dd.equals("15") && !dd.equals("16") && !dd.equals("17") && !dd.equals("18") && !dd.equals("19") && !dd.equals("20") && !dd.equals("21") && !dd.equals("22") && !dd.equals("23") && !dd.equals("24") && !dd.equals("25") && !dd.equals("26") && !dd.equals("27") && !dd.equals("28")) {
                return false;
            }
        }
        return true;
    }

}
