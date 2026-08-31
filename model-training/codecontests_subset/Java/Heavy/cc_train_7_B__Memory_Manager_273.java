/**
 * ******* Created on 19/9/19 3:33 AM*******
 */

import java.io.*;
import java.util.*;

public class B7 {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            int t = input.nextInt();
            int m = input.nextInt();
            int[] arr = new int[m];
            for(int i=0;i<m;i++) {
                arr[i]=0;
            }
            int id =0;
            while(t-- >0){
                String s = input.next();
                if(s.equals("defragment")){
                    for(int i=0, j=0;i<m;i++){
                        if(arr[j]!=0)j++;
                        if(arr[i]!=0 && j <i){
                            arr[j]= arr[i];
                            arr[i]=0;
                            j++;
                        }
                    }
                }else if(s.equals("alloc")){
                    int size = input.nextInt();
                    int cnt1 =0, pos =-1;
                    for(int i=0;i<m;i++){
                        if(arr[i]==0)cnt1++;
                        else cnt1 =0;
                        if(cnt1 ==size){
                            id++;
                            pos =i;
                            break;
                        }
                    }
                    if(pos ==-1){
                        System.out.println("NULL");
                    }else{
                        System.out.println(id);
                        for(int i=pos, k=0;k<size;k++,i--)
                            arr[i]=id;
                    }
                }else{
                    int ids = input.nextInt();
                    boolean flag =false;
                    for(int i=0;i<m;i++){
                        if(arr[i]==ids){
                            flag =true;
                            arr[i]=0;
                        }
                    }
                    if(!flag || ids <=0){
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                }
            }
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}
