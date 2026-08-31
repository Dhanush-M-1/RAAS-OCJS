#include <bits/stdc++.h>
using namespace std;
vector<int> r[2000000 + 10], c[2000000 + 10];
int n, ans = 0;
int xx[100010], yy[100010];
char buf[5000000], *pt = buf;
inline int getint() {
  int x = 0, f = 1;
  while ((*pt != '-') && (*pt < '0' || *pt > '9')) pt++;
  if (*pt == '-') f = -1, pt++;
  while (*pt >= '0' && *pt <= '9') x = x * 10 + *pt++ - 48;
  return x * f;
}
int main() {
  fread(buf, 1, 5000000, stdin);
  n = getint();
  int x, y;
  int mx = 2000000 + 1, my = 2000000 + 1, maxx = 0, maxy = 0;
  for (int i = 1; i <= n; i++) {
    xx[i] = getint();
    yy[i] = getint();
    mx = min(mx, xx[i]);
    my = min(my, yy[i]);
  }
  for (int i = 1; i <= n; i++) {
    xx[i] -= mx;
    yy[i] -= my;
    r[xx[i]].push_back(yy[i]);
    c[yy[i]].push_back(xx[i]);
    maxx = max(xx[i], maxx);
    maxy = max(yy[i], maxy);
  }
  for (int i = 0; i <= maxx; i++) sort(r[i].begin(), r[i].end());
  for (int i = 0; i <= maxy; i++) sort(c[i].begin(), c[i].end());
  int ix, iy, tx, ty;
  for (int i = 0; i <= maxx; i++) {
    for (int j = 0; j < r[i].size(); j++) {
      x = i, y = r[i][j];
      iy = j + 1,
      ix = lower_bound(c[y].begin(), c[y].end(), x) - c[y].begin() + 1;
      while (ix < c[y].size() && iy < r[x].size()) {
        tx = c[y][ix], ty = r[x][iy];
        if (tx - x < ty - y)
          ++ix;
        else if (tx - x > ty - y)
          ++iy;
        else {
          if (binary_search(r[tx].begin(), r[tx].end(), ty)) ++ans;
          ++ix;
          ++iy;
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
