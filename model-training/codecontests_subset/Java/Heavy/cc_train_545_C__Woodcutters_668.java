import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int caseSize = in.nextInt();
		
		int lastPosition, position, length, nextPosition;
		position = Integer.MIN_VALUE;
		nextPosition = in.nextInt();
		int result = 0;
		
		for (int i = 0; i < caseSize; i++) {
			lastPosition = position;
			position = nextPosition;
			length = in.nextInt();
			
			if (i < caseSize - 1) {
				nextPosition = in.nextInt();
			} else {
				nextPosition = Integer.MAX_VALUE;
			}
			
			if (position - length > lastPosition) {
				result++;
			} else if (position + length < nextPosition) {
				result++;
				position += length;
			} else {
			}
		}
		System.out.println(result);
	}
}
