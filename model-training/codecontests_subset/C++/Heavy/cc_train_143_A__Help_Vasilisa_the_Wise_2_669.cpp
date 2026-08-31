#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:102400000,102400000")
using namespace std;
const int MAXN = 100000 + 10;
const int INF = 0x7fffffff;
bool vis[10];
int main() {
  int r1, r2, c1, c2, d1, d2, a, b, c, d;
  while (scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2) == 6) {
    bool f = false;
    memset(vis, -1, sizeof(vis));
    for (a = 1; a < 10; a++) {
      vis[a] = false;
      for (b = 1; b < 10; b++) {
        if (vis[b]) {
          vis[b] = false;
          for (c = 1; c < 10; c++) {
            if (vis[c]) {
              vis[c] = false;
              for (d = 1; d < 10; d++) {
                if (vis[d] && a + b == r1 && c + d == r2 && a + c == c1 &&
                    b + d == c2 && a + d == d1 && b + c == d2) {
                  f = true;
                  break;
                }
              }
              if (f) break;
              vis[c] = true;
            }
          }
          if (f) break;
          vis[b] = true;
        }
      }
      if (f) break;
      vis[a] = true;
    }
    if (f)
      printf("%d %d\n%d %d\n", a, b, c, d);
    else
      printf("-1\n");
  }
  return 0;
}
