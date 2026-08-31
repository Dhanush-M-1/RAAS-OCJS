import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
public class Main {


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /* static class obj{
           int a1;
           int a2;
           obj(int a1,int a2){
               this.a1=a1;
               this.a2=a2;
           }
       }
       static  class sortby implements Comparator<obj>{
           public   int compare(obj o1,obj o2){
               return o1.a1>o2.a1?-1:1;
           }
       }*/
    public static void main(String[] args) {
        FastReader s = new FastReader();
        //InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        //Scanner s=new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            int n=s.nextInt();
            ArrayList<String> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(s.nextLine());
            }
            boolean b0=false;
            if(a.get(0).charAt(1)=='0'||a.get(1).charAt(0)=='0')
                b0=true;
            boolean b1=false;
            if(a.get(0).charAt(1)=='1'||a.get(1).charAt(0)=='1')
                b1=true;
            if(b0&&b1){
                if(a.get(n-1).charAt(n-2)=='0'&&a.get(n-2).charAt(n-1)=='0'){
                    out.println(1);
                    if(a.get(0).charAt(1)=='0'){
                        out.println(1+" "+2);
                    }
                    else{
                        out.println(2+" "+1);
                    }
                }
               else if(a.get(n-1).charAt(n-2)=='1'&&a.get(n-2).charAt(n-1)=='1'){
                    out.println(1);
                    if(a.get(0).charAt(1)=='1'){
                        out.println(1+" "+2);
                    }
                    else{
                        out.println(2+" "+1);
                    }
                }
                else if(a.get(n-1).charAt(n-2)=='1'||a.get(n-2).charAt(n-1)=='1'){
                    out.println(2);
                    if(a.get(0).charAt(1)=='1'){
                        out.println(1+" "+2);
                    }
                    else{
                        out.println(2+" "+1);
                    }
                    if(a.get(n-1).charAt(n-2)=='1'){

                        int l=n-2+1;
                        int k=n-1+1;
                        out.println(l+" "+k);
                    }
                    else{
                        int l=n-1+1;
                        int k=n-2+1;
                        out.println(l+" "+k);
                    }
                }

                }
            else if(b0){
                if(a.get(n-1).charAt(n-2)=='1'&&a.get(n-2).charAt(n-1)=='1'){
                    out.println(0);
                }
               else if(a.get(n-1).charAt(n-2)=='0'&&a.get(n-2).charAt(n-1)=='0'){
                    out.println(2);

                        int l=n-2+1;
                        int k=n-1+1;
                        out.println(l+" "+k);

                         l=n-1+1;
                         k=n-2+1;
                        out.println(l+" "+k);
                    }
                else if(a.get(n-1).charAt(n-2)=='0'){
                    out.println(1);
                    int l=n-1+1;
                    int k=n-2+1;
                    out.println(l+" "+k);
                }
                else{
                    out.println(1);
                    int l=n-2+1;
                    int k=n-1+1;
                    out.println(l+" "+k);
                }
                }
            else {
                if(a.get(n-1).charAt(n-2)=='0'&&a.get(n-2).charAt(n-1)=='0'){
                    out.println(0);
                }
                else if(a.get(n-1).charAt(n-2)=='1'&&a.get(n-2).charAt(n-1)=='1'){
                    out.println(2);

                    int l=n-2+1;
                    int k=n-1+1;
                    out.println(l+" "+k);

                    l=n-1+1;
                    k=n-2+1;
                    out.println(l+" "+k);
                }
                else if(a.get(n-1).charAt(n-2)=='1'){
                    out.println(1);
                    int l=n-1+1;
                    int k=n-2+1;
                    out.println(l+" "+k);
                }
                else {
                    out.println(1);
                    int l=n-2+1;
                    int k=n-1+1;
                    out.println(l+" "+k);
                }

            }


        }
        out.close();
    }
}
