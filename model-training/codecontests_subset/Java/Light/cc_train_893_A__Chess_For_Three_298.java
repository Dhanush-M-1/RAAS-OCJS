import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        chess_for_three();
        //free_cash();
    }

    public static void chess_for_three() {
        Scanner in = new Scanner(System.in);

        byte number_of_games = in.nextByte();
        byte current_log;
        byte current_third = 3;

        for (byte i = 0; i < number_of_games; i++) {
            current_log = in.nextByte();
            if (current_log == current_third) {
                System.out.println("NO");
                return;
            }
            current_third = (byte) (6 - current_third - current_log);
        }
        System.out.println("YES");
    }

    public static void free_cash() {
        Scanner in = new Scanner(System.in);

        int number_of_visitors = in.nextByte();
        in.nextLine();

        int number_of_cash = 1;
        int current_max_cash = 1;
        String last_time = "";
        String time;

        for (int i = 0; i < number_of_visitors; i++) {
            time = in.nextLine();
            if (time.equals(last_time)) number_of_cash += 1;
            else number_of_cash = 1;
            last_time = time;
            if (number_of_cash > current_max_cash) current_max_cash = number_of_cash;
        }

        System.out.println(current_max_cash);
    }
}
