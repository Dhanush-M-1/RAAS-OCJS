import java.io.*;
public class Prob1189A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String st = br.readLine();
        int z = 0;
        int o = 0;
        for(int i = 0; i < n; i++)
        {
            if(st.charAt(i) == '0')
                z++;
            else
                o++;
        }
        if(o != z)
            System.out.println(1 + "\n" + st);
        else
            System.out.println(2 + "\n" + st.substring(0, st.length() - 1) + " " + st.charAt(st.length() - 1));
    }
}
