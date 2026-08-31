#include <bits/stdc++.h>
using namespace std;
int get() {
  char c;
  while (c = getchar(), (c < '0' || c > '9') && (c != '-'))
    ;
  bool flag = (c == '-');
  if (flag) c = getchar();
  int x = 0;
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - 48;
    c = getchar();
  }
  return flag ? -x : x;
}
void output(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  int len = 0, data[10];
  while (x) {
    data[len++] = x % 10;
    x /= 10;
  }
  if (!len) data[len++] = 0;
  while (len--) putchar(data[len] + 48);
  putchar('\n');
}
const int maxn = 100000;
const int maxsize = 262144;
const int mod = 1000000007;
int n, counter;
vector<pair<int, int> > g[maxn], q[maxn];
int seq[maxn], dfn[maxn], dfn2[maxn], parent[maxn], depth[maxn];
int Left[maxsize], Right[maxsize];
long long s1[maxsize], s2[maxsize], delta[maxsize];
long long ans[maxn];
void dfs(int x, int last, int d) {
  seq[counter] = x;
  dfn[x] = counter++;
  parent[x] = last;
  depth[x] = d;
  for (int i = 0; i < g[x].size(); i++)
    if (g[x][i].first != last)
      dfs(g[x][i].first, x, (d + g[x][i].second) % mod);
  dfn2[x] = counter;
}
void build(int p, int l, int r) {
  Left[p] = l;
  Right[p] = r;
  if (l == r) {
    s1[p] = depth[seq[l]];
    s2[p] = s1[p] * s1[p] % mod;
  } else {
    int mid = (l + r) / 2;
    build(p * 2, l, mid);
    build(p * 2 + 1, mid + 1, r);
    s1[p] = (s1[p * 2] + s1[p * 2 + 1]) % mod;
    s2[p] = (s2[p * 2] + s2[p * 2 + 1]) % mod;
  }
}
void check(int p) {
  if (!delta[p]) return;
  long long len = Right[p] - Left[p] + 1;
  s2[p] = (s2[p] + s1[p] * delta[p] * 2) % mod;
  s2[p] = (s2[p] + delta[p] * delta[p] % mod * len) % mod;
  s1[p] = (s1[p] + delta[p] * len) % mod;
  if (len > 1) {
    delta[p * 2] = (delta[p * 2] + delta[p]) % mod;
    delta[p * 2 + 1] = (delta[p * 2 + 1] + delta[p]) % mod;
  }
  delta[p] = 0;
}
void add(int p, int l, int r, long long d) {
  if (l > r) return;
  check(p);
  if (Left[p] == l && Right[p] == r) {
    delta[p] = (delta[p] + d) % mod;
    return;
  }
  int mid = (Left[p] + Right[p]) / 2;
  if (r <= mid)
    add(p * 2, l, r, d);
  else if (l > mid)
    add(p * 2 + 1, l, r, d);
  else {
    add(p * 2, l, mid, d);
    add(p * 2 + 1, mid + 1, r, d);
  }
  check(p * 2);
  check(p * 2 + 1);
  s1[p] = (s1[p * 2] + s1[p * 2 + 1]) % mod;
  s2[p] = (s2[p * 2] + s2[p * 2 + 1]) % mod;
}
long long getsum(int p, int l, int r) {
  check(p);
  if (Left[p] == l && Right[p] == r) return s2[p];
  int mid = (Left[p] + Right[p]) / 2;
  if (r <= mid) return getsum(p * 2, l, r);
  if (l > mid) return getsum(p * 2 + 1, l, r);
  return getsum(p * 2, l, mid) + getsum(p * 2 + 1, mid + 1, r);
}
void solve(int x) {
  for (int i = 0; i < q[x].size(); i++) {
    int y = q[x][i].first, num = q[x][i].second;
    ans[num] = (getsum(1, dfn[y], dfn2[y] - 1) * 2 - getsum(1, 0, n - 1)) % mod;
    if (ans[num] < 0) ans[num] += mod;
  }
  for (int i = 0; i < g[x].size(); i++) {
    int y = g[x][i].first, w = g[x][i].second;
    if (y == parent[x]) continue;
    add(1, dfn[y], dfn2[y] - 1, -w);
    add(1, 0, dfn[y] - 1, w);
    add(1, dfn2[y], n - 1, w);
    solve(y);
    add(1, dfn[y], dfn2[y] - 1, w);
    add(1, 0, dfn[y] - 1, -w);
    add(1, dfn2[y], n - 1, -w);
  }
}
int main() {
  n = get();
  for (int i = 1; i < n; i++) {
    int x = get() - 1, y = get() - 1, w = get();
    g[x].push_back(make_pair(y, w));
    g[y].push_back(make_pair(x, w));
  }
  int m = get();
  for (int i = 0; i < m; i++) {
    int x = get() - 1, y = get() - 1;
    q[x].push_back(make_pair(y, i));
  }
  counter = 0;
  dfs(0, -1, 0);
  build(1, 0, n - 1);
  memset(delta, 0, sizeof(delta));
  solve(0);
  for (int i = 0; i < m; i++) output(ans[i]);
  return 0;
}
