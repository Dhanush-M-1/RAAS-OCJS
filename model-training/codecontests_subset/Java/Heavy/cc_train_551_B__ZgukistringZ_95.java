
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner();
        StringBuffer buffer = new StringBuffer();
        int par[] = new int[26];
        int arr[] = new int[26];
        int brr[] = new int[26];
        int ansa=0;int ansb=0;
        while (scn.hasNext()) {
            String p = scn.next();
            String a = scn.next();
            String b = scn.next();
            for (int i = 0; i < p.length(); i++) {
                par[p.charAt(i) - 'a']++;
            }
            for (int i = 0; i < a.length(); i++) {
                arr[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < b.length(); i++) {
                brr[b.charAt(i) - 'a']++;
            }
            int range = 9999999;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    int temp = par[i]/ arr[i];
                    if(temp<range)range=temp;
                }
            }
            for(int i=0;i<=range;i++)
            {
                int cpy[]=new int[26];
                for(int j=0;j<26;j++){
                 cpy[j]=par[j]-arr[j]*i;
                }
                int tempb=999;
                for(int j=0;j<26;j++){
                  if(brr[j]>0)
                 if(  cpy[j]/brr[j]<tempb){tempb=  cpy[j]/brr[j];}
                }
                if(ansa+ansb<i+tempb){ansa=i;ansb=tempb;}
            }
            //System.out.println(ansa+""+ansb);
            for(int i=0;i<ansa;i++)System.out.print(a);
              for(int i=0;i<ansb;i++)System.out.print(b);
            for(int j=0;j<26;j++){
                 par[j]=par[j]-arr[j]*ansa;
                 par[j]=par[j]-brr[j]*ansb;
             }
           for(int i=0;i<26;i++){
               for(int j=0;j<par[i];j++)
               {System.out.print((char)(i+'a'));
               }
           }
        }
    }

}

class Scanner implements Iterator<String> {

    BufferedReader buffer;
    StringTokenizer tok;

    public Scanner() {
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buffer.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public String next() {
        if (hasNext()) {
            return tok.nextToken();
        }
        return null;
    }

    public void remove() {
        return;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
