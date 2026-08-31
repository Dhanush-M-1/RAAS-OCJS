import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean[][] card = new boolean[4][14];

        String[] markArr = {"S", "H", "C", "D"};
        HashMap<String, Integer> markMap = new HashMap<>();
        for(int i = 0; i < 4; i++) markMap.put(markArr[i], i);

        //input
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            String mark = in.next();
            int num = Integer.parseInt(in.next());

            card[markMap.get(mark)][num] = true;
        }

        //search missing card
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                if(!card[i][j]) out.printf("%s %d\n", markArr[i], j);
            }
        }

        out.flush();
    }
}
