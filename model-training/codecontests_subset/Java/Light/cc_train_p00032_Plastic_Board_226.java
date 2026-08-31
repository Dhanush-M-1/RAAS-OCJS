import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> inputList = new LinkedList<String>();

        try {
            setList(inputList);

            int rectangle = 0;
            int diamond = 0;

            for (String input : inputList) {

                String[] length = input.split(",");
                int x = Integer.parseInt(length[0]);
                int y = Integer.parseInt(length[1]);
                int diagonal = Integer.parseInt(length[2]);

                // 長方形の判定
                if (x * x + y * y == diagonal * diagonal) {
                    rectangle++;
                }

                // ひし形の判定
                if (x == y && x + y > diagonal) {
                    diamond++;
                }
            }

            System.out.println(rectangle);
            System.out.println(diamond);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setList(List<String> inputDataList) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        try {
            while ((input = in.readLine()) != null) {
                inputDataList.add(input);
            }
        } finally {
            in.close();
        }
    }
}