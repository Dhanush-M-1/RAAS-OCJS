import java.util.*;
import java.io.*;

public class Woodcutters {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coor = new int[n];
		int[] height = new int[n];
		int count = 1;

		for(int i=0; i<n; i++){
			coor[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}

		int lastPos = coor[0];
		for(int i=1; i<n-1; i++){
			if(coor[i]-height[i]>lastPos){
				count++;
				lastPos = coor[i];
			} else if (coor[i]+height[i]<coor[i+1]){
				count++;
				lastPos = coor[i] + height[i];
			} else
				lastPos = coor[i];
		}

		if(n > 1)
			count++;
		System.out.println(count);
	}
}