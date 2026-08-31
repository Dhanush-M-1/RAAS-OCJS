
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static final int Mod=(int)1e9+7;
    static final int N=(int)1000+5;

    public static void main(String[] args) throws IOException {
        // Reader.init(System.in);
        //Scanner in=new Scanner(new FileInputStream("input.txt"));
        FastReader in=new FastReader();
        StringBuilder sb=new StringBuilder();
        //in=new FileReader("input.txt");
        //PrintWriter out=new PrintWriter(new FileOutputStream("output.txt"));
        PrintWriter out=new PrintWriter(System.out);
        Main ob=new Main();
        Map<String,Integer> mp=new TreeMap();
        String s=in.next();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='-'||(i>0&&s.charAt(i-1)!='-'))
                continue;

            String dd="",mm="",yy="";
            int j=i;
            while(j<s.length()&&s.charAt(j)!='-'){
                dd+=s.charAt(j);
                j++;
            }
            j++;
            while(j<s.length()&&s.charAt(j)!='-'){
                mm+=s.charAt(j);
                j++;
            }
            j++;
            while(j<s.length()&&s.charAt(j)!='-'){
                yy+=s.charAt(j);
                j++;
            }
            if(dd.length()<2||mm.length()!=2||yy.length()<4) {
                //out.println(dd);
                continue;
            }
            while(i<s.length()&&s.charAt(i)!='-')
                i++;
            dd=dd.substring(dd.length()-2);
            yy=yy.substring(0,4);
            if(!isYear(yy)||!isMonth(mm)||!isDay(dd,mm))
                continue;
            String date=dd+"-"+mm+"-"+yy;
            if(mp.containsKey(date)){
                int val=mp.get(date);
                mp.put(date,val+1);
            }
            else{
                mp.put(date,1);
            }
        }

        int mx=Integer.MIN_VALUE;
        String res="";
        for(Map.Entry<String,Integer> x:mp.entrySet()){
            if(x.getValue()>mx){
                mx=x.getValue();
                res=x.getKey();
            }
        }
        out.println(res);



        out.close();
    }
    static int numOfDays(String s){
        int val=Integer.parseInt(s);
        if(val==2)return 28;
        else if(val==9||val==4||val==6||val==11)
            return 30;
        else return 31;
}
    static boolean isYear(String s){
        return s.equals("2013")||s.equals("2014")||s.equals("2015");
    }
    static boolean isMonth(String s){
        int val=Integer.parseInt(s);
        return (val>=1&&val<=12);
    }
    static boolean isDay(String s,String mm){
        int val=Integer.parseInt(s);
        return (val>=1&&val<=numOfDays(mm));
    }
    static int[] reverse(int [] arr){
        ArrayList<Integer> temp=new ArrayList();
        for(int i=0;i<arr.length;i++)
            temp.add(arr[i]);
        Collections.reverse(temp);
        for(int i=0;i<temp.size();i++)
            arr[i]=temp.get(i);
        return arr;
    }
    static String reverse(String s){
        String temp="";
        for(int i=s.length()-1;i>=0;i--)
            temp+=s.charAt(i);
        return temp;
    }
    static String sort(String inputString)
    {
        ArrayList<Character> arr=new ArrayList();
        for(int i=0;i<inputString.length();i++)
            arr.add(inputString.charAt(i));
        Collections.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.size();i++)
            sb.append(arr.get(i));

        return sb.toString();
    }

    static boolean next_permutation(int[] p, int len) {
        int a = len - 2;
        while (a >= 0 && p[a] >= p[a + 1]) {
            a--;
        }

        if (a == -1) {
            return false;
        }

        int b = len - 1;
        while (p[b] <= p[a]) {
            b--;
        }

        p[a] += p[b];
        p[b] = p[a] - p[b];
        p[a] -= p[b];

        for (int i = a + 1, j = len - 1; i < j; i++, j--) {
            p[i] += p[j];
            p[j] = p[i] - p[j];
            p[i] -= p[j];
        }

        return true;
    }
    static int lower_bound(ArrayList<Integer> arr,int key) {
        int len = arr.size();
        int lo = 0;
        int hi = len-1;
        int mid = (lo + hi)/2;
        while (true) {
            int cmp = (arr.get(mid)==key?1:0);
            if (cmp == 0 || cmp > 0) {
                hi = mid-1;
                if (hi < lo)
                    return mid;
            } else {
                lo = mid+1;
                if (hi < lo)
                    return mid<len-1?mid+1:-1;
            }
            mid = (lo + hi)/2;
        }
    }
    static int upper_bound(ArrayList<Integer> arr, int key) {
        int len = arr.size();
        int lo = 0;
        int hi = len-1;
        int mid = (lo + hi)/2;
        while (true) {
            int cmp = (arr.get(mid)==key?1:0);
            if (cmp == 0 || cmp < 0) {
                lo = mid+1;
                if (hi < lo)
                    return mid<len-1?mid+1:-1;
            } else {
                hi = mid-1;
                if (hi < lo)
                    return mid;
            }
            mid = (lo + hi)/2;
        }
    }
    static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    static double dot(Point p,Point q){
        return (p.x*q.x+p.y*q.y);
    }
    static double cross(Point p,Point q){
        return (p.x*q.y-p.y*q.x);
    }
    static Point computeLineIntersection(Point a,Point b,Point c,Point d){
        b=b.sub(a);d=c.sub(d);c=c.sub(a);
        return a.add(b.mulCon(cross(c,d)).devideCon(cross(b,d)));
    }
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

}
class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(
                new InputStreamReader(input, "UTF-8"));
        tokenizer = new StringTokenizer("");
    }

    static void init(String url) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(url));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
class Point{
    double x,y;
    Point(double _x,double _y){
        x=_x;
        y=_y;
    }
    Point add(final Point p){
        return new Point(x+p.x,y+p.y);
    }
    Point sub(final Point p){
        return new Point(x-p.x,y-p.y);
    }
    Point mulCon(final double c){
        return new Point(c*x,c*y);
    }
    Point devideCon(final double c){
        return new Point(x/c,y/c);
    }
}
class  pair implements Comparator<pair>{
    int  first;
    int  second;
    //int third;
    pair(){}
    pair(int a,int s){
        first = a;
        second = s;
        //third=t;
    }

    /* pair(pair a,pair b){
         first = a;
         second = b;
     }*/
    @Override
    public int compare(pair a,pair b){
        return (a.first-b.first);
    }
}