#include <bits/stdc++.h>
using namespace std;
int const N = 400400;
int const mod = 1000000007;
void add(int &a, int b) {
  if ((a += b) >= mod) a -= mod;
}
int prod(int a, int b) { return (long long)a * b % mod; }
int sum[N], sq[N], down[N];
void apply(int v, int l, int r, int val) {
  add(sq[v], prod(2, prod(sum[v], val)));
  add(sq[v], prod(val, prod(val, r - l)));
  add(sum[v], prod(val, r - l));
  add(down[v], val);
}
void push(int v, int l, int r) {
  int m = (l + r) / 2;
  apply(2 * v + 1, l, m, down[v]);
  apply(2 * v + 2, m, r, down[v]);
  down[v] = 0;
}
void add(int v, int l, int r, int from, int to, int val) {
  if (r <= from || to <= l) return;
  if (from <= l && r <= to) {
    apply(v, l, r, val);
    return;
  }
  push(v, l, r);
  int m = (l + r) / 2;
  add(2 * v + 1, l, m, from, to, val);
  add(2 * v + 2, m, r, from, to, val);
  sum[v] = sum[2 * v + 1] + sum[2 * v + 2];
  add(sum[v], 0);
  sq[v] = sq[2 * v + 1] + sq[2 * v + 2];
  add(sq[v], 0);
}
int get_sq(int v, int l, int r, int from, int to) {
  if (r <= from || to <= l) return 0;
  if (from <= l && r <= to) return sq[v];
  push(v, l, r);
  int m = (l + r) / 2;
  int ans =
      get_sq(2 * v + 1, l, m, from, to) + get_sq(2 * v + 2, m, r, from, to);
  add(ans, 0);
  return ans;
}
int n;
vector<pair<int, int>> g[N];
int tin[N], tout[N];
void dfs(int v, int par) {
  static int timer = 0;
  tin[v] = timer++;
  for (auto e : g[v]) {
    if (e.first != par) {
      dfs(e.first, v);
      add(0, 0, n, tin[e.first], tout[e.first], e.second);
    }
  }
  tout[v] = timer;
}
int ans[N];
vector<pair<int, int>> qs[N];
void calc(int v, int par) {
  for (auto q : qs[v]) {
    int cur = get_sq(0, 0, n, tin[q.first], tout[q.first]);
    int all = get_sq(0, 0, n, 0, n);
    ans[q.second] = prod(2, cur);
    add(ans[q.second], mod - all);
  }
  for (auto e : g[v]) {
    if (e.first != par) {
      add(0, 0, n, 0, n, e.second);
      add(0, 0, n, tin[e.first], tout[e.first], mod - prod(2, e.second));
      calc(e.first, v);
      add(0, 0, n, 0, n, mod - e.second);
      add(0, 0, n, tin[e.first], tout[e.first], prod(2, e.second));
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    --a, --b;
    g[a].emplace_back(b, c);
    g[b].emplace_back(a, c);
  }
  dfs(0, -1);
  int q;
  scanf("%d", &q);
  for (int i = 0; i < q; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    --u, --v;
    qs[u].emplace_back(v, i);
  }
  calc(0, -1);
  for (int i = 0; i < q; ++i) cout << ans[i] << '\n';
}
