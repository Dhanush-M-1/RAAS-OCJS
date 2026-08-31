import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> idS = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> idPos = new HashMap<Integer, Integer>();
        int blId = 1;

        for (int i = 0; i < t; i++) {
            String s = in.readLine();
            if (s.startsWith("a")) {
                int sz = Integer.parseInt(s.split(" ")[1]);

                int l = 0, r = -1;
                while (true) {
                    r++;

                    if (b.keySet().contains(r)) {
                        int id = b.get(r);
                        l += idS.get(id);
                        r = l - 1;
                    }

                    if (l >= m || r >= m) {
                        out.println("NULL");
                        break;
                    }

                    if (r - l + 1 >= sz) {
                        int id = blId++;
                        out.println(id);
                        idS.put(id, sz);
                        idPos.put(id, l);
                        b.put(l, id);
                        break;
                    }
                }
            } else if (s.startsWith("erase")) {
                int id = Integer.parseInt(s.split(" ")[1]);
                Integer l = idPos.get(id);
                if (l == null)
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                else {
                    idPos.remove(id);
                    idS.remove(id);
                    b.remove(l);
                }
            } else {
                int r = 0, curr = 0;
                while (true) {
                    if (curr >= m)
                        break;

                    if (b.containsKey(curr)) {
                        int id = b.get(curr);
                        int sz = idS.get(id);
                        b.remove(curr);
                        idPos.remove(id);
                        b.put(r, id);
                        idPos.put(id, r);
                        r += sz;
                    }

                    curr++;
                }
            }
        }

        // 10 100
        // alloc 50
        // alloc 20
        // alloc 20
        // alloc 30
        // erase 2
        // alloc 30
        // defragment
        // alloc 30
        // erase 1
        // alloc 50

        out.close();
    }
}
