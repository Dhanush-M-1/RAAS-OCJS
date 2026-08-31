import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.IOError;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author skt
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        double[] a = new double[3];
        double minvalue = Double.MIN_VALUE;
        for (int i = 0; i < 3; i ++) {
            a[i] = in.nextDouble();
            minvalue = Math.min(minvalue, a[i]);
        }
        double base = Math.log(minvalue);
        int id = 0;
        ArrayList<Node> array1 = new ArrayList<>();
        array1.add(new Node(a[2] * Math.log(a[1]), "x^y^z", id ++));
        array1.add(new Node(a[1] * Math.log(a[2]), "x^z^y", id ++));
        array1.add(new Node(Math.log(a[1] * a[2]), "(x^y)^z", id ++));
        array1.sort((x, y) -> {
            if (x.value == y.value || a[0] == 1.0) {
                return x.id - y.id;
            }
            if (a[0] > 1.0) {
                return x.value < y.value ? 1 : -1;
            } else {
                return x.value < y.value ? -1 : 1;
            }
        });

        ArrayList<Node> array2 = new ArrayList<>();
        array2.add(new Node(a[2] * Math.log(a[0]), "y^x^z", id ++));
        array2.add(new Node(a[0] * Math.log(a[2]), "y^z^x", id ++));
        array2.add(new Node(Math.log(a[0] * a[2]), "(y^x)^z", id ++));
        array2.sort((x, y) -> {
            if (x.value == y.value || a[1] == 1.0) {
                return x.id - y.id;
            }
            if (a[1] > 1.0) {
                return x.value < y.value ? 1 : -1;
            } else {
                return x.value < y.value ? -1 : 1;
            }
        });

        ArrayList<Node> array3 = new ArrayList<>();
        array3.add(new Node(a[1] * Math.log(a[0]), "z^x^y", id ++));
        array3.add(new Node(a[0] * Math.log(a[1]), "z^y^x", id ++));
        array3.add(new Node(Math.log(a[1] * a[0]), "(z^x)^y", id ++));
        array3.sort((x, y) -> {
            if (x.value == y.value || a[2] == 1.0) {
                return x.id - y.id;
            }
            if (a[2] > 1.0) {
                return x.value < y.value ? 1 : -1;
            } else {
                return x.value < y.value ? -1 : 1;
            }
        });
        boolean exist = false;
        double goal = 0.0;
        String ans = "";
        if (a[0] > 1.0) {
            if (!exist) {
                goal = array1.get(0).value + Math.log(Math.log(a[0]));
                ans = array1.get(0).answer;
            } else {
                double temp = array1.get(0).value + Math.log(Math.log(a[0]));
                if (goal < temp) {
                    goal = temp;
                    ans = array1.get(0).answer;
                }
            }
            exist = true;
        }
        if (a[1] > 1.0) {
            if (!exist) {
                goal = array2.get(0).value + Math.log(Math.log(a[1]));
                ans = array2.get(0).answer;
            } else {
                double temp = array2.get(0).value + Math.log(Math.log(a[1]));
                if (goal < temp) {
                    goal = temp;
                    ans = array2.get(0).answer;
                }
            }
            exist = true;
        }
        if (a[2] > 1.0) {
            if (!exist) {
                goal = array3.get(0).value + Math.log(Math.log(a[2]));
                ans = array3.get(0).answer;
            } else {
                double temp = array3.get(0).value + Math.log(Math.log(a[2]));
                if (goal < temp) {
                    goal = temp;
                    ans = array3.get(0).answer;
                }
            }
            exist = true;
        }
        if (exist) {
            out.println(ans);
        } else {
            if (a[0] == 1.0) {
                out.println(array1.get(0).answer); return ;
            }
            if (a[1] == 1.0) {
                out.println(array2.get(0).answer); return ;
            }
            if (a[2] == 1.0) {
                out.println(array3.get(0).answer); return ;
            }
            if (a[0] < 1.0) {
                if (!exist) {
                    goal = array1.get(0).value + Math.log(Math.log(1.0 / a[0]));
                    ans = array1.get(0).answer;
                } else {
                    double temp = array1.get(0).value + Math.log(Math.log(1.0 / a[0]));
                    if (goal > temp) {
                        goal = temp;
                        ans = array1.get(0).answer;
                    }
                }
                exist = true;
            }
            if (a[1] < 1.0) {
                if (!exist) {
                    goal = array2.get(0).value + Math.log(Math.log(1.0 / a[1]));
                    ans = array2.get(0).answer;
                } else {
                    double temp = array2.get(0).value + Math.log(Math.log(1.0 / a[1]));
                    if (goal > temp) {
                        goal = temp;
                        ans = array2.get(0).answer;
                    }
                }
                exist = true;
            }
            if (a[2] < 1.0) {
                if (!exist) {
                    goal = array3.get(0).value + Math.log(Math.log(1.0 / a[2]));
                    ans = array3.get(0).answer;
                } else {
                    double temp = array3.get(0).value + Math.log(Math.log(1.0 / a[2]));
                    if (goal > temp) {
                        goal = temp;
                        ans = array3.get(0).answer;
                    }
                }
                exist = true;
            }
            out.println(ans);
        }
    }

    public static class Node {
        double value;
        String answer;
        int id;

        Node(double value, String answer, int id) {
            this.value = value;
            this.answer = answer;
            this.id = id;
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}

