#include <iostream>
#include <algorithm>

using namespace std;

const int N = 365;

int dat[N][16], n;
bool vis[N+1][9][7][7][7][7];

int dfs(int d, int p, int k0, int k1, int k2, int k3){
  static int dy[4] = {-1, 0, 1, 0};
  static int dx[4] = {0, 1, 0, -1};
  if(d == n) return 1;
  int nk0 = k0, nk1 = k1, nk2 = k2, nk3 = k3;
  if(p == 0) nk0 = 0;
  if(p == 2) nk1 = 0;
  if(p == 8) nk2 = 0;
  if(p == 10) nk3 = 0;
  if(nk0 >= 7 || nk1 >= 7 || nk2 >= 7 || nk3 >= 7) return 0;
  if(dat[d][p] == 1 || dat[d][p+1] == 1 || dat[d][p+4] == 1 || dat[d][p+5] == 1) return 0;
  if(vis[d][p][k0][k1][k2][k3]) return 0;
  vis[d][p][k0][k1][k2][k3] = 1;
  for(int j=0;j<3;j++){
    for(int i=0;i<4;i++){
      int ny = p / 4 + dy[i] * j;
      int nx = p % 4 + dx[i] * j;
      if(min(ny, nx) < 0 || max(ny, nx) > 2) continue;
      if(dfs(d + 1, ny*4 + nx, nk0+1, nk1+1, nk2+1, nk3+1)) return 1;
    }
  }
  return 0;
}

int main(){
  while(cin >> n && n){
    for(int i=0;i<n;++i) for(int j=0;j<16;++j) cin >> dat[i][j];
    fill(vis[0][0][0][0][0], vis[N+1][0][0][0][0], 0);
    cout << dfs(0, 5, 1, 1, 1, 1) << endl;
  }
}