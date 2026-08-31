import java.util.Scanner;

public class Main {
    void run() {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;
            int legState[] = new int[2];//現在の脚の状況legState[0]が左脚,[1]が右足、値が0が床、1が踏み台
            int prevSate = 0;//前回両足床(0)でカウントしたのか、両足踏み台(1)でカウントしたのか覚えておく
            int stepCount = 0;
            for (int i = 0; i < n; i++) {
                String moveLeg = sc.next();
                if(moveLeg.equals("lu")){
                    legState[0] = 1;
                }
                else if (moveLeg.equals("ru")) {
                    legState[1] = 1;
                }
                else if (moveLeg.equals("ld")) {
                    legState[0] = 0;
                }
                else if (moveLeg.equals("rd")) {
                    legState[1] = 0;
                }
                
                if(legState[0] == 0 && legState[1] == 0 && prevSate == 1){
                    stepCount++;
                    prevSate = 0;
                }
                else if(legState[0] == 1 && legState[1] == 1 && prevSate == 0){
                    stepCount++;
                    prevSate = 1;
                }
            }
            System.out.println(stepCount);
        }
    }
    public static void main(String[] args) {
        // new AOJ2582().run();
        new Main().run();
    }
}