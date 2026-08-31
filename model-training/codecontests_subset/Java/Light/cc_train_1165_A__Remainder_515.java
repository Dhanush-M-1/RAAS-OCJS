import java.util.Scanner;

public class contest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] input = new int[n];
		int[] output= new int[x];
		output[x-y-1] = 1;
		String s = sc.next();
		for(int i=0;i<n;i++)
			input[i] = Integer.parseInt(Character.toString(s.charAt(i)));
		int c = 0;
//		for(int i=0;i<n;i++)
//			System.out.print(input[i] + " ");
//		System.out.println();
//		for(int i=0;i<output.length;i++)
//			System.out.print(output[i] + " ");
		for(int i=0;i<x;i++)
			if(input[n-x+i]!=output[i])
				c++;
		System.out.println(c);
		
	}
}
