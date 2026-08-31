import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            int row_from = in.nextInt();
            int col_from = in.nextInt();
            int row_to = in.nextInt();
            int col_to = in.nextInt();
            Set<Cell> visited = new HashSet<>();
            Set<Cell> allowed = new HashSet<>();
            int N = in.nextInt();
            while (N-- > 0)
            {
                int row = in.nextInt();
                int colStart = in.nextInt();
                int colEnd = in.nextInt();
                for (int i = colStart; i <= colEnd; i++)
                {
                    allowed.add(new Cell(row, i));
                }
            }
            int moves = visit(row_from, col_from, row_to, col_to, visited, allowed);
            out.println(moves);
        }

        private int visit(int row_from, int col_from, int row_to, int col_to, Set<Cell> visited, Set<Cell> allowed)
        {
            Deque<Location> q = new ArrayDeque<>();
            q.add(new Location(row_from, col_from, 0));
            while (!q.isEmpty())
            {
                Location currentLocation = q.pollFirst();
                if (!allowed.contains(new Cell(currentLocation.row, currentLocation.col))) continue;
                if (visited.contains(new Cell(currentLocation.row, currentLocation.col))) continue;
                if (currentLocation.row == row_to && currentLocation.col == col_to) return currentLocation.depth;
                visited.add(new Cell(currentLocation.row, currentLocation.col));
                // moves
                int[][] offsets = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
                for (int offset[] : offsets)
                {
                    int row_offset = offset[0];
                    int col_offset = offset[1];
                    q.add(new Location(currentLocation.row + row_offset, currentLocation.col + col_offset, currentLocation.depth + 1));
                }
            }
            return -1;
        }

    }

    static class Location
    {
        int row;
        int col;
        int depth;

        Location(int row, int column, int depth)
        {
            this.row = row;
            this.col = column;
            this.depth = depth;
        }

    }

    static class Cell
    {
        int row;
        int col;

        Cell(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row && col == cell.col;
        }

        public int hashCode()
        {
            return Objects.hash(row, col);
        }

    }
}

