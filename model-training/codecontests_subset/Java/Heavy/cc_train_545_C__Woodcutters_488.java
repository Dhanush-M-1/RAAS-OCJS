import java.io.*;

public class Solution545C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];

		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");

			arr[i][0] = Integer.parseInt(input[0]); //x
			arr[i][1] = Integer.parseInt(input[1]); //h
		}

		//나무 넘어뜨리는게 가능한 영역
		int start = arr[0][0] + 1;
		int end = arr[n-1][0] - 1;

		int count = n == 1 ? 1 : 2; //가장 바깥쪽 나무 2개는 무조건 바깥방향으로 넘길 수 있다.

		//1 ~ n-2 인덱스 나무 체크
		for(int i = 1; i <= n-2; i++) {
			int currX = arr[i][0];
			int currH = arr[i][1];

			//바깥쪽 나무를 바깥방향으로 잘라 넘길 수 있는지
			if(start <= currX - currH) {
				start = currX + 1;
				count++;
			}
			//바깥쪽 나무를 안쪽방향으로 잘라 넘길 수 있는지
			else if(currX + currH < arr[i+1][0]) {
				start = currX + currH + 1;
				count++;
			}
			else {
				start = currX + 1;
			}
		}

		System.out.println(count);
	}

}

