import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class B {

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input"));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int a,f,ii;
        a = f = ii = 0;
        int ans = 0;
        for (Character c : line.toCharArray()){
            if (c == 'A')
                a++;
            else if (c =='F')
                f++;
            else if (c == 'I')
                ii++;
        }
        
        if (ii > 1){
            ans = 0;
        }else if (ii == 1){
            ans = ii;
        }else{
            ans = a;
        }
        System.out.println(ans);
        
    }

}
