#include <bits/stdc++.h>
using namespace std;
vector<set<int> > g;
int n, m, k;
vector<pair<int, int> > q;
set<int> s;
void remove(int v) {
  if (g[v].size() < k && s.erase(v)) {
    for (auto to : g[v]) g[to].erase(v), remove(to);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m >> k;
  q.resize(m);
  g.resize(n);
  for (int i = 0; i < m; ++i) {
    int x, y;
    cin >> x >> y;
    x--, y--;
    g[x].insert(y), g[y].insert(x);
    q.push_back(make_pair(x, y));
  }
  for (int i = 0; i < n; ++i) s.insert(i);
  for (int i = 0; i < n; ++i) remove(i);
  vector<int> ans;
  for (int i = 0; i < m; ++i) {
    ans.push_back(s.size());
    auto cur = q.back();
    q.pop_back();
    g[cur.first].erase(cur.second);
    g[cur.second].erase(cur.first);
    remove(cur.first);
    remove(cur.second);
  }
  for (int i = 0; i < m; ++i) cout << ans[m - i - 1] << '\n';
  return 0;
}
