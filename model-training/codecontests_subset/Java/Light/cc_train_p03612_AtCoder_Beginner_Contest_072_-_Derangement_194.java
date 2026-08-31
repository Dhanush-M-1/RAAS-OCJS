import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) throws IOException {
		//File file = new File("input.txt");
		//Scanner in = new Scanner(file);
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] p = new int[N];
		for(int i = 0; i < N; i++) p[i] = in.nextInt();
		
		int index = 0;
		int count = 0;
		while(index < N - 1){
			//System.out.println(index);
			if(p[index] == index + 1){
				count++;
				index += 2;
			}else index++;
		}
		
		if(index == N-1 && p[index] == index + 1) count++;
		
		System.out.println(count);
	}
}
