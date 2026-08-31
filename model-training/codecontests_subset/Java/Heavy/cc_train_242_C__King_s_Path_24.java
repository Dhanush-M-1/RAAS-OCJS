import java.io.*;
import java.util.*;

public class Solution {
    private IO io;
    private int ioMode = -1;
    private String problemName = "";
    private final String mjArgument = "master_j";

    public static void main(String programArguments[]) throws IOException{
        if(programArguments != null && programArguments.length > 0)
            new Solution().run(programArguments[0]);
        else
            new Solution().run(null);
    }

    private void run(String programArgument) throws IOException {
//         _______________________________________________ _________
//        |   Input Mode     |      Output Mode    | mode | comment |
//        |------------------|---------------------|----- |---------|
//        |   input.txt      |      System.out     |  0   |    mj   |
//        |   System.in      |      System.out     |  1   |  T / CF |
//        |<problemName>.in  |  <problemName>.out  |  2   |         |
//        |   input.txt      |      output.txt     |  3   |    C    |
//        |__________________|_____________________|______|_________|
        long nanoTime = 0;
        if(programArgument != null && programArgument.equals(mjArgument)) // mj
            ioMode = 0;
        else if(System.getProperty("ONLINE_JUDGE") != null) // T / CF
            ioMode = 1;
        else
            ioMode = 2;
        switch(ioMode){
            case -1:
                try{
                    throw new Exception("<ioMode> init failure") ;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return;
            case 0:
                break;
            case 1:
                break;
            case 2:
                if(problemName.length() == 0){
                    try{
                        throw new Exception("<problemName> init failure");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return;
                }
            case 3:
                break;
        }
        io = new IO(ioMode, problemName);
        if(ioMode == 0){
            System.out.println("File output : \n<start>");
            System.out.flush();
            nanoTime = System.nanoTime();
        }
        solve();
        io.flush();
        if(ioMode == 0){
            System.out.println("</start>");
            long t = System.nanoTime() - nanoTime;
            int d3 = 1000000000, d2 = 1000000, d1 = 1000000;
            if(t>=d3)
                System.out.println(t/d3 + "." + t%d3 + " seconds");
            else if(t>=d2)
                System.out.println(t/d2 + "." + t%d2 + " millis");
            else if(t>=d1)
                System.out.println(t/d1 + "." + t%d1 + " millis");
            System.out.flush();
        }
    }

    private class Cell {
        private int x, y;
        private Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            Cell cell = (Cell)o;
            if(x != cell.x) return false;
            if(y != cell.y) return false;
            return true;
        }
        @Override
        public int hashCode(){
            int result = x;
            result = 31 * result + y;
            return result;
        }
        @Override
        public String toString(){
            return x + " " + y;
        }
    }

    HashMap<Cell, Integer> dist = new HashMap<>();
    ArrayDeque<Cell> queue = new ArrayDeque<>();
    private void solve() throws IOException {
        int x0 = io.nI(), y0 = io.nI(), x1 = io.nI(), y1 = io.nI(), n = io.nI();
        for(int i = 0; i<n; i++){
            int c = io.nI(), l = io.nI(), r = io.nI();
            for(int j = l; j <= r; j++)
                dist.put(new Cell(c, j), -1);
        }
        queue.addFirst(new Cell(x0, y0));
        dist.put(new Cell(x0, y0), 0);
        while(queue.size() > 0){
            Cell cell = queue.pollFirst();
            int d = dist.get(cell)+1;
            for(int tx = cell.x-1; tx <= cell.x+1; tx++)
                for(int ty = cell.y-1; ty <= cell.y+1; ty++)
                    if(tx != cell.x || ty != cell.y){
                        Cell c = new Cell(tx, ty);
                        Integer t = dist.get(c);
                        if(t != null && t == -1){
                            dist.put(c, d);
                            queue.add(c);
                        }
                    }
        }
        Cell c = new Cell(x1, y1);
        io.wln(dist.get(c));
    }//2.2250738585072012e-308

    /**
     * Input-output class
     * @author master_j
     * @version 0.2.4
     */
    @SuppressWarnings("unused")
    private class IO{
        private boolean alwaysFlush;
        StreamTokenizer in; PrintWriter out; BufferedReader br; Reader reader; Writer writer;
        public IO(int ioMode, String problemName) throws IOException{
            Locale.setDefault(Locale.US);
//         _______________________________________________ _________
//        |   Input Mode     |      Output Mode    | mode | comment |
//        |------------------|---------------------|----- |---------|
//        |   input.txt      |      System.out     |  0   |    mj   |
//        |   System.in      |      System.out     |  1   |  T / CF |
//        |<problemName>.in  |  <problemName>.out  |  2   |         |
//        |   input.txt      |      output.txt     |  3   |    C    |
//        |__________________|_____________________|______|_________|
            switch(ioMode){
                case 0:
                    reader = new FileReader("input.txt");
                    writer = new OutputStreamWriter(System.out);
                    break;
                case 1:
                    reader = new InputStreamReader(System.in);
                    writer = new OutputStreamWriter(System.out);
                    break;
                case 2:
                    reader = new FileReader(problemName + ".in");
                    writer = new FileWriter(problemName + ".out");
                    break;
                case 3:
                    reader = new FileReader("input.txt");
                    writer = new FileWriter("output.txt");
                    break;
            }
            br = new BufferedReader(reader);
            in = new StreamTokenizer(br);
            out = new PrintWriter(writer);
            alwaysFlush = false;
        }
        public void setAlwaysFlush(boolean arg){alwaysFlush = arg;}
        public void wln(){out.println(); if(alwaysFlush)flush();}
        public void wln(int arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(long arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(double arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(String arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(boolean arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(char arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(float arg){out.println(arg); if(alwaysFlush)flush();}
        public void wln(Object arg){out.println(arg); if(alwaysFlush)flush();}
        public void w(int arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(long arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(double arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(String arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(boolean arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(char arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(float arg){out.print(arg); if(alwaysFlush)flush();}
        public void w(Object arg){out.print(arg); if(alwaysFlush)flush();}
        public void wf(String format, Object...args){out.printf(format, args); if(alwaysFlush)flush();}
        public void flush(){out.flush();}
        public int nI() throws IOException {in.nextToken(); return(int)in.nval;}
        public long nL() throws IOException {in.nextToken(); return(long)in.nval;}
        public String nS() throws IOException {in.nextToken(); return in.sval;}
        public double nD() throws IOException {in.nextToken(); return in.nval;}
        public float nF() throws IOException {in.nextToken(); return (float)in.nval;}
        public char nC() throws IOException {return (char)br.read();}
        public void wc(char...arg){for(char c : arg){in.ordinaryChar(c);in.wordChars(c, c);}}
        public void wc(String arg){wc(arg.toCharArray());}
        public void wc(char arg0, char arg1){in.ordinaryChars(arg0, arg1); in.wordChars(arg0, arg1);}
        public boolean eof(){return in.ttype == StreamTokenizer.TT_EOF;}
        public boolean eol(){return in.ttype == StreamTokenizer.TT_EOL;}
    }
}