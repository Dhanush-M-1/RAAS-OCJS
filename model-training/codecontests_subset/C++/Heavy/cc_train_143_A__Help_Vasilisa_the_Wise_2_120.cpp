#include <bits/stdc++.h>
using namespace std;
const int M = 1024;
int s[M], b[M];
int main() {
  int r1, r2, c1, c2, d1, d2;
  while (~scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2)) {
    bool flag = false;
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        for (int k = 1; k < 10; k++) {
          for (int u = 1; u < 10; u++) {
            if (i != j && i != k && i != u && j != k && j != u && k != u &&
                i + j == r1 && k + u == r2 && i + k == c1 && j + u == c2 &&
                i + u == d1 && j + k == d2) {
              printf("%d %d\n%d %d\n", i, j, k, u);
              flag = true;
              break;
            }
          }
          if (flag) break;
        }
        if (flag) break;
      }
      if (flag) break;
    }
    if (!flag) puts("-1");
  }
  return 0;
}
