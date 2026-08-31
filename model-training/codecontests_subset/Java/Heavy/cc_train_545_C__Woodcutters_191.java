import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Tree> trees = new ArrayList<>();
        for(int i=0; i<n;i++) {
            trees.add(new Tree(scanner.nextInt(), scanner.nextInt()));
        }

        int count = trees.size() > 1 ? 2 : 1;
        for(int i=1, max=trees.get(0).startPoint;i<n-1;i++) {
            Tree curr = trees.get(i);
            Tree next = trees.get(i+1);
            if(curr.leftEnd() > max) {
                count++;
                max = curr.startPoint;
            } else if(curr.rightEnd() < next.startPoint) {
                count++;
                max = curr.rightEnd();
            } else {
                max = curr.startPoint;
            }
        }

        System.out.println(count);
    }

    private static class Tree{
        public int startPoint;
        public int height;

        public Tree(int startPoint, int height) {
            this.startPoint = startPoint;
            this.height = height;
        }

        public int leftEnd() {
            return startPoint - height;
        }

        public int rightEnd() {
            return startPoint + height;
        }
    }
}