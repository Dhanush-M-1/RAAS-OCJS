#include <bits/stdc++.h>
using namespace std;
const int N = 100 + 5;
int n, m, p, t;
bool vis[N];
int main() {
  while (scanf("%d%d", &n, &m) == 2) {
    memset(vis, 0, sizeof(vis));
    bool flag = 1;
    for (int i = 0; i < n; i++) {
      scanf("%d", &p);
      for (int i = 0; i < p; i++) {
        scanf("%d", &t);
        vis[t] = 1;
      }
    }
    for (int i = 1; i <= m; i++)
      if (!vis[i]) flag = 0;
    if (flag)
      puts("YES");
    else
      puts("NO");
  }
  return 0;
}
