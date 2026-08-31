import java.util.Scanner;

class Main {
    private static void solve() {
        Scanner scanner = new Scanner(System.in).useDelimiter("[,\\s]+");
        int nRectangles = 0;
        int nLozenges = 0;

        while (scanner.hasNextInt()) {
            int side1 = scanner.nextInt();
            int side2 = scanner.nextInt();
            int diagonal = scanner.nextInt();
            if (side1 * side1 + side2 * side2 == diagonal * diagonal) {
                nRectangles++;
            }
            if (side1 == side2) {
                nLozenges++;
            }
        }
        System.out.println(nRectangles);
        System.out.println(nLozenges);
    }

    public static void main(String... args) {
        solve();
    }
}