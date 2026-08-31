import java.util.Scanner;

/**
 * Created by Amir on 06.05.2018.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int max = 0;
        String best = "";

        for (int i = 0; i < s.length()-1; i++) {
            String temp = s.charAt(i) + ""+s.charAt(i+1);
            int c = 0;
            for (int j = 0; j < s.length()-1; j++) {
                if((s.charAt(j)+""+s.charAt(j+1)).equals(temp))c++;
            }
            if(c>max){
                max = c;
                best = temp;
            }
        }
        System.out.println(best);
    }
}
