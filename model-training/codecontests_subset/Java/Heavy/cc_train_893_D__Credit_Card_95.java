import java.io.*;
import java.util.*;

public class D33 {
    public static void main(String[] args) {
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        int bal[] = new int[n];
        a[0] = in.nextInt();
        bal[0] = a[0];
        if(bal[0] > d) {
        	System.out.println(-1);
        	return;
        }
        for(int i = 1; i < n; ++i) {
        	a[i] = in.nextInt();
        	bal[i] = bal[i - 1] + a[i];
        	if(bal[i] > d) {
        		System.out.println(-1);
        		return;
        	}
        }
//        if(n == 100000) {
//        	int maxSufBal[] = new int[n];
//            maxSufBal[n - 1] = bal[n - 1];
//            for(int i = n - 2; i >= 0; --i) {
//            	maxSufBal[i] = Integer.max(maxSufBal[i + 1], bal[i]);
//            }
//            SegmentTree tree = new SegmentTree(bal);
//            int cur = 0;
//            int days = 0;
//            for(int i = 0; i < n; ++i) {
//            	if(bal[i] > d) {
//            		System.out.println(-1);
//            		return;
//            	}
//            	if(a[i] == 0 && bal[i] + cur < 0) {
//            		int delta = d - maxSufBal[i] - cur;
//            		int add = tree.max(i, n-1);
//            		if(delta != add) {
//            			System.out.println("delta " + delta + "");
//            		}
//            		if(bal[i] + cur + delta < 0) {
//            			System.out.println(-1);
//            			return;
//            		}
//            		cur += d - maxSufBal[i] - cur;
//            		days++;
//            	}
//            }
//        }
        SegmentTree tree = new SegmentTree(bal);
        int days = 0;
        for(int i = 0; i < n; ++i) {
        	if(a[i] == 0 && tree.max(i, i) < 0) {
        		int add = d - tree.max(i, n - 1);
	       		if(tree.max(i, i) + add < 0) {
	       			System.out.println(-1);
	       			return;
	       		} else {
	        		tree.add(i, n-1, add);
	        	days++;
	        	}
        	}
        }
        System.out.println(days);
    }
    
    private static class SegmentTree {
    	private int max[];
    	private int lpos[];
    	private int rpos[];
    	private int add[];
    	private final int root = 1;
    	
    	SegmentTree(int[] arr) {
    		max = new int[arr.length * 4];
    		lpos =new int[arr.length * 4];
    		rpos = new int[arr.length * 4]; 
    		add = new int[arr.length * 4];
    		build(root, arr, 0, arr.length - 1);
    	}
    	
    	private void build(int v, int[] arr, int left, int right) {
    		lpos[v] = left;
    		rpos[v] = right;
    		if(left == right) {
    			max[v] = arr[left];
    		} else {
    			int middle = (left + right) / 2;
    			build(v * 2, arr, left, middle);
    			build(v * 2 + 1, arr, middle + 1, right);
    			update(v);
    		}
    	}
    	
    	private void update(int v) {
    		max[v] = Integer.max(max[v * 2 ], max[v * 2 + 1]);
    	}
    	
    	void add(int from, int to, int value) {
    		add(root, from, to, value);
    	}
    	
    	private void add(int v, int from, int to, int value) {
    		if(lpos[v] >= from && rpos[v] <= to) {
    			addValue(v, value);
    		} else {
    			push(v);
    			from = Integer.max(from, lpos[v]);
    			to = Integer.min(to, rpos[v]);
    			if(from <= to) {
    				add(v * 2, from, to, value);
    				add(v * 2 + 1, from, to, value);
    				update(v);
    			}
    		}
    	}
    	
    	private void push(int v) {
    		if(add[v] != 0) {
    			addValue(v * 2, add[v]);
    			addValue(v * 2 + 1, add[v]);
    			add[v] = 0;
    		}
    	}
    	
    	private void addValue(int v, int value) {
			max[v] += value;
			if(lpos[v] != rpos[v]) {
				add[v] += value;
			}
    	}
    	
    	int max(int from, int to) {
    		return max(root, from, to);
    	}
    	
    	private int max(int v, int from, int to) {
    		if(lpos[v] >= from && rpos[v] <= to) {
    			return max[v];
    		} else {
    			push(v);
    			from = Integer.max(from, lpos[v]);
    			to = Integer.min(to, rpos[v]);
    			if(from > to) {
    				return Integer.MIN_VALUE;
    			}
    			return Integer.max(max(v * 2, from, to), max(v * 2 + 1, from, to));
    		}
    	}
    }

    public static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
    
    static class InputReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public InputReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}


