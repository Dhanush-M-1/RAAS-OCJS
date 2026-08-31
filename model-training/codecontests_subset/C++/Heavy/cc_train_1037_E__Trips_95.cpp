#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int ind[N], ans[N];
set<int> vec[N];
int U[N], V[N];
bool vis[N];
int n, m, K;
int sum = 0;
queue<int> q;
void Top() {
  while (!q.empty()) {
    ++sum;
    int u = q.front();
    q.pop();
    ind[u] = 0;
    set<int>::iterator it;
    for (it = vec[u].begin(); it != vec[u].end();) {
      int v = *it;
      if (vis[v]) {
        it++;
        continue;
      }
      vec[u].erase(it++);
      vec[v].erase(u);
      ind[v]--;
      if (!vis[v] && ind[v] < K) {
        vis[v] = 1;
        q.push(v);
      }
    }
  }
}
int main() {
  scanf("%d %d %d", &n, &m, &K);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d", &U[i], &V[i]);
    int u = U[i], v = V[i];
    vec[u].insert(v);
    vec[v].insert(u);
    ind[u]++;
    ind[v]++;
  }
  for (int i = 1; i < n + 1; ++i) {
    if (ind[i] < K) {
      vis[i] = 1;
      q.push(i);
    }
  }
  Top();
  for (int i = m - 1; i >= 0; --i) {
    ans[i] = n - sum;
    int u = U[i], v = V[i];
    if (vec[u].count(v)) ind[v]--, vec[u].erase(v);
    if (vec[v].count(u)) ind[u]--, vec[v].erase(u);
    if (!vis[v] && ind[v] < K) vis[v] = 1, q.push(v);
    if (!vis[u] && ind[u] < K) vis[u] = 1, q.push(u);
    Top();
  }
  for (int i = 0; i < m; ++i) printf("%d\n", ans[i]);
  return 0;
}
