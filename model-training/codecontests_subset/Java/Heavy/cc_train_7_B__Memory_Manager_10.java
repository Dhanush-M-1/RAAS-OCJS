    import java.io.*;
    import java.text.*;
    import java.util.*;
import java.util.regex.*;

    public class Main{
        static class Run implements Runnable{
            //TODO parameters
            final boolean consoleIO = true;
            final String inFile = "input.txt";
            final String outFile = "output.txt";
            
            int t, m;
            int[] mem;
            Vector<Block> blocks;
            int last_id = -1;
            
            class Block {
                int id;
                int pos;
                int size;
                
                Block(int id, int pos, int size) {
                    this.id = id;
                    this.pos = pos;
                    this.size = size;
                }
                
                public String toString() {
                    return (id+1)+" "+(pos+1)+" "+size;
                }
            }
            
            int alloc(int n) {
                Block b = new Block(last_id+1, 0, n);
                
                boolean find = false;
                int free_count = 0;
                int i = 0;
                
                while(i < m) { 
                    if(mem[i]==0) {
                        ++free_count;
                        if(free_count == n) {
                            find = true;
                            break;
                        }
                    }
                    else
                        free_count = 0;
                    
                    ++i;
                }
                
                if(!find)
                    return -1;
                
                b.pos = i - n + 1;
                insert(mem, b.pos, b.size);
                blocks.add(b);
                ++last_id;
                
                return b.id+1;
            }
            
            boolean erase(int x) {
                try {
                    Block cur = blocks.elementAt(x);
                
                    for(int i = cur.pos; i < cur.pos+cur.size;++i)
                        mem[i] = 0;
                    
                    blocks.setElementAt(null, cur.id);
                    return true;
                } catch(Exception e) {
                    return false;
                }
            }
            
            void defrag() {
                int[] mem_new = new int[m];
                
                Block prev = null;
                Vector<Block> nblocks = new Vector<Block>();
                nblocks.setSize(blocks.size());
                Collections.copy(nblocks, blocks);
                Collections.sort(nblocks, new BlockComparator());
                
                for(Block bl:nblocks) {
                    if(bl!=null) {
                        if(prev == null)
                            bl.pos = 0;
                        else
                            bl.pos = prev.pos + prev.size;
                    
                        insert(mem_new, bl.pos, bl.size);
                        prev = bl;
                    }
                }
                
                mem = mem_new;
            }
            
            class BlockComparator implements Comparator<Block> {
                @Override
                public int compare(Block o1, Block o2) {
                    if(o2 == null)
                        return -1;
                    if(o1 == null)
                        return 1;
                        
                    if(o1.pos<o2.pos)
                        return -1;
                    if(o1.pos >o2.pos)
                        return 1;
                    return 0;
                }
            }
            
            void insert(int[] mem, int start_pos, int size) {
                for(int i = start_pos; i < start_pos + size; ++i)
                    mem[i] = 1;
            }
            
            @Override
            public void run() {
                t = nextInt();
                m = nextInt();
                
                mem = new int[m];
                blocks = new Vector<Block>();
                
                for(int i = 0; i < t; ++i) {
                    String cur = nextLine();
                    
                    if(cur.equals("defragment"))
                        defrag();
                    else {
                        String[] ar = cur.split(" ");
                        int num = Integer.valueOf(ar[1]);
                        
//                      int v;
                        if(ar[0].equals("erase")&&!erase(num-1))// v = 0;
                            print("ILLEGAL_ERASE_ARGUMENT\n");
                        else
                            if(ar[0].equals("alloc")) {
                                int res = alloc(num);
                                print(res==-1?"NULL\n":res+"\n");
                            }
                    }
                    
//                  print(i+1+".) "+cur+"\n\n");
//                  for(Block j: blocks)
//                      if(j != null)
//                          print(j+"\n");
//                  print("\n");
//                  
//                  for(int j: mem)
//                      print(j);
//                  print("\n-----------------\n");
                }
                
                close();
            }
        //=========================================================================================================================
            BufferedReader in;
            PrintWriter out;
            StringTokenizer strTok;
           
            Run() {
                if (consoleIO) {
                    initConsoleIO();
                }
                else {
                    initFileIO();
                }
            }
           
            void initConsoleIO() {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
           
            void initFileIO() {
                try {
                    in = new BufferedReader(new FileReader(inFile));
                    out = new PrintWriter(new FileWriter(outFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            void close() {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            int nextInt() {
                return Integer.parseInt(nextToken());
            }
           
            double nextDouble() {
                return Double.parseDouble(nextToken());
            }
           
            float nextFloat() {
                return Float.parseFloat(nextToken());
            }
           
            long nextLong() {
                return Long.parseLong(nextToken());
            }
           
            String nextLine() {
                try {
                    return in.readLine();
                } catch (IOException e) {
                    return "__NULL";
                }
            }
           
            boolean hasMoreTokens() {
                return (strTok == null) || (strTok.hasMoreTokens());
            }
           
            String nextToken() {
                while (strTok == null || !strTok.hasMoreTokens()) {
                    String line;
                    try {
                        line = in.readLine();
                        strTok = new StringTokenizer(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               
                return strTok.nextToken();
            }
           
            void cout(Object o){
                System.out.println(o);
            }
           
            void print(Object o) {
                out.write(o.toString());
            }
            
            void println(Object o) {
                out.write(o.toString() + '\n');
            }
           
            void printf(String format, Object... args) {
                out.printf(format, args);
            }
           
            String sprintf(String format, Object... args) {
            return MessageFormat.format(format, args);
        }
        }
       
        static class Pair<A, B> {
            A a;
            B b;
           
            A f() {
                return a;
            }
           
            B s() {
                return b;
            }
           
            Pair(A a, B b) {
                this.a = a;
                this.b = b;
            }
           
            Pair(Pair<A, B> p) {
                a = p.f();
                b = p.s();
            }
        }
       
        public static void main(String[] args) throws IOException {
            Run run = new Run();
            Thread thread = new Thread(run);
            thread.run();
        }
    }