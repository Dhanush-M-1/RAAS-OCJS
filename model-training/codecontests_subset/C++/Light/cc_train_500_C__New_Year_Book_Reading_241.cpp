#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double ESP = 1e-5;
const double PI = acos(-1.0);
const int MOD = 1e9 + 7;
const int MAXN = 1e5;
int weight[MAXN], pos[MAXN];
int st[MAXN], num[MAXN];
bool vis[MAXN];
int main() {
  int n, m;
  while (scanf("%d%d", &n, &m) != EOF) {
    memset(vis, 0, sizeof(vis));
    for (int i = 1; i <= n; i++) {
      scanf("%d", &weight[i]);
    }
    int cnt = 0;
    for (int i = 0; i < m; i++) {
      scanf("%d", &st[i]);
      if (!vis[st[i]]) {
        pos[cnt++] = st[i];
        vis[st[i]] = true;
      }
    }
    int ans = 0;
    memset(vis, 0, sizeof(vis));
    cnt = 0;
    for (int i = 0; i < m; i++) {
      int p;
      for (p = 0; pos[p] != st[i]; p++) {
        ans += weight[pos[p]];
      }
      for (int j = p; j >= 1; j--) pos[j] = pos[j - 1];
      pos[0] = st[i];
    }
    printf("%d\n", ans);
  }
  return 0;
}
