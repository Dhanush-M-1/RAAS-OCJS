#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <map>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <cassert>

using namespace std;

#define FOR(i,k,n) for(int i=(k); i<(int)(n); ++i)
#define REP(i,n) FOR(i,0,n)
#define FORIT(i,c) for(__typeof((c).begin())i=(c).begin();i!=(c).end();++i)

template<class T> void debug(T begin, T end){ for(T i = begin; i != end; ++i) cerr<<*i<<" "; cerr<<endl; }
inline bool valid(int x, int y, int W, int H){ return (x >= 0 && y >= 0 && x < W && y < H); }

typedef long long ll;
const int INF = 100000000;
const double EPS = 1e-8;
const int MOD = 1000000007;
int dx[9] = {1, 0, -1, 0, 0, 0, 2, -2, 0};
int dy[9] = {0, 1, 0, -1, 0, 2, 0, 0, -2};

int main(){
  int D;
  int sch[365][4][4] = {};
  while(cin>>D && D){
    bool goal = false;
    REP(i, D) REP(y, 4) REP(x, 4) cin>>sch[i][y][x];
    static bool used[366][16][2401];
    memset(used, 0, sizeof(used));
    queue<int> qd, qy, qx;
    queue< vector<int> > qv;
    vector<int> s(4, 0);
    qd.push(0); qx.push(1); qy.push(1); qv.push(s);
    while(!qd.empty()){
      int d = qd.front(); qd.pop();
      int x = qx.front(); qx.pop();
      int y = qy.front(); qy.pop();
      //printf("d = %d x = %d y = %d\n", d, x, y);
      vector<int> v = qv.front(); qv.pop();
      if(d == D){
        goal = true;
        break;
      }
      REP(i, 4) v[i]++;
      bool ok = true;
      REP(dy, 2)REP(dx, 2) if(sch[d][y + dy][x + dx] == 1) ok = false;
      if(x == 0 && y == 0) v[0] = 0;
      if(x == 2 && y == 0) v[1] = 0;
      if(x == 0 && y == 2) v[2] = 0;
      if(x == 2 && y == 2) v[3] = 0;
      REP(i, 4) if(v[i] >= 7) ok = false;
      if(!ok) continue;
      REP(r, 9){
        bool ok2 = true;
        int nx = x + dx[r];
        int ny = y + dy[r];
        REP(dx, 2)REP(dy, 2) ok2 &= valid(nx + dx, ny + dy, 4, 4);
        if(!ok2) continue;
        if(used[d + 1][ny + nx * 4][v[0] + 7 * v[1] + 49 * v[2] + 343 * v[3]]) continue;
        used[d + 1][ny + nx * 4][v[0] + 7 * v[1] + 49 * v[2] + 343 * v[3]] = true;
        qd.push(d + 1);
        qx.push(nx);
        qy.push(ny);
        qv.push(v);
      }
    }
    if(goal) cout<<1<<endl;
    else cout<<0<<endl;
  }
  return 0;
}