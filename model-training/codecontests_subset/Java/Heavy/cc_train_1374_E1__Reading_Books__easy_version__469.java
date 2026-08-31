import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		Books[] books = new Books[n];
		for (int i = 0; i < n; i++) {
			books[i] = new Books(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(books);
		int a = 0, b = 0, ans = 0;
		Deque<Books> booksa = new ArrayDeque<Books>(), 
				booksb = new ArrayDeque<Books>();
		for (Books book : books) {
			if (book.a && book.b) {
				if (a < k || b < k) {
					ans += book.time;
					a++;
					b++;
					if (a > k) {
						ans -= booksa.peek().time;
						booksa.pop();
						a--;
					}
					if (b > k) {
						ans -= booksb.peek().time;
						booksb.pop();
						b--;
					}
				} else {
					if (!booksa.isEmpty() && !booksb.isEmpty()) {
						int bonus = booksa.peek().time+booksb.peek().time;
						if (bonus > book.time) {
							ans -= bonus;
							booksa.pop();
							booksb.pop();
							ans += book.time;
						}
					} else if (!booksa.isEmpty()) {
						int bonus = booksa.peek().time;
						if (bonus > book.time) {
							b++;
							ans -= bonus;
							booksa.pop();
							ans += book.time;
						}
					} else if (!booksb.isEmpty()) {
						int bonus = booksb.peek().time;
						if (bonus > book.time) {
							a++;
							ans -= bonus;
							booksb.pop();
							ans += book.time;
						}
					}
				}
			} else if (book.a) {
				if (a < k) {
					booksa.push(book);
					ans += book.time;
					a++;
				}
			} else if (book.b) {
				if (b < k) {
					booksb.push(book);
					ans += book.time;
					b++;
				}
			}
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println();
		}
		if (a < k || b < k)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	
	static class Books implements Comparable<Books> {
		int time;
		boolean a, b;
		public Books(int time, int a, int b) {
			this.time = time;
			this.a = a==1;
			this.b = b==1;
		}
		
		@Override
		public int compareTo(Books o) {
			return Integer.compare(time, o.time);
		}
	}
}
