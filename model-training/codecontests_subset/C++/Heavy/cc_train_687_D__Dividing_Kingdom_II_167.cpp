#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
int n, m, q, a[1000005], b[1000005], w[1000005];
vector<int> t[4 * 1000005], c[4 * 1000005];
pair<int, int> par[1005];
int sz[1005];
pair<int, int> Find(int v) {
  if (v != par[v].first) {
    int w = par[v].second;
    par[v] = Find(par[v].first);
    par[v].second ^= w;
  }
  return par[v];
}
int Union(int a, int b) {
  pair<int, int> pa = Find(a);
  int x = pa.second;
  a = pa.first;
  pair<int, int> pb = Find(b);
  int y = pb.second;
  b = pb.first;
  if (a == b) {
    if (x == y) return -1;
    return 1;
  }
  if (sz[a] < sz[b]) swap(a, b);
  par[b] = {a, x ^ y ^ 1};
  sz[a] += sz[b];
  return 0;
}
void MERGE(vector<int> &c, vector<int> &a, vector<int> &b) {
  int i = 0, j = 0, n = a.size(), m = b.size();
  while (i != n || j != m) {
    if (j == m || (i != n && w[a[i]] > w[b[j]]))
      c.push_back(a[i++]);
    else
      c.push_back(b[j++]);
  }
}
void build(int v, int tl, int tr) {
  int m = (tl + tr) / 2, i;
  if (tl == tr) {
    t[v].push_back(tl);
    return;
  }
  build(v * 2, tl, m);
  build(v * 2 + 1, m + 1, tr);
  MERGE(t[v], t[v * 2], t[v * 2 + 1]);
  for (i = 0; i < t[v].size(); i++) {
    int u = a[t[v][i]];
    par[u] = {u, 0};
    sz[u] = 1;
    u = b[t[v][i]];
    par[u] = {u, 0};
    sz[u] = 1;
  }
  vector<int> nw;
  for (i = 0; i < t[v].size(); i++) {
    int x = Union(a[t[v][i]], b[t[v][i]]);
    if (x != 1) nw.push_back(t[v][i]);
    if (x == -1) break;
  }
  swap(t[v], nw);
}
void get(int v, int tl, int tr, int l, int r) {
  int m = (tl + tr) / 2, i;
  if (l > r) return;
  if (tl == l && tr == r) {
    c[v] = t[v];
    return;
  }
  get(v * 2, tl, m, l, min(m, r));
  get(v * 2 + 1, m + 1, tr, max(l, m + 1), r);
  if (c[v * 2].empty()) swap(c[v], c[v * 2 + 1]);
  if (c[v * 2 + 1].empty()) swap(c[v], c[v * 2]);
  if (c[v].empty()) MERGE(c[v], c[v * 2], c[v * 2 + 1]);
  c[v * 2].clear();
  c[v * 2 + 1].clear();
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie();
  int i;
  cin >> n >> m >> q;
  for (i = 0; i < m; i++) {
    cin >> a[i] >> b[i] >> w[i];
    a[i]--;
    b[i]--;
  }
  build(1, 0, m - 1);
  while (q--) {
    int l, r;
    cin >> l >> r;
    l--;
    r--;
    get(1, 0, m - 1, l, r);
    vector<int> s;
    swap(s, c[1]);
    for (i = 0; i < s.size(); i++) {
      int v = a[s[i]];
      par[v] = {v, 0};
      sz[v] = 1;
      v = b[s[i]];
      par[v] = {v, 0};
      sz[v] = 1;
    }
    for (i = 0; i < s.size(); i++) {
      int x = Union(a[s[i]], b[s[i]]);
      if (x == -1) {
        cout << w[s[i]] << "\n";
        break;
      }
    }
    if (i == s.size()) cout << "-1\n";
  }
  return 0;
}
