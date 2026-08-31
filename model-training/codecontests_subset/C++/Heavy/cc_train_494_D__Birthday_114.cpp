#include <bits/stdc++.h>
using namespace std;
long long p[400010], s[400010], tt[400010], dis2[400010], dis[400010],
    dist[400010], a, b, c, i, j, w[400010], d[400010], ans[400010];
long long dp, pre[400010], n, q, tmp, t, dd;
long long r[400010], st[400010][20], deep[400010], tot;
void link(int x, int y, int z) {
  dp++;
  pre[dp] = p[x];
  p[x] = dp;
  tt[dp] = y;
  w[dp] = z;
}
int mi(int a, int b) {
  if (deep[a] < deep[b]) return a;
  return b;
}
int lca(int a, int b) {
  int k;
  a = r[a];
  b = r[b];
  if (b < a) {
    k = a;
    a = b;
    b = k;
  }
  k = (int)log2(b - a + 1);
  return mi(st[a][k], st[b - (1 << k) + 1][k]);
}
void dfs(int x, int fa) {
  int i;
  i = p[x];
  s[x] = 1;
  tot++;
  r[x] = tot;
  st[tot][0] = x;
  while (i) {
    if (tt[i] != fa) {
      dist[tt[i]] = (dist[x] + w[i]) % 1000000007;
      deep[tt[i]] = deep[x] + 1;
      dfs(tt[i], x);
      tot++;
      st[tot][0] = x;
      s[x] = s[x] + s[tt[i]];
      dis[x] =
          (dis[x] + dis[tt[i]] + (s[tt[i]] * w[i]) % 1000000007) % 1000000007;
      dis2[x] = (dis2[x] + dis2[tt[i]] +
                 ((s[tt[i]] * w[i]) % 1000000007 * w[i]) % 1000000007 +
                 2 * (w[i] * dis[tt[i]]) % 1000000007) %
                1000000007;
    }
    i = pre[i];
  }
}
void cnt1(int x, int fa) {
  int i;
  i = p[x];
  while (i) {
    if (tt[i] != fa) {
      d[tt[i]] = (d[x] - (s[tt[i]] * w[i]) % 1000000007 +
                  (n - s[tt[i]]) * w[i] % 1000000007) %
                 1000000007;
      cnt1(tt[i], x);
    }
    i = pre[i];
  }
}
void cnt2(int x, int fa) {
  int i;
  i = p[x];
  while (i) {
    if (tt[i] != fa) {
      ans[tt[i]] =
          (ans[x] -
           (dis2[tt[i]] + ((w[i] * w[i]) % 1000000007) * s[tt[i]] % 1000000007 +
            2 * dis[tt[i]] * w[i] % 1000000007) +
           ((w[i] * w[i]) % 1000000007) * (n - s[tt[i]]) % 1000000007 +
           2 * w[i] * (d[x] - dis[tt[i]] - (s[tt[i]] * w[i]) % 1000000007) %
               1000000007 +
           dis2[tt[i]]) %
          1000000007;
      cnt2(tt[i], x);
    }
    i = pre[i];
  }
}
int main() {
  cin >> n;
  for (i = 1; i <= n - 1; i++) {
    cin >> a >> b >> c;
    link(a, b, c);
    link(b, a, c);
  }
  dfs(1, 0);
  for (i = tot; i >= 1; i--) {
    a = (int)log2(tot);
    for (j = 1; j <= a; j++)
      st[i][j] = mi(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
  }
  d[1] = dis[1];
  ans[1] = dis2[1];
  cnt1(1, 0);
  cnt2(1, 0);
  cin >> q;
  for (i = 1; i <= q; i++) {
    cin >> a >> b;
    c = lca(a, b);
    dd = (dist[a] + dist[b] - 2 * dist[c]) % 1000000007;
    if (c != b) {
      t = ((2 * (dis2[b] + ((s[b] * dd) % 1000000007) * dd % 1000000007 +
                 2 * (dd * dis[b]) % 1000000007) -
            ans[a]) %
               1000000007 +
           1000000007) %
          1000000007;
    } else {
      tmp = (ans[b] - dis2[b] + ((n - s[b]) * dd) % 1000000007 * dd +
             2 * dd * (d[b] - dis[b])) %
            1000000007;
      t = ((ans[a] - 2 * tmp) % 1000000007 + 1000000007) % 1000000007;
    }
    t = (t + 1000000007) % 1000000007;
    cout << t << endl;
  }
}
