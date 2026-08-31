import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    enum Player {
Alexey, Boris, Vasiliy;
    }
    static Player waitPlayer = Player.Vasiliy;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Player> winnerofgames = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            switch (in.nextInt()){
                case 1:{
                    winnerofgames.add(Player.Alexey);break;
                }
                case 2:{
                    winnerofgames.add(Player.Boris);
                    break;
                }
                default:
                    winnerofgames.add(Player.Vasiliy);
            }
        }
        for (Player item: winnerofgames){
            if (item == waitPlayer){
                System.out.println("NO");
                return;
            }
            else {
                if (item == Player.Alexey){
                    waitPlayer = (waitPlayer == Player.Vasiliy)?Player.Boris:Player.Vasiliy;
                }
                else if (item == Player.Boris){
                    waitPlayer = (waitPlayer == Player.Vasiliy)?Player.Alexey:Player.Vasiliy;
                }
                else {
                    waitPlayer = (waitPlayer == Player.Alexey)?Player.Boris:Player.Alexey;
                }
            }
        }
        System.out.println("YES");
    }
}