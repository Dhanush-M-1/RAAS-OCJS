import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args){
        fastSC sc = new fastSC();
        int sum = 0;
        int n = 5;
        while(n--!=0){
            sum+=sc.nextInt();
        }
        System.out.println(sum%5==0 && sum!=0?sum/5:-1);
    }
    static class fastSC{
        BufferedReader br;
        StringTokenizer st;
        private fastSC(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
   }
}