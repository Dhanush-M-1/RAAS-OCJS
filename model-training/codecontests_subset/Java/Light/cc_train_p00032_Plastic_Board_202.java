
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(System.in);
            int countRectangle = 0;
            int countRhombus = 0;

            while (sc.hasNextLine()) {
                String[] input = sc.nextLine().split(",");
                int[] sides = convertToInt(input);

                if (isRectangle(sides)) {
                    countRectangle++;
                } else if (isRhombus(sides)) {
                    countRhombus++;
                }
            }

            System.out.println(countRectangle);
            System.out.println(countRhombus);

        } finally {
            sc.close();
        }
    }

    public static boolean isRectangle(int[] side) {
        return square(side[0]) + square(side[1]) == square(side[2]);
    }

    public static boolean isRhombus(int[] side) {
        return side[0] == side[1];
    }

    public static int square(int n) {

        return n * n;
    }

    public static int[] convertToInt(String[] strings) {
        int[] ints = new int[3];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

}