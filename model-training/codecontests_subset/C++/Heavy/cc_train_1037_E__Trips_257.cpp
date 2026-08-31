#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
vector<int> p[maxn];
int vis[maxn];
int ans[maxn];
int num[maxn];
int v[maxn], w[maxn];
int now;
int n, m, k;
void dfs(int j, int v) {
  ans[j]--;
  for (int i = 0; i < p[v].size(); i++) {
    num[p[v][i]]--;
    if (vis[p[v][i]] == 1) {
      if (num[p[v][i]] < k) {
        vis[p[v][i]] = 0;
        dfs(j, p[v][i]);
      }
    }
  }
  vis[v] = -1;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &v[i], &w[i]);
    p[v[i]].push_back(w[i]);
    p[w[i]].push_back(v[i]);
  }
  for (int i = 1; i <= n; i++) {
    num[i] = p[i].size();
    if (p[i].size() >= k) vis[i] = 1;
  }
  ans[m] = n;
  for (int i = 1; i <= n; i++) {
    if (vis[i] == 0) dfs(m, i);
  }
  for (int i = m; i >= 2; i--) {
    p[v[i]].pop_back();
    p[w[i]].pop_back();
    if (vis[v[i]] == 1) num[w[i]]--;
    if (vis[w[i]] == 1) num[v[i]]--;
    ans[i - 1] = ans[i];
    if (vis[w[i]] == 1 && num[w[i]] < k) {
      vis[w[i]] = 0;
      dfs(i - 1, w[i]);
    }
    if (vis[v[i]] == 1 && num[v[i]] < k) {
      vis[v[i]] = 0;
      dfs(i - 1, v[i]);
    }
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
