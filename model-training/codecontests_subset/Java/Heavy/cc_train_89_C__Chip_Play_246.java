import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AlexFetisov
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC_ solver = new TaskC_();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC_ {
    char[][] f;
    Piece[][] field;
    int n, m;
    private int bestScore;
    private int canAchieve;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        f = new char[n][m];

        for (int i = 0; i < n; ++i) {
            f[i] = in.nextString().toCharArray();
        }
        field = new Piece[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (f[i][j] != '.') {
                    field[i][j] = new Piece();
                    field[i][j].x = i;
                    field[i][j].y = j;
                }
            }
        }

        bestScore = 0;
        canAchieve = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (f[i][j] != '.') {
                    buildLinks();
                    emulate(field[i][j], 1);
                }
            }
        }
        out.println(bestScore + " " + canAchieve);
    }

    private void emulate(Piece current, int deleted) {
        if (f[current.x][current.y] == 'L') {
            if (current.left == null) {
                finish(deleted);
            } else {
                Piece next = current.left;
                remove(current);
                emulate(next, deleted + 1);
            }
        } else if (f[current.x][current.y] == 'R') {
            if (current.right == null) {
                finish(deleted);
            } else {
                Piece next = current.right;
                remove(current);
                emulate(next, deleted + 1);
            }
        } else if (f[current.x][current.y] == 'U') {
            if (current.up == null) {
                finish(deleted);
            } else {
                Piece next = current.up;
                remove(current);
                emulate(next, deleted + 1);
            }
        } else if (f[current.x][current.y] == 'D') {
            if (current.down == null) {
                finish(deleted);
            } else {
                Piece next = current.down;
                remove(current);
                emulate(next, deleted + 1);
            }
        }
    }

    private void finish(int deleted) {
        if (deleted > bestScore) {
            bestScore = deleted;
            canAchieve = 1;
        } else if (deleted == bestScore) {
            ++canAchieve;
        }
    }

    private void remove(Piece current) {
        if (current.left != null) {
            current.left.right = current.right;
        }
        if (current.right != null) {
            current.right.left = current.left;
        }
        if (current.up != null) {
            current.up.down = current.down;
        }
        if (current.down != null) {
            current.down.up = current.up;
        }
    }

    void buildLinks() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (f[i][j] != '.') {
                    field[i][j].clear();
                }
            }
        }

        for (int row = 0; row < n; ++row) {
            int prevCol = -1;
            for (int col = 0; col < m; ++col) {
                if (field[row][col] != null) {
                    if (prevCol != -1) {
                        field[row][col].left = field[row][prevCol];
                        field[row][prevCol].right = field[row][col];
                    }
                    prevCol = col;
                }
            }
        }

        for (int col = 0; col < m; ++col) {
            int prevRow = -1;
            for (int row = 0; row < n; ++row) {
                if (field[row][col] != null) {
                    if (prevRow != -1) {
                        field[row][col].up = field[prevRow][col];
                        field[prevRow][col].down = field[row][col];
                    }
                    prevRow = row;
                }
            }
        }
    }

    class Piece {
        Piece left, right, up, down;
        int x, y;

        public Piece() {
        }

        public void clear() {
            left = right = up = down = null;
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer stt;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public String nextString() {
        while (stt == null || !stt.hasMoreTokens()) {
            stt = new StringTokenizer(nextLine());
        }
        return stt.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

}

