import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
	private static FastScanner sc = new FastScanner();

	public static void main(String[] args) {
		int n = sc.nextInt();
		Point[] p = new Point[n];
		for(int i=0; i<n; i++) {
			p[i] = new Point(sc.nextDouble(), sc.nextDouble());
		}
		
		for(int i=0; i<n; i++) {
//			System.out.println(i);
			if(!checkCounterClockwise(p[i], p[(i+1)%n], p[(i+2)%n])) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}

	static class Point {
		double x;
		double y;
		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean checkCounterClockwise(Point p1, Point p2, Point p3) {
		double a = (p2.y - p1.y) / (p2.x - p1.x);
		double b = p2.y - a * p2.x;
		if(p1.x == p2.x) {
			if((p1.y <= p2.y && p3.x <= p1.x) || (p1.y >= p2.y && p3.x >= p1.x)) {
				return true;
			} else {
				return false;
			}	
			
		} else {
			if((p1.x <= p2.x && p3.y - (a * p3.x + b) >= 0) || (p1.x >= p2.x && p3.y - (a * p3.x + b) <= 0)) {
				return true;
			} else {
				return false;
			}				
		}
	}
	
	static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if(ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                if(buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
        public boolean hasNext() { skipUnprintable(); return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}