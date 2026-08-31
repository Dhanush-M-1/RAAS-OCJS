//Problem: Reading Books (easy version) (https://codeforces.com/problemset/problem/1374/E1)
//Status: Not accepted

import java.util.*;
import java.io.*;

public class _1374E1 {
    private static BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(infile.readLine());
        int numBooks = Integer.parseInt(st.nextToken());
        int minLiked = Integer.parseInt(st.nextToken());

        LinkedList<Book> both = new LinkedList<Book>();
        LinkedList<Book> alice = new LinkedList<Book>();
        LinkedList<Book> bob = new LinkedList<Book>();
        int numAlice = 0, numBob = 0;
        for(int i = 0; i < numBooks; i++) {
            st = new StringTokenizer(infile.readLine());
            Book temp = new Book(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if(temp.alice && temp.bob)
                both.add(temp);
            else if(temp.alice)
                alice.add(temp);
            else if(temp.bob)
                bob.add(temp);

            if(temp.alice)
                numAlice++;
            if(temp.bob)
                numBob++;
        }
        Collections.sort(both);
        Collections.sort(alice);
        Collections.sort(bob);

        if(numAlice < minLiked || numBob < minLiked)
            System.out.println("-1");
        else {
            numAlice = 0;
            numBob = 0;
            int minTime = 0;
            while(numAlice < minLiked || numBob < minLiked) {
                if(!both.isEmpty() && !alice.isEmpty() && !bob.isEmpty()) {
                    numAlice++;
                    numBob++;
                    if(both.get(0).time < alice.get(0).time + bob.get(0).time)
                        minTime += both.removeFirst().time;
                    else
                        minTime += alice.removeFirst().time + bob.removeFirst().time;
                }
                else if(!both.isEmpty() && (alice.isEmpty() || bob.isEmpty())) {
                    numAlice++;
                    numBob++;
                    minTime += both.removeFirst().time;
                }
                else if(both.isEmpty()) {
                    if(numAlice < minLiked) {
                        numAlice++;
                        minTime += alice.removeFirst().time;
                    }
                    if(numBob < minLiked) {
                        numBob++;
                        minTime += bob.removeFirst().time;
                    }
                }
            }
            System.out.println(minTime);
        }
    }
}

class Book implements Comparable<Book> {
    public boolean alice, bob;
    public int time;

    public Book(int time, int alice, int bob) {
        this.time = time;
        this.alice = alice == 1;
        this.bob = bob == 1;
    }

    public int compareTo(Book other) {
        return this.time - other.time;
    }
}