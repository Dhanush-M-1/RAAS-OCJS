import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

 
 
public class Main {
	
	
	public static void main(String[] args) throws Exception {
        solve(1);	
    }
 
    
    public static void solve(int testCases) throws Exception{
    	int t = StdIn.readInt();
    	int m = StdIn.readInt();
    	Memory mem = new Memory(m);
    	while(t-- > 0){
    		String line = StdIn.readString();
    		if(line.equals("alloc")){
    			StdOut.println(mem.alloc(StdIn.readInt()));
    		}else if(line.equals("erase")){
    			mem.erase(StdIn.readInt());
    		}else{
    			mem.defragment();
    		}
    	}
    }
}


class Memory{
	int[] blocks;
	int blen;
	int id;
	
	public Memory(int n){
		blen = n;
		blocks = new int[n];
		id = 0;
	}
	
	public String alloc(int n){
		//StdOut.println("alloc called with : " + n);
		for(int i = 0 ; i < blen ; i++){
			int a = 0;
			for(int j = i ; j < blen ; j++){
				if(blocks[j]!=0)
					break;
				a++;
			}
			if(a >= n){
				id += 1;
				for(int p = i ; p < (i+n); p++){
					blocks[p] = id;
				}
				return String.valueOf(id);
			}
		}
		return "NULL";
	}
	
	public void erase(int x){
		boolean flag = false;
		for(int i = 0 ; i < blen ; i++){
			if(blocks[i] == x && x!= 0){
				blocks[i] = 0;
				flag = true;
			}
		}
		if(!flag)
			StdOut.println("ILLEGAL_ERASE_ARGUMENT");
	}
	
	public void defragment(){
		int[] temp = new int[blen];
		int j = 0;
		for(int i = 0 ; i < blen ; i++){
			if(blocks[i] != 0)
				temp[j++] = blocks[i];
		}
		blocks = temp;
	}
}

final class StdIn {
 
    private StdIn() { }
 
    private static Scanner scanner;
    
    private static final String CHARSET_NAME = "UTF-8";
 
    private static final Locale LOCALE = Locale.US;
 
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
 
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");
 
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
 
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }
 
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }
 
    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }
 
    public static String readLine() {
        String line;
        try                 { line = scanner.nextLine(); }
        catch (Exception e) { line = null;               }
        return line;
    }
 
    public static char readChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        String ch = scanner.next();
        assert (ch.length() == 1) : "Internal (Std)In.readChar() error!"
            + " Please contact the authors.";
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return ch.charAt(0);
    }  
 
 
    public static String readAll() {
        if (!scanner.hasNextLine())
            return "";
 
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimeter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }
 
    public static String readString() {
        return scanner.next();
    }
 
    public static int readInt() {
        return scanner.nextInt();
    }
 
    public static double readDouble() {
        return scanner.nextDouble();
    }
 
    public static float readFloat() {
        return scanner.nextFloat();
    }
 
    public static long readLong() {
        return scanner.nextLong();
    }
    
    public static short readShort() {
        return scanner.nextShort();
    }
 
    public static byte readByte() {
        return scanner.nextByte();
    }
 
    public static boolean readBoolean() {
        String s = readString();
        if (s.equalsIgnoreCase("true"))  return true;
        if (s.equalsIgnoreCase("false")) return false;
        if (s.equals("1"))               return true;
        if (s.equals("0"))               return false;
        throw new InputMismatchException();
    }
 
    public static String[] readAllStrings() {
        // we could use readAll.trim().split(), but that's not consistent
        // because trim() uses characters 0x00..0x20 as whitespace
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;
 
        // don't include first token if it is leading whitespace
        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }
 
    public static String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<String>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[0]);
    }
 
    public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }
 
    public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }
    
    static {
        resync();
    }
 
    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }
    
    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCALE);
    }
 
    public static int[] readInts() {
        return readAllInts();
    }
 
    public static double[] readDoubles() {
        return readAllDoubles();
    }
 
    public static String[] readStrings() {
        return readAllStrings();
    }
 
}
 
final class StdOut {
 
    private static final String CHARSET_NAME = "UTF-8";
 
    private static final Locale LOCALE = Locale.US;
 
    private static PrintWriter out;
 
    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        }
        catch (UnsupportedEncodingException e) { System.out.println(e); }
    }
 
    private StdOut() { }
 
    public static void close() {
        out.close();
    }
 
    public static void println() {
        out.println();
    }
 
    public static void println(Object x) {
        out.println(x);
    }
 
    public static void println(boolean x) {
        out.println(x);
    }
 
    public static void println(char x) {
        out.println(x);
    }
 
    public static void println(double x) {
        out.println(x);
    }
 
    public static void println(float x) {
        out.println(x);
    }
 
    public static void println(int x) {
        out.println(x);
    }
 
    public static void println(long x) {
        out.println(x);
    }
 
    public static void println(short x) {
        out.println(x);
    }
 
    public static void println(byte x) {
        out.println(x);
    }
 
    public static void print() {
        out.flush();
    }
 
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(char x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(double x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(float x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(int x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(long x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(short x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }
 
    public static void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }
 
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }
 
} 