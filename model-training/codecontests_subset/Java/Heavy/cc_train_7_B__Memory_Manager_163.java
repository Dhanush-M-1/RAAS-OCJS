import java.io.*;
import java.util.*;

public class CodeForce {
    
    public static class MemBlock {
        int size;
        int ptr;
        int id;
        public MemBlock(int size_, int ptr_, int id_) {
            size = size_;
            ptr = ptr_;
            id = id_;
        }
    }
    
    public static List<MemBlock> blocks = new LinkedList<MemBlock>();
    private static void sortMem() {
        Collections.sort(blocks, new Comparator<MemBlock>() {
            public int compare(MemBlock arg0, MemBlock arg1) {
                if(arg0 == null || arg1 == null) {
                    System.out.println("ERRORRRR");
                }
                return arg0.ptr - arg1.ptr;
            }
        });
    }
    private static int ID = 1;
    public static int []mem;
    public static int alloc(int n) {
        int ptr = 1;
        int id = -1;
        
        for(MemBlock block : blocks) {
            if(block.ptr - ptr >= n) {
                id = ID++;
                mem[ptr] = id;
                if(ptr > M) {
                    System.out.println("FAILURE");
                    return -1;
                }
                blocks.add(new MemBlock(n, ptr, id));
                sortMem();
                break;
            } else {
                ptr = block.ptr + block.size;
            }
        }
        
        if(id == -1 && M - ptr + 1 >= n) {
            id = ID++;
            if(ptr > M) {
                System.out.println("SHIT");
                return -1;
            }
            mem[ptr] = id;
            blocks.add(new MemBlock(n, ptr, id));
            sortMem();
        }
        
        return id;
    }
    
    public static boolean dealloc(int id) {
        boolean have = false;
        for(int i = 0; i < blocks.size(); i++) {
            MemBlock block = blocks.get(i);
            if(block.id == id) {
                have = true;
                if(block.ptr > M) {
                    System.out.println("ERROR2");
                    return false;
                }
                mem[block.ptr] = 0;
                blocks.remove(i);
                sortMem();
                break;
            }
        }
        return have;
    }
    
    private static void defragment() {
        int ptr = 1;
        List<MemBlock> tmp = new LinkedList<CodeForce.MemBlock>();
        for(int i = 0; i < blocks.size(); i++) {
            MemBlock m = blocks.get(i);
            MemBlock block = new MemBlock(m.size, ptr, m.id);
            if(ptr > M) {
                MemBlock prev = blocks.get(i - 1);
                System.out.println("pl: " + prev.size + " pp: " + prev.ptr + " ptr: " + ptr);
                return;
            }
            mem[m.ptr] = 0;
            if(m.ptr > M) {
                System.out.println("ERROR6");
                return;
            }
            mem[ptr] = m.id;
            ptr += m.size;
            tmp.add(block);
        }
        blocks = tmp;
        sortMem();
    }
    
    public static int M;
    
    private void solve() throws IOException {
        int T = nextInt();
        M = nextInt();
        
        mem = new int[M + 1];
        for(int t = 0; t < T; t++) {
            String line = nextLine();
            if(line.equals("defragment")) {
                defragment();
                continue;
            }
            StringTokenizer toker = new StringTokenizer(line);
            if(toker.countTokens() != 2) {
                System.out.println("ERROR4");
                continue;
            }
            String cmd = toker.nextToken();
            if(cmd.equals("alloc")) {
                int id = alloc(Integer.parseInt(toker.nextToken()));
                if(id == -1) {
                    System.out.println("NULL");
                } else {
                    System.out.println(id);
                }
            } else if(cmd.equals("erase")) {
                if(!dealloc(Integer.parseInt(toker.nextToken()))) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                } 
            }
        }
    }
    
    public static void main(String[] args) {
        new CodeForce().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
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
    
    String nextLine() throws IOException {
        return reader.readLine();
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
