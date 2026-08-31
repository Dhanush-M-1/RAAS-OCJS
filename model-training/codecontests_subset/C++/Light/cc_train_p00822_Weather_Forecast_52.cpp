#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <complex>
#include <queue>
#include <map>
#include <set>
#include <cstring>
#include <cstdlib>
#include <string>
#include <cmath>
using namespace std;

#define REP(i,n) for(int i=0;i<(int)n;++i)
#define FOR(i,c) for(__typeof((c).begin())i=(c).begin();i!=(c).end();++i)
#define ALL(c) (c).begin(), (c).end()
const int INF = 1<<29;

int n;
int ba[365][4][4];
bool memo[365][3][3][7*7*7*7];
bool visited[365][3][3][7*7*7*7];

int dx[] = {0,1,0,-1};
int dy[] = {1,0,-1,0};

int hogex[] = {0, 0, 2, 2};
int hogey[] = {0, 2, 0, 2};

bool solve(int day, int y, int x, int S) {
  if (visited[day][y][x][S]) return memo[day][y][x][S];
  visited[day][y][x][S] = 1;
  
  REP(i, 2) 
    REP(j, 2)
      if (ba[day][y+i][x+j]) return memo[day][y][x][S]=0;

  if (day == n-1) return memo[day][y][x][S]=1;

  // l÷ÌîñvZ
  int tmp = S;
  int norain[4];
  REP(i,4) {
    norain[i] = tmp%7;
    tmp /= 7;
  }
  // ÌúÖ
  REP(i, 4) {
    int xx = x, yy = y;
    if (i) {
      xx+=dx[i]; yy+=dy[i];
    }
    while(0<=xx&&xx<=2&&0<=yy&&yy<=2) {
      int nextS = 0;
      int tmp = 1;
      bool f = 0;
      REP(j, 4) {
        if (!(xx==hogex[j] && yy==hogey[j])) {
          if (norain[j] == 6) f = 1;
          nextS += tmp * (norain[j] + 1);
        }
        tmp *= 7;
      }
      if (!f && solve(day+1, yy, xx, nextS))
        return memo[day][y][x][S]=1;
      yy += dy[i];
      xx += dx[i];
    }
  }
  return memo[day][y][x][S]=0;
}

int main() {
  while(cin>>n,n) {
    REP(i, n) REP(j,4) REP(k,4) 
      cin >> ba[i][j][k];
    memset(visited,0,sizeof(visited));
    cout <<  (solve(0, 1, 1, 400)? 1: 0) << endl;
  }
}