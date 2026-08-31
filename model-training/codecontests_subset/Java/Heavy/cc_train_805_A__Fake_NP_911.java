import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static class Node<V extends Comparable<V>> {
        public Node parent;
        private final V data;

        public Node(V data) {
            this.data = data;
            this.parent = null;
        }

    }

    class Max_Min {
        int max;
        int min;

        Max_Min(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(),r = sc.nextInt();
        if(l == r) System.out.println(l);
        else System.out.println(2);

    }
}
