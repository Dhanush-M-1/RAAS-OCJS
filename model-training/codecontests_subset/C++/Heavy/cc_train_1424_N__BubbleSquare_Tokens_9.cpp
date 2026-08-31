#include <bits/stdc++.h>
using namespace std;
const int mxn = 2e4 + 4;
const int mxm = 1e6 + 6;
vector<pair<int, int> > g[mxn];
int one[mxn], n, m;
int wei[mxn];
struct edge {
  int from, to;
  int cap;
};
inline edge me(int from, int to) {
  edge rt;
  rt.from = from, rt.to = to, rt.cap = 1;
  ++wei[from], ++wei[to];
  return rt;
}
edge e[mxm];
inline void solve() {
  scanf("%d%d", &n, &m);
  for (register int i = 1; i <= m; ++i) {
    register int u, v;
    scanf("%d%d", &u, &v);
    e[i] = me(u, v);
    g[u].push_back(make_pair(v, i));
    g[v].push_back(make_pair(u, i));
  }
  for (int i = 1; i <= n; ++i) {
    int cnt = 0;
    for (int j = 0; j < g[i].size(); ++j) {
      int t = g[i][j].first;
      if (t > i) continue;
      ++cnt;
      if (!one[t]) {
        int id = g[i][j].second;
        --e[id].cap;
        one[t] = 1;
        --wei[i];
      }
    }
    set<int> s;
    s.clear();
    for (int j = 0; j <= cnt; ++j) s.insert(j + wei[i]);
    for (int j = 0; j < g[i].size(); ++j) {
      int t = g[i][j].first;
      if (t > i) continue;
      if (s.find(wei[t]) != s.end()) s.erase(wei[t]);
    }
    int ans = *s.begin();
    int need = ans - wei[i];
    for (int j = 0; j < g[i].size() and need; ++j) {
      int t = g[i][j].first, id = g[i][j].second;
      if (t > i) continue;
      one[t] = 0;
      e[id].cap++;
      wei[i]++;
      --need;
    }
  }
  vector<int> ones;
  for (int i = 1; i <= n; ++i)
    if (one[i]) ones.push_back(i);
  printf("%d\n", ones.size());
  for (int i = 0; i < ones.size(); ++i) printf("%d ", ones[i]);
  if (ones.size()) printf("\n");
  for (int i = 1; i <= m; ++i)
    printf("%d %d %d\n", e[i].from, e[i].to, e[i].cap);
}
int main() {
  ios_base::sync_with_stdio(false);
  int T = 1;
  for (; T--;) solve();
}
