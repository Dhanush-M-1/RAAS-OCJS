import java.util.Scanner;

public class Bulbs {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int but = Integer.parseInt(in.next());
        int bulb = Integer.parseInt(in.next());

        int bulbstatus[] = new int[bulb+1];
        in.nextLine();

        for(int i = 0; i < but; ++i){
            int bn = Integer.parseInt(in.next());

            for(int j = 0; j < bn; ++j){
                int cb = Integer.parseInt(in.next());
                if(bulbstatus[cb] == 0){
                    bulbstatus[cb] = 1;
                }
            }
        }

        for(int i = 1; i < bulbstatus.length; ++i){
            if(bulbstatus[i] == 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
