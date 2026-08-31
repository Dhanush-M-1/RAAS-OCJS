import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

public class Competition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(scan.nextLine());
            StringBuilder[] grid = new StringBuilder[n];
            for (int j = 0; j < n; j++) {
                grid[j] = new StringBuilder(scan.nextLine());
            }
            solver(grid);
        }
        scan.close();
    }
    
    private static void solver(StringBuilder[] grid) {
        char c12 = grid[0].charAt(1), c21 = grid[1].charAt(0);
        char cln1 = grid[grid.length - 1].charAt(grid.length - 2), cn1l = grid[grid.length - 2].charAt(grid.length - 1);
        if (c12 == c21 && cln1 == cn1l && c12 != cln1) {
            System.out.println(0);
        }
        else if (c12 == c21) {
            if (cln1 == cn1l) {
                System.out.println(2);
                System.out.println(grid.length + " " + (grid.length - 1));
                System.out.println((grid.length - 1) + " " + grid.length);
            }
            else {
                System.out.println(1);
                if (cln1 == c12) System.out.println(grid.length + " " + (grid.length - 1));
                else System.out.println((grid.length - 1) + " " + grid.length);
            }
        }
        else {
            if (cln1 == cn1l) {
                System.out.println(1);
                if (c12 == cln1) System.out.println(1 + " " + 2);
                else System.out.println(2 + " " + 1);
            }
            else {
                System.out.println(2);
                grid[0].setCharAt(1, grid[1].charAt(0));
                System.out.println(1 + " " + 2);
                if (cln1 == grid[0].charAt(1)) System.out.println(grid.length + " " + (grid.length - 1));
                else System.out.println((grid.length - 1) + " " + grid.length);
            }
        }
    }
}