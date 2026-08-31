import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long l = scanner.nextLong(),r = scanner.nextLong(),d = scanner.nextLong();
            if(d<l){
                System.out.println(d);
            }else{
                r++;
                if(r%d == 0)
                    System.out.println(r);
                else
                    System.out.println((d-(r%d))+r);
            }
        }
    }
}