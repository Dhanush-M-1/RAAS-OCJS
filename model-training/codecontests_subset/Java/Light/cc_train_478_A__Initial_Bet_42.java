import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt()+scanner.nextInt()+scanner.nextInt()+scanner.nextInt()+scanner.nextInt();
        System.out.println(s>0&&s%5==0?s/5:-1);
    }
}