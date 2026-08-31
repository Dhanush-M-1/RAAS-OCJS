import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main{
 private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 public static void main(String[] args)throws IOException{
     StringTokenizer st;
     st = new StringTokenizer(br.readLine());
     int n=Integer.parseInt(st.nextToken());
     int m=Integer.parseInt(st.nextToken());
     HashSet<Integer> bom = new HashSet<>();
     for(int i=0;i<n;i++){
       String b[] = br.readLine().split(" ");
       for(int j=1;j<b.length;j++){
        bom.add(Integer.parseInt(b[j]));
       }
     }
     boolean ban = (bom.size()==m)?true:false;
     bw.write((ban)?"YES"+"\n":"NO"+"\n");
     bw.flush();
 }
}