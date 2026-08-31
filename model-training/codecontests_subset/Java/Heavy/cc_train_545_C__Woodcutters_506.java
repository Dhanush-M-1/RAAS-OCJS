import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class C545 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(new StringTokenizer(br.readLine()).nextToken());
		int[] point = new int[n+1];
		int[] height = new int[n+1];
		int count = 2,now = 0;
		if(n==1){
			count--;
			System.out.println(count);return;
		}
		for(int i=1;i<n+1;i++){
			String a = br.readLine();
			String[] v = a.split(" ");
			point[i] = Integer.parseInt(v[0]);
			height[i] = Integer.parseInt(v[1]);
		}
		now = point[1];
		for(int i=2;i<n;i++){
			if(point[i]-height[i]>now){
				count++;now = point[i];
			}else if(point[i]+height[i]<point[i+1]){
				count++;now = point[i]+height[i];
			}else
				now = point[i];
		}
		System.out.println(count);
	}
}