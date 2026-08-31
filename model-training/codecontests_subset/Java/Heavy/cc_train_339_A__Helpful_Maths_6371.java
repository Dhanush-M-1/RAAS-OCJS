/************
@Author tarunguptaraja-quirkyAlone
@Quote Coding is under my rule. 
************/

import java.io.*;
import java.util.*;


public class Main {
   
    public static void main(String[] params) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        String s = in.readWord();
        int[] arr = new int[(s.length()+1)/2];
        for(int i=0,j=0;i<s.length();i=i+2,j++){
            arr[j]=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            out.printInt(arr[i]);
            if(i!=arr.length-1)out.printString("+");
        }

        out.flush();
    }

    static class InputReader {
        static final int bufferSize = 1 << 25;

        private char[] content;
        private int pos = 0;
        private long[] readTo = new long[1];

        public InputReader(InputStream in) throws IOException {
            Reader charReader = new InputStreamReader(in);
            content = new char[bufferSize];
            charReader.read(content, 0, content.length);
            charReader.close();
        }

        public int readInt() {
            return (int)readLong();
        }

        public long readLong() {
            readLongArray(readTo, 0, 1);
            return readTo[0];
        }

        public String readWord() {
            while (pos < content.length && (content[pos] == ' ' || content[pos] == 13 || content[pos] == 10)) ++pos;
            int count = 0;
            int initialPos = pos;
            while (pos < content.length) {
                char ch = content[pos];
                if (ch != ' ' && ch != 10 && ch != 13 && ch != 0) {
                    ++count;
                    ++pos;
                } else break;
            }
            while (pos < content.length && (content[pos] == ' ' || content[pos] == 13 || content[pos] == 10)) ++pos;
            return new String(content, initialPos, count);
        }

        public void readLongArray(long[] arr, int from, int length) {
            for (int i = from, k = 0; k < length; ++k, ++i) {
                while (pos < content.length && content[pos] < '0' && content[pos] != '+' && content[pos] != '-') ++pos;

                long num = 0;
                long sign = 1;
                if (content[pos] == '-') {
                    sign = -1;
                    ++pos;
                } else if (content[pos] == '+') ++pos;

                while (pos < content.length) {
                    char ch = content[pos++];
                    if (ch < '0') {
                        break;
                    } else {
                        long digit = ch - '0';
                        num = (num << 3) + (num << 1) + digit;
                    }
                }
                arr[from++] = num * sign;
            }
        }
    }

    static class OutputWriter {
        private static final int outBufferSize = 1 << 25; // 8M

        private PrintStream out;
        private byte[] outBuffer = new byte[outBufferSize];
        private int outByteCnt = 0;
        private byte[] intToStringBuffer = new byte[21];

        public OutputWriter(PrintStream out) {
            this.out = out;
        }

        public void flush() {
            out.write(outBuffer, 0, outByteCnt);
        }

        public void printInt(long val) {
            int outBufferPos = intToStringBuffer.length;
            if (val == 0) {
                outBufferPos = intToStringBuffer.length - 1;
                intToStringBuffer[outBufferPos] = '0';
            } else {
                boolean minus = false;
                if (val < 0) {
                    minus = true;
                    val = -val;
                }
                while (val != 0) {
                    byte digitChar = (byte)(val % 10 + '0');
                    intToStringBuffer[--outBufferPos] = digitChar;
                    val = val / 10;
                }
                if (minus) intToStringBuffer[--outBufferPos] = '-';
            }

            System.arraycopy(intToStringBuffer, outBufferPos, outBuffer, outByteCnt, intToStringBuffer.length - outBufferPos);
            outByteCnt += intToStringBuffer.length - outBufferPos;
        }

        public void printString(String str) {
            for (int i = 0, strLength = str.length(); i < strLength; ++i) {
                outBuffer[outByteCnt++] = (byte)str.charAt(i);
            }
        }

        public void newLine() {
            printString(System.lineSeparator());
        }
    }
}