#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int a[200010], b[200010];
vector<pair<int, int> > G[200010];
int deg[200010];
int ans[200010], cnt;
queue<int> q;
inline void spfa(int x) {
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i].first;
      int s = G[u][i].second;
      if (s >= x) continue;
      if (deg[v] >= k) {
        deg[v]--;
        if (deg[v] < k) {
          q.push(v);
          cnt--;
        }
      }
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", a + i, b + i);
    deg[a[i]]++;
    deg[b[i]]++;
    G[a[i]].push_back(pair<int, int>(b[i], i));
    G[b[i]].push_back(pair<int, int>(a[i], i));
  }
  cnt = n;
  for (int i = 1; i <= n; i++)
    if (deg[i] < k) q.push(i), cnt--;
  spfa(m + 1);
  ans[m + 1] = cnt;
  for (int i = m; i > 1; i--) {
    if (deg[a[i]] >= k && deg[b[i]] >= k) {
      deg[a[i]]--;
      deg[b[i]]--;
      if (deg[a[i]] < k) q.push(a[i]), cnt--;
      if (deg[b[i]] < k) q.push(b[i]), cnt--;
    }
    spfa(i);
    ans[i] = cnt;
  }
  for (int i = 2; i <= m + 1; i++) printf("%d\n", ans[i]);
  return 0;
}
