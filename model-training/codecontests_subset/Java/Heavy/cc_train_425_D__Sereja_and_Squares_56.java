
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class F {
    
    static class p {
        int x, y, i, xp, yp;
        p(int i, int x, int y) {this.i=i; this.x=x; this.y=y;}
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
        
        ArrayList<p>[] x2p=new ArrayList[maxx+1];
        for (int i=0; i<=maxx; i++) {
            x2p[i]=new ArrayList<p>();
        }

        ArrayList<p>[] y2p=new ArrayList[maxy+1];
        for (int i=0; i<=maxy; i++) {
            y2p[i]=new ArrayList<p>();
        }
        
        
        Arrays.sort(pts, new Comparator<p>() {
            public int compare(p o1, p o2) {
                return o1.y-o2.y;
            }
        });
        for (int i=0; i<N; i++) {
            ArrayList<p> l=x2p[pts[i].x];
            pts[i].xp=l.size();
            l.add(pts[i]);
        }

        Arrays.sort(pts, new Comparator<p>() {
            public int compare(p o1, p o2) {
                return o1.x-o2.x;
            }
        });
        for (int i=0; i<N; i++) {
            ArrayList<p> l=y2p[pts[i].y];
            pts[i].yp=l.size();
            l.add(pts[i]);
        }
        
        int ret=0; p aux=new p(0,0,0);
        Comparator<p> by_x=new Comparator<p>() {
            public int compare(p o1, p o2) {
                return o1.x-o2.x;
            }
        };
        Comparator<p> by_y=new Comparator<p>() {
            public int compare(p o1, p o2) {
                return o1.y-o2.y;
            }
        };
        
        for (int i=0; i<N; i++) {
            p pt=pts[i];
            if(x2p[pt.x].size()-pt.xp<=y2p[pt.y].size()-pt.yp) {
                ArrayList<p> l=x2p[pt.x];
                for (int j=pt.xp+1; j<l.size(); j++) {
                    p pt2=l.get(j);
                    int d=pt2.y-pt.y;
                    aux.x=pt.x+d;
                    if(Collections.binarySearch(y2p[pt.y], aux, by_x)>=0&&
                            Collections.binarySearch(y2p[pt2.y], aux, by_x)>=0) {
                        ret++;
                    }
                }
            } else {
                ArrayList<p> l=y2p[pt.y];
                for (int j=pt.yp+1; j<l.size(); j++) {
                    p pt2=l.get(j);
                    int d=pt2.x-pt.x;
                    aux.y=pt.y+d;
                    if(Collections.binarySearch(x2p[pt.x], aux, by_y)>=0&&
                            Collections.binarySearch(x2p[pt2.x], aux, by_y)>=0) {
                        ret++;
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


}
