import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elections {
	int n, maxVotes = 0;
	int elodreipVotes = 0;
	public static void main(String[] args) throws IOException {
		Elections e = new Elections();
		e.input();
		System.out.println(Math.max(e.maxVotes, (e.elodreipVotes * 2 + 1)/e.n + ((e.elodreipVotes * 2 + 1)% e.n == 0 ? 0 : 1)));
	}
	public void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input);
		input = br.readLine();
		for (String vote : input.split(" ")){
			int v = Integer.parseInt(vote);
			maxVotes = Math.max(maxVotes, v);
			elodreipVotes += v;
		}
	}
}
