#include <iostream>
#include <complex>
#include <sstream>
#include <string>
#include <algorithm>
#include <deque>
#include <list>
#include <map>
#include <numeric>
#include <queue>
#include <vector>
#include <set>
#include <limits>
#include <cstdio>
#include <cctype>
#include <cmath>
#include <cstring>
#include <cstdlib>
#include <ctime>
using namespace std;
#define REP(i, j) for(int i = 0; i < (int)(j); ++i)
#define FOR(i, j, k) for(int i = (int)(j); i < (int)(k); ++i)
#define SORT(v) sort((v).begin(), (v).end())
#define REVERSE(v) reverse((v).begin(), (v).end())
typedef complex<double> P;
const int N = 16;
const int L = 6;
const int MAX_A = 366;
const int MAX_B = 9;
const int MAX_C = 7 * 7 * 7 * 7;

int D;
bool v[MAX_A][4][4], dp[MAX_A][MAX_B][MAX_C];

int vtoi(int *h){
  int res = 0;
  for(int i = 3; i >= 0; --i){
    res *= 7;
    res += h[i];
  }
  return res;
}

void itov(int c, int *h){
  REP(i, 4){
    h[i] = c % 7;
    c /= 7;
  }
}

int check(int d, int y, int x, int c){
  int h[4];
  itov(c, h);
  h[0] = (y == 0 && x == 0 ? 0 : h[0] + 1);
  h[1] = (y == 0 && x == 2 ? 0 : h[1] + 1);
  h[2] = (y == 2 && x == 0 ? 0 : h[2] + 1);
  h[3] = (y == 2 && x == 2 ? 0 : h[3] + 1);
  REP(i, 4) if(h[i] >= 7) return -1;
  REP(i, 2) REP(j, 2) if(v[d][y + i][x + j]) return -1;
  return vtoi(h);
}

int solve(){
  if(v[0][1][1] || v[0][1][2] || v[0][2][1] || v[0][2][2]) return 0;
  memset(dp, 0, sizeof(dp));
  dp[0][4][400] = 1;
  REP(a, D - 1){
    REP(b, MAX_B){
      REP(c, MAX_C){
        if(!dp[a][b][c]) continue;
        int nc;
        if((nc = check(a + 1, b / 3, b % 3, c)) != -1) dp[a + 1][b][nc] = 1;
        for(int i = -1; i <= 1; ++i){
          for(int j = -1; j <= 1; ++j){
            if((i != 0 && j != 0) || (i == 0 && j == 0)) continue;
            int y = b / 3 + i, x = b % 3 + j;
            while(y >= 0 && y <= 2 && x >= 0 && x <= 2){
              if((nc = check(a + 1, y, x, c)) != -1) dp[a + 1][y * 3 + x][nc] = 1;
              y += i; x += j;
            }
          }
        }
      }
    }
  }
  bool res = 0;
  REP(i, MAX_B) REP(j, MAX_C) if(dp[D - 1][i][j]) res = 1;
  return res;
}

int main() {
  while(cin >>D && D){
    REP(i, D) REP(j, 4) REP(k, 4) cin >>v[i][j][k];
    cout <<solve() <<endl;
  }
    return 0;
}