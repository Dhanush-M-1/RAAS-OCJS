#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)2e5 + 5;
int n, m, k;
vector<pair<int, int> > out[maxn];
int la[maxn];
int pos[maxn];
int deg[maxn];
int add[maxn];
bool dead[maxn];
set<pair<int, int>, greater<pair<int, int> > > s;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k;
  fill(la, la + n, -1);
  for (auto i = 0; i < m; ++i) {
    int v, u;
    cin >> v >> u;
    --v;
    --u;
    out[v].push_back(make_pair(i, u));
    out[u].push_back(make_pair(i, v));
    ++deg[v];
    ++deg[u];
    if (deg[v] == k) {
      pos[v] = out[v].size() - 1;
      la[v] = i;
    }
    if (deg[u] == k) {
      pos[u] = out[u].size() - 1;
      la[u] = i;
    }
  }
  for (auto i = 0; i < n; ++i)
    if (la[i] == -1) la[i] = m;
  for (auto i = 0; i < n; ++i) s.insert(make_pair(la[i], i));
  while (!s.empty()) {
    int v = s.begin()->second;
    dead[v] = true;
    s.erase(s.begin());
    for (auto e : out[v]) {
      int u = e.second;
      if (dead[u] || la[u] == la[v]) continue;
      if (la[u] < e.first) continue;
      s.erase(make_pair(la[u], u));
      ++pos[u];
      while (pos[u] != (int)out[u].size() && dead[out[u][pos[u]].second])
        ++pos[u];
      if (pos[u] == (int)out[u].size())
        la[u] = m;
      else
        la[u] = out[u][pos[u]].first;
      la[u] = min(la[u], la[v]);
      s.insert(make_pair(la[u], u));
    }
  }
  for (auto i = 0; i < n; ++i) add[la[i]]++;
  int curr = 0;
  for (auto i = 0; i < m; ++i) {
    curr += add[i];
    cout << curr << '\n';
  }
  return 0;
}
