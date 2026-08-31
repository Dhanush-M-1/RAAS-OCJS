import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Ques1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()), i, z=0, o=0;
        String s = br.readLine();
        for(i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                z++;
            }
            else{
                o++;
            }
        }
        if(z!=o){
            System.out.println(1);
            System.out.println(s);
        }
        else{
            System.out.println(2);
            System.out.println(s.charAt(0)+" "+s.substring(1));
        }
    }
}
