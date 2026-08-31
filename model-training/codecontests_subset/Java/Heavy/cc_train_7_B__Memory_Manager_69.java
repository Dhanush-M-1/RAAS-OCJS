import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemB {
    static class Segment implements Comparable<Segment> {
        static int seq_id = 0;
        int from;
        int to;
        int identifier = 0;
        Segment(int f, int t) {
            from = f;
            to = t;
            identifier = seq_id;
            seq_id++;
        }
        @Override
        public int compareTo(Segment arg0) {
            return from - arg0.from;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] line = s.readLine().split(" ");
        int q = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);
        List<Segment> memories = new ArrayList<Segment>();
        memories.add(new Segment(m+1, m+2));
        
        for (int i = 0 ; i < q ; i++) {
            String[] data = s.readLine().split(" ");
            String operation = data[0];
            if ("defragment".equals(operation)) {
                defragment(m, memories);
            } else {
                int arg = Integer.valueOf(data[1]);
                if ("alloc".equals(operation)) {
                    int id = alloc(m, memories, arg);
                    out.println(id == -1 ? "NULL" : id);
                } else {
                    boolean result = erase(m, memories, arg);
                    if (!result) {
                        out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                }
            }
        }
        
        
        
        
        out.flush();
    }

    private static boolean erase(int M, List<Segment> memories, int arg) {
        if (arg <= 0) {
            return false;
        }
        Collections.sort(memories);
        for (int i = 0, len = memories.size() ; i < len ; i++) {
            if (memories.get(i).identifier == arg) {
                memories.remove(i);
                return true;
            }
        }
        return false;
    }

    private static int alloc(int M, List<Segment> memories, int arg) {
        Collections.sort(memories);
        int from = 1;
        for (int i = 0, len = memories.size() ; i < len ; i++) {
            Segment seg = memories.get(i);
            int to = seg.from - 1;
            int mlen = to - from + 1;
            if (mlen >= arg) {
                Segment newseg = new Segment(from, from + arg - 1);
                memories.add(newseg);
                return newseg.identifier;
            }
            from = seg.to + 1;
        }
        return -1;
    }

    private static void defragment(int M, List<Segment> memories) {
        Collections.sort(memories);
        int from = 1;
        for (int i = 0, len = memories.size() - 1 ; i < len ; i++) {
            Segment seg = memories.get(i);
            int seglen = seg.to - seg.from;
            seg.from = from;
            seg.to = from + seglen;
            from = seg.to+1;
        }
    }

    public static void debug(Object... os){
        System.err.println(Arrays.deepToString(os));
    }
}