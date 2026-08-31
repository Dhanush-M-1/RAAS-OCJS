import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q7B implements Runnable {

    int next = 1;
    List<Block> mem = new ArrayList<Block>();

    private void solve() throws IOException {
        int n = nextInt();
        int size = nextInt();
        mem.add(new Block(0, size, 0));
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            if (s.startsWith("def")) {
                defragment();
            } else {
                String[] split = s.split(" ");
                if (split[0].startsWith("all")) {
                    alloc(Integer.valueOf(split[1]));
                } else {
                    erase(Integer.valueOf(split[1]));
                }
            }
        }
    }

    private void erase(int id) {
        if (id < 1000 && id > 0) {
            for (int i = 0; i < mem.size(); i++) {
                Block block = mem.get(i);
                if (block.id == id) {
                    block.id = 0;
                    if (i < mem.size() - 1 && mem.get(i + 1).id == 0) {
                        block.end = mem.get(i + 1).end;
                        mem.remove(i + 1);
                    }
                    if (i > 0 && mem.get(i - 1).id == 0) {
                        mem.get(i - 1).end = block.end;
                        mem.remove(i);
                    }
                    return;
                }
            }
        }
        writer.println("ILLEGAL_ERASE_ARGUMENT");
    }


    private void defragment() {
        List<Block> nm = new ArrayList<Block>();
        int last = 0;
        for (int i = 0; i < mem.size(); i++) {
            Block block = mem.get(i);
            if (block.id != 0) {
                block.end = last + block.size();
                block.start = last;
                last = block.end;
                nm.add(block);
            }
        }
        nm.add(new Block(last, mem.get(mem.size() - 1).end, 0));
        mem = nm;
    }


    private void alloc(int reqS) {
        for (int i = 0; i < mem.size(); i++) {
            Block block = mem.get(i);
            if (block.id == 0 && block.size() >= reqS) {
                Block newB = new Block(block.start, block.start + reqS, next++);
                block.start += reqS;
                mem.add(i, newB);
                writer.println(newB.id);
                return;
            }
        }
        writer.println("NULL");

    }


    private static class Block {
        int end;
        int start;
        int id;

        private Block(int start, int end, int id) {
            this.end = end;
            this.start = start;
            this.id = id;
        }

        int size() {
            return end - start;
        }
    }

    public static void main(String[] args) {
        new Q7B().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {

            boolean oj = System.getProperty("ONLINE_JUDGE") != null;

            reader = oj ? new BufferedReader(new InputStreamReader(System.in)) :
                    new BufferedReader(new FileReader(new File("input.txt")));


            tokenizer = null;
            writer = new PrintWriter(System.out);
            long start = System.currentTimeMillis();
            solve();
            reader.close();
            if (!oj) {
                writer.print("\nTime:" + (System.currentTimeMillis() - start));
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
