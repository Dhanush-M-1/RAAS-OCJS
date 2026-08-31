import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Marlin {
    public static void main(String[] args) {
    FastReader scan = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int n=scan.nextInt();
    Node[] arr=new Node[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=new Node(scan.nextInt(),scan.nextInt());
        }
        if(n<2)
        {
            System.out.println("1");
            return;
        }
        int ans=2;
        int left=arr[0].position;
        int right=0;
        for (int i = 1; i < n-1; i++) {
            right=arr[i+1].position;
            if(arr[i].position-arr[i].height>left)
            {
                ans++;
                left=arr[i].position;
            }
            else if(arr[i].position+arr[i].height<right)
            {
                ans++;
                left=arr[i].position+arr[i].height;
            }
            else
            {
                left=arr[i].position;
            }
        }
        System.out.println(ans);
    out.flush();
}
static class Node{
        int position;
        int height;
        public Node(int position,int height)
        {
            this.position=position;
            this.height=height;
        }
}
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
