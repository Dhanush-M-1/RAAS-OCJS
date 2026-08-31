import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		long ax = Integer.parseInt(arr[0]);
		long ay = Integer.parseInt(arr[1]);
		long bx = Integer.parseInt(arr[2]);
		long by = Integer.parseInt(arr[3]);
		long cx = Integer.parseInt(arr[4]);
		long cy = Integer.parseInt(arr[5]);
		long distAB = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
		long distBC = (bx - cx) * (bx - cx) + (by - cy) * (by - cy);
		if (distAB != distBC) {
			System.out.println("No");
		} else {
			long dxab = bx - ax;
			long dyab = by - ay;
			long dxbc = cx - bx;
			long dybc = cy - by;
			if (dxab == dxbc && dyab == dybc) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
		br.close();
	}

}
