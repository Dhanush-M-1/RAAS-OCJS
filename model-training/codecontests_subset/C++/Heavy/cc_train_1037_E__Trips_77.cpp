#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 200;
int n, m, k, id[N], vis[N], ans[N];
vector<pair<int, int> > g[N];
struct node {
  int x, y;
} e[N];
set<pair<int, int> > s;
void change(int x) {
  if (vis[x]) return;
  auto it = s.lower_bound(make_pair(id[x], x));
  pair<int, int> t = *it;
  s.erase(it);
  t.first--;
  id[t.second]--;
  s.insert(t);
}
void update(int now) {
  while (!s.empty() && (*s.begin()).first < k) {
    pair<int, int> t = *s.begin();
    vis[t.second] = 1;
    s.erase(s.begin());
    for (auto pp : g[t.second]) {
      if (pp.second > now) break;
      int v = pp.first;
      if (vis[v]) continue;
      auto it = s.lower_bound(make_pair(id[v], v));
      t = *it;
      s.erase(it);
      id[v]--;
      t.first--;
      s.insert(t);
    }
  }
}
bool cmp(pair<int, int> a, pair<int, int> b) { return a.second < b.second; }
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> e[i].x >> e[i].y;
    g[e[i].x].push_back(make_pair(e[i].y, i));
    g[e[i].y].push_back(make_pair(e[i].x, i));
    id[e[i].x]++;
    id[e[i].y]++;
  }
  for (int i = 1; i <= n; i++) sort(g[i].begin(), g[i].end(), cmp);
  for (int i = 1; i <= n; i++) s.insert(make_pair(id[i], i));
  for (int i = m; i >= 1; i--) {
    update(i);
    ans[i] = s.size();
    if (vis[e[i].x] || vis[e[i].y]) continue;
    int l = id[e[i].x], r = id[e[i].y];
    change(e[i].x);
    change(e[i].y);
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << endl;
  return 0;
}
