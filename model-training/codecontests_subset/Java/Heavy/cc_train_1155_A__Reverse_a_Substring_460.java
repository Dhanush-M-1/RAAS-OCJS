import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in = br.readLine();
        char prev = in.charAt(0);
        int previ = 1;
        int start=1,end=1;
        boolean found=false;
        for (int i=1; i<in.length(); i++) {
            char curr = in.charAt(i);
            if (prev>curr) {
                found = true;
                start = previ;
                end = i+1;
                break;
            }
            prev = curr;
            previ++;
        }
        System.out.println(found ? ("YES\n" + start + " " + end) : "NO");
    }
}