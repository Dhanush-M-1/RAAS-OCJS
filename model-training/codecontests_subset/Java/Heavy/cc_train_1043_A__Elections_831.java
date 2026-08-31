import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class TaskA {
	public static void main(final String[] args) throws Throwable {
		final InputStream inputStream = System.in;
		final OutputStream outputStream = System.out;
		final PrintWriter out = new PrintWriter(outputStream);
		final Scanner in = new Scanner(inputStream);
		final int N = in.nextInt();
		final int [] oppositeVoices  = new int[N];
		for(int i=0;i<N;i++){
			oppositeVoices[i] = in.nextInt();
		}
		out.println(solution(oppositeVoices));
		out.flush();
		out.close();
		in.close();
	}
	
	private static long solution(final int [] oppositeVoices){
		long sum  = 0;
		int max = oppositeVoices[0];
		for(int i=0;i<oppositeVoices.length;i++){
			sum+=oppositeVoices[i];
			if(max<oppositeVoices[i]){
				max = oppositeVoices[i];
			}
		}
		final long allSum =2*sum+1;
		long K = allSum/(oppositeVoices.length);
		if(K*oppositeVoices.length  < allSum) {
			K++;
		}
		if(K<max){
			K=max;
		}
		return K;
	}
}
