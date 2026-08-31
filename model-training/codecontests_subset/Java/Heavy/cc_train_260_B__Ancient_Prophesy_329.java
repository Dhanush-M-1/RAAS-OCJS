
import java.util.*;
import java.io.*;

/**
 *
 * @author mohanad
 */
public class Div2_260B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String ans[] = {"00", "-", "00", "-", "0000"};

        int len = s.length();
        int i = 0;
        String monrtLen[] = {"00", "31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
        List<String> list = new LinkedList<String>();
        int counter[] = new int[100001];
        while (i <= len - 10) {

            String date = s.substring(i, i + 10);
            char[] charDate = date.toCharArray();

            String yyyy, mm, dd;
            if (charDate.length < 10 || charDate[2] != '-' || charDate[5] != '-') {
                ++i;
                continue;
            }
            yyyy = charDate[6] + "" + charDate[7] + "" + charDate[8] + "" + charDate[9];
            if (charDate[6] == '-' || charDate[7] == '-' || charDate[8] == '-' || charDate[9] == '-' || yyyy.compareTo("2013") < 0
                    || yyyy.compareTo("2015") > 0) {
                ++i;
                continue;
            }

            mm = charDate[3] + "" + charDate[4];
            if (charDate[3] == '-' || charDate[4] == '-' || mm.compareTo("00") <= 0 || mm.compareTo("12") > 0) {
                ++i;
                continue;
            }

            String monthl;
            if (charDate[3] == '0') {
                monthl = monrtLen[charDate[4] - '0'];
            } else {
                monthl = monrtLen[Integer.parseInt(mm)];
            }

            dd = charDate[0] + "" + charDate[1];
            if (charDate[0] == '-' || charDate[1] == '-' || dd.compareTo(monthl) > 0 || dd.compareTo("00") <= 0) {
                ++i;
                continue;
            }

//            if (dd.compareTo(ans[0])>=0 && mm.compareTo(ans[2])>=0 || yyyy.compareTo(ans[4])>=0){
//                ans[0]=dd;
//                ans[2] = mm;
//                ans[4] = yyyy;
//            }
//            //31-05-201501-12-201363-18-201501-12-31-05-2015-201395301-12-201301-12-20132939131-05-201578-11-201301-12-20132196-14-201075-00-201501-12-201301-12-2013801-12-20131-05-2015301-12-201301-12-20139-59-18-20129101-12-201301-12-201301-12-201319-29-100401-12-20131-05-201531-05-2015-99031-05-201531-05-201531-05-20154-38101-12-201301-12-20131601-12-20131-05-201545101-12-201329131-05-201501-12-201395841-03-201658201-12-201301-12-20133701-12-201345-08-201701-12-201301-12-20131-05-201555165-02-102236-3931-05-20159024-801-12-201301-12-2013
//            boolean flag = false;
//            if (yyyy.compareTo(ans[4]) > 0) {
//                flag = true;
//            } else if (yyyy.compareTo(ans[4]) == 0 && mm.compareTo(ans[2]) > 0) {
//                flag = true;
//            } else if (dd.compareTo(ans[0]) > 0 && mm.compareTo(ans[2]) >= 0 || yyyy.compareTo(ans[4]) >= 0) {
//                flag = true;
//            }
//            if (flag) {
//                ans[0] = dd;
//                ans[2] = mm;
//                ans[4] = yyyy;
//            }

            //
            String countes = dd + "-" + mm + "-" + yyyy;
            int l = list.size();
            boolean visted = false;
            int j = 0;
            for (j = 0; j < l; ++j) {
                if (countes.equals(list.get(j))) {
                    visted = true;
                    break;
                }
            }
            if (visted) {
                ++counter[j];
            } else {
                list.add(countes);
                ++counter[j];
            }

            ++i;
        }

        int max = 0;
        int l = list.size();
        for (int t = 1; t < l; ++t) {
            if (counter[t] > counter[max]) {
                max = t;
            }
        }
        System.out.println(list.get(max));
    }

}
