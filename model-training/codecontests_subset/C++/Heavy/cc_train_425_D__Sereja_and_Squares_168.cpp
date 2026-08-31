#include <bits/stdc++.h>
using namespace std;
int n, kk;
int x[211111], y[211111];
vector<int> vx[211111], vy[211111];
long long yy[211111];
int pp[211111], xx[1222000];
void add(int x, int y) {
  long long e = (x + 1) * 100111ll + (y + 1);
  int o = e % 1000007;
  yy[++kk] = e;
  pp[kk] = xx[o];
  xx[o] = kk;
}
bool fin(int x, int y) {
  if (x < 0 || x > 100000) return 0;
  if (y < 0 || y > 100000) return 0;
  long long e = (x + 1) * 100111ll + (y + 1);
  int o = e % 1000007;
  for (int w = xx[o]; w; w = pp[w])
    if (yy[w] == e) return 1;
  return 0;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x[i], &y[i]);
    vx[x[i]].push_back(y[i]);
    vy[y[i]].push_back(x[i]);
    add(x[i], y[i]);
  }
  for (int i = 0; i <= 100000; i++) {
    sort(vx[i].begin(), vx[i].end());
    sort(vy[i].begin(), vy[i].end());
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int xx = x[i];
    int yy = y[i];
    int d;
    if (vx[xx].size() < vy[yy].size()) {
      for (int j = 0; j < vx[xx].size(); j++) {
        if (vx[xx][j] == yy) break;
        d = yy - vx[xx][j];
        if (fin(xx - d, yy) && fin(xx - d, yy - d)) ans++;
      }
    } else {
      for (int j = 0; j < vy[yy].size(); j++) {
        if (vy[yy][j] == xx) break;
        d = xx - vy[yy][j];
        if (fin(xx, yy - d) && fin(xx - d, yy - d)) ans++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
