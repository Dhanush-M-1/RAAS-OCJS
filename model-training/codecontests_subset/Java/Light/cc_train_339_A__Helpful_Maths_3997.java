import java.util.PriorityQueue;
import java.util.Scanner;

public class HelpfulMaths {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
        int i = 0;
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        while (i < exp.length()) {
            minHeap.add(exp.charAt(i));
            i+=2;
        }
        String result = "";
        while (!minHeap.isEmpty()) {
            result += minHeap.poll();
            if (!minHeap.isEmpty()) {
                result += "+";
            }
        }
        System.out.println(result);

	}

}
