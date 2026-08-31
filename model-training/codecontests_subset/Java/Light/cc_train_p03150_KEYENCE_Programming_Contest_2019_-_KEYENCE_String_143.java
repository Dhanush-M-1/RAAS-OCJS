import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] data = str.split("");

        String[] keyence = { "k", "e", "y", "e", "n", "c", "e" };

        int x = 0;
        int y = 0;
        int z = 0;
        int i = 0;
        while (i < keyence.length) {
            if (data[x].equals(keyence[i])) {
                i++;
                x++;
            } else {
                if (y == 0) {
                    x = x + (data.length - keyence.length);
                    y = 1;
                } else {
                    z = 1;
                    break;
                }
            }
        }

        if (z == 1)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}