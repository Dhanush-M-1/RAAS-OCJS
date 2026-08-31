#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const int mod = 1e9 + 7;
long long mark[N], st[N], ft[N], lzy[4 * N], ans[N], n, t;
pair<long long, long long> seg[4 * N];
vector<pair<long long, long long> > adj[N], qry[N];
void add(int id, int l, int r, long long x) {
  seg[id].first = (seg[id].first + 2LL * seg[id].second * x +
                   (x * x) % mod * 1LL * (r - l)) %
                  mod;
  seg[id].second = (seg[id].second + x * (r - l)) % mod;
  lzy[id] = (lzy[id] + x) % mod;
}
void shift(int id, int l, int r) {
  int md = (l + r) >> 1;
  add(id << 1, l, md, lzy[id]);
  add(id << 1 | 1, md, r, lzy[id]);
  lzy[id] = 0;
}
void upd(int l, int r, long long x, int s = 0, int e = n, int id = 1) {
  if (e <= l || r <= s) return;
  if (l <= s && e <= r) {
    add(id, s, e, x);
    return;
  }
  shift(id, s, e);
  int md = (s + e) >> 1;
  upd(l, r, x, s, md, id << 1);
  upd(l, r, x, md, e, id << 1 | 1);
  seg[id].first = (seg[id << 1].first + seg[id << 1 | 1].first) % mod;
  seg[id].second = (seg[id << 1].second + seg[id << 1 | 1].second) % mod;
}
long long get(int l, int r, int s = 0, int e = n, int id = 1) {
  if (e <= l || r <= s) return 0;
  if (l <= s && e <= r) return seg[id].first;
  shift(id, s, e);
  int md = (s + e) >> 1;
  return (get(l, r, s, md, id << 1) + get(l, r, md, e, id << 1 | 1)) % mod;
}
void preDFS(int v, long long d = 0) {
  mark[v] = 1;
  st[v] = t++;
  upd(st[v], st[v] + 1, d % mod);
  for (pair<long long, long long> e : adj[v])
    if (!mark[e.first]) preDFS(e.first, d + e.second);
  ft[v] = t;
}
void DFS(int v) {
  mark[v] = 1;
  for (pair<long long, long long> p : qry[v]) {
    int u = p.first, id = p.second;
    ans[id] = (2LL * get(st[u], ft[u]) - seg[1].first) % mod;
  }
  for (pair<long long, long long> e : adj[v]) {
    int u = e.first, w = e.second;
    if (mark[u]) continue;
    upd(0, n, w);
    upd(st[u], ft[u], -2 * w);
    DFS(u);
    upd(st[u], ft[u], 2 * w);
    upd(0, n, -w);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back(make_pair(v, w));
    adj[v].push_back(make_pair(u, w));
  }
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int u, v;
    cin >> u >> v;
    qry[u].push_back(make_pair(v, i));
  }
  preDFS(1);
  memset(mark, 0, sizeof mark);
  DFS(1);
  for (int i = 0; i < q; i++) cout << (ans[i] + mod) % mod << '\n';
  return 0;
}
