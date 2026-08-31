import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int opt = 0;
        for(int i=0;i<N;i++) opt+=sc.nextInt()-1;
        System.out.println(opt);
    }
}
