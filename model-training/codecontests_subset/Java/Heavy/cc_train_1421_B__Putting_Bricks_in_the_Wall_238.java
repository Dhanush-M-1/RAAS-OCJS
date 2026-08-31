import java.io.*;
import java.util.*;

public class B{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        public FastReader(String fileName) throws FileNotFoundException{br = new BufferedReader(new FileReader(fileName));}
        String next(){while (st == null || !st.hasMoreElements()){try{st = new StringTokenizer(br.readLine());}catch (IOException  e){e.printStackTrace();}}return st.nextToken();}
        int nextInt(){return Integer.parseInt(next());}
        long nextLong(){return Long.parseLong(next());}
        double nextDouble(){return Double.parseDouble(next());}
        char[][] readCharArray(int n,int m) {
            String str;
            char[][] arr = new char[n][m];
            for(int i=0;i<n;i++) {
                str=nextLine();
                for(int j=0;j<n;j++) {
                    arr[i][j]=str.charAt(j);
                }
            }
            return arr;
        }
        char[][] readCharArray(int n){
            return readCharArray(n,n);
        }
        int[] readArray(int n){int[] a=new int[n];for (int i=0; i<n; i++) a[i]=nextInt();return a;}
        long[] readLongArray(int n){long[] a=new long[n];for (int i=0; i<n; i++) a[i]=nextLong();return a;}
        String nextLine(){String str = "";try{str = br.readLine();}catch (IOException e){e.printStackTrace();}return str;}
    }
    static void printArray(int[] arr){
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static int c(int n) {
    	if(n==1) return 0;
    	else return 1;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
    	FastReader st = new FastReader();
        int tt = st.nextInt();
        int n,cs,cf;
        boolean tests,testf;
        while(tt-- > 0) {
        	cs=cf=-1;
        	n=st.nextInt();
        	tests=testf=false;
        	char[][] arr = st.readCharArray(n);
        	int[] imp = new int[4];
        	imp[0] = Character.getNumericValue(arr[0][1]);
        	imp[1] = Character.getNumericValue(arr[1][0]);
        	imp[2] = Character.getNumericValue(arr[n-1][n-2]);
        	imp[3] = Character.getNumericValue(arr[n-2][n-1]);
        	StringBuilder str = new StringBuilder("");
        	int ans=0;
        	if(imp[0]==imp[1]) tests=true;
        	if(imp[2]==imp[3]) testf=true;
        	if(tests||testf) {
        		if(tests) {
        			cf=c(imp[0]);
        		}else{
        			cs=c(imp[2]);
        		}
        		if(cf==-1) {
        			if(imp[0]!=cs) {
        				ans++;
        				str.append("1 2\n");
        			}if(imp[1]!=cs) {
        				ans++;
        				str.append("2 1\n");
        			}
        		}else {
        			if(imp[2]!=cf) {
        				ans++;
        				str.append(n+" "+(n-1)+"\n");
        			}if(imp[3]!=cf) {
        				ans++;
        				str.append((n-1)+" "+n+"\n");
        			}
        		}
        		System.out.println(ans);
        		System.out.print(str);
        	}else {
        		if(imp[0]!=0) {
    				ans++;
    				str.append("1 2\n");
    			}if(imp[1]!=0) {
    				ans++;
    				str.append("2 1\n");
    			}if(imp[2]!=1) {
    				ans++;
    				str.append(n+" "+(n-1)+"\n");
    			}if(imp[3]!=1) {
    				ans++;
    				str.append((n-1)+" "+n+"\n");
    			}
    			System.out.println(ans);
        		System.out.print(str);
        	}
        }
    }
}