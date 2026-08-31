#include <bits/stdc++.h>
using namespace std;
int n, k, a[200010], s, la[200010], f[200010], tg[200010], ans, p[200010],
    va[320][200010], pr[200010];
int bl(int x) { return (x - 1) / s + 1; }
void ins(int x, int y) {
  p[x] -= tg[bl(x)];
  ans = (ans + y) % 998244353ll;
  va[bl(x)][p[x] + n] = (va[bl(x)][p[x] + n] + y) % 998244353ll;
}
void md(int x, int y) {
  int po = bl(x);
  if (p[x] + tg[po] <= k) ans = (ans - f[x - 1] + 998244353ll) % 998244353ll;
  va[po][p[x] + n] = (va[po][p[x] + n] + 998244353ll - f[x - 1]) % 998244353ll;
  p[x] += y;
  if (p[x] + tg[po] <= k) ans = (ans + f[x - 1]) % 998244353ll;
  va[po][p[x] + n] = (va[po][p[x] + n] + f[x - 1]) % 998244353ll;
}
void mod(int l, int r, int v) {
  if (l > r) return;
  int p1 = bl(l), p2 = bl(r);
  if (p1 + 1 >= p2) {
    for (int i = l; i <= r; i++) md(i, v);
  } else {
    for (int i = l; i <= s * p1; i++) md(i, v);
    for (int i = (p2 - 1) * s + 1; i <= r; i++) md(i, v);
    for (int i = p1 + 1; i < p2; i++) {
      if (v != -1)
        ans = (ans - va[i][k - tg[i] + n] + 998244353ll) % 998244353ll;
      else
        ans = (ans + va[i][k - tg[i] + 1 + n]) % 998244353ll;
      tg[i] += v;
    }
  }
}
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pr[i] = la[a[i]];
    la[a[i]] = i;
  }
  s = sqrt(n);
  f[0] = 1;
  ins(1, 1);
  for (int i = 1; i <= n; i++) {
    mod(pr[i] + 1, i, 1);
    mod(pr[pr[i]] + 1, pr[i], -1);
    f[i] = ans;
    ins(i + 1, ans);
  }
  cout << f[n];
}
