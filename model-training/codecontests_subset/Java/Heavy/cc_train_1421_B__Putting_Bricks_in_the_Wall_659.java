import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.util.StringTokenizer;

public class PuttingBricksInTheWall implements AutoCloseable {
    public static void main(String[] args) {
        try(
                PuttingBricksInTheWall puttingBricksInTheWall = new PuttingBricksInTheWall();//Initialize class element
        ) {
            puttingBricksInTheWall.solve();
        }
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    PrintWriter output = new PrintWriter(System.out);;
    StringTokenizer tokens;

    int[][] grid;
    int n;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public void solve() {
        int t = nextInt();

        for (int l = 0; l < t; l++) {
            int n = nextInt();
            grid = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = nextString();
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        grid[i][j] = -1;
                    } else if (i == n-1 && j == n-1) {
                        grid[i][j] = -1;
                    } else {
                        grid[i][j] = line.charAt(j) - '0';
                    }
                }
            }
            if (grid[0][1] == 1 && grid[1][0] == 1) {
                if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 1) {
                    printLine(2);
                    printLine((n - 1) + " " + (n));
                    printLine((n) + " " + (n - 1));
                } else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 1) {
                    printLine(1);
                    printLine((n) + " " + (n - 1));
                } else if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 0) {
                    printLine(1);
                    printLine((n - 1) + " " + (n));
                } else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 0) {
                    printLine(0);
                }
            } else if (grid[0][1] == 1 && grid[1][0] == 0)  {
                if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 1) {
                    printLine(1);
                    printLine(1 + " " + 2);
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 1) {
                    printLine(2);
                    printLine(1 + " " + 2);
                    printLine((n - 1) + " " + (n));
                }
                else if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 0) {
                    printLine(2);
                    printLine(1 + " " + 2);
                    printLine((n) + " " + (n - 1));
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 0) {
                    printLine(1);
                    printLine(2 + " " + 1);
                }
            }  else if (grid[0][1] == 0 && grid[1][0] == 1)  {
                if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 1) {
                    printLine(1);
                    printLine(2 + " " + 1);
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 1) {
                    printLine(2);

                    printLine(2 + " " + 1);
                    printLine((n - 1) + " " + (n));
                }
                else if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 0) {
                    printLine(2);

                    printLine(2 + " " + 1);
                    printLine((n) + " " + (n - 1));
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 0) {
                    printLine(1);
                    printLine(1 + " " + 2);
                }
            }  else if (grid[0][1] == 0 && grid[1][0] == 0)  {
                if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 1) {
                    printLine(0);
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 1) {
                    printLine(1);
                    printLine((n - 1) + " " +  (n));
                }
                else if (grid[n - 2][n - 1] == 1 && grid[n - 1][n - 2] == 0) {
                    printLine(1);
                    printLine((n) + " " +  (n - 1));
                }
                else if (grid[n - 2][n - 1] == 0 && grid[n - 1][n - 2] == 0) {
                    printLine(2);
                    printLine((1) + " " +  (2));
                    printLine((2) + " " +  (1));
                }
            }
        }
    }

    public void print(Object n) {
        output.print(n);
    }

    public void printLine(Object n) {
        output.println(n);
    }

    public void close() {
        output.close();
    }

    private long nextLong() {
        String token = nextString();
        return Long.parseLong(token);
    }

    private int nextInt() {
        String token = nextString();
        return Integer.parseInt(token);
    }


    private String nextString() {
        while (tokens == null || !tokens.hasMoreTokens()){
            getLineTokenizer();
        }

        return tokens.hasMoreTokens() ? tokens.nextToken(): null;

    }
    private boolean getLineTokenizer() {
        try {
            String line = reader.readLine();

            tokens = new StringTokenizer(line);
            return tokens.hasMoreTokens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

