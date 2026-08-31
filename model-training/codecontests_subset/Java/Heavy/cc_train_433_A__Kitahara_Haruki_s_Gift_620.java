import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;


public class Gift {
    
    public static void main(String args[]) throws Exception {
                
        MyScanner in = new MyScanner();

        int n = in.nextInt();
        int[] b = new int [n];
        int count1=0,count2=0,flag=0;
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();    
            if (b[i]==100) count1++;
            else count2++;
        }
        
        if (count1%2==0) {
            if (count1==0 && count2%2==0)
                flag=1;
            else if (count1==0 && count2%2==1)
                flag=0;
            else
                flag=1;
        }
       
        
        if (flag==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }


    public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
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