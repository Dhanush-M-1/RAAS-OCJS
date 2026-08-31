import java.io.*;

public class test{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            if(n%2==0) {
                int tot=0;
                for(char c : s.toCharArray()) {
                    if(c=='1') tot+=1;
                    else tot-=1;
                }
                if(tot==0) {
                    System.out.println(2);
                    System.out.println(s.substring(0,s.length()-1) + " " + s.substring(s.length()-1));
                }else {
                    System.out.println(1);
                    System.out.println(s);     
                }
            }else {
                System.out.println(1);
                System.out.println(s);
            }
            return;
        } catch (Exception e) {
            return;
        }
    }
}