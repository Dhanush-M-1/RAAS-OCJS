#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
inline int add(int a, int b) {
  if ((a += b) >= mod) a -= mod;
  return a;
}
inline int dec(int a, int b) {
  if ((a -= b) < 0) a += mod;
  return a;
}
inline int mult(int a, int b) {
  long long t = 1ll * a * b;
  if (t >= mod) t %= mod;
  return t;
}
int n;
vector<pair<int, int> > v[100010];
class node {
 public:
  int siz, sum, sqr;
} dp[100010], tot[100010];
int dis[100010], st[100010][18], dep[100010];
void dfs(int np, int fath) {
  dp[np] = (node){1, 0, 0};
  dep[np] = dep[fath] + 1;
  st[np][0] = fath;
  for (int i = 1; i < 18; i++) st[np][i] = st[st[np][i - 1]][i - 1];
  for (auto &x : v[np]) {
    if (x.first == fath) continue;
    dis[x.first] = add(dis[np], x.second);
    dfs(x.first, np);
    dp[np].siz += dp[x.first].siz;
    dp[np].sum =
        add(add(dp[np].sum, dp[x.first].sum), mult(dp[x.first].siz, x.second));
    dp[np].sqr = add(add(dp[np].sqr, dp[x.first].sqr),
                     add(mult(2, mult(dp[x.first].sum, x.second)),
                         mult(dp[x.first].siz, mult(x.second, x.second))));
  }
}
void dfs2(int np, int fath) {
  for (auto &x : v[np]) {
    if (x.first == fath) continue;
    node tmp;
    tmp.siz = tot[np].siz - dp[x.first].siz;
    tmp.sum =
        dec(tot[np].sum, add(dp[x.first].sum, mult(dp[x.first].siz, x.second)));
    tmp.sqr = dec(tot[np].sqr,
                  add(dp[x.first].sqr,
                      add(mult(2, mult(dp[x.first].sum, x.second)),
                          mult(dp[x.first].siz, mult(x.second, x.second)))));
    tot[x.first].siz = n;
    tot[x.first].sum =
        add(add(dp[x.first].sum, tmp.sum), mult(x.second, tmp.siz));
    tot[x.first].sqr = add(add(dp[x.first].sqr, tmp.sqr),
                           add(mult(2, mult(tmp.sum, x.second)),
                               mult(tmp.siz, mult(x.second, x.second))));
    dfs2(x.first, np);
  }
}
inline int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 17; i >= 0; i--)
    if (dep[st[x][i]] >= dep[y]) x = st[x][i];
  if (x == y) return x;
  for (int i = 17; i >= 0; i--)
    if (st[x][i] != st[y][i]) x = st[x][i], y = st[y][i];
  return st[x][0];
}
int main() {
  scanf("%d", &n);
  for (int i = 1, ti, tj, tk; i < n; i++) {
    scanf("%d%d%d", &ti, &tj, &tk);
    v[ti].push_back(make_pair(tj, tk));
    v[tj].push_back(make_pair(ti, tk));
  }
  dfs(1, 0);
  tot[1] = dp[1];
  dfs2(1, 0);
  int Q;
  scanf("%d", &Q);
  while (Q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    int l = lca(x, y);
    int d = dec(add(dis[x], dis[y]), add(dis[l], dis[l]));
    if (l != y) {
      int tmp = add(dp[y].sqr, add(mult(2, mult(dp[y].sum, d)),
                                   mult(dp[y].siz, mult(d, d))));
      printf("%d\n", dec(add(tmp, tmp), tot[x].sqr));
    } else {
      node t;
      t.siz = tot[y].siz - dp[y].siz;
      t.sum = dec(tot[y].sum, dp[y].sum);
      t.sqr = dec(tot[y].sqr, dp[y].sqr);
      int tmp =
          add(t.sqr, add(mult(2, mult(d, t.sum)), mult(t.siz, mult(d, d))));
      printf("%d\n", dec(tot[x].sqr, add(tmp, tmp)));
    }
  }
  return 0;
}
