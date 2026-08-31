import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        int cnt = 0;
        int result = 0;
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='8') cnt++;
        }
        result = Math.min(cnt,num/11);
        System.out.println(result);
    }
}
