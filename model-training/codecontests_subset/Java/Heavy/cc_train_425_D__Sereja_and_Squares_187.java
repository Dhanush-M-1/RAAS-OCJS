
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {
    
    static class p {
        int x, y, i;
        p(int i, int x, int y) {this.i=i; this.x=x; this.y=y;}
        
        public String toString() { return x+":"+y; };
    }
    
    static int solve(int[] x, int[] y) {
        int N=x.length, maxx=0, maxy=0;
        
        p[] pts=new p[N];
        for (int i=0; i<N; i++) {
            pts[i]=new p(i,x[i],y[i]);
            if(maxx<x[i]) {
                maxx=x[i];
            }
            if(maxy<y[i]) {
                maxy=y[i];
            }
        }
        
        map<Integer, p>[] x2p=new map[maxx+1];
        for (int i=0; i<=maxx; i++) {
            x2p[i]=new map<Integer, p>();
        }

        map<Integer, p>[] y2p=new map[maxy+1];
        for (int i=0; i<=maxy; i++) {
            y2p[i]=new map<Integer, p>();
        }
        
        for (int i=0; i<N; i++) {
            map<Integer, p> l=x2p[pts[i].x];
            l.put(pts[i].y, pts[i]);
        }

        for (int i=0; i<N; i++) {
            map<Integer, p> l=y2p[pts[i].y];
            l.put(pts[i].x, pts[i]);
        }
        
        int ret=0;
        
        for (int i=0; i<N; i++) {
            p pt=pts[i];
            if(x2p[pt.x].size<=y2p[pt.y].size) {
                map<Integer, p> l=x2p[pt.x];
                for (int j=0; j<l.size; j++) {
                    p pt2=(p)l.idx2v[j];
                    if(pt2.y>pt.y) {
                        int d=pt2.y-pt.y;
                        Integer key=pt.x+d;
                        if(y2p[pt.y].contains(key)&&y2p[pt2.y].contains(key)) {
                            ret++;
                        }
                    }
                }
            } else {
                map<Integer, p> l=y2p[pt.y];
                for (int j=0; j<l.size; j++) {
                    p pt2=(p)l.idx2v[j];
                    if(pt2.x>pt.x) {
                        int d=pt2.x-pt.x;
                        Integer key=pt.y+d;
                        if(x2p[pt.x].contains(key)&&x2p[pt2.x].contains(key)) {
                            ret++;
                        }
                    }
                }
            }
        }
        
        return ret;
    }

    
    
    
    
    static void run_stream(InputStream ins) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] x=new int[n], y=new int[n];
        
        for (int i=0; i<n; i++) {
            String[] xy=br.readLine().split(" ");
            x[i]=Integer.parseInt(xy[0]);
            y[i]=Integer.parseInt(xy[1]);
        }
        
        System.out.println(solve(x, y));
    }

    public static void main(String[] args) throws IOException {
        run_stream(System.in);
    }


    
    
    
    static class map<K,V> {
        public int size=0;
        float load_factor;
        
        public int[] 
                bucket2idx,
                idx2n;
        
        public Object[] idx2k,idx2v;
        
        public map() {
            this(8, 0.75f);
        }
        
        public map(int capacity, float load_factor) {
            this.load_factor=load_factor;
            bucket2idx=new int[capacity];
            Arrays.fill(bucket2idx, -1);
            
            int data_size=(int)(capacity*load_factor)+1;
            idx2k=new Object[data_size];
            idx2v=new Object[data_size];
            idx2n=new int[data_size];
        }
        
        private int i2hash(int i) {
            i^=(i>>>20)^(i>>>12);
            return i^(i>>>7)^(i>>>4);
        }
        
        public boolean contains(K k) {
            int idx=bucket2idx[k2bucket(k)];
            while(idx>=0) {
                if(idx2k[idx].equals(k)) {
                    return true;
                } else {
                    idx=idx2n[idx];
                }
            }
            return false;
        }
        
        public V get(K k) {
            int idx=bucket2idx[k2bucket(k)];
            while(idx>=0) {
                if(idx2k[idx].equals(k)) {
                    return (V)idx2v[idx];
                } else {
                    idx=idx2n[idx];
                }
            }
            throw new IndexOutOfBoundsException();
        }
        
        public V put(K k, V v) {
            if(size>(int)(bucket2idx.length*load_factor)) {
                rehash(bucket2idx.length<<1);
            }
            
            int bucket_idx=k2bucket(k);
            int idx=bucket2idx[bucket_idx];
            if(idx>=0) {
                while(true) {
                    if(idx2k[idx].equals(k)) {
                        V oldv=(V)idx2v[idx];
                        idx2v[idx]=v;
                        return oldv;
                    } else if(idx2n[idx]<0) {
                        int idx2=size++;
                        idx2k[idx2]=k;
                        idx2v[idx2]=v;
                        idx2n[idx]=idx2;
                        idx2n[idx2]=-1;
                        return v;
                    } else {
                        idx=idx2n[idx];
                    }
                }
            } else {
                idx=size++;
                bucket2idx[bucket_idx]=idx;
                idx2k[idx]=k;
                idx2v[idx]=v;
                idx2n[idx]=-1;
                return v;
            }
        }

        protected int k2bucket(K k) {
            int bucket_idx=i2hash(k.hashCode())%bucket2idx.length;
            if(bucket_idx<0) {
                bucket_idx=bucket2idx.length+bucket_idx;
            }
            return bucket_idx;
        }

        void rehash(int new_capacity) {
            int[] _bucket2idx=new int[new_capacity];
            Arrays.fill(_bucket2idx, -1);
            
            int data_size=(int)(new_capacity*load_factor)+1;
            Object[] _idx2k=new Object[data_size];
            Object[] _idx2v=new Object[data_size];
            int[] _idx2n=new int[data_size];
            
            int old_size=size;
            size=0;
            //swap
            int[] aux=_bucket2idx; _bucket2idx=bucket2idx; bucket2idx=aux;
            aux=_idx2n; _idx2n=idx2n; idx2n=aux;

            Object[] oaux=_idx2k; _idx2k=idx2k; idx2k=oaux;
            oaux=_idx2v; _idx2v=idx2v; idx2v=oaux;
            //populate
            for(int i=0; i<old_size; i++) {
                put((K)_idx2k[i], (V)_idx2v[i]);
            }
        }
        
        public void clear() {
            if(size>0) {
                size=0;
                Arrays.fill(bucket2idx, -1);
            }
        }
        
        public void putAll(map<K,V> m) {
            int new_size=size+m.size;
            if(new_size>(int)(bucket2idx.length*load_factor)) {
                rehash((int)(1+new_size/load_factor));
            }
            for(int idx=0; idx<m.size; idx++) {
                put((K)m.idx2k[idx], (V)m.idx2v[idx]);
            }
        }
        
        public String toString() {
            if(size==0)
                return "{}";

            StringBuilder sb=new StringBuilder();
            sb.append('{');
            for(int i=0; i<size; i++) {
                sb.append(idx2k[i]);
                sb.append('=');
                sb.append(idx2v[i]);
                if(i<size-1) {
                    sb.append(", ");
                }
            }
            return sb.append('}').toString();
        }
    }
}
