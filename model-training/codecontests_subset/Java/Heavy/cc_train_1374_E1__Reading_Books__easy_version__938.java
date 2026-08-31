import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public final class ReadingBooksHard {

    private static final FastReader fr = new FastReader();

    public static void main(String[] args) {
        final int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt();
        final Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new Book(i, fr.nextInt(), fr.nextInt() == 1, fr.nextInt() == 1);
        }
        final Set<Book> ans = new ReadingBooksHard(books, m, k).solve2();

        System.out.println(ans == null ? -1 : ans.stream().mapToInt(b -> b.time).sum());
        if (ans != null) {
            final StringBuilder sb = new StringBuilder();
            for (Book b : ans) {
                sb.append(b.index + 1).append(' ');
            }
            System.out.println(sb);
        }
    }

    private final Book[] books;
    private final int m, k;

    public ReadingBooksHard(Book[] books, int m, int k) {
        this.books = books;
        this.m = m;
        this.k = k;
    }

    public Set<Book> solve2() {
        final Map<Interest, List<Book>> classified = Arrays.stream(books).collect(Collectors.groupingBy(b -> b.interest));
        for (Interest interest : Interest.values()) {
            final List<Book> books = classified.get(interest);
            if (books == null) classified.put(interest, Collections.emptyList());
            else books.sort(null);
        }

        final List<Book> alices = classified.get(Interest.ALICE),
                bobs = classified.get(Interest.BOB),
                commons = classified.get(Interest.COMMON),
                nons = classified.get(Interest.NON);

        final ListIterator<Book> alicesIt = alices.listIterator(),
                bobsIt = bobs.listIterator(),
                commonsIt = commons.listIterator(),
                nonsIt = nons.listIterator();

        final Set<Book> books = new HashSet<>(Math.max(2 * k, m), 1.0F);

        for (int i = 0; i < k; i++) {
            final List<ActionAndChange> actions = new ArrayList<>(2);

            if (commonsIt.hasNext())
                actions.add(new ActionAndChange(Action.ADD_COMMON, commons.get(commonsIt.nextIndex()).time));
            if (alicesIt.hasNext() && bobsIt.hasNext())
                actions.add(new ActionAndChange(Action.ADD_ALICE_AND_BOB, alices.get(alicesIt.nextIndex()).time + bobs.get(bobsIt.nextIndex()).time));

            final Action action = actions.stream().min(ActionAndChange::compareTo).map(a -> a.action).orElse(null);
            if (action == null) return null;

            switch (action) {
                case ADD_COMMON:
                    books.add(commonsIt.next());
                    break;
                case ADD_ALICE_AND_BOB:
                    books.addAll(Arrays.asList(alicesIt.next(), bobsIt.next()));
                    break;
            }

        }

        while (books.size() != m) {
            Action action = null;
            if (books.size() < m) { // Add a book
                final List<ActionAndChange> actions = new ArrayList<>(4);

                if (commonsIt.hasPrevious() && alicesIt.hasNext() && bobsIt.hasNext()) {
                    Book common = commons.get(commonsIt.previousIndex()),
                            bob = bobs.get(bobsIt.nextIndex()),
                            alice = alices.get(alicesIt.nextIndex());
                    actions.add(new ActionAndChange(Action.COMMON_TO_SEPARATE, alice.time + bob.time - common.time));
                }
                if (nonsIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_NON, nons.get(nonsIt.nextIndex()).time));
                }
                if (alicesIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_ALICE, alices.get(alicesIt.nextIndex()).time));
                }
                if (bobsIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_BOB, bobs.get(bobsIt.nextIndex()).time));
                }
                if (commonsIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_COMMON, commons.get(commonsIt.nextIndex()).time));
                }
                action = actions.stream().min(ActionAndChange::compareTo).map(a -> a.action).orElse(null);

            } else { // Remove a book with respects to k
                if (alicesIt.hasPrevious() && bobsIt.hasPrevious() && commonsIt.hasNext()) {
                    action = Action.SEPARATE_TO_COMMON;
                }
            }
            if (action == null) return null;
            switch (action) {
                case ADD_NON:
                    books.add(nonsIt.next());
                    break;
                case COMMON_TO_SEPARATE:
                    books.remove(commonsIt.previous());
                    books.addAll(Arrays.asList(bobsIt.next(), alicesIt.next()));
                    break;
                case ADD_ALICE:
                    books.add(alicesIt.next());
                    break;
                case ADD_BOB:
                    books.add(bobsIt.next());
                    break;
                case ADD_COMMON:
                    books.add(commonsIt.next());
                    break;
                case SEPARATE_TO_COMMON:
                    books.removeAll(Arrays.asList(alicesIt.previous(), bobsIt.previous()));
                    books.add(commonsIt.next());
                    break;
            }

        }

        return books;

    }

    public Set<Book> solve() {

        final Map<Interest, List<Book>> classified = Arrays.stream(books).collect(Collectors.groupingBy(b -> b.interest));
        for (Interest interest : Interest.values()) {
            List<Book> books = classified.get(interest);
            if (books == null) classified.put(interest, Collections.emptyList());
            else books.sort(null);
        }

        final List<Book> alices = classified.get(Interest.ALICE),
                bobs = classified.get(Interest.BOB),
                commons = classified.get(Interest.COMMON),
                nons = classified.get(Interest.NON);

        List<Book> best = null;
        int bestCommonsCount = -1;
        for (int commonsCount = 1; commonsCount <= k; commonsCount++) {
            if (commons.size() < commonsCount || alices.size() < k - commonsCount || bobs.size() < k - commonsCount)
                continue;

            final List<Book> books = new ArrayList<>(commonsCount + 2 * (k - commonsCount));
            books.addAll(commons.subList(0, commonsCount));
            books.addAll(alices.subList(0, k - commonsCount));
            books.addAll(bobs.subList(0, k - commonsCount));

            if (best == null || books.stream().mapToInt(b -> b.time).sum() < best.stream().mapToInt(b -> b.time).sum()) {
                best = books;
                bestCommonsCount = commonsCount;
            }
        }
        if (best == null) return null;

        final ListIterator<Book> alicesIt = alices.listIterator(),
                bobsIt = bobs.listIterator(),
                commonsIt = commons.listIterator(),
                nonsIt = nons.listIterator();

        for (int i = 0; i < bestCommonsCount; i++) {
            commonsIt.next();
        }
        for (int i = 0; i < k - bestCommonsCount; i++) {
            alicesIt.next();
            bobsIt.next();
        }

        final Set<Book> books = new HashSet<>(Math.max(best.size(), m), 1.0F);
        books.addAll(best);

        while (books.size() != m) {
            Action action = null;
            if (books.size() < m) { // Common to separates or add non, alice or bob
                class ActionAndChange {
                    public final int timeChange;
                    public final Action action;

                    public ActionAndChange(Action action, int timeChange) {
                        this.timeChange = timeChange;
                        this.action = action;
                    }
                }

                final List<ActionAndChange> actions = new ArrayList<>(4);

                if (commonsIt.hasPrevious() && alicesIt.hasNext() && bobsIt.hasNext()) {
                    Book common = commons.get(commonsIt.previousIndex()),
                            bob = bobs.get(bobsIt.nextIndex()),
                            alice = alices.get(alicesIt.nextIndex());
                    actions.add(new ActionAndChange(Action.COMMON_TO_SEPARATE, alice.time + bob.time - common.time));
                }

                if (nonsIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_NON, nons.get(nonsIt.nextIndex()).time));
                }
                if (alicesIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_ALICE, alices.get(alicesIt.nextIndex()).time));
                }
                if (bobsIt.hasNext()) {
                    actions.add(new ActionAndChange(Action.ADD_BOB, bobs.get(bobsIt.nextIndex()).time));
                }
                action = actions.stream().min(Comparator.comparingInt(a -> a.timeChange)).map(a -> a.action).orElse(null);

            } else { // Separate to common
                if (alicesIt.hasPrevious() && bobsIt.hasPrevious() && commonsIt.hasNext()) {
                    action = Action.SEPARATE_TO_COMMON;
                }
            }
            if (action == null) return null;
            switch (action) {
                case ADD_NON:
                    books.add(nonsIt.next());
                    break;
                case COMMON_TO_SEPARATE:
                    books.remove(commonsIt.previous());
                    books.addAll(Arrays.asList(bobsIt.next(), alicesIt.next()));
                    break;
                case ADD_ALICE:
                    books.add(alicesIt.next());
                    break;
                case ADD_BOB:
                    books.add(bobsIt.next());
                    break;
                case SEPARATE_TO_COMMON:
                    books.removeAll(Arrays.asList(alicesIt.previous(), bobsIt.previous()));
                    books.add(commonsIt.next());
                    break;
            }

        }

        return books;

    }

    private static final class ActionAndChange implements Comparable<ActionAndChange> {
        public final int timeChange;
        public final Action action;

        public ActionAndChange(Action action, int timeChange) {
            this.timeChange = timeChange;
            this.action = action;
        }

        @Override
        public int compareTo(ActionAndChange o) {
            return Integer.compare(timeChange, o.timeChange);
        }
    }

    private enum Action {
        ADD_NON, COMMON_TO_SEPARATE, ADD_ALICE, ADD_BOB, SEPARATE_TO_COMMON, ADD_ALICE_AND_BOB, ADD_COMMON
    }

    private enum Interest {
        COMMON, ALICE, BOB, NON
    }

    private static final class Book implements Comparable<Book> {
        public final int time, index;
        public final Interest interest;

        public Book(final int index, final int time, final Interest interest) {
            this.index = index;
            this.time = time;
            this.interest = interest;
        }

        public Book(final int index, int time, boolean alice, boolean bob) {
            this(index, time, alice && bob ? Interest.COMMON : alice ? Interest.ALICE : bob ? Interest.BOB : Interest.NON);
        }

        @Override
        public int compareTo(Book o) {
            return Integer.compare(this.time, o.time);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return index == book.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }

    private static final class FastReader {
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