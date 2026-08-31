#include <bits/stdc++.h>
using namespace std;
int n, m, k, x[200001], y[200001], ans[200001];
set<int> d[200001], s;
queue<int> q;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++)
    scanf("%d%d", &x[i], &y[i]), d[x[i]].insert(y[i]), d[y[i]].insert(x[i]);
  for (int i = 1; i <= n; i++)
    if (d[i].size() < k) q.push(i);
  while (!q.empty()) {
    int cur = q.front();
    q.pop();
    for (auto nxt : d[cur]) {
      d[nxt].erase(cur);
      if (d[nxt].size() < k) q.push(nxt);
    }
    d[cur].clear();
  }
  for (int i = 1; i <= n; i++)
    if (d[i].size() >= k) s.insert(i);
  for (int i = m; i >= 1; i--) {
    ans[i] = s.size();
    if (d[x[i]].count(y[i])) {
      d[x[i]].erase(y[i]);
      d[y[i]].erase(x[i]);
      if (d[x[i]].size() < k) q.push(x[i]);
      if (d[y[i]].size() < k) q.push(y[i]);
    }
    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      for (auto nxt : d[cur]) {
        d[nxt].erase(cur);
        if (d[nxt].size() < k) q.push(nxt);
      }
      d[cur].clear(), s.erase(cur);
    }
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
}
