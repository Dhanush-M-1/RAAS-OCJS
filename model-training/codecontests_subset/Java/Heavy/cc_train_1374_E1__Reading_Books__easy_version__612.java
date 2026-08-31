import java.util.*;

public class Main {

	public static void main(String args[]) {
		int n = 0;
		int k = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
//		PriorityQueue<Book> pq = new PriorityQueue<Book>(new BookComparator());
		PriorityQueue<Book> alice = new PriorityQueue<Book>(new BookComparator());
		PriorityQueue<Book> bob = new PriorityQueue<Book>(new BookComparator());
		PriorityQueue<Book> both = new PriorityQueue<Book>(new BookComparator());
		int alice_count = 0;
		int bob_count = 0;
		
		for(int i=0;i<n;i++) {
			int t = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			Book bk = new Book(t,a,b);
			if(a == 1 && b ==1) {
				alice_count++;
				bob_count++;
				both.add(bk);
				continue;
			}
			else if(a==1 && b==0) {
				alice_count++;
				alice.add(bk);
				continue;
			}
			else if(a==0 && b==1) {
				bob_count++;
				bob.add(bk);
				continue;
			}
			
		}
		
		if(alice_count < k || bob_count<k) {
			System.out.println(-1);
			return;
		}
		alice_count = k;
		bob_count = k;
		int a=0;
		int b=0;
		int c=0;
		long sum = 0;
		while(true) {
			if(alice_count == 0 && bob_count == 0)
				break;
			if(alice.size()<=0) {
				sum += both.peek().time;
				both.poll();
				c++;
				alice_count--;
				bob_count--;
				continue;
			}
			if(bob.size()<=0) {
				sum += both.peek().time;
				both.poll();
				c++;
				alice_count--;
				bob_count--;
				continue;
			}
			if(both.size()<=0) {
				sum += alice.peek().time;
				alice.poll();
				a++;
				sum += bob.peek().time;
				b++;
				bob.poll();
				alice_count--;
				bob_count--;
				continue;
			}
			if(alice.peek().time + bob.peek().time < both.peek().time) {
				sum += alice.peek().time;
				alice.poll();
				sum += bob.peek().time;
				bob.poll();
				alice_count--;
				bob_count--;
				
			}
			else {
				sum += both.peek().time;
				both.poll();
				alice_count--;
				bob_count--;
			}
			
		}
		System.out.println(sum);
	}
	
}

    
class Book {
	public int time;
	public int a;
	public int b;
	public Book(int t,int p_a,int p_b) {
		time = t;
		a = p_a;
		b = p_b;
	}
	public void print() {
		System.out.println(time+"    "+a+"     "+b);
	}
}

class BookComparator implements Comparator<Book>{
    //	public int compare(Book first,Book second) {
    //		if(first.a == 1 && first.b == 1)
    //			return -1;
    //		if(first.a == 1 && first.b == 1 && second.a == 1 && second.b == 1 && first.time<second.time)
    //			return -1;
    //		if(first.a == 1 && first.b ==0 && second.a == 0 && second.b == 0)
    //			return -1;
    //		if(first.a == 0 && first.b ==1 && second.a == 0 && second.b == 0)
    //			return -1;
    //		if(first.a == second.a && first.b ==second.b && first.time < second.time)
    //			return -1;
    //		
    //		return 1;
    //	}
    //	
        public int compare(Book first,Book second) {
            if(first.time < second.time)
                return -1;
            return 1;
        }
}


