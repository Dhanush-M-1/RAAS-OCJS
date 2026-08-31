import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),m=in.nextInt();
        int w[]=new int [n+1];
        int q[]=new int [m+1];
        for(int i=1;i<=n;i++){
            w[i]=in.nextInt();
        }
        int q1[]=new int [m],cou=0;
        q[0]=0;
        for(int i=1;i<=m;i++){
            q[i]=in.nextInt();
            if(q[i]!=q[i-1])
                q1[cou++]=q[i];
        }
        long ans=0;
        ArrayList<Integer> stack=new ArrayList<Integer>();
        int done[]=new int [n+1];
        Arrays.fill(done,0);
        int k=0;
        for(int i=0;i<cou;i++){
            if(done[q1[i]]==0){
                stack.add(k++,q1[i]);
                done[q1[i]]++;
            }
        }
        /**for(int i=0;i<k;i++){
            out.print(stack.get(i));
        }*/
        for(int i=1;i<m;i++){
            int tmp=0;
            for(int j=0;j<k;j++){
                if(stack.get(j)==q1[i]){
                    ans+=tmp;
                    //out.print(i+" "+tmp+" ");
                    tmp=stack.remove(j);
                    stack.add(0,tmp);
                    break;
                }
                else tmp+=w[stack.get(j)];
            }
            /**out.printLine();
            for(int i1=0;i1<k;i1++){
                out.print(stack.get(i1));
             }
            out.printLine();

            //ans+=tmp;*/
        }
        out.printLine(ans);
    }
}

class InputReader {
    BufferedReader in;
    StringTokenizer tokenizer=null;

    public InputReader(InputStream inputStream)
    {
        in=new BufferedReader(new InputStreamReader(inputStream));
    }
    public String next()
    {
        try{
            while (tokenizer==null||!tokenizer.hasMoreTokens())
            {
                tokenizer=new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        }
        catch (IOException e)
        {
            return null;
        }
    }
    public int nextInt()
    {
        return Integer.parseInt(next());
    }
}

class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

    public void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object...objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
}
