import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class p000268A {
    static public void main(String[] args) throws IOException {
        new Solver() {{{ nameIn = "p000268A.in"; singleTest = true;}}
            @Override
            public void process(BufferedReader br, PrintWriter pw) throws IOException {
                int n = readIntArray(br)[0];
                int[][] ha = new int[n][];
                for(int i = 0; i < n; i++) {
                    ha[i] = readIntArray(br);
                }
                int res = 0;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(i != j && ha[i][0] == ha[j][1]) {
                            res++;
                        }
                    }
                }
                pw.println(res);
            }

        }.run();
    }
// begin import package net.leksi.contest;
static abstract class Solver{protected String nameIn=null;protected String nameOut=null
;protected boolean singleTest=false;private void preProcess(final BufferedReader
br,final PrintWriter pw)throws IOException{if(!singleTest){int t=Integer.valueOf
(br.readLine().trim());while(t-->0){process(br,pw);}}else{process(br,pw);}}abstract
public void process(final BufferedReader br,final PrintWriter pw)throws IOException
;protected int[]readIntArray(final BufferedReader br)throws IOException{return Arrays
.stream(br.readLine().trim().split("\\s+")).mapToInt(v->Integer.valueOf(v)).toArray
();}protected long[]readLongArray(final BufferedReader br)throws IOException{return
Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(v->Long.valueOf(v)).toArray
();}protected String readString(final BufferedReader br)throws IOException{return
br.readLine().trim();}public void run()throws IOException{try{try(FileReader fr=
new FileReader(nameIn);BufferedReader br=new BufferedReader(fr);PrintWriter pw=select_output
();){preProcess(br,pw);}}catch(Exception ex){try(InputStreamReader fr=new InputStreamReader
(System.in);BufferedReader br=new BufferedReader(fr);PrintWriter pw=select_output
();){preProcess(br,pw);}}}private PrintWriter select_output()throws FileNotFoundException
{if(nameOut !=null){return new PrintWriter(nameOut);}return new PrintWriter(System
.out);}}
// end import package net.leksi.contest;
    
}
