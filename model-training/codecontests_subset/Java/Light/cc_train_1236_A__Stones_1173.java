
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PickStone {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String [] in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b =Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);
            long count =0L;
            if(b<c/2){
                count+=b+2*b;
                b=0;
            }else{
                count+=c/2;
                if(c%2==0){
                    count+=c;
                }else{
                    count+=c-1;
                }
                b-=c/2;
            }
            if(a<b/2){
                count+=a;
                count+=2*a;
            }else{
                count+=b/2;
                if(b%2==0){
                    count+=b;
                }else{
                    count+=b-1;
                }
            }
            System.out.println(count);
        }
    }
}
