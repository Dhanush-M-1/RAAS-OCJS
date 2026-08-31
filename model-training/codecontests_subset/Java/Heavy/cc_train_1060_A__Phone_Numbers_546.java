import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ApplicationContext con = new
		// ClassPathXmlApplicationContext("bean.xml");
		FastReader in = new FastReader();
		StringBuilder out = new StringBuilder();
		int n = in.nextInt();
		String str = in.next();
		if (!str.contains("8") || str.length() < 11) {
			System.out.println(0);
			return;
		}
		ArrayList<Character> arr = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.charAt(i));
		}
		Collections.sort(arr);
		int s = arr.indexOf('8');
		int e = arr.lastIndexOf('8');
		int m = e - s + 1;
		System.out.println(Math.min(n / 11, m));

	}

}

class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

class BinaryTree {

	static Node head;
	Node root;

	/*
	 * Given a binary search tree and a number, inserts a new node with the
	 * given number in the correct place in the tree. Returns the new root
	 * pointer which the caller should then use (the standard trick to avoid
	 * using reference parameters).
	 */
	Node insert(Node node, int data) {

		/*
		 * 1. If the tree is empty, return a new, single node
		 */
		if (node == null) {
			return (new Node(data));
		} else {

			/* 2. Otherwise, recur down the tree */
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}

			/* return the (unchanged) node pointer */
			return node;
		}
	}

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	int minValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.data);
	}

	public int maxValue(Node node) {
		Node cur = node.right;
		while (cur.right != null) {
			cur = cur.right;
		}
		return cur.data;
	}

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBSTUtil(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}
}

class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
