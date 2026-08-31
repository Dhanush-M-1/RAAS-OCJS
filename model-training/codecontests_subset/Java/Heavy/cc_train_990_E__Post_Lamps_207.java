import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class FastReader
    {
        final BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastReader()
        {
            bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
        }

        FastReader(String inputFile){
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        String next()
        {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements())
            {
                try
                {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = bufferedReader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter{
        PrintWriter printWriter;

        FastWriter(){
            printWriter = new PrintWriter(new BufferedOutputStream(System.out));
        }

        FastWriter(String outputFile){
            File file = new File(outputFile);
            if (!file.exists()){
                try {
                    if (!file.createNewFile())
                        throw new RuntimeException("Output file was not created!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        void print(Object object){
            printWriter.print(object);
        }

        void print(Object ...objects){
            for (int i = 0; i < objects.length; i ++) {
                printWriter.print(objects[i]);
                if (i != objects.length - 1)
                    printWriter.write(' ');
            }
        }

        void flush(){
            printWriter.flush();
        }
    }

    private static final int mn = 1000006;
    private static int n, m, k, a[] = new int[mn], jump[] = new int[mn];
    private static boolean mark[] = new boolean[mn];

    private static void setup() {
        FastReader fastReader = new FastReader();
        n = fastReader.nextInt();
        m = fastReader.nextInt();
        k = fastReader.nextInt();
        for (int i = 1; i <= m; i++) 
            mark[fastReader.nextInt()] = true;
        for (int i = 1; i <= k; i ++)
            a[i] = fastReader.nextInt();
    }

    private static void xuly() {
        FastWriter fastWriter = new FastWriter();
        if (mark[0]) {
            fastWriter.print(-1);
            fastWriter.flush();
            return;
        }
        for (int x = 0; x < n; x ++)
            if (mark[x])
                jump[x] = jump[x - 1];
            else
                jump[x] = x;

        long ans = Long.MAX_VALUE;
        for (int l = 1; l <= k; l ++) {
            int pos = 0;
            long cost = 0;
            while(pos < n) {
                int place = jump[pos];
                if (place + l <= pos) {
                    cost = Long.MAX_VALUE;
                    break;
                }
                cost += a[l];
                pos = place + l;
            }
            ans = Long.min(ans, cost);
        }

        if (ans == Long.MAX_VALUE) {
            fastWriter.print(-1);
        } else {
            fastWriter.print(ans);
        }
        fastWriter.flush();
    }

    public static void main(String[] args) {
        setup();
        xuly();
    }
}