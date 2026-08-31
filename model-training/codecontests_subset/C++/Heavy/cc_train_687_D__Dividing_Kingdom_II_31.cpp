#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimization("unroll-loops, no-stack-protector")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const long long maxn = 1e6 + 530;
const long long mod = 998244353;
const long long base = 1e9;
long long par[maxn][2];
long long find_par(long long u, long long t) {
  if (par[u][t] < 0) return u;
  return par[u][t] = find_par(par[u][t], t);
}
void dsu(long long x, long long y, long long t) {
  if (x == 0 || y == 0) return;
  x = find_par(x, t);
  y = find_par(y, t);
  if (x == y) return;
  if (par[x][t] > par[y][t]) swap(x, y);
  par[x][t] += par[y][t];
  par[y][t] = x;
}
struct tk {
  long long x, y, w, pos;
};
long long nxt[maxn];
tk a[maxn];
bool lf(tk a, tk b) { return a.w > b.w; }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  if (fopen("t.inp", "r")) {
    freopen("test.inp", "r", stdin);
    freopen("test.out", "w", stdout);
  }
  long long n, m, q;
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> a[i].x >> a[i].y >> a[i].w;
    a[i].pos = i;
  }
  sort(a + 1, a + m + 1, lf);
  while (q--) {
    long long l, r;
    cin >> l >> r;
    for (int i = 1; i <= n; i++) {
      par[i][0] = -1;
      par[i][1] = -1;
      nxt[i] = 0;
    }
    long long ans = -1;
    for (int i = 1; i <= m; i++) {
      if (a[i].pos > r || a[i].pos < l) continue;
      long long x = a[i].x;
      long long y = a[i].y;
      long long x1 = find_par(x, 0);
      long long y1 = find_par(y, 0);
      if (x1 == y1) {
        x = find_par(x, 1);
        y = find_par(y, 1);
        if (x == y) {
          ans = a[i].w;
          break;
        }
      } else {
        dsu(x1, y1, 0);
        dsu(x, nxt[y], 1);
        dsu(y, nxt[x], 1);
        nxt[x] = y;
        nxt[y] = x;
      }
    }
    cout << ans << "\n";
  }
}
