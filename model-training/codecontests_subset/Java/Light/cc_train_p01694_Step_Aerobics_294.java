import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int number=0;
            int upstatus=0;
            boolean nowFloor = true;
            List<String> action = new ArrayList<String>();
            int up=sc.nextInt();
            if(up==0)break;
            for (int i = 0; i <up; i++) {
                action.add(sc.next());
            }//???????????£??¨??°?????????????????\?????????????°????
            for (String upString : action) {
                if (upString.equals("lu") || upString.equals("ru")) {
                    upstatus++;
                } else {
                    upstatus--;
                }
                if (nowFloor && upstatus == 2) {
                    nowFloor = false;number++;
                }
                if (!nowFloor && upstatus == 0) {
                    nowFloor = true;number++;
                }
            }System.out.println(number);
        }
    }
}