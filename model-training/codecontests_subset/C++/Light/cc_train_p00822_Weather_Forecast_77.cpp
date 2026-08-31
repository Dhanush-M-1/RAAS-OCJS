#include <iostream>
#include <algorithm>
#include <numeric>
#include <vector>
#include <cassert>
#include <string>
#include <memory.h>
#include <queue>
#include <cstdio>
#include <cstdlib>
#include <set>
#include <map>
#include <cctype>
#include <iomanip>
#include <sstream>
#include <cctype>
#include <fstream>
#include <cmath>
using namespace std;

#define REP2(i, m, n) for(int i = (int)(m); i < (int)(n); i++)
#define REP(i, n) REP2(i, 0, n)
#define ALL(c) (c).begin(), (c).end()
#define ITER(c) __typeof((c).begin())
#define PB(e) push_back(e)
#define FOREACH(i, c) for(ITER(c) i = (c).begin(); i != (c).end(); ++i)
#define MP(a, b) make_pair(a, b)
#define PARITY(n) ((n) & 1)

typedef long long ll;
typedef pair<ll, ll> P;
const int INF = 1000 * 1000 * 1000 + 7;
const double EPS = 1e-10;

const int DMAX = 365;

bool dp[DMAX + 1][3][3][7][7][7][7];
bool can_move[DMAX + 1][3][3];

int main(){
  int D;
  const int N = 4;
  
  memset(dp, false, sizeof(dp));
  
  while(cin >> D && D){

    REP(i, D){
      int F[4][4];
      REP(r, N)REP(c, N) cin >> F[r][c];
      
      REP(r, N - 1)REP(c, N - 1){
        can_move[i][r][c] = true;
        REP(dr, 2)REP(dc, 2) can_move[i][r][c] &= F[r+dr][c+dc] == 0;
      }
    }
    
    memset(dp, false, sizeof(dp));
    dp[0][1][1][0][0][0][0] = true;
    
    REP(i, D)REP(r, N - 1)REP(c, N - 1){
      if(i == 1 && (r != 1 || c != 1)) continue;
      
      int dr[9] = {0, 0, 0, 0, 0, 1, 2, -1, -2};
      int dc[9] = {0, 1, 2, -1, -2, 0, 0, 0, 0};
      
      REP(s, 7)REP(t, 7)REP(u, 7)REP(v, 7)if(dp[i][r][c][s][t][u][v]){
        REP(p, 9){
          int r2 = r + dr[p];
          int c2 = c + dc[p];
          
          if(0 <= r2 && r2 < N-1 && 0 <= c2 && c2 < N-1 && can_move[i][r2][c2]){
            int s2 = (r2 == 0 && c2 == 0) ? 0 : s + 1;
            int t2 = (r2 == 0 && c2 == N - 2) ? 0 : t + 1;
            int u2 = (r2 == N - 2 && c2 == 0) ? 0 : u + 1;
            int v2 = (r2 == N - 2 && c2 == N - 2) ? 0 : v + 1;
            if(s2 < 7 && t2 < 7 && u2 < 7 && v2 < 7){
              dp[i+1][r2][c2][s2][t2][u2][v2] = true;
            }
          }
        }
      }
    }
    
    bool ok = false;
    REP(r, 3)REP(c, 3)REP(s, 7)REP(t, 7)REP(u, 7)REP(v, 7){
      if(D > 1){
        ok |= dp[D][r][c][s][t][u][v];
      }else{
        ok |= dp[D][1][1][s][t][u][v];
      }
    }
    cout << ok << endl;
  }
  return 0;
}