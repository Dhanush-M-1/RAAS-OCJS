#include <bits/stdc++.h>
const int N = 1e6 + 10;
const long long int INF = 1e18;
const int MOD = 998244353;
const int lgN = 20;
using namespace std;
long long int tree[4 * N], lz[4 * N], v[N], w[N];
void build(int node, int st, int en) {
  lz[node] = 0;
  if (st == en) {
    tree[node] = v[st];
    return;
  }
  int m = (st + en) / 2;
  build(2 * node + 1, st, m);
  build(2 * node + 2, m + 1, en);
  tree[node] = min(tree[2 * node + 1], tree[2 * node + 2]);
}
void pushdown(int node, int st, int en) {
  if (lz[node] > 0) {
    tree[node] -= lz[node];
    if (st < en) {
      lz[2 * node + 1] += lz[node];
      lz[2 * node + 2] += lz[node];
    }
    lz[node] = 0;
  }
}
void pupd(int pos, long long int val, int node, int st, int en) {
  pushdown(node, st, en);
  if (st == en) {
    tree[node] = val;
    return;
  }
  int m = (st + en) / 2;
  pushdown(2 * node + 1, st, m);
  pushdown(2 * node + 2, m + 1, en);
  if (pos <= m)
    pupd(pos, val, 2 * node + 1, st, m);
  else
    pupd(pos, val, 2 * node + 2, m + 1, en);
  tree[node] = min(tree[2 * node + 1], tree[2 * node + 2]);
}
void upd(int l, int r, int val, int node, int st, int en) {
  pushdown(node, st, en);
  if (st > r || en < l) return;
  int m = (st + en) / 2;
  if (st >= l && en <= r) {
    tree[node] -= val;
    if (st < en) {
      lz[2 * node + 1] += val;
      lz[2 * node + 2] += val;
    }
    return;
  }
  upd(l, r, val, 2 * node + 1, st, m);
  upd(l, r, val, 2 * node + 2, m + 1, en);
  tree[node] = min(tree[2 * node + 1], tree[2 * node + 2]);
}
int query(int node, int st, int en) {
  pushdown(node, st, en);
  if (st == en) return st;
  int m = (st + en) / 2;
  pushdown(2 * node + 1, st, m);
  pushdown(2 * node + 2, m + 1, en);
  if (tree[2 * node + 2] <= tree[2 * node + 1])
    return query(2 * node + 2, m + 1, en);
  return query(2 * node + 1, st, m);
}
void solve() {
  int n, i, go = 1;
  cin >> n;
  for (i = 0; i < n; i++) cin >> v[i];
  build(0, 0, n - 1);
  while (go <= n) {
    int ans = query(0, 0, n - 1);
    assert(ans >= 0 && ans <= n - 1);
    w[ans] = go;
    if (ans + 1 < n) upd(ans + 1, n - 1, go, 0, 0, n - 1);
    go++;
    pupd(ans, INF, 0, 0, n - 1);
  }
  for (i = 0; i < n; i++) cout << w[i] << " \n"[i == n - 1];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int T = 1;
  for (int t = 1; t <= T; t++) {
    solve();
  }
  return 0;
}
