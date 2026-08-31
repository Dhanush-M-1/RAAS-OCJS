import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Barrel {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringTokenizer s=new StringTokenizer(str);
        int days=Integer.parseInt(s.nextToken());
        int rasp=Integer.parseInt(s.nextToken());
        str=br.readLine();
        s=new StringTokenizer(str);
        int[] price=new int[days];
        for(int i=0; i<days;i++){
            price[i]=Integer.parseInt(s.nextToken());
        }
        System.out.println(printResult(price, rasp));
    }
    private static int printResult(int[] p, int rasp){
        if(p.length<=1){
            return 0;
        }
        int max=0;
        for(int i=0;i<p.length-1;i++){
            if(p[i]-p[i+1]>max){
                max=p[i]-p[i+1];
            }
        }
        if(max-rasp>0){
            return max-rasp;
        }
        return 0;
    }

}
