import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.awt.Point;
/**
 *
 * @author Prateep
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskB solver = new TaskB();
    solver.solve(1, in, out);
    out.close();
    }
}
class myPoint extends Point{
    public int move=0;
    public myPoint(int x,int y,int move){
        super(x,y);
        this.move=move;
    }
}
class TaskB{
    public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException{
        int x0=in.nextInt(),y0=in.nextInt(),x1=in.nextInt(),y1=in.nextInt(),n=in.nextInt();
        Set<Point> set=new HashSet<>();
        for(int i=1;i<=n;i++){
            int ri=in.nextInt(),ai=in.nextInt(),bi=in.nextInt();
            for(int j=ai;j<=bi;j++)set.add(new Point(ri,j));
        }
        LinkedList<myPoint> list=new LinkedList<>();
        list.add(new myPoint(x0,y0,0));
        set.remove(new Point(x0,y0));
        while(!list.isEmpty()){
            myPoint temp=list.poll();
            if(temp.x==x1 && temp.y==y1){
                out.println(temp.move);
                return;
            }
            for(int i=-1;i<=1;i++)
                for(int j=-1;j<=1;j++){
                    if(i==0 && j==0)continue;
                    Point cur=new Point(temp.x+i,temp.y+j);
                    if(set.contains(cur)){
                        list.add(new myPoint(temp.x+i,temp.y+j,temp.move+1));
                        set.remove(cur);
                    }
                }
        }
        out.println("-1");
    }
}
class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private BufferedReader br;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public String nextWhole() throws IOException{
        br=new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong(){
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
    public String nextLine(){
    try{
            return reader.readLine();
    }catch (IOException e){
            throw new RuntimeException(e);
    }
    }
}
class Pair<A, B> {
    private A first;
    private B second;
    public int move=0;
    public Pair() {
        super();
    }
    public Pair(A first,B second,int move){
        super();
        this.first=first;
        this.second=second;
        this.move=move;
    }
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return 
            ((  this.first == otherPair.first ||
                ( this.first != null && otherPair.first != null &&
                  this.first.equals(otherPair.first))) &&
             (  this.second == otherPair.second ||
                ( this.second != null && otherPair.second != null &&
                  this.second.equals(otherPair.second))) );
        }

        return false;
    }

    @Override
    public String toString()
    { 
           return "("+first+","+second+")"; 
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first){
        this.first=first;
    }
    public B getSecond(){
        return second;
    }
    public void setSecond(B second){
        this.second=second;
    }
}
