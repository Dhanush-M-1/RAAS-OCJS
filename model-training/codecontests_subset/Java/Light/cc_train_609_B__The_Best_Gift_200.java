import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPC {
public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n =Integer.parseInt(st.nextToken());
	int m =Integer.parseInt(st.nextToken());
int[] output =new int[m];
st= new StringTokenizer(bf.readLine());
while(st.hasMoreTokens()) {
	int num =Integer.parseInt(st.nextToken());
	output[num-1]+=1;
}
int r=0;
for(int i=0;i<output.length;i++) {
	for(int j=i+1;j<output.length;j++) {
		r+=output[i]*output[j];
	}
}
System.out.println(r);
}
}
