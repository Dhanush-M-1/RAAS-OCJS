import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Юля on 22.09.2015.
 */
public class SolverB551 {

    public static void main(String[] args) throws IOException {
        new SolverB551().run();
    }

    BufferedReader br;
    PrintWriter pw;
    StringTokenizer tokenizer;

    public String nextToken() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(br.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException, NumberFormatException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException, NumberFormatException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(nextToken());
    }

    public void run() throws IOException {
//        br = new BufferedReader(new FileReader("input.txt"));
//        pw = new PrintWriter("output.txt");
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        solve();

        pw.flush();
        pw.close();
    }

    private void solve() throws IOException {
        String astr=nextToken();
        String bstr=nextToken();
        String cstr=nextToken();
        int[] a=new int[26];
        int[] b=new int[26];
        int[] c=new int[26];

        for(int i=0;i<astr.length();i++){
            a[astr.charAt(i)-'a']++;
        }
        for(int i=0;i<bstr.length();i++){
            b[bstr.charAt(i)-'a']++;
        }
        for(int i=0;i<cstr.length();i++){
            c[cstr.charAt(i)-'a']++;
        }
        int countB=100000;
        boolean ok=false;
        for(int i=0;i<26;i++){
            int cnt=0;
            if(b[i]>0){
                ok=true;
                cnt=a[i]/b[i];
                countB=Math.min(countB,cnt);
            }
        }
        if(!ok)
            countB=0;
        int countC=100000;
        ok=false;
        for(int i=0;i<26;i++){
            int cnt=0;
            if(c[i]>0){
                ok=true;
                cnt=(a[i]-b[i]*countB)/c[i];
                countC=Math.min(countC,cnt);
            }
        }
        if(!ok)
            countC=0;
        int res=countB+countC;
        int countBNew=countB;
        int countCNew=countC;
        ok=false;
        for(int i=0;i<countB;i++){
            countC=100000;
            for(int j=0;j<26;j++){
                int cnt=0;
                if(c[j]>0){
                    ok=true;
                    cnt=(a[j]-b[j]*i)/c[j];
                    countC=Math.min(countC,cnt);

                }
            }
            if(ok){
                if(i+countC>res){
                    res=i+countC;
                    countBNew=i;
                    countCNew=countC;
                }
            }
        }

        for(int i=0;i<countBNew;i++){
            pw.print(bstr);
        }
        for(int i=0;i<countCNew;i++){
            pw.print(cstr);
        }
        for(int i=0;i<26;i++){
            a[i]=a[i]-b[i]*countBNew-c[i]*countCNew;
            if(a[i]>0){
                for(int j=0;j<a[i];j++){
                    pw.print((char)(i+'a'));
                }
            }
        }
    }
}
