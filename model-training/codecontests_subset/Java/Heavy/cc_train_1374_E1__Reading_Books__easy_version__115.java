//package div3._1374;

import java.io.*;
import java.util.*;

public class ReadingBooksHardVersion {

    private final FastReader fr = new FastReader();

    public static void main(String[] args) {
        new ReadingBooksHardVersion().solve();
    }

    private void solve() {
        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();

        List<Book> groupA = new ArrayList<>();
        List<Book> groupB = new ArrayList<>();
        List<Book> groupAB = new ArrayList<>();
        List<Book> groupNotAB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int t = fr.nextInt(), a = fr.nextInt(), b = fr.nextInt();
            Book book = new Book(i + 1, t);
            if (a == 1 && b == 1) {
                groupAB.add(book);
            } else if (a == 1) {
                groupA.add(book);
            } else if (b == 1) {
                groupB.add(book);
            } else {
                groupNotAB.add(book);
            }
        }


        Collections.sort(groupA);
        Collections.sort(groupB);
        Collections.sort(groupAB);
        Collections.sort(groupNotAB);

//        System.out.println("size = " + groupNotAB.size() + " -> " + groupNotAB);
//        System.out.println("size = " + groupA.size() + " -> " + groupA);
//        System.out.println("size = " + groupB.size() + " -> " + groupB);
//        System.out.println("size = " + groupAB.size() + " -> " + groupAB);

        Set<Book> books = readingBooks(groupNotAB, groupA, groupB, groupAB, m, k);
        if (books == null)
            System.out.println(-1);
        else {
            int time = 0;
            StringBuilder s = new StringBuilder();
            for (Book b : books) {
                time += b.time;
                s.append(b.index + " ");
            }
            System.out.printf("%d\n%s\n", time, s);
        }

    }


    private Set<Book> readingBooks(List<Book> groupNotAB, List<Book> groupA, List<Book> groupB, List<Book> groupAB, int m, int k) {

        int ai = 0; // group A index
        int bi = 0; // group B index
        int abi = 0; // group AB index
        int ni = 0; // group not AB index

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

        int bd = Math.abs(m - books.size()); // books difference

        if (m < books.size()) {
            // remove books
            for (int i = 1; i <= bd; i++) {
                if (ai == 0 || bi == 0 || groupAB.size() <= abi) return null;
                books.remove(groupA.get(--ai));
                books.remove(groupB.get(--bi));
                books.add(groupAB.get(abi++));
            }
        } else { // add more books
            for (int i = 1; i <= bd; i++) {
                Integer swap = (groupA.size() > ai && groupB.size() > bi && abi > 0) ? groupA.get(ai).time + groupB.get(bi).time - groupAB.get(abi - 1).time : null;
                Integer none = (groupNotAB.size() > ni) ? groupNotAB.get(ni).time : null;
                Integer a = (groupA.size() > ai) ? groupA.get(ai).time : null;
                Integer b = (groupB.size() > bi) ? groupB.get(bi).time : null;
                Integer ab = (groupAB.size() > abi) ? groupAB.get(abi).time : null;

                if (swap == null && none == null && a == null && b == null && ab == null) {
                    return null;
                }


                if (beatsAll(swap, new ArrayList<Integer>() {{
                    add(none);
                    add(a);
                    add(b);
                    add(ab);
                }})) {
                    books.remove(groupAB.get(--abi));
                    books.add(groupA.get(ai++));
                    books.add(groupB.get(bi++));
                } else if (beatsAll(none, new ArrayList<Integer>() {{
                    add(a);
                    add(b);
                    add(ab);
                }})) {
                    books.add(groupNotAB.get(ni++));
                } else if (beatsAll(a, new ArrayList<Integer>() {{
                    add(b);
                    add(ab);
                }})) {
                    books.add(groupA.get(ai++));
                } else if (beats(b, ab)) {
                    books.add(groupB.get(bi++));
                } else {
                    books.add(groupAB.get(abi++));
                }

            }

        }

        return books;
    }


    private boolean beats(Integer a, Integer b) {
        return b == null || (a != null && a < b);
    }

    private boolean beatsAll(Integer a, List<Integer> list) {
        return list.stream().allMatch(item -> beats(a, item));
    }

    private void sortTimes(List<Book>[] times) {
        for (List l : times
        ) {
            Collections.sort(l);
        }
    }

    private void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private void printListInArr(List[] lists) {
        System.out.println("**********");
        for (List l : lists
        ) {
            System.out.println(l);
        }
        System.out.println("**********");
    }

    static class Book implements Comparable {

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

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Object o) {
            return this.time - ((Book) o).time;
        }
    }

    class FastReader {
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

