#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

struct info{
    int n,w,s,e,p;
    info(int n, int w, int s, int e, int p):n(n), w(w), s(s), e(e), p(p){}
    info(){}
    void decrease(){
        n--; w--; s--; e--;
    }
    bool isvalid(){
        return n>0 && w>0 && s>0 && e>0;
    }
    bool operator < (const info &a) const{
        return (n +(w<<3) +(s<<6) +(e<<9) +(p<<12)) < (a.n +(a.w<<3) +(a.s<<6) +(a.e<<9) +(a.p<<12));
    }
};

int main(){
    while(1){
        int n;
        cin >> n;
        if(n==0) break;

        vector<vector<int> > w(n, vector<int>(17));
        for(int i=0; i<n; i++){
            for(int j=1; j<=16; j++){
                cin >> w[i][j];
            }
        }
        set<info> s;
        if(w[0][6] +w[0][7] +w[0][10] +w[0][11] == 0){
            s.insert(info(6, 6, 6, 6, 6));
        }
        for(int i=1; i<n; i++){
            set<info> ns;
            for(set<info>::iterator itr=s.begin(); itr != s.end(); itr++){
                info e = *itr;
                int x = (e.p -1) %4;
                int y = (e.p -1) /4;
                e.decrease();
                for(int d=0; d<4; d++){
                    for(int t=(d==0)?0:1; t<=2; t++){
                        int nx = x +t*dx[d];
                        int ny = y +t*dy[d];
                        info ni = e;
                        ni.p = 4*ny +nx +1;
                        if(nx<0 || nx>2 || ny<0 || ny>2) break;
                        if(w[i][ni.p] +w[i][ni.p+1] +w[i][ni.p+4] +w[i][ni.p+5] > 0) continue;
                        if(ni.p == 1) ni.n = 7;
                        if(ni.p == 3) ni.w = 7;
                        if(ni.p == 9) ni.s = 7;
                        if(ni.p == 11) ni.e = 7;
                        if(ni.isvalid()) ns.insert(ni);
                    }
                }
            }
            s = ns;
        }
        
        if(s.size()!=0){
            cout << 1 << endl;
        }else{
            cout << 0 << endl;
        }
    }
    return 0;
}

