import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = Integer.parseInt(scan.nextLine());
	int[] elements = new int[n];
	String[] input = scan.nextLine().split(" ");
	for (int i = 0; i < n; i++) {
	    elements[i] = Integer.parseInt(input[i]);
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
	    int min = i;
	    for (int j = i; j < n; j++) {
		if (elements[j] < elements[min]) {
		    min = j;
		}
	    }
	    if (i != min) {
		cnt++;
		int tmp = elements[i];
		elements[i] = elements[min];
		elements[min] = tmp;
	    }
	}
	for (int i = 0; i < n-1; i++) {
	    System.out.print(elements[i] + " ");
	}
	System.out.println(elements[n-1]);
	System.out.println(cnt);
    }
}