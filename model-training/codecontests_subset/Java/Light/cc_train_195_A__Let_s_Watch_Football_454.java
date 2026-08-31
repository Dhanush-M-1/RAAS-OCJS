import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp =str.split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2]);
        boolean result = true;
        int t =1;
        int t0;
        while(true){
            for(t0 = t; t0 <= c+t;t0++){
                if((a*(t0-t)) > (b*t0)){result = false; break;}
            }
            if(!result){t = t+1;result = true;}
            else{System.out.println(t);break;}
        }
    }
}