import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Gs {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(bf.readLine());
        StringTokenizer tk;
        int []a=new int[n],b=new int[n];
        for (int i = 0; i < n; i++) {
            tk=new StringTokenizer(bf.readLine());
            a[i]=Integer.parseInt(tk.nextToken());
            b[i]=Integer.parseInt(tk.nextToken());  
        }
        int c=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j!=i && a[i]==b[j])c++;
            }
        }
       
        out.write(c+"\n");
        out.flush();
    }
}