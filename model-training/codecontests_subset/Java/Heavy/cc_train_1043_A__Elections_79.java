import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = System.in;
//        InputStream inputStream = new FileInputStream(new File("/Users/mmyrzaku/development/learn/learn-java/src/resources/my_input"));
        InputReader in = new InputReader(inputStream);
        int numFriends = in.nextInt();
        int[] data = new int[numFriends];
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < numFriends; i++) {
            data[i] = in.nextInt();
            min = Math.max(data[i], min);
            sum += data[i];
        }

        for (int i = min; i < 1000; i++) {
            if (score(i, data) > sum) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int score(int num, int[] aData) {
        int sum = 0;
        for (int i = 0; i < aData.length; i++) {
            sum += (num - aData[i]);
        }
        return sum;
    }

    public List<TreeNode> allPossibleFBT(int count) {
        List<TreeNode> trees = new ArrayList<>();
        if (count % 2 == 0) {
            return trees;
        }

        TreeNode root = new TreeNode(0);
        if (count == 1) {
            trees.add(root);
            return trees;
        }
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        count -= 3;
        if (count == 0) {
            return trees;
        }

        buildTree(root.left, count);
        trees.add(root);
        buildTree(root.right, count);
        trees.add(root);
        return trees;
    }

    private void buildTree(TreeNode aRoot, int aCount) {
        if (aCount <= 0) {
            return;
        }

        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        aRoot.left = left;
        aRoot.right = right;
        buildTree(left, aCount - 2);
        buildTree(right,  aCount - 2);
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String nextString() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextString());
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
