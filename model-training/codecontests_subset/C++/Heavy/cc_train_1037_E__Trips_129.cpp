#include <bits/stdc++.h>
using namespace std;
const long long N = 201102;
vector<long long> g[N];
set<pair<long long, long long> > s;
long long n, m, k, v, u, d[N], a[N], b[N], ans[N];
pair<long long, long long> x;
set<pair<long long, long long> >::iterator it;
map<long long, bool> e[N];
int main() {
  scanf("%lld%lld%lld", &n, &m, &k);
  for (long long i = 1; i <= m; i++) {
    scanf("%lld%lld", &v, &u);
    d[v]++, d[u]++;
    g[v].push_back(u), g[u].push_back(v);
    a[i] = v, b[i] = u;
  }
  for (long long i = 1; i <= n; i++) s.insert({d[i], i});
  for (long long i = m + 1; i >= 1 and s.size(); i--) {
    v = a[i];
    if (e[a[i]][b[i]]) {
      ans[i] = s.size();
      continue;
    }
    e[b[i]][a[i]] = e[a[i]][b[i]] = 1;
    if (d[v] >= k) {
      s.erase({d[v], v});
      d[v]--;
      s.insert({d[v], v});
    }
    v = b[i];
    if (d[v] >= k) {
      s.erase({d[v], v});
      d[v]--;
      s.insert({d[v], v});
    }
    while (s.size()) {
      v = (*s.begin()).second;
      if (d[v] >= k) break;
      s.erase({d[v], v});
      d[v] = 0;
      for (long long j = 0; j < g[v].size(); j++) {
        u = g[v][j];
        if (d[u] < k or e[u][v] or s.find({d[u], u}) == s.end()) continue;
        e[u][v] = e[v][u] = 1;
        s.erase({d[u], u});
        d[u]--;
        s.insert({d[u], u});
      }
    }
    ans[i] = s.size();
  }
  for (long long i = 2; i <= m + 1; i++) printf("%lld\n", ans[i]);
}
