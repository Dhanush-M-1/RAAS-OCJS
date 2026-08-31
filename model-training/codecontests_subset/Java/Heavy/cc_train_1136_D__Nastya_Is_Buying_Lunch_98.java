import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class ProblemD {

    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        //Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int pupilsNum = sc.nextInt();
        int pairsNum = sc.nextInt();
        int[] queue = new int[pupilsNum];
        //HashMap<Integer,Integer> pos = new HashMap<>();
        for (int i = 0; i < pupilsNum-1; i++) {
            queue[i] = sc.nextInt();
            //pos.put(queue[i],i);
        }
        int nastya = sc.nextInt();
        int[] passedBy = new int[pupilsNum+1];
//        for (int i = 0; i < pupilsNum; i++) {
//            toPassBy[i] = pupilsNum-2;
//        }
        HashSet<Integer> iCanPass = new HashSet<>();
        HashSet<Integer>[] canPass = new HashSet[pupilsNum+1];
        for (int i = 0; i < pupilsNum+1; i++) {
            canPass[i] = new HashSet<>();
        }
        for (int i = 0; i < pairsNum; i++) {
            int delante = sc.nextInt();
            int detras = sc.nextInt();
            if (detras == nastya){
                iCanPass.add(delante);
            } else if (delante == nastya){
                continue;
            } else {
                canPass[detras].add(delante);
            }
        }
        int iPassed = 0;
        int steps = 0;
        for (int i = pupilsNum-2; i >= 0; i--, steps++) {
            if (iCanPass.contains(queue[i]) && passedBy[queue[i]]+iPassed==steps){
                iPassed++;
            }
            else {
                for (Integer pass : canPass[queue[i]]) {
                    passedBy[pass]++;
                }
            }
        }
        pw.println(iPassed);
        pw.flush();
    }



    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}