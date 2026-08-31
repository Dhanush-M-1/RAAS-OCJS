import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ProblemE {

    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        //Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = sc.nextInt();
        for (int test = 0; test < tests; test++) {
            int nodos = sc.nextInt();
            int aristas = sc.nextInt();
            int fair1 = sc.nextInt();
            int fair2 = sc.nextInt();
            ArrayList<Integer>[] vecino = new ArrayList[nodos+1];
            for (int i = 0; i < nodos+1; i++) {
                vecino[i] = new ArrayList<>();
            }
            for (int i = 0; i < aristas; i++) {
                int ori = sc.nextInt();
                int des = sc.nextInt();
                vecino[ori].add(des);
                vecino[des].add(ori);
            }
            boolean[] visited = new boolean[nodos+1];
            long only1 = 0;
            long only2 = 0;
            visited[fair1]=true;
            visited[fair2]=true;
            for (int i = 1; i < nodos+1; i++) {
                if (visited[i]) continue;
                int thisBatch = 1;
                boolean met1 = false;
                boolean met2 = false;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()){
                    int ori = queue.removeFirst();
                    for (Integer vec : vecino[ori]) {
                        if (vec == fair1) met1 = true;
                        else if (vec == fair2) met2 = true;
                        else {
                            if (!visited[vec]){
                                thisBatch++;
                                queue.add(vec);
                                visited[vec] = true;
                            }
                        }
                    }
                }
                if (met1 && met2){
                } else if (met1){
                    only1 += thisBatch;
                } else if (met2){
                    only2 += thisBatch;
                } else {
                }
            }
            pw.println(only1*only2);
        }


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
