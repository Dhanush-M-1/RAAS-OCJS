#include <bits/stdc++.h>
using namespace std;
int vis[200];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  int cnt = 0;
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i < n; i++) {
    int k;
    scanf("%d", &k);
    for (int j = 0; j < k; j++) {
      int p;
      scanf("%d", &p);
      if (!vis[p]) {
        vis[p] = 1;
        cnt++;
      }
    }
  }
  if (cnt == m)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
