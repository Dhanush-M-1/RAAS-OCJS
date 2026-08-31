import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        // write your code here

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Solver taskA = new Solver();
        taskA.solve(1, in, out);

        out.flush();
        out.close();
    }
}




class Solver {


    public void solve(int caseNumber, InputReader in, PrintWriter out) {

        int numberOfPlayer=in.getNextInt();
        String input=in.getNextString();

        int countAllin,countIn,countFolded;
        countAllin=countIn=countFolded=0;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='A') countAllin++;
            if(input.charAt(i)=='I') countIn++;
            if(input.charAt(i)=='F') countFolded++;
        }

        if(countIn>1){
            out.println("0"); return ;
        }
        if(countIn==1){
            out.println("1"); return ;
        }
        out.println(countAllin);

    }

}


class InputReader {

    public BufferedReader reader;
    public StringTokenizer tokenizer;

    InputReader(InputStream stream) {
        try {
            reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        tokenizer = null;
    }

    String getNextString() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    int getNextInt() {
        return Integer.parseInt(getNextString());
    }


}