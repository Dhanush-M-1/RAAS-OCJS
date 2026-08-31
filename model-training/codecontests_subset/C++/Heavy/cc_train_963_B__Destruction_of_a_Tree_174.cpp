#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int a[N], d[N];
vector<int> G[N];
vector<int> ans;
int vis[N], sz[N];
void init(int fa, int u) {
  sz[u] = 1;
  for (int v : G[u]) {
    if (v != fa) {
      init(u, v);
      sz[u] += sz[v];
    }
  }
}
void dfs(int fa, int u) {
  int flg = 0;
  for (int v : G[u]) {
    if (v != fa) {
      if (sz[v] % 2 == 0) {
        dfs(u, v);
      }
    }
  }
  ans.push_back(u);
  vis[u] = 1;
  for (int v : G[u]) {
    if (v != fa) {
      if (sz[v] % 2) {
        dfs(u, v);
      }
    }
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x) {
      G[i].push_back(x);
      G[x].push_back(i);
      d[x]++;
      d[i]++;
    }
  }
  if (n & 1) {
    init(-1, 1);
    dfs(0, 1);
    puts("YES");
    for (int x : ans) {
      printf("%d\n", x);
    }
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        printf("%d\n", i);
      }
    }
  } else
    puts("NO");
  return 0;
}
