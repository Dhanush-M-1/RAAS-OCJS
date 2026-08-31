
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Ada {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int cnt = 0;
            for (int i=0;i<x;i++){
                if (y==i && s.charAt(s.length()-i-1)=='0'){
                    cnt++;
                }else if (y!=i && s.charAt(s.length()-i-1)=='1'){
                    cnt++;
                }
            }
        System.out.println(cnt);
        }

}