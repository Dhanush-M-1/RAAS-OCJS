import java.io.*;
public class Prob1060A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();
        int pos = 0;
        if(!num.contains("8"))
            System.out.println(pos);
        else
        {
            int count = 0;
            for(int i = 0; i < n; i++)
            {
                if(num.charAt(i) == '8')
                    count++;
            }
            int k = n / 11;
            if(k < count)
                pos = k;
            else
                pos = count;
            System.out.println(pos);
        }
    }
}
