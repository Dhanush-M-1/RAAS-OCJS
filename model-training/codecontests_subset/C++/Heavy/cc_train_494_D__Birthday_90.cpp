#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 9;
const int mod = 1e9 + 7;
int s[N], st[N], ed[N], n, tot, ans[N];
long long sq[N << 2], sum[N << 2], ch[N << 2];
vector<pair<int, int> > adj[N];
vector<int> qu[N];
int rend(int v, int b, int e, int x) {
  ch[v] = (ch[v] + x) % mod;
  sq[v] = (sq[v] + (x * 1LL * x % mod) * (e - b) + sum[v] * x * 2) % mod;
  sum[v] = (x * 1LL * (e - b) + sum[v]) % mod;
}
void spread(int v, int b, int e) {
  int mid = b + e >> 1, l = v << 1, r = l | 1;
  rend(l, b, mid, ch[v]);
  rend(r, mid, e, ch[v]);
  ch[v] = 0;
}
void renew(int v) {
  int l = v << 1, r = l | 1;
  sq[v] = (sq[l] + sq[r]) % mod;
  sum[v] = (sum[l] + sum[r]) % mod;
}
void update(int i, int j, int x, int v = 1, int b = 0, int e = n) {
  if (i >= e || b >= j) return;
  if (i <= b && e <= j) {
    rend(v, b, e, x);
    return;
  }
  int mid = b + e >> 1, l = v << 1, r = l | 1;
  spread(v, b, e);
  update(i, j, x, l, b, mid);
  update(i, j, x, r, mid, e);
  renew(v);
}
int query(int i, int j, int v = 1, int b = 0, int e = n) {
  if (i >= e || b >= j) return 0;
  if (i <= b && e <= j) return sq[v];
  int mid = b + e >> 1, l = v << 1, r = l | 1;
  spread(v, b, e);
  return (query(i, j, l, b, mid) + query(i, j, r, mid, e)) % mod;
}
void dfs_init(int v, int p = -1, int d = 0) {
  st[v] = tot++;
  update(st[v], st[v] + 1, d);
  for (int i = 0; i < (int)adj[v].size(); i++)
    if (adj[v][i].first != p) {
      int u = adj[v][i].first, w = adj[v][i].second;
      dfs_init(u, v, (d + w) % mod);
    }
  ed[v] = tot;
}
void dfs_ans(int v, int p = -1) {
  for (int i = 0; i < (int)adj[v].size(); i++)
    if (adj[v][i].first != p) {
      int u = adj[v][i].first, w = adj[v][i].second;
      update(st[0], ed[0], w);
      update(st[u], ed[u], (-2 * w + 2 * mod) % mod);
      dfs_ans(u, v);
      update(st[0], ed[0], (-w + mod) % mod);
      update(st[u], ed[u], 2 * w % mod);
    }
  for (int i = 0; i < (int)qu[v].size(); i++) {
    int id = qu[v][i], u = s[id];
    ans[id] = (0LL + -query(st[0], ed[0]) + 2 * query(st[u], ed[u]) +
               100 * 1LL * mod) %
              mod;
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    s[i] = v;
    qu[u].push_back(i);
  }
  dfs_init(0);
  dfs_ans(0);
  for (int i = 0; i < q; i++) cout << ans[i] << '\n';
  return 0;
}
