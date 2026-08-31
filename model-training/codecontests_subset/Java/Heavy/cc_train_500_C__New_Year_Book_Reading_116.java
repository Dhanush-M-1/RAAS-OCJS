import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Book[] books = new Book[n];
		for(int i=0;i<n;i++) {
			books[i] = new Book(i,sc.nextInt());
		}
		int[] b = new int[m];
		for(int i=0;i<m;i++) {
			b[i] = sc.nextInt() - 1;
			books[b[i]].firstRead = Math.min(books[b[i]].firstRead,i);
		}
		int[] pos = new int[n];
		Arrays.sort(books, (ba,bb)->Integer.compare(ba.firstRead, bb.firstRead));
		for(int i=0;i<n;i++) {
			pos[books[i].id] = i;
		}
		int ans = 0;
		for(int i=0;i<m;i++) {
			int moveBookPos = pos[b[i]];
			Book moveBook = books[moveBookPos];
			for(int j=moveBookPos;j>=1;j--) {
				books[j] = books[j-1];
				pos[books[j].id]++;
				ans += books[j].weight;
			}
			books[0] = moveBook;
			pos[b[i]] = 0;
		}
		System.out.println(ans);
	}

	static class Book {
		int id,weight,firstRead;
		public Book(int id,int weight) {
			this.id = id;
			this.weight = weight;
			firstRead = 1 << 29;
		}
	}

}
