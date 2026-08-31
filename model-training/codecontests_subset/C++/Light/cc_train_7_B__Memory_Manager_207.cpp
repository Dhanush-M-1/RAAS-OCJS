#include <bits/stdc++.h>
using namespace std;
long long sql[105], t, m, y;
const long long inf = (long long)1e10;
char x[105];
int main() {
  scanf("%d %d", &t, &m);
  int xb, cnt = 0, x2;
  for (xb = 0; xb < m; xb++) sql[xb] = inf;
  for (xb = 0; xb < t; xb++) {
    scanf("%s", x);
    if (x[0] == 'a') {
      scanf("%d", &y);
      long long len = 0;
      for (x2 = 0; x2 < m && len < y; x2++) {
        if (sql[x2] == inf)
          len++;
        else
          len = 0;
      }
      if (len < y)
        printf("NULL\n");
      else {
        long long e = x2 - 1;
        cnt++;
        for (x2 = e - y + 1; x2 <= e; x2++) sql[x2] = cnt;
        printf("%d\n", cnt);
      }
    } else if (x[0] == 'e') {
      scanf("%d", &y);
      bool fnd = 0;
      for (x2 = 0; x2 < m; x2++)
        if (sql[x2] == y) {
          sql[x2] = inf;
          fnd = 1;
        }
      if (!fnd) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else {
      long long sp = 0;
      while (sql[sp] < inf) sp++;
      for (x2 = sp + 1; x2 < m; x2++) {
        if (sql[x2] < inf) {
          sql[sp] = sql[x2];
          sql[x2] = inf;
          while (sql[sp] < inf) sp++;
        }
      }
    }
  }
  return 0;
}
