#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
vector<int> G[maxn];
void insert(int u, int v) {
  G[u].push_back(v);
  G[v].push_back(u);
}
int sz[maxn];
void dfs(int u, int fa) {
  sz[u] = 1;
  for (int v : G[u]) {
    if (v == fa) continue;
    dfs(v, u);
    sz[u] += sz[v];
  }
}
void del(int u, int fa) {
  for (int v : G[u]) {
    if (v == fa) continue;
    if (sz[v] % 2 == 0) del(v, u);
  }
  printf("%d\n", u);
  for (int v : G[u]) {
    if (v == fa) continue;
    if (sz[v] & 1) del(v, u);
  }
}
int n;
int main() {
  scanf("%d", &n);
  int rt;
  for (int i = 1, x; i <= n; i++) {
    scanf("%d", &x);
    if (x == 0)
      rt = i;
    else
      insert(i, x);
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  puts("YES");
  dfs(rt, 0);
  del(rt, 0);
  return 0;
}
