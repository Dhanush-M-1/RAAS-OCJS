import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt(), m = sc.nextInt();
        int[] memory = new int[m];
        int[] start = new int[t + 1];
        int[] size = new int[t + 1];
        Arrays.fill(start, -1);
        int nxtID = 1;

        main: while(t-->0) {

            String op = sc.next();
            if(op.equals("alloc")) {
                int sz = sc.nextInt();
                search: for(int i = 0; i + sz <= m; )
                    if(memory[i] == 0) {
                        for(int j = 0; j < sz; ++j)
                            if(memory[i + j] != 0) {
                                ++i;
                                continue search;
                            }
                        for(int j = 0; j < sz; ++j)
                            memory[i + j] = nxtID;
                        start[nxtID] = i;
                        size[nxtID] = sz;
                        out.println(nxtID++);
                        continue main;
                    }
                    else
                        ++i;
                out.println("NULL");
            }
            else if(op.equals("erase")) {
                int x = sc.nextInt();
                if(x >= 1 && x <= start.length && start[x] != -1) {
                    for(int i = 0; i < size[x]; ++i)
                        memory[i + start[x]] = 0;
                    start[x] = -1;
                }
                else
                    out.println("ILLEGAL_ERASE_ARGUMENT");
            }
            else {
                int free = 0;
                while(free < m && memory[free] != 0) ++free;
                if(free == m)
                    continue;
                for(int i = free + 1; i < m; ++i) if(memory[i] != 0) {
                    if(start[memory[i]] == i)
                        start[memory[i]] = free;
                    memory[free++] = memory[i];
                    memory[i] = 0;
                }
            }
        }
        out.close();
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
    }
}
