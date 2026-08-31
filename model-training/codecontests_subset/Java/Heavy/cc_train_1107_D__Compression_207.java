import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static Main mm;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        mm = new Main();
        mm.problemD(new Input(new BufferedReader(new InputStreamReader(System.in))), out);
        out.close();
    }

    static void problemD(Input in, PrintWriter out) throws IOException {
        int n=in.nextInt();
        int[][] d={{0,0,0,0},{0,0,0,1},{0,0,1,0},{0,0,1,1},{0,1,0,0},{0,1,0,1},{0,1,1,0},{0,1,1,1},{1,0,0,0},{1,0,0,1},{1,0,1,0},{1,0,1,1},{1,1,0,0},{1,1,0,1},{1,1,1,0},{1,1,1,1}};
        int[][] a= new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n/4; j++) {
                char c=in.nextChar();
                int k=c-(c<='9'?'0':'A'-10);
                for (int l = 0; l < 4; l++) {
                    a[i][j*4+l+1]=d[k][l];
                }
            }
        }
        int[][] b= new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                b[i][j]=b[i-1][j]+b[i][j-1]-b[i-1][j-1]+a[i][j];
            }
        }
        ArrayList<Integer> div=new ArrayList<>();
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0){
                div.add(i);
                div.add(n/i);
            }
        }
        div.add(n);
        if((int)Math.sqrt(n)*(int)Math.sqrt(n)==n)div.add((int)Math.sqrt(n));
        div.sort(Integer::compareTo);
        for (int i = div.size()-1; i >=0; i--) {
            int k=div.get(i);
            int kk=k*k;
            boolean bl=true;
            for (int j = k; j <= n && bl; j+=k) {
                for (int l = k; l <= n && bl; l+=k) {
                    int s = b[j][l]-b[j-k][l]-b[j][l-k]+b[j-k][l-k];
                    if (s != 0 && s != kk) {
                        bl=false;
                    }
                }
            }
            if(bl){
                out.println(k);
                return;
            }
        }
        out.println(1);
    }

    static void quickSort(int[] array, int low, int high,int k) {

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        /*if(high-i+1>k) partsort(a,ll,r,k);
        if(high-i+1<k) partsort(a,l,rr-1,k-(r-ll+1));*/

        if (high-j<k)
            quickSort(array, low, j, k-(high-j));

        if (high-i+1>k)
            quickSort(array, i, high, k);
    }

    static void partsort(int[] a,int l, int r,int k){
        int x=a[(r+l)/2];
        int ll=l,rr=r;
        while(ll<rr){
            while(a[ll]<x)ll++;
            while(a[rr]>x)rr--;
            if(ll<rr){int t=a[ll];a[ll]=a[rr];a[rr]=t;ll++;}
        }
        if(r-ll+1>k) partsort(a,ll,r,k);
        if(r-ll+1<k) partsort(a,l,rr-1,k-(r-ll+1));
    }

    static void problemC0(Input in, PrintWriter out) throws IOException {
        int n=in.nextInt(),k=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        char[] s=new char[n+1];
        for (int i = 0; i < n; i++) {
            s[i]=in.nextChar();
        }
        s[n]='0';
        int r=0;
        long ans=0;
        while(r<n){
            int l=r;
            while(s[r]==s[r+1])r++;
            int d=r-l+1;
            if(d>k){
                Arrays.sort(a,l,r+1);
            }
            int ll=Math.max(l,r-k+1);
            for (int i = r; i >=ll; i--) {
                ans+=a[i];
            }
            r++;
        }
        out.println(ans);
    }

    static void problemC(Input in, PrintWriter out) throws IOException {
        int n=in.nextInt(),k=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        char[] s=new char[n+1];
        for (int i = 0; i < n; i++) {
            s[i]=in.nextChar();
        }
        s[n]='0';
        int r=0;
        long ans=0;
        while(r<n){
            int l=r;
            while(s[r]==s[r+1])r++;
            int d=r-l+1;
            if(d>k){
                quickSort(a,l,r,k);
            }
            int ll=Math.max(l,r-k+1);
            for (int i = r; i >=ll; i--) {
                ans+=a[i];
            }

            r++;
        }
        out.println(ans);
    }

    static void problemB(Input in, PrintWriter out) throws IOException {
        int q=in.nextInt();
        for (; q > 0; q--) {
            long k = in.nextLong(),x=in.nextLong();
            out.println((k-1)*9+x);
        }
    }

    static void problemA(Input in, PrintWriter out) throws IOException {
        int q=in.nextInt();
        for (; q > 0; q--) {
            int n = in.nextInt();
            char[] s=in.next().toCharArray();
            boolean ok=s[n-1]>s[0] || n>2;
            if(ok){
                out.print("YES\n2\n"+s[0]+' ');
                for (int i = 1; i < n; i++) {
                    out.print(s[i]);
                }
                out.println();

            }else{
                out.println("NO");
            }
        }
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public Input(String s) {
            this.in = new BufferedReader(new StringReader(s));
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char) c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char) c);
            }
            return sb.toString();
        }

        public char nextChar() throws IOException {
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return (char) c;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    return (char) c;
                }
            }
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable{
    int v1,v2,w;

    public Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        return w-((Edge)o).w;
    }
}