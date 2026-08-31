#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100020;
struct point {
  int x, y, z;
  void init() {
    scanf("%d %d", &x, &y);
    z = x - y;
  }
} p[MAXN];
typedef int arr32[MAXN];
arr32 X, Y, Z, xp, yp, zp;
int n, xt, yt, zt;
bool cmp(const int& a, const int& b) {
  return xp[a] < xp[b] || (xp[a] == xp[b] && yp[a] < yp[b]);
}
struct Link {
  int next[MAXN];
  vector<int> e[MAXN];
  int N;
  void insert(int x, int pos) { e[x].push_back(pos); }
  void build(int Sz) {
    N = Sz;
    for (int i = 1; i <= N; i++) {
      sort(e[i].begin(), e[i].end(), cmp);
      for (unsigned int j = 0; j + 1 < e[i].size(); j++)
        next[e[i][j]] = e[i][j + 1];
    }
  }
} xk, yk, zk;
int dist(int a, int b) { return max(p[a].x - p[b].x, p[a].y - p[b].y); }
int ans;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++)
    p[i].init(), X[i] = p[i].x, Y[i] = p[i].y, Z[i] = p[i].z;
  sort(X + 1, X + n + 1);
  xt = unique(X + 1, X + n + 1) - X - 1;
  sort(Y + 1, Y + n + 1);
  yt = unique(Y + 1, Y + n + 1) - Y - 1;
  sort(Z + 1, Z + n + 1);
  zt = unique(Z + 1, Z + n + 1) - Z - 1;
  for (int i = 1; i <= n; i++) {
    xp[i] = lower_bound(X + 1, X + xt + 1, p[i].x) - X;
    yp[i] = lower_bound(Y + 1, Y + yt + 1, p[i].y) - Y;
    zp[i] = lower_bound(Z + 1, Z + zt + 1, p[i].z) - Z;
    xk.insert(xp[i], i);
    yk.insert(yp[i], i), zk.insert(zp[i], i);
  }
  xk.build(xt), yk.build(yt), zk.build(zt);
  for (int i = 1; i <= n; i++) {
    int xv = xk.next[i], yv = yk.next[i], zv = zk.next[i];
    int xd = dist(xv, i), yd = dist(yv, i), zd = dist(zv, i);
    for (; xv && yv && zv;) {
      if (xd == yd && yd == zd) ans++;
      if (xd < yd && xd < zd)
        xv = xk.next[xv], xd = dist(xv, i);
      else if (yd < zd)
        yv = yk.next[yv], yd = dist(yv, i);
      else
        zv = zk.next[zv], zd = dist(zv, i);
    }
  }
  cout << ans << endl;
  return 0;
}
