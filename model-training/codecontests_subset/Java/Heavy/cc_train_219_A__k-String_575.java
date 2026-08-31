
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Codeforces {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
    public static void main(String asd[])throws Exception{        
        int n = readInt();        
        String str = reader.readLine();
        int[] list= new int[26];       
        //masukin data
        for (int i = 0; i < str.length(); i++) {
            list[str.charAt(i) - 97]++;            
        }
        boolean ok = true;
        //checker
        for (int i = 0; i < 26; i++) {
            if(list[i] != 0 && list[i] %n != 0){
                ok = false;
            }
        }
        
        
        if(ok){
            //print ulang
            String out = "";
            for (int k = 0; k < n; k++){                            
                for (int i = 0; i < 26; i++) {
                    if(list[i] != 0 && list[i] %n == 0){                    
                        for (int j = 0; j < list[i]/n; j++) {
                            out += ((char)(i + 97));                    
                        }                    
                    }
                }
            }
            
            
            System.out.println(out);
                        
        }else{
            System.out.println(-1);
        }
        
    }    
    public static int readInt()throws Exception{
        return Integer.parseInt(reader.readLine());
    }
    public static void token()throws Exception{
        token = new StringTokenizer(reader.readLine());
    }
    public static int nextInt()throws Exception{
        return Integer.parseInt(token.nextToken());
    }
    
}

