import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class d {
    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
       // StringBuilder sb = new StringBuilder();
        String[] st=s();long ans=0;
        int n=i(st[0]);String[] ss=s();
        int[] a=new int[n];long sum=0;
        for(int i=0;i<n;i++) {
         a[i]=i(ss[i]);sum+=a[i];
        }Arrays.sort(a);long val=0;
        for(int i=0;i<n;i++){
            val+=(a[n-1]-a[i]);
        }ans=a[n-1];while(val<=sum){
              val+=n;
              ans++;
        }
        System.out.println(ans);

    }
    static String[] s() throws IOException {
        return s.readLine().trim().split("\\s+");
    }

    static int i(String ss) {
        return Integer.parseInt(ss);
    }

    static long l(String ss) {
        return Long.parseLong(ss);
    }


    static int MAXN;
    static int[] spf;
    static void sieve() {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
            spf[i] = i;
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;
        for (int i=3; i*i<MAXN; i++)
        {
            if (spf[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)

                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }}

class Student12 {
    int  l;long r;
    public Student12(int l, long r) {
        this.l = l;
        this.r = r;
    }

    public String toString()
    {
        return this.l+" ";
    }
}
class Sortbyroll12 implements Comparator<Student12> {

    public int compare(Student12 a, Student12 b){
        if(a.l<=b.r) return -1;
     /*   else if(a.r==b.r){
            if(a.r==b.r){
                return 0;
            }
            if(a.r<b.r) return -1;
            return 1;}*/
        return 1;  }
}