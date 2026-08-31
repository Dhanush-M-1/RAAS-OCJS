import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class _p001060A {
    static public void main(final String[] args) throws IOException {
        p001060A._main(args);
    }
//begin p001060A.java
static private class p001060A extends Solver{public p001060A(){nameIn="p001060A.in"
;singleTest=true;}int n;String s;@Override protected void solve(){long count11=(long
)s.length()/11;long count8=Arrays.stream(s.split("")).mapToInt(v->(int)(v.charAt
(0)-'0')).filter(v->v==8).count();pw.println(Math.min(count8,count11));}@Override
public void readInput()throws IOException{n=sc.nextInt();if(sc.hasNextLine()){sc
.nextLine();}s=sc.nextLine().trim();}static public void _main(String[]args)throws
IOException{new p001060A().run();}}
//end p001060A.java
//begin net/leksi/contest/Solver.java
static private abstract class Solver{protected String nameIn=null;protected String
nameOut=null;protected boolean singleTest=false;protected boolean preprocessDebug
=false;protected boolean doNotPreprocess=false;protected Scanner sc=null;protected
PrintWriter pw=null;private void process()throws IOException{if(!singleTest){int
t=lineToIntArray()[0];while(t-->0){readInput();solve();}}else{readInput();solve(
);}}abstract protected void readInput()throws IOException;abstract protected void
solve()throws IOException;protected int[]lineToIntArray()throws IOException{return
Arrays.stream(sc.nextLine().trim().split("\\s+")).mapToInt(Integer::valueOf).toArray
();}protected long[]lineToLongArray()throws IOException{return Arrays.stream(sc.nextLine
().trim().split("\\s+")).mapToLong(Long::valueOf).toArray();}protected String intArrayToString
(final int[]a){return Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors
.joining(" "));}protected String longArrayToString(final long[]a){return Arrays.stream
(a).mapToObj(Long::toString).collect(Collectors.joining(" "));}protected List<Long>
longArrayToList(final long[]a){return Arrays.stream(a).mapToObj(Long::valueOf).collect
(Collectors.toList());}protected List<Integer>intArrayToList(final int[]a){return
Arrays.stream(a).mapToObj(Integer::valueOf).collect(Collectors.toList());}protected
List<Long>intArrayToLongList(final int[]a){return Arrays.stream(a).mapToObj(Long
::valueOf).collect(Collectors.toList());}protected void run()throws IOException{
boolean done=false;if(nameIn !=null){try{try(FileInputStream fis=new FileInputStream
(nameIn);PrintWriter pw0=select_output();){done=true;sc=new Scanner(fis);pw=pw0;
process();}}catch(IOException ex){}}if(!done){try(PrintWriter pw0=select_output(
);){sc=new Scanner(System.in);pw=pw0;process();}}}private PrintWriter select_output
()throws FileNotFoundException{if(nameOut !=null){return new PrintWriter(nameOut
);}return new PrintWriter(System.out);}}
//end net/leksi/contest/Solver.java
}
