#include <bits/stdc++.h>
using namespace std;
const int maxn = 200007;
vector<int> G[maxn];
int cnt[maxn], n;
vector<int> ans;
void addedge(int u, int v) {
  G[u].push_back(v);
  G[v].push_back(u);
}
int stat(int u, int fa) {
  cnt[u] = 1;
  for (int v : G[u])
    if (v != fa) cnt[u] += stat(v, u);
  return cnt[u];
}
void dfs(int u, int fa) {
  for (int v : G[u])
    if (v != fa && cnt[v] % 2 == 0) dfs(v, u);
  printf("%d\n", u);
  for (int v : G[u])
    if (v != fa && cnt[v] % 2 == 1) dfs(v, u);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int j;
    scanf("%d", &j);
    if (j) addedge(i, j);
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  puts("YES");
  stat(1, 0);
  dfs(1, 0);
  return 0;
}
