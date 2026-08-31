#include <bits/stdc++.h>
using namespace std;
const long long N = 3e5 + 5;
const long long M = 1;
const long long K = 1;
const long long mod = 1e9 + 7;
const long long inf = 2e9;
const long long Inf = 2e18;
long long n, m, k, q;
vector<pair<long long, long long> > adj[N];
vector<pair<long long, pair<long long, long long> > > ed;
long long d[N];
void dick() {
  priority_queue<pair<long long, long long>,
                 vector<pair<long long, long long> >,
                 greater<pair<long long, long long> > >
      q;
  memset(d, 0x3f, sizeof d);
  for (long long i = 1; i <= k; ++i) {
    d[i] = 0;
    q.push({0, i});
  }
  while (q.size()) {
    pair<long long, long long> top = q.top();
    q.pop();
    long long pd = top.first;
    long long p = top.second;
    if (pd != d[p]) continue;
    for (pair<long long, long long> u : adj[p])
      if (pd + u.second < d[u.first]) {
        d[u.first] = pd + u.second;
        q.push({d[u.first], u.first});
      }
  }
}
vector<pair<long long, long long> > re[N];
long long par[N], res[N];
vector<long long> con[N];
void init() {
  for (long long i = 1; i <= n; ++i) {
    par[i] = i;
    con[i].push_back(i);
  }
}
long long get(long long x) {
  if (x == par[x]) return x;
  return par[x] = get(par[x]);
}
void mix(long long x, long long y, long long w) {
  long long u = get(x);
  long long v = get(y);
  if (u == v) return;
  if (con[u].size() > con[v].size()) swap(u, v);
  for (long long x : con[u]) {
    for (pair<long long, long long> i : re[x]) {
      long long id = i.second;
      long long j = i.first;
      if (get(j) == v) res[id] = w;
    }
    con[v].push_back(x);
  }
  par[u] = v;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (long long i = 1; i <= m; ++i) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  dick();
  for (long long i = 1; i <= n; ++i)
    for (pair<long long, long long> x : adj[i]) {
      long long dis = x.second + d[i] + d[x.first];
      ed.push_back({dis, {i, x.first}});
    }
  for (long long i = 1; i <= q; ++i) {
    long long u, v;
    cin >> u >> v;
    re[u].push_back({v, i});
    re[v].push_back({u, i});
  }
  init();
  sort(ed.begin(), ed.end());
  for (auto x : ed) mix(x.second.first, x.second.second, x.first);
  for (long long i = 1; i <= q; ++i) cout << res[i] << '\n';
}
