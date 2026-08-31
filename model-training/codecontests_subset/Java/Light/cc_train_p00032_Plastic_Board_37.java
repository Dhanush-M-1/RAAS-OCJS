

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class Main {

    private Main() {
    }

    public static void main(final String[] argv) throws IOException {
        final BufferedReader inputReader =
                new BufferedReader(new InputStreamReader(System.in));
        int countRectangles = 0;
        int countLozenges = 0;
        while (true) {
            String input = inputReader.readLine();
            if (input == null) {
                break;
            }
            String[] temp = input.split(",");
            int[] l = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                l[i] = Integer.parseInt(temp[i]);
            }
            if (Math.pow(l[0], 2) + Math.pow(l[1], 2) == Math.pow(l[2], 2)) {
                countRectangles++;
            } else if (l[0] == l[1] && l[0] + l[1] > l[2]) {
                countLozenges++;
            }
        }
        System.out.println(countRectangles);
        System.out.println(countLozenges);
    }
}