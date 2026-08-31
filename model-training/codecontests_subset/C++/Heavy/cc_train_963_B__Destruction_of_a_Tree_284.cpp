#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 7;
vector<int> vt[MAXN];
int ans[MAXN], sum, root;
bool flag[MAXN];
void dfs2(int u) {
  if (flag[u]) return;
  flag[u] = true;
  ans[sum++] = u;
  for (int i = 0; i < vt[u].size(); i++) dfs2(vt[u][i]);
}
void dfs(int u) {
  int e = 0;
  if (u != root) e++;
  for (int i = 0; i < vt[u].size(); i++) {
    int v = vt[u][i];
    dfs(v);
    if (!flag[v]) e++;
  }
  if (e % 2 == 0) dfs2(u);
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    memset(ans, 0, sizeof(ans));
    memset(flag, false, sizeof(flag));
    sum = 0;
    for (int i = 1; i <= n; i++) {
      int x;
      scanf("%d", &x);
      if (x == 0)
        root = i;
      else
        vt[x].push_back(i);
    }
    if (n % 2 == 0) {
      printf("NO\n");
      continue;
    }
    dfs(root);
    if (sum == n) {
      printf("YES\n");
      for (int i = 0; i < sum; i++) printf("%d\n", ans[i]);
    } else
      printf("NO\n");
  }
}
