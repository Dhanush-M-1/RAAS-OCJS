
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.regex.Pattern;
import javafx.util.Pair;
import sun.util.locale.StringTokenIterator;

public class Foh {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int I(String s) {
        return Integer.parseInt(s);
    }

    static long L(String s) {
        return Long.parseLong(s);
    }

    static double D(String s) {
        return Double.parseDouble(s);
    }

    static String[] SA() throws IOException {
        return bf.readLine().split(" ");
    }

    public static void main(String[] args) throws IOException {

        /*    int n = I(bf.readLine());
        ArrayList<Integer> al = new ArrayList();

        HashMap hm = new HashMap();
        StringTokenizer in = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int x = I(in.nextToken());
            al.add(x);
        }
        int let = 0;
        int inc = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = al.get(i);
            if (!hm.containsKey(x)) {
                hm.put(x, 0);
                inc++;
            } else {
                if (let > 0) {
                    max = Math.max(max, inc);
                    inc = 1;
                    hm = new HashMap();
                    hm.put(x, 0);
                } else {
                    let = 1;
                    for (int j = i + 1; j < n; j++) {
                        if (!hm.containsKey(al.get(j))) {
                            i = j - 1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(n-Math.max(max, inc));*/
 /*  StringBuffer st = new StringBuffer();
        st.append(bf.readLine());
        int x = 0;
        int num = -1;
        boolean key=false;
        int str=0;
        for (int i = 0; i < st.length(); i++) {
            
            if ((st.charAt(i) - '0') % 2 == 0 && (st.charAt(i) - '0') < st.charAt(st.length()-1)-'0') {
                num = (st.charAt(i) - '0');
                x = i;break;
            }

        }
        if(num==-1){
         for (int i = st.length()-1; i >=0; i--) {
            
            if ((st.charAt(i) - '0') % 2 == 0 ) {
                num = (st.charAt(i) - '0');
                x = i;break;
            }

        }
        }
        for (int i = 0; i < st.length(); i++) {
            
          if(st.charAt(i)=='0'&&!key){str=i+1;}else{key=true;break;}

        }
        if (num != -1) {
            st.setCharAt(x, st.charAt(st.length() - 1));
            st.setCharAt(st.length()-1, (char)(num+'0'));
            System.out.println(st.substring(str));
        } else {
            System.out.println("-1");
        }*/
 /*  StringTokenizer in = new StringTokenizer(bf.readLine());
        int n = I(in.nextToken());
        int k = I(in.nextToken());
        if(n==k){n--;}
        in = new StringTokenizer(bf.readLine());
int numco=0;
        HashMap<Integer, Integer> hm = new HashMap();
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < Math.min(k, n); i++) {
            int x = I(in.nextToken());
          
                al.add(x);
               if(!hm.containsKey(x)){
                   numco++;
                   hm.put(x, x);
               }

        }
     if(numco==k){k--;}
       int inc=0;
      hm = new HashMap();
        for (int i = 0; i <al.size(); i++) {
            int x=al.get(i);
            if(!hm.containsKey(x)){
            inc++;
            hm.put(x, x);
            out.insert(0, al.get(i)+" ");
        }if(inc==k)break;}
        System.out.print(inc+"\n"+out);*/
 /*   StringTokenizer in = new StringTokenizer(bf.readLine());
        int n = I(in.nextToken());
        int k = I(in.nextToken());
        ArrayList<Integer> al = new ArrayList();
        in = new StringTokenizer(bf.readLine());
        int prev = I(in.nextToken());

        for (int i = 1; i < n; i++) {
int x=I(in.nextToken());
al.add(x-prev);
prev=x;        }
        Collections.sort(al);
        int sum=0;
        for(int i=0;i<n-k;i++){sum+=al.get(i);}
        System.out.println(sum);*/
 /*  int n = I(bf.readLine());
        String st = bf.readLine();
        ArrayList<Integer> al = new ArrayList();
        StringTokenizer in = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 9; i++) {
            al.add(I(in.nextToken()));
        }
        int x=0;
        int ind=0;
        for (int i = 0; i < st.length(); i++) {
            if(al.get(st.charAt(i)-'0')>(st.charAt(i)-'0')){
                ind=st.charAt(i)-'0';
            x=i;break;
            }
        }
        int inc=0;
        for(int i=x;i>=0;i--){
        
        }
        System.out.println(out);*/
 /*     int t = I(bf.readLine());
        while (t-- > 0) {
            StringTokenizer in = new StringTokenizer(bf.readLine());
            int n = I(in.nextToken());
            int x = I(in.nextToken());
            int min = Integer.MAX_VALUE;
            boolean tf = false;
            for (int i = 0; i < n; i++) {
                in = new StringTokenizer(bf.readLine());
                int d = I(in.nextToken());
                int h = I(in.nextToken());
                 if(d>=x&&!tf){tf=true;min=1;}
          else if(!tf&&d>h){
                  
                if((d-h)>=Math.ceil(x/2.0)){min=2;}
                else{
                int te=x/(d-h);
                if(x%(d-h)!=0){
              //      System.out.println((te*d)-((te-1)*d)<x);
                if((te*d)-((te-1)*h)<x){te++;}
                
                
                }
                min=Math.min(min,te);
                }
                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            System.out.println(min);
        }*/
 /* StringTokenizer in = new StringTokenizer(bf.readLine());
        int n = I(in.nextToken());
 
        int q = I(in.nextToken());
        int a[][] = new int[3][n + 9];
        
        ArrayList<HashSet<Integer>> al = new ArrayList();
        for (int i = 0; i < 3; i++) {
            al.add(new HashSet<Integer>());
        }
 
        while (q-- > 0) {
            in = new StringTokenizer(bf.readLine());
            int r = I(in.nextToken());
            int c = I(in.nextToken()) + 3;
            a[r][c] = a[r][c] == 1 ? 0 : 1;
           if(r==1){
           if(a[r][c]==1&&(a[2][c]==1||a[2][c+1]==1||a[2][c-1]==1)){inc++;}
           else if(a[r][c]==0&&(a[2][c]==1||a[2][c+1]==1||a[2][c-1]==1)){if(inc>0)inc--;}}
           else {
               if (a[r][c] == 0) {
                   tester(c, a);
               } else if (a[r][c] == 1) {
                   tester1(c, a);
               }
           }
            System.out.println(inc);
            if(inc==0){out.append("YeS\n");}else{out.append("nO\n");}
        }
        System.out.print(out);*/
 /*int t = I(bf.readLine());
for(int i=0;i<26;i++){al1[i]=new HashSet();}
boolean  check[]=new boolean[26];
        for (int i = 0; i < t; i++) {

            String n = bf.readLine();
            ArrayList<Integer> al = new ArrayList();
            HashSet<Integer> set = new HashSet();
            for (int j = 0; j < n.length(); j++) {
                int x = n.charAt(j) - 'a';
                if (!set.contains(x)) {check[x]=true;
                    set.add(x);
                    al.add(x);
                }

            }
            for (int j = 1; j < al.size(); j++) {
                al1[al.get(j)].add(al.get(j - 1));
                al1[al.get(j - 1)].add(al.get(j));
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!id[i]&&check[i]) {
                inc++;
                dfs(i);
            }
        }
        System.out.println(inc);*/
 /*  int t = I(bf.readLine());
        while (t-- > 0) {
            StringTokenizer in = new StringTokenizer(bf.readLine());
            int n = I(in.nextToken());
            int k = I(in.nextToken());
            String st = bf.readLine();
            int str = st.indexOf("1");
            int end = st.lastIndexOf("1");
            if (str == end) {
                out.append("0\n");
            } else {
                int dp[] = new int[st.length()];
                int sum = 0;
                for (int i = 0; i < st.length(); i++) {
                    if (st.charAt(i) == '1') {
                        sum++;
                    }
                    dp[i] = sum;
                }
                int a[][] = new int[2][st.length()];
                int min = Integer.MAX_VALUE;
                for (int i = str; i <= Math.min(str + k, end); i++) {
                    int inc = 0;
                    int var = i + k;
                    while (true) {

                        if (var >= end) {
                            System.out.println(dp[end - 1] + "  " + dp[var - k] + "    " + (end - 1) + "  " + (var - k) + "   " + var);
                            inc += (dp[end - 1] - dp[var - k]);

                            break;
                        }
                        System.out.println((var - 1) + "   " + (var - k) + "   " + var);
                        //   inc += dp[var -1] - ((var - k)!=0?dp[var - k]:0);

                        inc += dp[var - 1] - dp[var - k];
                        if (st.charAt(var) == '0') {
                            inc++;
                        }
                        var += k;

                    }
                    System.out.println("inc1:"+inc);
                  if(i!=0)  inc+=(dp[i-1]);
                    System.out.println("inc2:"+inc);
                    //   min=Math.min(inc,min);
                }
                //System.out.println(min);
            }
        }
        System.out.println(out);*/
        //B-
        /*
       int t = I(bf.readLine());
        while (t-- > 0) {
             int n = I(bf.readLine());
            StringTokenizer in = new StringTokenizer(bf.readLine());
           ArrayList<Integer> al=new ArrayList();
            for(int i=0;i<n;i++){al.add(I(in.nextToken()));}
            Collections.sort(al);
            int min=Integer.MAX_VALUE;
            for(int i=1;i<n;i++){ min=Math.min(min,al.get(i)-al.get(i-1));}
            out.append(min+"\n");
        }
        System.out.println(out);*/
        //c-
        /*
       int t = I(bf.readLine());
        while (t-- > 0) {
             int n = I(bf.readLine());
            StringTokenizer in = new StringTokenizer(bf.readLine());
            int o=0;
            int e=0;
            ArrayList<Integer> al=new ArrayList();
            HashMap<Integer,Integer> hm=new HashMap();
            for(int i=0;i<n;i++){
            int x=I(in.nextToken());
            if(x%2==0){al.add(x);e++;}else{hm.put(x, 0);o++;}
            
            }
            if(o%2==0&&e%2==0){out.append("YES\n");}
            else{
                boolean tf=false;
            for(int i=0;i<al.size();i++){
            if(hm.containsKey(al.get(i)-1)||hm.containsKey(al.get(i)+1)){tf=true;break;}
            }
            if(tf){out.append("YES\n");}
            else{out.append("NO\n");}
            }
        }System.out.println(out);*/
        //D
        /*
        int t = I(bf.readLine());
        while (t-- > 0) {

            StringTokenizer in = new StringTokenizer(bf.readLine());
            int n = I(in.nextToken());
            int k = I(in.nextToken());
            ArrayList<Integer> al = new ArrayList();
            for (int i = 1; i * i <= n ; i++) {
                if (n % i == 0) {
                    al.add(i);
                    al.add(n/i);
                }
            }
            al.add(n);
            Collections.sort(al);
            for (int i = al.size() - 1; i >= 0; i--) {
                if (al.get(i) <= k) {
                    out.append((n/al.get(i)) + "\n");break;
                }
            }
        }
        System.out.println(out);
         */
        //A
        /*
           int t = I(bf.readLine());
        while (t-- > 0) {

            StringTokenizer in = new StringTokenizer(bf.readLine());
            int n = I(in.nextToken());
            int k = I(in.nextToken());
        int x=n*k;
        int min=Integer.MAX_VALUE;
        if(n*2>=k){min=Math.min(min, n*2);}
        if(n<=k*2){min=Math.min(min, k*2);}
          if(n>=k*2){min=Math.min(min, n);}
        if(n*2<=k){min=Math.min(min, k);}
      min=Math.min(min, n+k);
     
    //        System.out.println(min);
        int i=1;
       while(true){
        if(i*i>=(2*x)&&(i>=min)){out.append((i*i)+"\n");break;}
        i++;
        }
        
        }
        System.out.println(out);
    
         */
 /*  int t = I(bf.readLine());
        while (t-- > 0) {
            int n = I(bf.readLine());
            char a[][]=new char[n][];
            for(int i=0;i<n;i++){a[i]=bf.readLine().toCharArray();}
            boolean[][] tf=new boolean[n][n];
            for(int i=0;i<n;i++){
            
                for(int j=n-1;j>=0;j--){
                if(a[i][j]=='1'){tf[i][j]=true;}else{break;}
                }
            for(int j=n-1;j>=0;j--){
                if(a[j][i]=='1'){tf[j][i]=true;}else{break;}
                }
            }
            boolean isok=false;
            for(int i=n-2;i>=0;i--){
            
            for(int j=n-2;j>=0;j--){
            if(!tf[i][j]&&a[i][j]=='1'){
            if(tf[i+1][j]||tf[i][j+1]){tf[i][j]=true;}
            else{isok=true;break;}
            }
            
            }
            }
            if(isok){out.append("NO\n");}else{out.append("YES\n");}
        }
        System.out.println(out);*/
        StringTokenizer in = new StringTokenizer(bf.readLine());
        long a = I(in.nextToken());
        long b = I(in.nextToken());
        long c = I(in.nextToken());
        if (a == 0 && b == 0&&c==0) {
            System.out.println("-1");
        } else  if (a == 0 && b == 0&&c!=0) {
            System.out.println("0");
        } else if (a == 0 && b != 0) {
            System.out.println("1");
            System.out.printf("%.5f%n", ((-c * 1.0) / (b * 1.0)));
        } else if (b == 0 && a != 0) {

            if ((a < 0 && c >= 0) || (c <= 0 && a > 0)) {
                if (Math.sqrt((-c * 1.0) / (a * 1.0)) != 0) {
                    System.out.println("2");
                    System.out.printf("%.5f%n", -Math.sqrt((-c * 1.0) / (a * 1.0)));
                    System.out.printf("%.5f%n", Math.sqrt((-c * 1.0) / (a * 1.0)));
                } else {
                    System.out.println("1");
                    System.out.printf("%.5f%n", Math.sqrt((-c * 1.0) / (a * 1.0)));
                }
            } else {
                System.out.println("0");
            }
        } else {

            if ((b * b) - (4 * a * c) < 0) {
                System.out.println(0);
            } else if ((b * b) - (4 * a * c) == 0) {
                System.out.println("1");
                System.out.printf("%.5f%n", ((-b * 1.0) / (2 * a * 1.0)));
            } else {

                
                double max = Math.max(((((-b) * 1.0) + Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)), (((-b) - Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)));
                double min = Math.min(((((-b) * 1.0) + Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)), (((-b) - Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)));
                if ((min == 0 && max == min)) {
                    System.out.println("1\n");
                    System.out.print("0.000000");

                }
                else{
                    System.out.println("2\n");
                    System.out.printf("%.5f%n", (min));

                    System.out.printf("%.5f%n", (max));
                }
            }
        }
    }
    /*
    1
9 2
100100100

     */

    static boolean id[] = new boolean[26];
    static HashSet<Integer> al1[] = new HashSet[26];

    static void dfs(int i) {
        id[i] = true;
        for (Integer x : al1[i]) {
            if (!id[x]) {
                dfs(x);
            }
        }
    }
    static int inc = 0;

    static void tester(int x, int a[][]) {
        if (a[1][x] == 1 && a[2][x + 1] == 0 && a[2][x - 1] == 0 && a[2][x] == 0) {
            if (inc > 0) {
                inc--;
            }
        }
        if (a[1][x + 1] == 1 && a[2][x + 2] == 0 && a[2][x] == 0 && a[2][x + 1] == 0) {
            if (inc > 0) {
                inc--;
            }
        }
        if (a[1][x - 1] == 1 && a[2][x] == 0 && a[2][x - 2] == 0 && a[2][x - 1] == 0) {
            if (inc > 0) {
                inc--;
            }
        }
    }

    static void tester1(int x, int a[][]) {
        if (a[1][x] == 1 && a[2][x + 1] == 0 && a[2][x - 1] == 0) {
            inc++;
        }
        if (a[1][x + 1] == 1 && a[2][x + 2] == 0 && a[2][x] == 0) {
            inc++;
        }
        if (a[1][x - 1] == 1 && a[2][x] == 0 && a[2][x - 2] == 0) {
            inc++;
        }
    }

    /*
6 5
1 2
1 3
1 4
2 3
1 3

     */
}
//to be fare with you
//the testcase number 7 i just saw the output , and i discover wrong in understanding when the answer equal infinit