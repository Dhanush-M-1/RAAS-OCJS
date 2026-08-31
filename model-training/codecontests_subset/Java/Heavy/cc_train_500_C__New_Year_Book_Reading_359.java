import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

 class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int days = in.readInt();
        int[] w = IOUtils.readIntArray(in, n);
        int[] bookIds = IOUtils.readIntArray(in, days);
        MiscUtils.decreaseByOne(bookIds);
        int ans = 0;
        EzIntArrayList books = new EzIntArrayList();
        for (int day = 0; day < days; day++) {
            int curBook = bookIds[day];
            int pos = books.indexOf(curBook);
            if (pos == -1) {
                for (int i = 0; i < books.size(); i++) {
                    ans += w[books.get(i)];
                }
                books.insert(0, curBook);
            } else {
                for (int i = 0; i < pos; i++) {
                    ans += w[books.get(i)];
                }
                books.removeAt(pos);
                books.insert(0, curBook);
            }
        }
        out.printLine(ans);
    }
}


 class InputReader {

     private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

     public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

     public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	public static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

     public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}


 class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

     public void close() {
		writer.close();
	}

     public void printLine(int i) {
		writer.println(i);
	}
}


 class IOUtils {

     public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}

 }


 class MiscUtils {

     public static void decreaseByOne(int[]...arrays) {
		for (int[] array : arrays) {
			for (int i = 0; i < array.length; i++)
				array[i]--;
		}
	}

 }

 class EzIntArrayList implements EzIntList, EzIntStack {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double ENLARGE_SCALE = 2.0;
    private static final int HASHCODE_INITIAL_VALUE = 0x811c9dc5;
    private static final int HASHCODE_MULTIPLIER = 0x01000193;

    private int[] array;
    private int size;

    public EzIntArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public EzIntArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        array = new int[capacity];
        size = 0;
    }

    public EzIntArrayList(EzIntCollection collection) {
        size = collection.size();
        array = new int[size];
        int i = 0;
        for (EzIntIterator iterator = collection.iterator(); iterator.hasNext(); ) {
            array[i++] = iterator.next();
        }
    }

    public EzIntArrayList(int[] srcArray) {
        size = srcArray.length;
        array = new int[size];
        System.arraycopy(srcArray, 0, array, 0, size);
    }

    public EzIntArrayList(Collection<Integer> javaCollection) {
        size = javaCollection.size();
        array = new int[size];
        int i = 0;
        for (int element : javaCollection) {
            array[i++] = element;
        }
    }

    public int size() {
        return size;
    }

     public EzIntIterator iterator() {
        return new EzIntArrayListIterator();
    }

     public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, size = " + size);
        }
        return array[index];
    }

     public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, size = " + size);
        }
        if (size == array.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, size = " + size);
        }
        final int removedElement = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return removedElement;
    }

     public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

     private void enlarge() {
        int newSize = Math.max(size + 1, (int) (size * ENLARGE_SCALE));
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EzIntArrayList that = (EzIntArrayList) o;

        if (size != that.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] != that.array[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hash = HASHCODE_INITIAL_VALUE;
        for (int i = 0; i < size; i++) {
            hash = (hash ^ PrimitiveHashCalculator.getHash(array[i])) * HASHCODE_MULTIPLIER;
        }
        return hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private class EzIntArrayListIterator implements EzIntIterator {
        private int curIndex = 0;

        public boolean hasNext() {
            return curIndex < size;
        }

        public int next() {
            if (curIndex == size) {
                throw new NoSuchElementException("Iterator doesn't have more elements");
            }
            return array[curIndex++];
        }
    }
}


interface EzIntList extends EzIntCollection {
    int size();

    EzIntIterator iterator();

    boolean equals(Object object);

    int hashCode();

    String toString();

 }


 interface EzIntStack extends EzIntCollection {
    int size();

     EzIntIterator iterator();

     boolean equals(Object object);

    int hashCode();

    String toString();

 }


interface EzIntCollection {
    int size();

    EzIntIterator iterator();

    boolean equals(Object object);

    int hashCode();

    String toString();
}


 interface EzIntIterator {
    boolean hasNext();

    int next();
}

 final class PrimitiveHashCalculator {
    private PrimitiveHashCalculator() {
    }

     public static int getHash(int x) {
        return x;
    }

 }


