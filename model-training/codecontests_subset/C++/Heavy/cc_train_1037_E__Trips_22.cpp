#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int du[maxn];
set<int> g[maxn];
int b1[maxn], b2[maxn], ans[maxn], vis[maxn];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  set<pair<int, int> > s;
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    b1[i] = x, b2[i] = y;
    du[x]++, du[y]++;
    g[x].insert(y);
    g[y].insert(x);
  }
  for (int i = 1; i <= n; i++) s.insert(make_pair(du[i], i));
  for (int i = m - 1; i >= 0; i--) {
    while (s.size() >= 1) {
      pair<int, int> itt = (*s.begin());
      if (itt.first >= k) break;
      for (set<int>::iterator it = g[itt.second].begin();
           it != g[itt.second].end(); it++) {
        int u = *it;
        if (vis[u] == 1) continue;
        s.erase(make_pair(du[u], u));
        du[u]--;
        s.insert(make_pair(du[u], u));
        g[u].erase(itt.second);
      }
      s.erase(itt);
      vis[itt.second] = 1;
    }
    ans[i] = s.size();
    if (vis[b1[i]] == 0 && vis[b2[i]] == 0) {
      s.erase(make_pair(du[b1[i]], b1[i]));
      du[b1[i]]--;
      s.insert(make_pair(du[b1[i]], b1[i]));
      g[b1[i]].erase(b2[i]);
      s.erase(make_pair(du[b2[i]], b2[i]));
      du[b2[i]]--;
      s.insert(make_pair(du[b2[i]], b2[i]));
      g[b2[i]].erase(b1[i]);
    }
  }
  for (int i = 0; i < m; i++) printf("%d\n", ans[i]);
}
