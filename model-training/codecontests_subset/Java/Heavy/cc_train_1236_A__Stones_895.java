import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class _p001236A {
    static public void main(final String[] args) throws java.io.IOException {
        p001236A._main(args);
    }
//begin p001236A.java
static private class p001236A{static public void _main(String[]args)throws IOException
{new Solver(){{{nameIn="p001236A1.in";singleTest=false;}}@Override public void process
(BufferedReader br,PrintWriter pw)throws IOException{int[]a=readIntArray(br);solve
(a[0],a[1],a[2],pw);}private void solve(int a,int b,int c,PrintWriter pw){PriorityQueue<Integer>
pq=new PriorityQueue<>((x,y)->y-x);pq.addAll(IntStream.rangeClosed(0,Math.min(a,
b/2)).map(i->3*(i+Math.min(b-2*i,c/2))).mapToObj(Integer::valueOf).collect(Collectors
.toList()));pw.println(pq.poll());}}.run();}}
//end p001236A.java
//begin net/leksi/contest/Solver.java
static private abstract class Solver{protected String nameIn=null;protected String
nameOut=null;protected boolean singleTest=false;protected boolean preprocessDebug
=false;protected boolean doNotPreprocess=false;private void preProcess(final BufferedReader
br,final PrintWriter pw)throws IOException{if(!singleTest){int t=Integer.valueOf
(br.readLine().trim());while(t-->0){process(br,pw);}}else{process(br,pw);}}abstract
public void process(final BufferedReader br,final PrintWriter pw)throws IOException
;protected int[]readIntArray(final BufferedReader br)throws IOException{return Arrays
.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::valueOf).toArray()
;}protected long[]readLongArray(final BufferedReader br)throws IOException{return
Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::valueOf).toArray
();}protected String readString(final BufferedReader br)throws IOException{return
br.readLine().trim();}protected String intArrayToString(final int[]a){return Arrays
.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(" "));}protected
String longArrayToString(final long[]a){return Arrays.stream(a).mapToObj(Long::toString
).collect(Collectors.joining(" "));}protected List<Long>longArrayToList(final long
[]a){return Arrays.stream(a).mapToObj(Long::valueOf).collect(Collectors.toList()
);}protected List<Integer>intArrayToList(final int[]a){return Arrays.stream(a).mapToObj
(Integer::valueOf).collect(Collectors.toList());}protected List<Long>intArrayToLongList
(final int[]a){return Arrays.stream(a).mapToObj(Long::valueOf).collect(Collectors
.toList());}public void run()throws IOException{try{try(FileReader fr=new FileReader
(nameIn);BufferedReader br=new BufferedReader(fr);PrintWriter pw=select_output()
;){preProcess(br,pw);}}catch(Exception ex){try(InputStreamReader fr=new InputStreamReader
(System.in);BufferedReader br=new BufferedReader(fr);PrintWriter pw=select_output
();){preProcess(br,pw);}}}private PrintWriter select_output()throws FileNotFoundException
{if(nameOut !=null){return new PrintWriter(nameOut);}return new PrintWriter(System
.out);}}
//end net/leksi/contest/Solver.java
}
