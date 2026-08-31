import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {
    public static void main(String[] args) throws IOException {
        int cntA = 0, cntF = 0, cntI = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        for(int i = 0; i < n; i++)
            if(c[i] == 'A')
                cntA++;
            else if(c[i] == 'F')
                cntF++;
            else
                cntI++;
        
        if(cntI == 0)
            System.out.println(cntA);
        else{
            if(cntI == 1)
                System.out.println(cntI);
            else
                System.out.println(0);
        }
    }
}
