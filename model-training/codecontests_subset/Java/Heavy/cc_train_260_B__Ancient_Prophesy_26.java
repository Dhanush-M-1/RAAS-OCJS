import java.util.*;

public class BAncientProphecy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = new String();
        String ans = new String();
        string = sc.next();
        int n = string.length();
        char[] ch = new char[n];
        int temp;
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ch = string.toCharArray();
        n -= 9;
        for (int i = 0; i < n; i++) {
            if (ch[i + 2] != '-' || ch[i + 5] != '-')
                continue;
            if (ch[i] == '-' || ch[i] > '3')
                continue;
            if (ch[i + 3] == '-' || ch[i + 3] > '1')
                continue;
            if (ch[i + 6] != '2' || ch[i + 7] != '0' || ch[i + 8] != '1')
                continue;
            if (ch[i + 9] == '-' || ch[i + 9] > '5' || ch[i + 9] < '3')
                continue;
            if (ch[i + 1] == '-' || ch[i + 4] == '-')
                continue;
            if (ch[i + 4] == '2' && ch[i] == '2' && ch[i + 1] > '8')
                continue;
            if (ch[i + 4] == '2' && ch[i + 3] == '0' && ch[i] > '2')
                continue;
            if (ch[i + 3] == '0' && ch[i + 4] == '0')
                continue;
            if (ch[i] == '0' && ch[i + 1] == '0')
                continue;
            if (ch[i + 3] == '1' && ch[i + 4] > '2')
                continue;
            if (ch[i] == '3' && ch[i + 1] > '1')
                continue;
            if (ch[i] == '3'
                    && ch[i] != '0'
                    && (ch[i + 4] == '4' || ch[i + 4] == '6'
                            || ch[i + 4] == '9' || (ch[i + 4] == '1' && ch[i + 3] == '1')))
                continue;
            StringBuilder sb = new StringBuilder();
            sb.append("" + ch[i] + ch[i + 1] + '-' + ch[i + 3] + ch[i + 4]
                    + '-' + '2' + '0' + '1' + ch[i + 9]);
            string = sb.toString();
            if (map.containsKey(string)) {
                temp = map.get(string);
                temp++;
                map.put(string, temp);
            } else {
                temp = 1;
                map.put(string, temp);
                set.add(string);
            }
        }
        n = 0;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            string = it.next();
            temp = map.get(string);
            if (temp > n) {
                n = temp;
                ans = string;
            }
        }
        System.out.print(ans);
    }
}
