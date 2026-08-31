import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String[] cards = new String[52];
        char[] suto = { 'S', 'H', 'C', 'D' };
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[i * 13 + j - 1] = "" + suto[i] + " " + j + "%n";
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String card = sc.nextLine();
            for (int j = 0; j < 52; j++) {
                // System.out.println("card=" + card + " cards[" + j + "]=" + cards[j]);
                if (cards[j].equals(card + "%n")) {
                    cards[j] = "";
                    break;
                }
            }
        }

        for (int i = 0; i < 52; i++) {
            System.out.printf(cards[i]);
        }

    }

}
