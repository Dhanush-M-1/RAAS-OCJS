import java.util.Scanner;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.HashSet;
        import java.util.LinkedList;
        import java.awt.List;
        import java.util.ArrayList;
        import java.util.Set;
        import java.text.DecimalFormat;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] teams = new int[n][2];


        int counter = 0;

        for (int i = 0; i < n; i++)
        {
            teams[i][0] = input.nextInt();
            teams[i][1] = input.nextInt();
        }

        for (int i = 0; i < n ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(i != j)
                {
                    if(teams[i][0] == teams[j][1])
                        counter++;
                }
            }
        }
        System.out.println(counter);

    }
}