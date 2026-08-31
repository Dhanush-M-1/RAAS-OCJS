import java.util.List;
import java.io.IOException;
import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Mahmoud Aladdin <aladdin3>
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader jin, PrintWriter jout) {
        long x = jin.int64();
        long v = solve(x);
        if(v == -1) {
            jout.println(2);
        } else {
            jout.println(1);
            jout.println(v);
        }
    }

    long solve(long x) {
        int[] primeList = PrimeNumbers.primes((int)1e7);
        int r = 2;
        int cp = 0;
        long found = 1;
        long orgx = x;
        while(r > 0 && x > 1 && cp < primeList.length) {
            if(x % primeList[cp] != 0) cp++;
            else {
                r--; found *= primeList[cp];
                x /= primeList[cp];
            }
        }
        if(r > 0 && PrimeNumbers.checkPrime(x)) {
            found *= x; r--;
        }
        if(r > 0) return 0;
        if(found == orgx) return -1;
        return found;
    }
}

class InputReader {
    private static final int bufferMaxLength = 1024;
    private InputStream in;
    private byte[] buffer;
    private int currentBufferSize;
    private int currentBufferTop;
    private static final String tokenizers = " \t\r\f\n";
    
    public InputReader(InputStream stream) {
        this.in = stream;
        buffer = new byte[bufferMaxLength];
        currentBufferSize = 0;
        currentBufferTop = 0;
    }
    
    private boolean refill() {
        try {
            this.currentBufferSize = this.in.read(this.buffer);
            this.currentBufferTop = 0;
        } catch(Exception e) {}
        return this.currentBufferSize > 0;
    }
    
    
    private Byte readChar() {
        if(currentBufferTop < currentBufferSize) {
            return this.buffer[this.currentBufferTop++];
        } else {
            if(!this.refill()) {
                return null;
            } else {
                return readChar();
            }
        }
    }
    
    
    public String token()  {
        StringBuffer tok = new StringBuffer();
        Byte first;
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) != -1));
        if(first == null) return null;
        tok.append((char)first.byteValue());
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) == -1)) {
            tok.append((char)first.byteValue());
        }
        return tok.toString();
    }
    
    public Long int64() throws NumberFormatException {
        String tok = token();
        return tok == null? null : Long.parseLong(tok);
    }
    
}

class PrimeNumbers {
    public static boolean checkPrime(long x) {
        if(x < 2) return false;
        if(x == 2) return true;
        if(x % 2 == 0) return false;
        long sx = (long) Math.sqrt(x);
        for(int i = 3; i <= sx; i += 2) {
            if(x % i == 0)
                return false;
        }
        return true;
    }

    private static boolean[] sieve(int max) {
        boolean[] primes = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for(int i = 0; i <= max; i++) {
            if(primes[i]) {
                int factor = i;
                while(i * (long) factor <= max) {
                    primes[(i * factor)] = false;
                    factor++;
                }
            }
        }
        return primes;
    }

    public static int[] primes(int max) {
        boolean[] primesChecker = PrimeNumbers.sieve(max);
        List<Integer> primeList = new LinkedList<Integer>();
        for(int i = 0; i < max; i++) {
            if(primesChecker[i]) {
                primeList.add(i);
            }
        }
        int ci = 0;
        int[] arr = new int[primeList.size()];
        for(Integer x: primeList) arr[ci++] = x;
        return arr;
    }
}

