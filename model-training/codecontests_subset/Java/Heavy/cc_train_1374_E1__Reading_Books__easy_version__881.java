//package div3._1374;

import java.io.*;
import java.util.*;

public class ReadingBooksHardVersion {

    private final FastReader fr = new FastReader();

    public static void main(String[] args) {
        new ReadingBooksHardVersion().solve();
    }

    private void solve() {
        final int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt();

        List<Book> groupA = new ArrayList<>(),
                groupB = new ArrayList<>(),
                groupAB = new ArrayList<>(),
                groupNotAB = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            int time = fr.nextInt(), a = fr.nextInt(), b = fr.nextInt();
            Book book = new Book(index + 1, time);
            if (a == 1 && b == 1) groupAB.add(book);
            else if (a == 1) groupA.add(book);
            else if (b == 1) groupB.add(book);
            else groupNotAB.add(book);
        }

        Collections.sort(groupA);
        Collections.sort(groupB);
        Collections.sort(groupAB);
        Collections.sort(groupNotAB);

        Set<Book> books = readingBooks(groupNotAB, groupA, groupB, groupAB, m, k);
        printAns(books);

    }

    private void printAns(Set<Book> books) {
        if (books == null)
            System.out.println(-1);
        else {
            int time = 0;
            StringBuilder s = new StringBuilder();
            for (Book b : books) {
                time += b.time;
                s.append(b.index).append(" ");
            }
            System.out.printf("%d\n%s\n", time, s);
        }
    }


    private Set<Book> readingBooks(List<Book> groupNotAB,
                                   List<Book> groupA,
                                   List<Book> groupB,
                                   List<Book> groupAB,
                                   int m,
                                   int k) {

        int ai = 0; // group A index
        int bi = 0; // group B index
        int abi = 0; // group AB index
        int noni = 0; // group not AB index

        Set<Book> books = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            Integer both = (groupAB.size() > abi) ? groupAB.get(abi).time : null;
            Integer separate = (groupA.size() > ai && groupB.size() > bi) ? groupA.get(ai).time + groupB.get(bi).time : null;

            if (both == null && separate == null) return null;

            if (beats(both, separate)) {
                books.add(groupAB.get(abi++));
            } else {
                books.add(groupA.get(ai++));
                books.add(groupB.get(bi++));
            }
        }

        int booksDiff = Math.abs(m - books.size()); // books difference

        if (m < books.size()) {
            // remove books
            for (int i = 1; i <= booksDiff; i++) {
                if (ai == 0 || bi == 0 || groupAB.size() <= abi) return null;
                books.remove(groupA.get(--ai));
                books.remove(groupB.get(--bi));
                books.add(groupAB.get(abi++));
            }
        } else {
            // add more books
            for (int i = 1; i <= booksDiff; i++) {
                Action swap = new Action(
                        "swap",
                        (groupA.size() > ai && groupB.size() > bi && abi > 0)
                                ? groupA.get(ai).time + groupB.get(bi).time - groupAB.get(abi - 1).time
                                : null
                );
                Action addNone = new Action(
                        "addNone",
                        (groupNotAB.size() > noni)
                                ? groupNotAB.get(noni).time
                                : null
                );
                Action addA = new Action(
                        "addA",
                        (groupA.size() > ai)
                                ? groupA.get(ai).time
                                : null
                );
                Action addB = new Action(
                        "addB",
                        (groupB.size() > bi)
                                ? groupB.get(bi).time
                                : null
                );
                Action addBoth = new Action(
                        "addBoth",
                        (groupAB.size() > abi)
                                ? groupAB.get(abi).time
                                : null
                );

                String action = findTheBestAction(new ArrayList<Action>() {{
                    add(swap);
                    add(addNone);
                    add(addA);
                    add(addB);
                    add(addBoth);
                }});

                switch (action) {
                    case "null":
                        return null;
                    case "swap":
                        books.remove(groupAB.get(--abi));
                        books.add(groupA.get(ai++));
                        books.add(groupB.get(bi++));
                        break;
                    case "addNone":
                        books.add(groupNotAB.get(noni++));
                        break;
                    case "addA":
                        books.add(groupA.get(ai++));
                        break;
                    case "addB":
                        books.add(groupB.get(bi++));
                        break;
                    case "addBoth":
                        books.add(groupAB.get(abi++));
                        break;
                }

            }

        }

        return books;
    }

    private String findTheBestAction(ArrayList<Action> integers) {
        Optional<Action> min = integers.stream().filter(item -> item.value != null).min(Comparator.comparingInt(a -> a.value));
        return min.map(action -> action.name).orElse("null");
    }


    private boolean beats(Integer a, Integer b) {
        return b == null || (a != null && a < b);
    }

    static class Action {
        @Override
        public String toString() {
            return "Action{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }

        private final String name;
        private final Integer value;

        public Action(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }

    static class Book implements Comparable<Book> {

        private final int index;
        private final int time;

        public Book(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(Book o) {
            return this.time - o.time;
        }
    }

    static class FastReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

