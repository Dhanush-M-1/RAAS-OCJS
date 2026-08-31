#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
const int M = 100 + 7;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int mod = 1e9 + 9;
vector<int> edge[N], e[N], ans;
int n, cnt[N], deg[N];
int vis[N];
void dfs(int u, int pre) {
  cnt[u] = 1;
  for (int v : edge[u]) {
    if (v == pre) continue;
    dfs(v, u);
    cnt[u] += cnt[v];
  }
}
bool dfs2(int u) {
  vis[u] = -1;
  for (int v : e[u]) {
    if (vis[v] == -1) return false;
    if (!vis[v] && !dfs2(v)) return false;
  }
  vis[u] = 1;
  ans.push_back(u);
  return true;
}
void dfs3(int u, int pre) {
  for (int v : edge[u]) {
    if (v == pre) continue;
    if (cnt[v] % 2) {
      e[u].push_back(v);
      deg[v]++;
    } else {
      e[v].push_back(u);
      deg[u]++;
    }
    dfs3(v, u);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int fa;
    scanf("%d", &fa);
    if (fa) {
      edge[fa].push_back(i);
      edge[i].push_back(fa);
    }
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  dfs(1, 0);
  dfs3(1, 0);
  for (int i = 1; i <= n; i++) {
    if (vis[i]) continue;
    if (!dfs2(i)) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  for (int i = ans.size() - 1; i >= 0; i--) printf("%d\n", ans[i]);
  return 0;
}
