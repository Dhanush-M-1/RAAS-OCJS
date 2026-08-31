//package srm303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Woodcuters {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		WoodTree[] trees = new WoodTree[n];
		for (int i = 0; i < n; i++) {
			String parts[] = br.readLine().split(" ");
			trees[i] = new WoodTree(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		}
		
		if (n==1)
		{
			System.out.println(1);
			return;
		}

		int result = 1;
		int tekPos = trees[0].start;
		for (int i = 1; i < n - 1; i++) {
			if (trees[i].start - trees[i].height > tekPos) {
				tekPos = trees[i].start;
				result++;
			} else if (trees[i].start + trees[i].height < trees[i + 1].start) {
				tekPos = trees[i].start + trees[i].height;
				result++;
			}
			else{
				tekPos = trees[i].start;
			}
		}
		result++;

		System.out.println(result);
	}
}

class WoodTree {
	int start;
	int height;

	public WoodTree(int start, int height) {
		this.start = start;
		this.height = height;
	}
}
