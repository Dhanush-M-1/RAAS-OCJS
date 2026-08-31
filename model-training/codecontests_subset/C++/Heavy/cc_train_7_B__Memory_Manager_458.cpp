#include <bits/stdc++.h>
using namespace std;
string s;
int vis[110];
int ps[110];
int main() {
  int t, m;
  memset(vis, -1, sizeof(vis));
  scanf("%d%d", &t, &m);
  int id = 1, x;
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s == "defragment") {
      int len = 0;
      memset(ps, -1, sizeof(ps));
      for (int j = 1; j <= m; j++) {
        if (vis[j] != -1) ps[++len] = vis[j];
      }
      for (int j = 1; j <= m; j++) vis[j] = ps[j];
    } else if (s == "alloc") {
      scanf("%d", &x);
      int minx = 0, ff = 0;
      for (int j = 1; j <= m; j++) {
        if (vis[j] == -1)
          minx++;
        else {
          minx = 0;
        }
        if (minx == x) {
          for (int k = j - x + 1; k <= j; k++) vis[k] = id;
          printf("%d\n", id);
          ff = 1;
          id++;
        }
        if (ff) break;
      }
      if (ff == 0) printf("NULL\n");
    } else {
      scanf("%d", &x);
      int flag = 0;
      if (x < 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      for (int j = 1; j <= m; j++) {
        if (vis[j] == x) vis[j] = -1, flag = 1;
      }
      if (flag == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    }
  }
  return 0;
}
